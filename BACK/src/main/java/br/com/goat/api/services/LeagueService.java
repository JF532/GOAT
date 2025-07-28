package br.com.goat.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.LeagueCreateDTO;
import br.com.goat.api.DTOs.LeagueResponseDTO;
import br.com.goat.api.DTOs.LeagueUpdateDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.ClubLeague;
import br.com.goat.api.entities.League;
import br.com.goat.api.entities.Player;
import br.com.goat.api.mappers.LeagueMapper;
import br.com.goat.api.repositories.ClubRepository;
import br.com.goat.api.repositories.LeagueRepository;

@Service
public class LeagueService {
    
    @Autowired
    LeagueRepository leagueRepository;

    @Autowired
    ClubRepository clubRepository;

    public LeagueResponseDTO store(LeagueCreateDTO leagueCreateDTO){
        Club club = clubRepository.findById(leagueCreateDTO.currentChampionClubId()).orElseThrow(()->new RuntimeException("Club whit id: " + leagueCreateDTO.currentChampionClubId() + " not found"));

        League league = LeagueMapper.toEntity(leagueCreateDTO,club);
        leagueRepository.save(league);
        return LeagueMapper.toDTO(league);
    }

    public List<LeagueResponseDTO> list(){
        return leagueRepository.findAll().stream().map(LeagueMapper::toDTO).toList();
    }   

    public LeagueResponseDTO show(long id){
        League league = leagueRepository.findById(id).orElseThrow(()-> new RuntimeException("League whit id:" + id + " not found"));
        return LeagueMapper.toDTO(league);
    }

    public LeagueResponseDTO update(LeagueUpdateDTO leagueUpdateDTO){
        League league = leagueRepository.findById(leagueUpdateDTO.id()).orElseThrow(()-> new RuntimeException("League not found for update"));
        Club club = clubRepository.findById(leagueUpdateDTO.currentChampionClubId()).orElseThrow(()->new RuntimeException("Club not found for update"));
        league.setName(leagueUpdateDTO.name());
        league.setType(leagueUpdateDTO.type());
        league.setLogoUrl(leagueUpdateDTO.logoUrl());
        league.setDivision(leagueUpdateDTO.division());
        league.setCurrentChampion(club);

        return LeagueMapper.toDTO(leagueRepository.save(league));
        
    }

    public void destroy(long id) {
		League league = leagueRepository.findById(id).orElseThrow(()->new RuntimeException("League not found for deletion"));
		leagueRepository.delete(league);
	}

}
