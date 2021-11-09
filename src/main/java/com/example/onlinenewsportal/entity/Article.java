package com.example.onlinenewsportal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String content;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Date createdTimestamp;

    public Article(String title, String description, String content, Category category, Date createdTimestamp) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.category = category;
        this.createdTimestamp = createdTimestamp;
    }

}