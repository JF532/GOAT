package br.com.goat.api.DTOs;

public record ClubLeagueResponseDTO(
    Long id,
    String temporada,
    Long clubeId,
    Long leagueId
) {} 