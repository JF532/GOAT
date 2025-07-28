package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.LeagueCreateDTO;
import br.com.goat.api.DTOs.LeagueResponseDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.League;

public class LeagueMapper {
    
    public static LeagueResponseDTO toDTO(League league){
        LeagueResponseDTO leagueResponseDTO = new LeagueResponseDTO(league.getId(),league.getName(),league.getType(),league.getLogoUrl(),league.getDivision(),league.getCurrentChampion().getId());

        return leagueResponseDTO;
    }

    public static League toEntity(LeagueCreateDTO leagueCreateDTO,Club club){
       League league = new League();
       league.setName(leagueCreateDTO.name());
       league.setType(leagueCreateDTO.type());
       league.setLogoUrl(leagueCreateDTO.logoUrl());
       league.setDivision(leagueCreateDTO.division());
       league.setCurrentChampion(club);

       return league;
    }
}
