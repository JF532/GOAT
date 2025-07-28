package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.ClubLeagueCreateDTO;
import br.com.goat.api.DTOs.ClubLeagueResponseDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.ClubLeague;
import br.com.goat.api.entities.League;


public class ClubLeagueMapper {
    
    public static ClubLeagueResponseDTO toDTO(ClubLeague clubLeague){
        ClubLeagueResponseDTO clubLeagueResponseDTO = new ClubLeagueResponseDTO(clubLeague.getId(),clubLeague.getSeason(),clubLeague.getClub().getId(),clubLeague.getLeague().getId());

        return clubLeagueResponseDTO;
    }

    public static ClubLeague toEntity(ClubLeagueCreateDTO clubLeagueCreateDTO, Club club,League league){
        ClubLeague clubLeague = new ClubLeague();
        clubLeague.setSeason(clubLeagueCreateDTO.season());
        clubLeague.setClub(club);
        clubLeague.setLeague(league);

        return clubLeague;

    }
}
