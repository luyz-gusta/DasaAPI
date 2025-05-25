package com.fiap.dasa_api.domain.entities;

import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.dto.material.UpdateMaterialDTO;
import com.fiap.dasa_api.domain.dto.stock.RequestStockDTO;
import com.fiap.dasa_api.domain.dto.stock.UpdateStockDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "tb_stock")
@Table(name = "tb_stock")
public class Stock {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_stock", nullable = false)
    private long idStock;

    @Column(name = "quantity_movemented", nullable = false)
    private int quantityMovemented;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_type_movement")
    private TypeMovement typeMovement;

    @ManyToOne
    @JoinColumn(name = "id_barcode")
    private Barcode barcode;

    public Stock(long idStock, int quantityMovemented, Timestamp createdAt, Timestamp updatedAt, User user, TypeMovement typeMovement, Barcode barcode) {
        this.idStock = idStock;
        this.quantityMovemented = quantityMovemented;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.typeMovement = typeMovement;
        this.barcode = barcode;
    }

    public Stock() {
    }

    public Stock(RequestStockDTO barcodeDTO, User user, Barcode barcode, TypeMovement typeMovement) {
        this.quantityMovemented = barcodeDTO.getQuantityMovemented();
        this.user = user;
        this.barcode = barcode;
        this.typeMovement = typeMovement;
    }

    public void setUpdateStock(UpdateStockDTO stockDTO, User user, Barcode barcode, TypeMovement typeMovement) {
        this.quantityMovemented = stockDTO.getQuantityMovemented();
        this.barcode = barcode;
        this.user = user;
        this.typeMovement = typeMovement;
    }

    public long getIdStock() {
        return idStock;
    }

    public void setIdStock(long idStock) {
        this.idStock = idStock;
    }

    public int getQuantityMovemented() {
        return quantityMovemented;
    }

    public void setQuantityMovemented(int quantityMovemented) {
        this.quantityMovemented = quantityMovemented;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeMovement getTypeMovement() {
        return typeMovement;
    }

    public void setTypeMovement(TypeMovement typeMovement) {
        this.typeMovement = typeMovement;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }
}
