package br.com.goat.api.DTOs;

public record LeagueUpdateDTO(
    Long id,
    String name,
    String type,
    String logoUrl,
    String division,
    Long currentChampionClubId 
) {} 
