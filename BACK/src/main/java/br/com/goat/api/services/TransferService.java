package br.com.goat.api.services;

import br.com.goat.api.DTOs.TransferCreateDTO;
import br.com.goat.api.DTOs.TransferResponseDTO;
import br.com.goat.api.DTOs.TransferUpdateDTO;
import br.com.goat.api.entities.*;
import br.com.goat.api.mappers.TransferMapper;
import br.com.goat.api.repositories.ClubRepository;
import br.com.goat.api.repositories.PlayerRepository;
import br.com.goat.api.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    @Autowired
    TransferRepository transferRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    PlayerRepository playerRepository;

    public TransferResponseDTO store(TransferCreateDTO dto) {
        Club originClub = clubRepository.findById(dto.originClubId())
                .orElseThrow(() -> new RuntimeException("Origin club with id " + dto.originClubId() + " not found"));
        Club destinyClub = clubRepository.findById(dto.destinyClubId())
                .orElseThrow(() -> new RuntimeException("Destiny club with id " + dto.destinyClubId()+ " not found"));
        Player player = playerRepository.findById(dto.playerId())
                .orElseThrow(() -> new RuntimeException("Player with id " + dto.playerId() + " not found"));
        Transfer response = TransferMapper.toEntity(dto, player, originClub, destinyClub);
        transferRepository.save(response);
        return TransferMapper.toDTO(response);
    }

    public TransferResponseDTO show(long id) {
        Transfer transfer = transferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transfer with id " + id + " not found"));
        return TransferMapper.toDTO(transfer);
    }

    public List<TransferResponseDTO> list() {
        return transferRepository.findAll().stream().map(TransferMapper::toDTO).toList();
    }

    public TransferResponseDTO update(TransferUpdateDTO dto) {
        Transfer transfer = transferRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("Transfer with id " + dto.id() + " not found for update"));
        Club originClub = clubRepository.findById(dto.originClubId())
                .orElseThrow(() -> new RuntimeException("Origin club with id " + dto.originClubId() + " not found"));
        Club destinyClub = clubRepository.findById(dto.destinyClubId())
                .orElseThrow(() -> new RuntimeException("Destiny club with id " + dto.destinyClubId()+ " not found"));
        Player player = playerRepository.findById(dto.playerId())
                .orElseThrow(() -> new RuntimeException("Player with id " + dto.playerId() + " not found"));
        transfer.setPlayer(player);
        transfer.setOriginClub(originClub);
        transfer.setDestinyClub(destinyClub);
        transfer.setTransferDate(dto.transferDate());
        transfer.setTransferType(dto.transferType());
        transfer.setTransferAmount(dto.transferAmount());
        transferRepository.save(transfer);
        return TransferMapper.toDTO(transfer);
    }

    public void destroy(long id) {
        Transfer transfer = transferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transfer with id " + id + " not found"));
        transferRepository.delete(transfer);
    }
}
