package com.trallkong.csitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seller")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Seller extends BaseEntity {

    @Id
    @Column(name = "seller_id", nullable = false)
    @JsonProperty("seller_id")
    private Long sellerId;

    @Column(name = "username", nullable = false)
    @JsonProperty("username")
    private String username;

    @Column(name = "password_hash", nullable = false)
    @JsonProperty("password_hash")
    private String passwordHash;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "phone", nullable = false)
    @JsonProperty("phone")
    private String phone;

    @Column(name = "id_card_hash")
    @JsonProperty("id_card_hash")
    private String idCardHash;

    @Column(name = "realname")
    @JsonProperty("realname")
    private String realname;

    @Column(name = "school_id", nullable = false)
    @JsonProperty("school_id")
    private Long schoolId;

    @Column(name = "rating")
    @JsonProperty("rating")
    private Short rating;

    @Column(name = "remark")
    @JsonProperty("remark")
    private String remark;
}
