package com.example.SpringHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product_stocks")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "adresses")
    private String adresses;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
