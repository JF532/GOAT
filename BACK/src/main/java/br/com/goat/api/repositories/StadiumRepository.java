package br.com.goat.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.goat.api.entities.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long>{

}
