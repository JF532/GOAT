package br.com.goat.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.CountryCreateDTO;
import br.com.goat.api.DTOs.CountryResponseDTO;
import br.com.goat.api.DTOs.CountryUpdateDTO;
import br.com.goat.api.entities.Country;
import br.com.goat.api.mappers.CountryMapper;
import br.com.goat.api.repositories.CountryRepository;

@Service
public class CountryService {
	@Autowired
	CountryRepository countryRepository;

	public CountryResponseDTO store(CountryCreateDTO countryCreateDTO) {
		Country country = CountryMapper.toEntity(countryCreateDTO);
		countryRepository.save(country);
		return CountryMapper.toDTO(country);
	}

	public List<CountryResponseDTO> list() {
		return countryRepository.findAll().stream().map(CountryMapper::toDTO).toList();
	}

	public CountryResponseDTO show(long id) {
		Country country = countryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Country with id: " + id + " not found"));
		return CountryMapper.toDTO(country);
	}

	public CountryResponseDTO update(CountryUpdateDTO countryUpdateDTO) {
		Country country = countryRepository.findById(countryUpdateDTO.id())
				.orElseThrow(() -> new RuntimeException("Country not found for update"));
		country.setFullName(countryUpdateDTO.fullName());
		country.setIsoCode(countryUpdateDTO.isoCode());
		country.setFlagImageUrl(countryUpdateDTO.flagImageUrl());
		
		return CountryMapper.toDTO(countryRepository.save(country));
	}

	public void destroy(long id) {
		Country country = countryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Country not found for deletion"));
		countryRepository.delete(country);
	}
}
