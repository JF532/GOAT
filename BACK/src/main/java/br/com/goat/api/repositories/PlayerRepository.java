package br.com.goat.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.goat.api.entities.Player;

public interface PlayerRepository  extends JpaRepository<Player,Long>{
    
}
