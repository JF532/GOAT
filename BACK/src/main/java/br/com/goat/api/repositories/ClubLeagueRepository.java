package br.com.goat.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.goat.api.entities.ClubLeague;

public interface ClubLeagueRepository extends JpaRepository<ClubLeague,Long> {   
} 