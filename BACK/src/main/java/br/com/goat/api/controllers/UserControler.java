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

import br.com.goat.api.DTOs.UserCreateDTO;
import br.com.goat.api.DTOs.UserLoginDTO;
import br.com.goat.api.DTOs.UserResponseDTO;
import br.com.goat.api.DTOs.UserUpdateDTO;
import br.com.goat.api.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserControler {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> store(@RequestBody UserCreateDTO userCreateDTO) {
		return new ResponseEntity<>(userService.store(userCreateDTO), HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {
		try {
			UserResponseDTO user = userService.login(userLoginDTO);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> list() {
		return new ResponseEntity<>(userService.list(), HttpStatus.OK);
	}

	@GetMapping("/{user_id}")
	public ResponseEntity<UserResponseDTO> show(@PathVariable long user_id) {
		try {
			return new ResponseEntity<>(userService.show(user_id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping
	public ResponseEntity<UserResponseDTO> update(@RequestBody UserUpdateDTO userUpdateDTO) {
		try {
			return new ResponseEntity<>(userService.update(userUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{user_id}")
	public ResponseEntity<String> destroy(@PathVariable long user_id) {
		try {
			userService.destroy(user_id);
			return new ResponseEntity<>("Cliente deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
