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

import br.com.goat.api.DTOs.StadiumCreateDTO;
import br.com.goat.api.DTOs.StadiumResponseDTO;
import br.com.goat.api.DTOs.StadiumUpdateDTO;
import br.com.goat.api.services.StadiumService;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {

	@Autowired
	StadiumService stadiumService;

	@PostMapping("/register")
	public ResponseEntity<?> store(@RequestBody StadiumCreateDTO dto) {
		StadiumResponseDTO response = stadiumService.store(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<StadiumResponseDTO>> list() {
		return new ResponseEntity<>(stadiumService.list(), HttpStatus.OK);
	}

	@GetMapping("/{stadium_id}")
	public ResponseEntity<?> show(@PathVariable long stadium_id) {
		try {
			return new ResponseEntity<>(stadiumService.show(stadium_id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody StadiumUpdateDTO dto) {
		try {
			return new ResponseEntity<>(stadiumService.update(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{stadium_id}")
	public ResponseEntity<String> delete(@PathVariable long stadium_id) {
		try {
			stadiumService.destroy(stadium_id);
			return new ResponseEntity<>("Club deleted successfully!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
}
