package com.trallkong.csitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    @JsonProperty("payment_id")
    private Long paymentId;

    @Column(name = "order_id", nullable = false)
    @JsonProperty("order_id")
    private Long orderId;

    @Column(name = "amount", nullable = false)
    @JsonProperty("amount")
    private BigDecimal amount;

    @Column(name = "user_id", nullable = false)
    @JsonProperty("user_id")
    private Long userId;

    @Column(name = "pay_method", nullable = false)
    @JsonProperty("pay_method")
    private Short payMethod;

    @Column(name = "create_at", nullable = false)
    @JsonProperty("create_at")
    private LocalDateTime createAt;
}
