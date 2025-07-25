package br.com.goat.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import br.com.goat.api.DTOs.PlayerCreateDTO;
import br.com.goat.api.DTOs.PlayerResponseDTO;
import br.com.goat.api.DTOs.PlayerUpdateDTO;
import br.com.goat.api.services.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    
    @Autowired
	PlayerService playerService;
	
	@PostMapping("/register")
	public ResponseEntity<PlayerResponseDTO> store(@RequestBody PlayerCreateDTO playerCreateDTO) {
		return new ResponseEntity<>(playerService.store(playerCreateDTO), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<PlayerResponseDTO>> list()
	{
		return new ResponseEntity<>(playerService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{player_id}")
	public ResponseEntity<PlayerResponseDTO> show(@PathVariable long player_id) {
		try {
			return new ResponseEntity<>(playerService.show(player_id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<PlayerResponseDTO> update(@RequestBody PlayerUpdateDTO playerUpdateDTO) {
		try {
			return new ResponseEntity<>(playerService.update(playerUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{player_id}")
	public ResponseEntity<String> destroy(@PathVariable long player_id) {
		try {
			playerService.destroy(player_id);
			return new ResponseEntity<>("Player successfully deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
