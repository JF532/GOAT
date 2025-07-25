package br.com.goat.api.DTOs;

import java.time.LocalDate;

public record ClubUpdateDTO(long id, String legalName, String tradeName, long countryId, String logoImageUrl,
		Double marketValue, int squadSize, long stadiumId, String manager, LocalDate foundationDate) {

}
