package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.CountryCreateDTO;
import br.com.goat.api.DTOs.CountryResponseDTO;
import br.com.goat.api.entities.Country;

public class CountryMapper {
	public static Country toEntity(CountryCreateDTO dto) {
		Country country = new Country();
		country.setFullName(dto.fullName());
		country.setIsoCode(dto.isoCode());
		country.setFlagImageUrl(dto.flagImageUrl());
		
		return country;
	}

	public static CountryResponseDTO toDTO(Country country) {
		return new CountryResponseDTO(country.getId(), country.getFullName(), country.getIsoCode(),
				country.getFlagImageUrl());
	}
}
