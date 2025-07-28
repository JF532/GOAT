package br.com.goat.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goat.api.DTOs.ClubLeagueCreateDTO;
import br.com.goat.api.DTOs.ClubLeagueResponseDTO;
import br.com.goat.api.DTOs.ClubLeagueUpdateDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.ClubLeague;
import br.com.goat.api.entities.League;
import br.com.goat.api.mappers.ClubLeagueMapper;
import br.com.goat.api.repositories.ClubLeagueRepository;
import br.com.goat.api.repositories.ClubRepository;
import br.com.goat.api.repositories.LeagueRepository;
import br.com.goat.api.repositories.ClubLeagueRepository;

@Service
public class ClubLeagueService {

    @Autowired
	ClubLeagueRepository clubLeagueRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    LeagueRepository leagueRepository;
	
	public ClubLeagueResponseDTO store(ClubLeagueCreateDTO clubLeagueCreateDTO) {
        Club club = clubRepository.findById(clubLeagueCreateDTO.clubeId()).orElseThrow(()-> new RuntimeException("Club with id:  "+ clubLeagueCreateDTO.clubeId() +" not found"));
        League league = leagueRepository.findById(clubLeagueCreateDTO.clubeId()).orElseThrow(()-> new RuntimeException("League with id:  "+ clubLeagueCreateDTO.clubeId() +" not found"));

		ClubLeague clubLeague = ClubLeagueMapper.toEntity(clubLeagueCreateDTO,club,league);
		clubLeagueRepository.save(clubLeague);
		return ClubLeagueMapper.toDTO(clubLeague);
	}
	
	public List<ClubLeagueResponseDTO> list() {
		return clubLeagueRepository.findAll().stream().map(ClubLeagueMapper::toDTO).toList();
	}
	
	public ClubLeagueResponseDTO show(long id) {
			ClubLeague clubLeague = clubLeagueRepository.findById(id)
					.orElseThrow(()->new RuntimeException("ClubLeague whit id: " + id + " not found"));
			return ClubLeagueMapper.toDTO(clubLeague);
	}
	
	public ClubLeagueResponseDTO update(ClubLeagueUpdateDTO clubLeagueUpdateDTO) {
        Club club = clubRepository.findById(clubLeagueUpdateDTO.clubeId()).orElseThrow(()-> new RuntimeException("Club not found for update"));
        League league = leagueRepository.findById(clubLeagueUpdateDTO.clubeId()).orElseThrow(()-> new RuntimeException("League not found for update"));
		ClubLeague clubLeague = clubLeagueRepository.findById(clubLeagueUpdateDTO.id()).orElseThrow(()->new RuntimeException("ClubLeague not found for update"));
        clubLeague.setTemporada(clubLeagueUpdateDTO.temporada());
        clubLeague.setClube(club);
        clubLeague.setLeague(league);
		return ClubLeagueMapper.toDTO(clubLeagueRepository.save(clubLeague));
	}
	
	public void destroy(long id) {
		ClubLeague clubLeague = clubLeagueRepository.findById(id).orElseThrow(()->new RuntimeException("ClubLeague not found for deletion"));
		clubLeagueRepository.delete(clubLeague);
	}
}
