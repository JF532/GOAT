package br.com.goat.api.entities;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="clubLeagues")
public class ClubLeague {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String temporada;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clube_id")
    private Club clube; 
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "league_id")
    private League league; 
}
