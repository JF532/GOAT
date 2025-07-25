package br.com.goat.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.goat.api.entities.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long>{

}
