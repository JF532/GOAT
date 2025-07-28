package br.com.goat.api.DTOs;

public record ClubLeagueUpdateDTO(
    Long id,
    String season,
    Long clubId,
    Long leagueId
) {} 
