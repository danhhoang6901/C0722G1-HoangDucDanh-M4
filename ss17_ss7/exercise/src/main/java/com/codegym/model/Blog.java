package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String dateSubmitted;
    private String author;
    private String content;

    @ManyToOne
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(int id, String title, String dateSubmitted, String author, String content, Category category) {
        this.id = id;
        this.title = title;
        this.dateSubmitted = dateSubmitted;
        this.author = author;
        this.content = content;
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String title, String dateSubmitted, String author, String content) {
        this.id = id;
        this.title = title;
        this.dateSubmitted = dateSubmitted;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
