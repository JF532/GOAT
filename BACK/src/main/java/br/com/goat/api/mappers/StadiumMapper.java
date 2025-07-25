package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.StadiumCreateDTO;
import br.com.goat.api.DTOs.StadiumResponseDTO;
import br.com.goat.api.entities.Country;
import br.com.goat.api.entities.Stadium;

public class StadiumMapper {
	public static Stadium toEntity(StadiumCreateDTO dto, Country country) {
		Stadium stadium = new Stadium();
		stadium.setName(dto.name());
		stadium.setCapacity(dto.capacity());
		stadium.setCity(dto.city());
		stadium.setCountry(country);

		return stadium;
	}

	public static StadiumResponseDTO toDTO(Stadium stadium) {
		return new StadiumResponseDTO(stadium.getId(), stadium.getName(), stadium.getCapacity(), stadium.getCity(),
				stadium.getCountry().getId());
	}
}
