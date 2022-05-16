package com.mishinyura.books.domain;

public class Book {
    private Long id;
    private String title;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
