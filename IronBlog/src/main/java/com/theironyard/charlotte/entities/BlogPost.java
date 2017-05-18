package com.theironyard.charlotte.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Ben on 5/18/17.
 */
@Entity // marks this class as an entity which will be stored by hibernate
@Table(name = "blog_posts") // sets the table name that will be used when this data is stored
public class BlogPost {
    @Id // mark this field as an id column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 140)
    String title;

    @Column(nullable = false)
    String subtitle;

    @Column(nullable = false)
    LocalDateTime date;

    @Column(nullable = false, length = 10000)
    String content;
}
