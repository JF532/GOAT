package br.com.goat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goat.api.DTOs.ClubCreateDTO;
import br.com.goat.api.DTOs.ClubResponseDTO;
import br.com.goat.api.DTOs.ClubUpdateDTO;
import br.com.goat.api.services.ClubService;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@PostMapping("/register")
	public ResponseEntity<?> store(@RequestBody ClubCreateDTO dto) {
		ClubResponseDTO response = clubService.store(dto);
	    return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ClubResponseDTO>> list(){
		return new ResponseEntity<>(clubService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{club_id}")
	public ResponseEntity<?> show(@PathVariable long club_id){
		try {
		return new ResponseEntity<>(clubService.show(club_id), HttpStatus.OK);
		} catch(Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ClubUpdateDTO dto){
		try {
			return new ResponseEntity<>(clubService.update(dto), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{club_id}")
	public ResponseEntity<String> delete(@PathVariable long club_id){
		try {
			clubService.destroy(club_id);
			return new ResponseEntity<>("Club deleted successfully!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
}
