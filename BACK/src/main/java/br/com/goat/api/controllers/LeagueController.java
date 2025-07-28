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

import br.com.goat.api.DTOs.LeagueCreateDTO;
import br.com.goat.api.DTOs.LeagueResponseDTO;
import br.com.goat.api.DTOs.LeagueUpdateDTO;
import br.com.goat.api.services.LeagueService;

@RestController
@RequestMapping("api/leagues")
public class LeagueController {
    
    @Autowired
    LeagueService leagueService;

    @PostMapping("/register")
	public ResponseEntity<LeagueResponseDTO> store(@RequestBody LeagueCreateDTO leagueCreateDTO) {
		return new ResponseEntity<>(leagueService.store(leagueCreateDTO), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<LeagueResponseDTO>> list()
	{
		return new ResponseEntity<>(leagueService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{league_id}")
	public ResponseEntity<LeagueResponseDTO> show(@PathVariable long league_id) {
		try {
			return new ResponseEntity<>(leagueService.show(league_id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<LeagueResponseDTO> update(@RequestBody LeagueUpdateDTO leagueUpdateDTO) {
		try {
			return new ResponseEntity<>(leagueService.update(leagueUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{league_id}")
	public ResponseEntity<String> destroy(@PathVariable long league_id) {
		try {
			leagueService.destroy(league_id);
			return new ResponseEntity<>("League successfully deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
