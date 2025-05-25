package com.fiap.dasa_api.domain.entities;

import com.fiap.dasa_api.domain.dto.typeMovement.RequestTypeMovementDTO;
import com.fiap.dasa_api.domain.dto.typeMovement.UpdateTypeMovementDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name="tb_type_movement")
@Entity(name="tb_type_movement")
public class TypeMovement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_movement")
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

    public TypeMovement() {
    }

    public TypeMovement(Long id, String name, Boolean status, LocalDateTime created_at, LocalDateTime updated_at, User user) {
        this.id = id;
        this.name = name;
        this.status = true;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
    }

    public TypeMovement(RequestTypeMovementDTO TypeMovementDTO, User user) {
        this.name = TypeMovementDTO.getMovement();
        this.user = user;
        this.status = true;
    }

    public void setUpdateTypeMovement(UpdateTypeMovementDTO TypeMovementDTO, User user) {
        this.name = TypeMovementDTO.getMovement();
        this.user = user;
        this.status = TypeMovementDTO.getStatus();
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
