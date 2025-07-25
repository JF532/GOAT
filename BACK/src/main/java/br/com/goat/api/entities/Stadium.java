package br.com.goat.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stadiums")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stadium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private int capacity;

	private String city;

	@OneToOne
	@JoinColumn(name = "countries")
	@Column(name = "country_id")
	private Country countryId;
}
