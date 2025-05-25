package com.fiap.dasa_api.repositories;

import com.fiap.dasa_api.domain.entities.Barcode;
import com.fiap.dasa_api.domain.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
