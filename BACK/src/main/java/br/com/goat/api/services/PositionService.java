package br.com.goat.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.PositionCreateDTO;
import br.com.goat.api.DTOs.PositionResponseDTO;
import br.com.goat.api.DTOs.PositionUpdateDTO;
import br.com.goat.api.entities.Player;
import br.com.goat.api.entities.Position;
import br.com.goat.api.mappers.PositionMapper;
import br.com.goat.api.repositories.PositionRepository;

import java.util.*;

@Service
public class PositionService {

    @Autowired
    PositionRepository positionRepository;

    public PositionResponseDTO store(PositionCreateDTO positionCreateDTO) {
        Position position = PositionMapper.toEntity(positionCreateDTO);
        positionRepository.save(position);
        return PositionMapper.toDTO(position);
    }

    public List<PositionResponseDTO> list(){
        return positionRepository.findAll().stream().map(PositionMapper::toDTO).toList();
    }

    public PositionResponseDTO show(Long id){
        Position position = positionRepository.findById(id).orElseThrow(()->new RuntimeException(" Position with id:" +id + "not found"));
        return PositionMapper.toDTO(position);
    }

    public PositionResponseDTO update(PositionUpdateDTO positionUpdateDTO){
        Position position = positionRepository.findById(positionUpdateDTO.id()).orElseThrow(()->new RuntimeException("Position not found for update"));
        position.setName(positionUpdateDTO.name());
        return PositionMapper.toDTO(positionRepository.save(position));
    }

    public void destroy(long id) {
		Position position = positionRepository.findById(id).orElseThrow(()->new RuntimeException("Position not found for deletion"));
		positionRepository.delete(position);
	}

}
