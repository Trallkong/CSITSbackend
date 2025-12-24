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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "phone", nullable = false)
    @JsonProperty("phone")
    private String phone;

    @Column(name = "school_id", nullable = false)
    @JsonProperty("school_id")
    private Long schoolId;

    @Column(name = "address", nullable = false)
    @JsonProperty("address")
    private String address;

    @Column(name = "rating")
    @JsonProperty("rating")
    private Short rating;

    @Column(name = "remark")
    @JsonProperty("remark")
    private String remark;
}
