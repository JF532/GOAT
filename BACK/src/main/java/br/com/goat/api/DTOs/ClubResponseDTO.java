package br.com.goat.api.DTOs;

import java.time.LocalDate;

public record ClubResponseDTO(long id, String legalName, String tradeName, long countryId, String logoImageUrl,
		Double marketValue, int squadSize, Long stadiumId, String manager, LocalDate foundationDate) {

}
