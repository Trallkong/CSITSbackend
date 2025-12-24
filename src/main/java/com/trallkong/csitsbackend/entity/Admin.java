package com.trallkong.csitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Admin extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    @JsonProperty("admin_id")
    private Long adminId;

    @Column(name = "username", nullable = false)
    @JsonProperty("username")
    private String username;

    @Column(name = "password_hash", nullable = false)
    @JsonProperty("password_hash")
    private String passwordHash;

    @Column(name = "email", nullable = false)
    @JsonProperty("email")
    private String email;

    @Column(name = "phone", nullable = false)
    @JsonProperty("phone")
    private String phone;

    @Column(name = "id_card_hash", nullable = false)
    @JsonProperty("id_card_hash")
    private String idCardHash;

    @Column(name = "realname", nullable = false)
    @JsonProperty("realname")
    private String realname;
}
