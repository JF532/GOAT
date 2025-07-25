package br.com.goat.api.entities;

import java.time.LocalDate;

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
@Table(name = "clubs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "legal_name")//nome completo
	private String legalName;

	@Column(name = "trade_name")//nome social
	private String tradeName;
	
	@OneToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@Column(name = "logo_image_url")
	private String logoImageUrl;
	
	@Column(name = "market_value")
	private Double marketValue;
	
	@Column(name = "squad_size")
	private int squadSize;
	
	@OneToOne
	@JoinColumn(name = "stadium_id")
	private Stadium stadium;

	private String manager;
	
	@Column(name = "foundation_date")
	private LocalDate foundationDate;
}
