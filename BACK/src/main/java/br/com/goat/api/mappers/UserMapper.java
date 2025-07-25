package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.UserCreateDTO;
import br.com.goat.api.DTOs.UserResponseDTO;
import br.com.goat.api.entities.User;

public class UserMapper {

	public static UserResponseDTO toDTO(User user) {
		UserResponseDTO userResponse = new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getCpf(), user.getTelephone());
		return userResponse;
	}
	
	public static User toEntity(UserCreateDTO userCreateDTO) {
		User user = new User();
		user.setName(userCreateDTO.name());
		user.setEmail(userCreateDTO.email());
		user.setPassword(userCreateDTO.password());
		user.setCpf(userCreateDTO.cpf());
		user.setTelephone(userCreateDTO.telephone());
		return user;
	}	
}
