package br.com.goat.api.DTOs;

public record ClubLeagueUpdateDTO(
    Long id,
    String temporada,
    Long clubeId,
    Long leagueId
) {} 
