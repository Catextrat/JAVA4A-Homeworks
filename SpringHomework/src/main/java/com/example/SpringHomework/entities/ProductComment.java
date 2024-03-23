package com.example.SpringHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "productComments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductComment {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
