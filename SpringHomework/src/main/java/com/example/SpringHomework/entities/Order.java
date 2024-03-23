package com.example.SpringHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "paymentDate")
    private BigDecimal paymentDate;
    @Column(name = "amount")
    private double amount;
    @Column(name = "orderStatus")
    private int orderStatus;
    @ManyToOne
    @JoinColumn(name = "paymentMethodId")
    private PaymentMethods paymentMethods;

}
