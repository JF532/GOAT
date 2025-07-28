package br.com.goat.api.DTOs;

public record LeagueCreateDTO(
    String name,
    String type,
    String logoUrl,
    String division,
    Long currentChampionClubId 
){}