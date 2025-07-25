package br.com.goat.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.StadiumCreateDTO;
import br.com.goat.api.DTOs.StadiumResponseDTO;
import br.com.goat.api.DTOs.StadiumUpdateDTO;
import br.com.goat.api.entities.Country;
import br.com.goat.api.entities.Stadium;
import br.com.goat.api.mappers.StadiumMapper;
import br.com.goat.api.repositories.CountryRepository;
import br.com.goat.api.repositories.StadiumRepository;

@Service
public class StadiumService {
	
	@Autowired
	StadiumRepository stadiumRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	public StadiumResponseDTO store(StadiumCreateDTO stadiumCreateDTO) {
		Country country = countryRepository.findById(stadiumCreateDTO.countryId()).orElseThrow(() -> new RuntimeException("Country with id: " + stadiumCreateDTO.countryId() + " not found"));
		Stadium stadium = StadiumMapper.toEntity(stadiumCreateDTO, country);
		stadiumRepository.save(stadium);
		return StadiumMapper.toDTO(stadium);
	}

	public List<StadiumResponseDTO> list() {
		return stadiumRepository.findAll().stream().map(StadiumMapper::toDTO).toList();
	}

	public StadiumResponseDTO show(long id) {
		Stadium stadium = stadiumRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Stadium with id: " + id + " not found"));
		return StadiumMapper.toDTO(stadium);
	}

	public StadiumResponseDTO update(StadiumUpdateDTO stadiumUpdateDTO) {
		Stadium stadium = stadiumRepository.findById(stadiumUpdateDTO.id())
				.orElseThrow(() -> new RuntimeException("Stadium not found for update"));
		Country country = countryRepository.findById(stadiumUpdateDTO.countryId()).orElseThrow(() -> new RuntimeException("Country with id: " + stadiumUpdateDTO.countryId() + " not found"));
		stadium.setName(stadiumUpdateDTO.name());
		stadium.setCapacity(stadiumUpdateDTO.capacity());
		stadium.setCity(stadiumUpdateDTO.city());
		stadium.setCountry(country);
		
		return StadiumMapper.toDTO(stadiumRepository.save(stadium));
	}

	public void destroy(long id) {
		Stadium stadium = stadiumRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Stadium not found for deletion"));
		stadiumRepository.delete(stadium);
	}
}
