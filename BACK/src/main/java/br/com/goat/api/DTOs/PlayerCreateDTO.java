package br.com.goat.api.DTOs;

import java.sql.Date;
import java.time.LocalDate;

public record PlayerCreateDTO(
        String name,
        String social_name,
        LocalDate dateBirth,
        int age,
        String preferredFoot,
        String height,
        Double marketValue,
        String photoUrl
        ) {
}