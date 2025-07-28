package br.com.goat.api.DTOs;

public record ClubLeagueCreateDTO(
    String season,
    Long clubId,
    Long leagueId
) {
} 
