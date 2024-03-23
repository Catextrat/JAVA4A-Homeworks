package com.example.SpringHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderStatus")
public class OrderStatus {
    @Column(name = "id")//Bu ıd tanımlamasında sıkıntı çıkabilir herhangi bir bugda buraya bak!!!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "picture1")
    private String picture1;
    @Column(name = "picture2")
    private String picture2;
    @Column(name = "picture3")
    private String picture3;



}
