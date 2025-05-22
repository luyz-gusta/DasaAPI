package com.fiap.dasa_api.domain.entities;

import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.UpdateUserDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name="tb_user")
@Entity(name="tb_user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_birth", nullable = false)
    private Date date_birth;

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
    private String reset_token;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "valided_token")
    private LocalDateTime valided_token;

    public User() {}

    public User(RequestUserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.date_birth = userDTO.getDate_birth();
        this.password = userDTO.getPassword();
        this.photo = userDTO.getPhoto();
        this.registration = userDTO.getRegistration();
    }

    public User(UpdateUserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.date_birth = userDTO.getDate_birth();
        this.reset_token = userDTO.getReset_token();
        this.valided_token = userDTO.getValided_token();
        this.photo = userDTO.getPhoto();
        this.registration = userDTO.getRegistration();
    }

    public void setUpdatedUser(UpdateUserDTO userDTO){
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.date_birth = userDTO.getDate_birth();
        this.reset_token = userDTO.getReset_token();
        this.valided_token = userDTO.getValided_token();
        this.photo = userDTO.getPhoto();
        this.registration = userDTO.getRegistration();
    }

    public User(
            Long id_user, String name, Date date_birth, String registration,
            String email, String photo, String password, Boolean status,
            String reset_token, LocalDateTime created_at,
            LocalDateTime updated_at, LocalDateTime valided_token
    ) {
        this.id_user = id_user;
        this.name = name;
        this.date_birth = date_birth;
        this.registration = registration;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.status = status;
        this.reset_token = reset_token;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.valided_token = valided_token;
    }

    public Long getId() {
        return id_user;
    }

    public void setId(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
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

    public String getReset_token() {
        return reset_token;
    }

    public void setReset_token(String reset_token) {
        this.reset_token = reset_token;
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

    public LocalDateTime getValided_token() {
        return valided_token;
    }

    public void setValided_token(LocalDateTime valided_token) {
        this.valided_token = valided_token;
    }
}
