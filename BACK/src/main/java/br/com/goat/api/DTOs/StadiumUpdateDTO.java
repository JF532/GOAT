package br.com.goat.api.DTOs;

public record StadiumUpdateDTO(long id, String name, int capacity, String city, long countryId) {

}
