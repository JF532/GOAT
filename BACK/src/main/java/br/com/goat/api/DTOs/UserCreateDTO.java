package br.com.goat.api.DTOs;

public record UserCreateDTO(
		String name,
		String email,
		String password,
		String cpf,
		String telephone
		) {}
