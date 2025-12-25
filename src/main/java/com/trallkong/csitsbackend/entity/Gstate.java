package com.trallkong.csitsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gstate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Gstate extends BaseEntity{

    // 商品 id
    @Id
    @Column(name = "gid", nullable = false)
    private Long gid;

    // 商品状态
    @Column(name = "state", nullable = false)
    private Short state;
}
