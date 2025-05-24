package com.fiap.dasa_api.domain.entities;

import com.fiap.dasa_api.domain.dto.typeMaterial.RequestTypeMaterialDTO;
import com.fiap.dasa_api.domain.dto.typeMaterial.UpdateTypeMaterialDTO;
import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name="tb_type_material")
@Entity(name="tb_type_material")
public class TypeMaterial {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_material")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

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

    public TypeMaterial() {
    }

    public TypeMaterial(Long id, String name, Boolean status, LocalDateTime created_at, LocalDateTime updated_at, User user) {
        this.id = id;
        this.name = name;
        this.status = true;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
    }

    public TypeMaterial(RequestTypeMaterialDTO typeMaterialDTO, User user) {
        this.name = typeMaterialDTO.getName();
        this.user = user;
        this.status = true;
    }

    public void setUpdateTypeMaterial(UpdateTypeMaterialDTO typeMaterialDTO, User user) {
        this.name = typeMaterialDTO.getName();
        this.user = user;
        this.status = typeMaterialDTO.getStatus();
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
}
