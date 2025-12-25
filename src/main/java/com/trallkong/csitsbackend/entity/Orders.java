package com.trallkong.csitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Orders extends BaseEntity {

    // 订单 id
    @Id
    @Column(name = "order_id", nullable = false)
    @JsonProperty("order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // 买家 id
    @Column(name = "buyer_id", nullable = false)
    @JsonProperty("buyer_id")
    private Long buyerId;

    // 卖家 id
    @Column(name = "seller_id", nullable = false)
    @JsonProperty("seller_id")
    private Long sellerId;

    // 商品 id
    @Column(name = "gid", nullable = false)
    @JsonProperty("gid")
    private Long gid;

    // 订单状态
    @Column(name = "state", nullable = false)
    @JsonProperty("state")
    private Short state;

    // 订单金额
    @Column(name = "amount", nullable = false)
    @JsonProperty("amount")
    private BigDecimal amount;

    // 订单编号
    @Column(name = "order_no", nullable = false)
    @JsonProperty("order_no")
    private String orderNo;
}
