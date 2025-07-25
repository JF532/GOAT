package br.com.goat.api.DTOs;

import java.time.LocalDate;

public record ClubCreateDTO(String legalName, String tradeName, long countryId, String logoImageUrl,
		Double marketValue, int squadSize, Long stadiumId, String manager, LocalDate foundationDate) {

}
