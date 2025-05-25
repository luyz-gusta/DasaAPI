package com.fiap.dasa_api.domain.entities;

import com.fiap.dasa_api.domain.dto.barcode.RequestBarcodeDTO;
import com.fiap.dasa_api.domain.dto.barcode.UpdateBarcodeDTO;
import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.dto.material.UpdateMaterialDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name="tb_barcode")
@Entity(name="tb_barcode")
public class Barcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barcode")
    private Long id;

    @Column(name = "barcode", nullable = false)
    private String barcode;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "status")
    private Boolean status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    public Barcode() {
    }

    public Barcode(Long id, String barcode, Boolean status, LocalDateTime created_at, LocalDateTime updated_at, User user, Material material) {
        this.id = id;
        this.barcode = barcode;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
        this.material = material;
    }

    public Barcode(RequestBarcodeDTO barcodeDTO, User user, Material material) {
        this.barcode = barcodeDTO.getBarcode();
        this.status = true;
        this.user = user;
        this.material = material;
    }



    public void setUpdateBarcode(UpdateBarcodeDTO barcodeDTO, User user, Material material) {
        this.barcode = barcodeDTO.getBarcode();
        this.material = material;
        this.user = user;
        this.status = barcodeDTO.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
