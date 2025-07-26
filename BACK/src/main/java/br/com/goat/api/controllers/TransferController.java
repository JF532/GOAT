package br.com.goat.api.controllers;

import br.com.goat.api.DTOs.TransferCreateDTO;
import br.com.goat.api.DTOs.TransferResponseDTO;
import br.com.goat.api.DTOs.TransferUpdateDTO;
import br.com.goat.api.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    
    @Autowired
    TransferService transferService;

    @PostMapping("/register")
    public ResponseEntity<?> store(@RequestBody TransferCreateDTO dto) {
        TransferResponseDTO response = transferService.store(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransferResponseDTO>> list(){
        return new ResponseEntity<>(transferService.list(), HttpStatus.OK);
    }

    @GetMapping("/{transfer_id}")
    public ResponseEntity<?> show(@PathVariable long transfer_id){
        try {
            return new ResponseEntity<>(transferService.show(transfer_id), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TransferUpdateDTO dto){
        try {
            return new ResponseEntity<>(transferService.update(dto), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{transfer_id}")
    public ResponseEntity<String> delete(@PathVariable long transfer_id){
        try {
            transferService.destroy(transfer_id);
            return new ResponseEntity<>("Transfer deleted successfully!", HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}
