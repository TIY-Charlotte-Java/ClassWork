package com.theironyard.charlotte.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Ben on 5/17/17.
 */
@Entity
@Table(name = "blog_entries")
public class BlogEntry {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String title;

    @Column(length = 40000, nullable = false)
    String content;

    @Column(nullable = false)
    LocalDateTime date;
}
