package com.example.SpringHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;
    @Column(name = "price")
    private String price;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private String date;
    @Column(name = "product_name")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<ProductComment>productCommentList;








    @OneToMany(mappedBy = "product")
    private List<ProductStock>productStockList;
}
