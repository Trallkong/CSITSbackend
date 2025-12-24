package com.trallkong.csitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gtype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class Gtype extends BaseEntity {

    // 商品类型 id
    @Id
    @Column(name = "gtype_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("gtype_id")
    private Short gtypeId;

    // 商品类型名
    @Column(name = "type_name", nullable = false)
    @JsonProperty("type_name")
    private String typeName;
}
