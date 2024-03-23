package com.example.SpringHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "adresses")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "adress")
    private List<UserAdress>userAdressList;
    @OneToMany(mappedBy = "adress2")
    private List<UserAdress>userAdressList2;
}
