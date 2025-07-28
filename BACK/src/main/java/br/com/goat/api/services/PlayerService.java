package br.com.goat.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.PlayerCreateDTO;
import br.com.goat.api.DTOs.PlayerResponseDTO;
import br.com.goat.api.DTOs.PlayerUpdateDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.Country;
import br.com.goat.api.entities.Player;
import br.com.goat.api.entities.Position;
import br.com.goat.api.mappers.PlayerMapper;
import br.com.goat.api.repositories.ClubRepository;
import br.com.goat.api.repositories.CountryRepository;
import br.com.goat.api.repositories.PlayerRepository;
import br.com.goat.api.repositories.PositionRepository;

import java.util.*;

@Service
public class PlayerService {
    @Autowired
	PlayerRepository playerRepository;

	@Autowired
	ClubRepository clubRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	PositionRepository positionRepository;
	
	public PlayerResponseDTO store(PlayerCreateDTO playerCreateDTO) {
		Club club = clubRepository.findById(playerCreateDTO.clubId()).orElseThrow(()->new RuntimeException("Club whit id:" + playerCreateDTO.clubId() + " not found"));
		Country country = countryRepository.findById(playerCreateDTO.countryId()).orElseThrow(()->new RuntimeException("Country whit id:" + playerCreateDTO.countryId() + " not found"));
		Position position = positionRepository.findById(playerCreateDTO.positionId()).orElseThrow(()->new RuntimeException("Position whit id:" + playerCreateDTO.positionId() + " not found"));

		Player player = PlayerMapper.toEntity(playerCreateDTO,country,position,club);
		playerRepository.save(player);
		return PlayerMapper.toDTO(player);
	}
	
	public List<PlayerResponseDTO> list() {
		return playerRepository.findAll().stream().map(PlayerMapper::toDTO).toList();
	}
	
	public PlayerResponseDTO show(long id) {
			Player player = playerRepository.findById(id)
					.orElseThrow(()->new RuntimeException("Player whit id: " + id + " not found"));
			return PlayerMapper.toDTO(player);
	}
	
	public PlayerResponseDTO update(PlayerUpdateDTO playerUpdateDTO) {
		Player player = playerRepository.findById(playerUpdateDTO.id()).orElseThrow(()->new RuntimeException("Player not found for update"));
		Club club = clubRepository.findById(playerUpdateDTO.clubId()).orElseThrow(()->new RuntimeException("Club whit id:" + playerUpdateDTO.clubId() + " not found"));
		Country country = countryRepository.findById(playerUpdateDTO.countryId()).orElseThrow(()->new RuntimeException("Country whit id:" + playerUpdateDTO.countryId() + " not found"));
		Position position = positionRepository.findById(playerUpdateDTO.positionId()).orElseThrow(()->new RuntimeException("Position whit id:" + playerUpdateDTO.positionId() + " not found"));

		player.setName(playerUpdateDTO.name());
        player.setSocialName(playerUpdateDTO.socialName());
        player.setDateBirth(playerUpdateDTO.dateBirth());
        player.setAge(playerUpdateDTO.age());
        player.setPreferredFoot(playerUpdateDTO.preferredFoot());
        player.setHeight(playerUpdateDTO.height());
        player.setMarketValue(playerUpdateDTO.marketValue());
        player.setPhotoUrl(playerUpdateDTO.photoUrl());
		player.setClubId(club);
		player.setNationalityId(country);
		player.setPrimaryPositionId(position);
		return PlayerMapper.toDTO(playerRepository.save(player));
	}
	
	public void destroy(long id) {
		Player player = playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found for deletion"));
		playerRepository.delete(player);
	}
}
