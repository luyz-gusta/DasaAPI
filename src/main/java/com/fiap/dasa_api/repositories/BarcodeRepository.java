package com.fiap.dasa_api.repositories;

import com.fiap.dasa_api.domain.entities.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarcodeRepository extends JpaRepository<Barcode, Long> {
    List<Barcode> findAllByStatusTrue();
}
