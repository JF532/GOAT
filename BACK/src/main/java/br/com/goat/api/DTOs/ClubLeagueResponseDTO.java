package br.com.goat.api.DTOs;

public record ClubLeagueResponseDTO(
    Long id,
    String season,
    Long clubId,
    Long leagueId
) {} 