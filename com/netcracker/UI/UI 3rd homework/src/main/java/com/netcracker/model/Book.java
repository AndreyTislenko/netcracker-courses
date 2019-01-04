package com.netcracker.model;

import java.util.Calendar;

public class Book {
    private Integer id;
    private String author;
    private String name;
    private Integer pages;
    private Calendar dateOfPublishing;
    private Calendar dateOfAdding;

    public Book() {}
    public Book(int id, String author, String name, int pages, Calendar dateOfPublishing, Calendar dateOfAdding) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.pages = pages;
        this.dateOfPublishing = dateOfPublishing;
        this.dateOfAdding = dateOfAdding;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public Calendar getDateOfPublishing() {
        return dateOfPublishing;
    }
    public void setDateOfPublishing(Calendar dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }
    public Calendar getDateOfAdding() {
        return dateOfAdding;
    }
    public void setDateOfAdding(Calendar dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }
}