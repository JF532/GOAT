package br.com.goat.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.ClubCreateDTO;
import br.com.goat.api.DTOs.ClubResponseDTO;
import br.com.goat.api.DTOs.ClubUpdateDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.Country;
import br.com.goat.api.entities.Stadium;
import br.com.goat.api.mappers.ClubMapper;
import br.com.goat.api.repositories.ClubRepository;
import br.com.goat.api.repositories.CountryRepository;
import br.com.goat.api.repositories.StadiumRepository;

@Service
public class ClubService {

	@Autowired
	ClubRepository clubRepository;

	@Autowired
	StadiumRepository stadiumRepository;

	@Autowired
	CountryRepository countryRepository;

	public ClubResponseDTO store(ClubCreateDTO dto) {
		Country country = countryRepository.findById(dto.countryId())
				.orElseThrow(() -> new RuntimeException("Country with id " + dto.countryId() + " not found"));
		Stadium stadium = stadiumRepository.findById(dto.stadiumId())
				.orElseThrow(() -> new RuntimeException("Stadium with id " + dto.stadiumId() + " not found"));
		Club response = ClubMapper.toEntity(dto, country, stadium);
		clubRepository.save(response);
		return ClubMapper.toDTO(response);
	}

	public ClubResponseDTO show(long id) {
		Club club = clubRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Club with id " + id + " not found"));
		return ClubMapper.toDTO(club);
	}

	public List<ClubResponseDTO> list() {
		return clubRepository.findAll().stream().map(ClubMapper::toDTO).toList();
	}

	public ClubResponseDTO update(ClubUpdateDTO dto) {
		Club club = clubRepository.findById(dto.id())
				.orElseThrow(() -> new RuntimeException("Club with id " + dto.id() + " not found for update"));
		Country country = countryRepository.findById(dto.countryId())
				.orElseThrow(() -> new RuntimeException("Country with id " + dto.countryId() + " not found"));
		Stadium stadium = stadiumRepository.findById(dto.stadiumId())
				.orElseThrow(() -> new RuntimeException("Stadium with id " + dto.stadiumId() + " not found"));
		club.setLegalName(dto.legalName());
		club.setTradeName(dto.tradeName());
		club.setCountry(country);
		club.setLogoImageUrl(dto.logoImageUrl());
		club.setMarketValue(dto.marketValue());
		club.setSquadSize(dto.squadSize());
		club.setStadium(stadium);
		club.setFoundationDate(dto.foundationDate());
		

	    clubRepository.save(club);
		return ClubMapper.toDTO(club);
	}
	
	public void destroy(long id) {
		Club club = clubRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Club with id " + id + " not found"));
		clubRepository.delete(club);
	}
}
