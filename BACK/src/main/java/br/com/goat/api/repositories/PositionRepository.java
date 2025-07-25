package br.com.goat.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.goat.api.entities.Position;

public interface PositionRepository extends JpaRepository<Position,Long> {
    
}
