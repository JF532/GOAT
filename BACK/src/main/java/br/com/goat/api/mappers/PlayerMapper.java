package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.PlayerCreateDTO;
import br.com.goat.api.DTOs.PlayerResponseDTO;
import br.com.goat.api.entities.Player;

public class PlayerMapper {

    public static PlayerResponseDTO toDTO(Player player){
        PlayerResponseDTO playerResponse = new PlayerResponseDTO(player.getId(), player.getName(), player.getSocial_name(), player.getDateBirth(), player.getAge(), player.getPreferredFoot(), player.getHeight(), player.getMarketValue(), player.getPhotoUrl());
        return playerResponse;
    }

    public static Player toEntity(PlayerCreateDTO playerCreateDTO){
        Player player = new Player();
        player.setName(playerCreateDTO.name());
        player.setSocial_name(playerCreateDTO.social_name());
        player.setDateBirth(playerCreateDTO.dateBirth());
        player.setAge(playerCreateDTO.age());
        player.setPreferredFoot(playerCreateDTO.preferredFoot());
        player.setHeight(playerCreateDTO.height());
        player.setMarketValue(playerCreateDTO.marketValue());
        player.setPhotoUrl(playerCreateDTO.photoUrl());

        return player;
    }
}
