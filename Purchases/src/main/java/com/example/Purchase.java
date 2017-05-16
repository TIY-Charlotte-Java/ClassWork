package com.example;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jake on 5/10/17.
 */

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    int ccv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase() {
    }

    public Purchase(Customer customer, String date, String creditCard, int ccv, String category) {
        this.customer = customer;
        this.date = date;
        this.creditCard = creditCard;
        this.ccv = ccv;
        this.category = category;

    }


}
