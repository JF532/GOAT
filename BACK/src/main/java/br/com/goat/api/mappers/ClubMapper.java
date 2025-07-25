package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.ClubCreateDTO;
import br.com.goat.api.DTOs.ClubResponseDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.Country;
import br.com.goat.api.entities.Stadium;

public class ClubMapper {

	public static Club toEntity(ClubCreateDTO dto, Country country, Stadium stadium) {
		Club club = new Club();

		club.setLegalName(dto.legalName());
		club.setTradeName(dto.tradeName());
		club.setCountry(country);
		club.setLogoImageUrl(dto.logoImageUrl());
		club.setMarketValue(dto.marketValue());
		club.setSquadSize(dto.squadSize());
		club.setStadium(stadium);
		club.setFoundationDate(dto.foundationDate());
		return club;
	}

	public static ClubResponseDTO toDTO(Club club) {
		return (new ClubResponseDTO(club.getId(), club.getLegalName(), club.getTradeName(), club.getCountry().getId(),
				club.getLogoImageUrl(), club.getMarketValue(), club.getSquadSize(), club.getStadium().getId(),
				club.getManager(), club.getFoundationDate()));
	}
}
