package com.trallkong.csitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Goods extends BaseEntity {

    // 商品 id
    @Id
    @Column(name = "gid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("gid")
    private Long gid;

    // 商品名
    @Column(name = "gname", nullable = false)
    @JsonProperty("gname")
    private String gname;

    // 商品类型 id
    @Column(name = "gtype_id", nullable = false)
    @JsonProperty("gtype_id")
    private Short gtypeId;

    // 新旧程度
    @Column(name = "don", nullable = false)
    @JsonProperty("don")
    private Short don;

    // 价格
    @Column(name = "price", nullable = false)
    @JsonProperty("price")
    private BigDecimal price;

    // 图片路径
    @Column(name = "image_path", nullable = false)
    @JsonProperty("image_path")
    private String imagePath;

    // 备注
    @Column(name = "remark")
    @JsonProperty("remark")
    private String remark;

    // 卖家 id
    @Column(name = "seller_id", nullable = false)
    @JsonProperty("seller_id")
    private Long sellerId;
}
