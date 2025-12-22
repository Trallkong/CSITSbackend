package com.trallkong.csitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "buyer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Buyer extends BaseEntity {

    @Id
    @Column(name = "buyer_id", nullable = false)
    @JsonProperty("buyer_id")
    private Long buyerId;

    @Column(name = "username", nullable = false)
    @JsonProperty("username")
    private String username;

    @Column(name = "password_hash", nullable = false)
    @JsonProperty("password_hash")
    private String passwordHash;

    @Column(name = "id_card_hash")
    @JsonProperty("id_card_hash")
    private String idCardHash;

    @Column(name = "realname")
    @JsonProperty("realname")
    private String realname;

    @Column(name = "email", nullable = false)
    @JsonProperty("email")
    private String email;
}
