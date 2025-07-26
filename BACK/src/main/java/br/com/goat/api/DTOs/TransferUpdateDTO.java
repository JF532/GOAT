package br.com.goat.api.DTOs;

import java.time.LocalDate;

public record TransferUpdateDTO(Long id, Long playerId, Long originClubId, Long destinyClubId, LocalDate transferDate,
                                String transferType, Double transferAmount) {
}
