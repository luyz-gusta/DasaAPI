package com.fiap.dasa_api.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.UpdateUserDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "tb_user")
@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_birth", nullable = false)
    private Date dateBirth;

    @Column(name = "registration")
    private String registration;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "photo")
    private String photo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "reset_token")
    private String resetToken;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "valided_token")
    private LocalDateTime validedToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TypeMaterial> typeMaterials = new HashSet<>();

    public User() {}

    public User(RequestUserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.dateBirth = userDTO.getDateBirth();
        this.password = userDTO.getPassword();
        this.photo = userDTO.getPhoto();
        this.registration = userDTO.getRegistration();
        this.status = true;
    }

    public User(UpdateUserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.dateBirth = userDTO.getDateBirth();
        this.resetToken = userDTO.getResetToken();
        this.validedToken = userDTO.getValidedToken();
        this.photo = userDTO.getPhoto();
        this.registration = userDTO.getRegistration();
    }

    public void setUpdatedUser(UpdateUserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.dateBirth = userDTO.getDateBirth();
        this.resetToken = userDTO.getResetToken();
        this.validedToken = userDTO.getValidedToken();
        this.photo = userDTO.getPhoto();
        this.registration = userDTO.getRegistration();
    }

    public User(Long id, String name, Date dateBirth, String registration, String email, String photo, String password, Boolean status, String resetToken, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime validedToken) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.registration = registration;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.status = status;
        this.resetToken = resetToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.validedToken = validedToken;
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdated_at(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getValidedToken() {
        return validedToken;
    }

    public void setValidedToken(LocalDateTime validedToken) {
        this.validedToken = validedToken;
    }
}
