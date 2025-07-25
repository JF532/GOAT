package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.PositionCreateDTO;
import br.com.goat.api.DTOs.PositionResponseDTO;
import br.com.goat.api.entities.Position;

public class PositionMapper {
    
    public static PositionResponseDTO toDTO(Position position){
        PositionResponseDTO positionResponse = new PositionResponseDTO(position.getId(),position.getName());
        return positionResponse;
    }

    public static Position toEntity(PositionCreateDTO positionCreateDTO){
        Position position = new Position();
        position.setName(positionCreateDTO.name());
        return position;
    }
}
