package com.example;

import javax.persistence.*;

/**
 * Created by Jake on 5/10/17.
 */


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
            String name;

    @Column(nullable = false)
            String email;


    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
