package com.example.SpringHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_addresses")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAdress {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Adress adress;
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Adress adress2;
}
