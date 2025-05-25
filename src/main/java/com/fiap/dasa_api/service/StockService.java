package com.fiap.dasa_api.service;

import com.fiap.dasa_api.domain.dto.stock.RequestStockDTO;
import com.fiap.dasa_api.domain.dto.stock.UpdateStockDTO;
import com.fiap.dasa_api.domain.entities.*;
import com.fiap.dasa_api.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService {
    private final StockRepository repository;
    private final TypeMovementRepository typeMovementRepository;
    private final UserRepository userRepository;
    private final BarcodeRepository barcodeRepository;

    public List<Stock> listAllStock() {
        return repository
                .findAll();
    }

    public Stock listStockById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Stock saveStock(RequestStockDTO stockDTO) {
        User user = userRepository.findById(stockDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);
        Barcode barcode = barcodeRepository.findById(stockDTO.getIdBarcode()).orElseThrow(EntityNotFoundException::new);
        TypeMovement typeMovement = typeMovementRepository.findById(stockDTO.getIdTypeMovement()).orElseThrow(EntityNotFoundException::new);

        Stock newStock = new Stock(stockDTO, user, barcode, typeMovement);

        repository.save(newStock);

        return newStock;
    }

    @Transactional
    public Stock editStock(UpdateStockDTO stockDTO) {
        User user = userRepository.findById(stockDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);
        Barcode barcode = barcodeRepository.findById(stockDTO.getIdBarcode()).orElseThrow(EntityNotFoundException::new);
        TypeMovement typeMovement = typeMovementRepository.findById(stockDTO.getIdTypeMovement()).orElseThrow(EntityNotFoundException::new);

        Stock stock = repository
                .findById(stockDTO.getId())
                .orElseThrow(EntityNotFoundException::new);

        stock.setUpdateStock(stockDTO, user, barcode, typeMovement);
        return stock;
    }

    @Transactional
    public void excludeStock(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
