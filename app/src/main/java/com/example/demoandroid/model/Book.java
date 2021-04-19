package com.example.demoandroid.model;

public class Book {
    private String name;
    private String url;
    private String author;

    public Book(String name, String url, String author) {
        this.name = name;
        this.url = url;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
