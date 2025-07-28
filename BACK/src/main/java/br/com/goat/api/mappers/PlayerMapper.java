package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.PlayerCreateDTO;
import br.com.goat.api.DTOs.PlayerResponseDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.Country;
import br.com.goat.api.entities.Player;
import br.com.goat.api.entities.Position;

public class PlayerMapper {

    public static PlayerResponseDTO toDTO(Player player){


        PlayerResponseDTO playerResponse = new PlayerResponseDTO(player.getId(), player.getName(), player.getSocialName(), player.getDateBirth(), player.getAge(), player.getPreferredFoot(), player.getHeight(), player.getMarketValue(), player.getPhotoUrl(),player.getNationalityId().getId(),player.getPrimaryPositionId().getId(),player.getClubId().getId());
        return playerResponse;
    }

    public static Player toEntity(PlayerCreateDTO playerCreateDTO,Country country, Position position, Club club){
        Player player = new Player();
        player.setName(playerCreateDTO.name());
        player.setSocialName(playerCreateDTO.socialName());
        player.setDateBirth(playerCreateDTO.dateBirth());
        player.setAge(playerCreateDTO.age());
        player.setPreferredFoot(playerCreateDTO.preferredFoot());
        player.setHeight(playerCreateDTO.height());
        player.setMarketValue(playerCreateDTO.marketValue());
        player.setPhotoUrl(playerCreateDTO.photoUrl());
        player.setNationalityId(country);
        player.setClubId(club);
        player.setPrimaryPositionId(position);
        return player;
    }
}
