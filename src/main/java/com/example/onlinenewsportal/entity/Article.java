package com.example.onlinenewsportal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Date createdTimestamp;

    public Article(String title, String description, String content, Date createdTimestamp) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.createdTimestamp = createdTimestamp;
    }
}