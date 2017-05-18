package com.theironyard.charlotte.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ben on 5/17/17.
 */
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @OneToMany
    List<BlogEntry> entries;
}
