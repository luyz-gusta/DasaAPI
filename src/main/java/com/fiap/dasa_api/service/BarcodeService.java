package com.fiap.dasa_api.service;

import com.fiap.dasa_api.domain.dto.barcode.RequestBarcodeDTO;
import com.fiap.dasa_api.domain.dto.barcode.UpdateBarcodeDTO;
import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.dto.material.UpdateMaterialDTO;
import com.fiap.dasa_api.domain.entities.Barcode;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.repositories.BarcodeRepository;
import com.fiap.dasa_api.repositories.MaterialRepository;
import com.fiap.dasa_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BarcodeService {
    private final BarcodeRepository repository;
    private final MaterialRepository materialRepository;
    private final UserRepository userRepository;

    public List<Barcode> listAllMaterial() {
        return repository
                .findAll();
    }


    public List<Barcode> listMaterialActive() {
        return repository
                .findAllByStatusTrue();
    }

    public Barcode listMaterialById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Barcode saveBarcode(RequestBarcodeDTO barcodeDTO) {
        User user = userRepository.findById(barcodeDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);
        Material material = materialRepository.findById(barcodeDTO.getIdMaterial()).orElseThrow(EntityNotFoundException::new);

        Barcode newBarcode = new Barcode(barcodeDTO, user, material);

        repository.save(newBarcode);
        return newBarcode;
    }

    @Transactional
    public Barcode editBarcode(UpdateBarcodeDTO barcodeDTO) {
        User user = userRepository.findById(barcodeDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);
        Material material = materialRepository.findById(barcodeDTO.getIdMaterial()).orElseThrow(EntityNotFoundException::new);
        Barcode barcode = repository
                .findById(barcodeDTO.getId())
                .orElseThrow(EntityNotFoundException::new);

        barcode.setUpdateBarcode(barcodeDTO, user, material);
        return barcode;
    }

    @Transactional
    public void excludeBarcode(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

}
