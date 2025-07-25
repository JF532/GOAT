package br.com.goat.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.UserCreateDTO;
import br.com.goat.api.DTOs.UserLoginDTO;
import br.com.goat.api.DTOs.UserResponseDTO;
import br.com.goat.api.DTOs.UserUpdateDTO;
import br.com.goat.api.entities.User;
import br.com.goat.api.mappers.UserMapper;
import br.com.goat.api.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserResponseDTO store(UserCreateDTO userCreateDTO) {
		User user = UserMapper.toEntity(userCreateDTO);
		userRepository.save(user);
		return UserMapper.toDTO(user);
	}


	public UserResponseDTO login(UserLoginDTO userLoginDTO) {
    User user = userRepository.findByEmail(userLoginDTO.email())
        .orElseThrow(() -> new RuntimeException("Email não encontrado"));

    if (!user.getPassword().equals(userLoginDTO.password())) {
        throw new RuntimeException("Senha incorreta");
    }

    return UserMapper.toDTO(user);
}

	
	public List<UserResponseDTO> list() {
		return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
	}
	
	public UserResponseDTO show(long id) {
			User user = userRepository.findById(id)
					.orElseThrow(()->new RuntimeException("User com id" + id + " não encontrado"));
			return UserMapper.toDTO(user);
	}
	
	public UserResponseDTO update(UserUpdateDTO userUpdateDTO) {
		User user = userRepository.findById(userUpdateDTO.id()).orElseThrow(()->new RuntimeException("User não encontrado para alteração"));
		user.setCpf(userUpdateDTO.cpf());
		user.setEmail(userUpdateDTO.email());
		user.setName(userUpdateDTO.name());
		user.setPassword(userUpdateDTO.password());
		user.setTelephone(userUpdateDTO.telephone());
		return UserMapper.toDTO(userRepository.save(user));
	}
	
	public void destroy(long id) {
		User user= userRepository.findById(id).orElseThrow(()->new RuntimeException("User não encontrado para deleção"));
		userRepository.delete(user);
	}
}
