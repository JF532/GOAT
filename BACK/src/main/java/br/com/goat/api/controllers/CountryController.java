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

import br.com.goat.api.DTOs.CountryCreateDTO;
import br.com.goat.api.DTOs.CountryResponseDTO;
import br.com.goat.api.DTOs.CountryUpdateDTO;
import br.com.goat.api.services.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@PostMapping("/register")
	public ResponseEntity<?> store(@RequestBody CountryCreateDTO dto) {
		CountryResponseDTO response = countryService.store(dto);
	    return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CountryResponseDTO>> list(){
		return new ResponseEntity<>(countryService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{country_id}")
	public ResponseEntity<?> show(@PathVariable long country_id){
		try {
		return new ResponseEntity<>(countryService.show(country_id), HttpStatus.OK);
		} catch(Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CountryUpdateDTO dto){
		try {
			return new ResponseEntity<>(countryService.update(dto), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{country_id}")
	public ResponseEntity<String> delete(@PathVariable long country_id){
		try {
			countryService.destroy(country_id);
			return new ResponseEntity<>("Club deleted successfully!", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
}
