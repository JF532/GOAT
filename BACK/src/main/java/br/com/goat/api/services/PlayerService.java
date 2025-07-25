package br.com.goat.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.PlayerCreateDTO;
import br.com.goat.api.DTOs.PlayerResponseDTO;
import br.com.goat.api.DTOs.PlayerUpdateDTO;
import br.com.goat.api.entities.Player;
import br.com.goat.api.mappers.PlayerMapper;
import br.com.goat.api.repositories.PlayerRepository;

import java.util.*;

@Service
public class PlayerService {
    @Autowired
	PlayerRepository playerRepository;
	
	public PlayerResponseDTO store(PlayerCreateDTO playerCreateDTO) {
		Player player = PlayerMapper.toEntity(playerCreateDTO);
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
		player.setName(playerUpdateDTO.name());
        player.setSocial_name(playerUpdateDTO.social_name());
        player.setDateBirth(playerUpdateDTO.dateBirth());
        player.setAge(playerUpdateDTO.age());
        player.setPreferredFoot(playerUpdateDTO.preferredFoot());
        player.setHeight(playerUpdateDTO.height());
        player.setMarketValue(playerUpdateDTO.marketValue());
        player.setPhotoUrl(playerUpdateDTO.photoUrl());
		return PlayerMapper.toDTO(playerRepository.save(player));
	}
	
	public void destroy(long id) {
		Player player = playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found for deletion"));
		playerRepository.delete(player);
	}
}
