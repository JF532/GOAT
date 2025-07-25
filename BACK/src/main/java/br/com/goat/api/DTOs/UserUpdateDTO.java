package br.com.goat.api.DTOs;

public record UserUpdateDTO(
		long id,
		String name,
		String email,
		String password,
		String cpf,
		String telephone
		) {}
