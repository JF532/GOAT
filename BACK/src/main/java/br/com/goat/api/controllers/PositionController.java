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

import br.com.goat.api.DTOs.PositionCreateDTO;
import br.com.goat.api.DTOs.PositionResponseDTO;
import br.com.goat.api.DTOs.PositionUpdateDTO;
import br.com.goat.api.services.PositionService;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    
    @Autowired
	PositionService positionService;
	
	@PostMapping("/register")
	public ResponseEntity<PositionResponseDTO> store(@RequestBody PositionCreateDTO positionCreateDTO) {
		return new ResponseEntity<>(positionService.store(positionCreateDTO), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<PositionResponseDTO>> list()
	{
		return new ResponseEntity<>(positionService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{position_id}")
	public ResponseEntity<PositionResponseDTO> show(@PathVariable long position_id) {
		try {
			return new ResponseEntity<>(positionService.show(position_id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<PositionResponseDTO> update(@RequestBody PositionUpdateDTO positionUpdateDTO) {
		try {
			return new ResponseEntity<>(positionService.update(positionUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{position_id}")
	public ResponseEntity<String> destroy(@PathVariable long position_id) {
		try {
			positionService.destroy(position_id);
			return new ResponseEntity<>("Position successfully deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
