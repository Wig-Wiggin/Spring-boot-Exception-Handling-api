package com.example.backendapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(name = "item_left",nullable = false)
    private int itemLeft;

    @ManyToOne
    private Category category;

    public Product(String name, double price, int itemLeft) {
        this.name = name;
        this.price = price;
        this.itemLeft = itemLeft;
    }

    public Product(int id, String name, double price, int itemLeft) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.itemLeft = itemLeft;
    }
}
