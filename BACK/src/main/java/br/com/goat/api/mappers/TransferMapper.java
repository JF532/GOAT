package br.com.goat.api.mappers;

import br.com.goat.api.DTOs.TransferCreateDTO;
import br.com.goat.api.DTOs.TransferResponseDTO;
import br.com.goat.api.entities.Club;
import br.com.goat.api.entities.Player;
import br.com.goat.api.entities.Transfer;

public class TransferMapper {
    public static Transfer toEntity(TransferCreateDTO dto, Player player,Club originClub, Club destinyClub) {
        Transfer transfer = new Transfer();
        transfer.setPlayer(player);
        transfer.setOriginClub(originClub);
        transfer.setDestinyClub(destinyClub);
        transfer.setTransferDate(dto.transferDate());
        transfer.setTransferType(dto.transferType());
        transfer.setTransferAmount(dto.transferAmount());
        return transfer;
    }

    public static TransferResponseDTO toDTO(Transfer transfer) {
        return new TransferResponseDTO(transfer.getId(), transfer.getPlayer().getId(), transfer.getOriginClub().getId(), transfer.getDestinyClub().getId(), transfer.getTransferDate(), transfer.getTransferType(), transfer.getTransferAmount());
    }
}
