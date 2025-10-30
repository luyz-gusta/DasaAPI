package com.fiap.dasa_api.domain.entities;

import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.dto.material.UpdateMaterialDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name="tb_material")
@Entity(name="tb_material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

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
    @JoinColumn(name = "id_type_material")
    private TypeMaterial typeMaterial;

    public Material() {
    }

    public Material(Long id, String name, Boolean status, LocalDateTime created_at, LocalDateTime updated_at, User user, TypeMaterial typeMaterial) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
        this.typeMaterial = typeMaterial;
    }

    public Material(RequestMaterialDTO materialDTO, User user, TypeMaterial typeMaterial) {
        this.name = materialDTO.getName();
        this.quantity = materialDTO.getQuantity();
        this.status = true;
        this.user = user;
        this.typeMaterial = typeMaterial;
    }

    public void setUpdateMaterial(UpdateMaterialDTO materialDTO, User user, TypeMaterial typeMaterial) {
        this.name = materialDTO.getName();
        this.typeMaterial = typeMaterial;
        this.user = user;
        this.status = materialDTO.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public TypeMaterial getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(TypeMaterial typeMaterial) {
        this.typeMaterial = typeMaterial;
    }
}
