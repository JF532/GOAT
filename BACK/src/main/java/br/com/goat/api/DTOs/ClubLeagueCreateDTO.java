package br.com.goat.api.DTOs;

public record ClubLeagueCreateDTO(
    String temporada,
    Long clubeId,
    Long leagueId
) {
} 
