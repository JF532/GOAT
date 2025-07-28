package br.com.goat.api.controllers;

import java.util.List;

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

import br.com.goat.api.DTOs.ClubLeagueCreateDTO;
import br.com.goat.api.DTOs.ClubLeagueResponseDTO;
import br.com.goat.api.DTOs.ClubLeagueUpdateDTO;
import br.com.goat.api.services.ClubLeagueService;

@RestController
@RequestMapping("/api/clubLeagues")
public class ClubLeagueController {

     @Autowired
	ClubLeagueService clubLeagueService;
	
	@PostMapping("/register")
	public ResponseEntity<ClubLeagueResponseDTO> store(@RequestBody ClubLeagueCreateDTO clubLeagueCreateDTO) {
		return new ResponseEntity<>(clubLeagueService.store(clubLeagueCreateDTO), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<ClubLeagueResponseDTO>> list()
	{
		return new ResponseEntity<>(clubLeagueService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{clubLeague_id}")
	public ResponseEntity<ClubLeagueResponseDTO> show(@PathVariable long clubLeague_id) {
		try {
			return new ResponseEntity<>(clubLeagueService.show(clubLeague_id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<ClubLeagueResponseDTO> update(@RequestBody ClubLeagueUpdateDTO clubLeagueUpdateDTO) {
		try {
			return new ResponseEntity<>(clubLeagueService.update(clubLeagueUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{clubLeague_id}")
	public ResponseEntity<String> destroy(@PathVariable long clubLeague_id) {
		try {
			clubLeagueService.destroy(clubLeague_id);
			return new ResponseEntity<>("ClubLeague successfully deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
