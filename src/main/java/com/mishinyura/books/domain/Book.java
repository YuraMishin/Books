package com.mishinyura.books.domain;

/**
 * Class Book.
 * Implements Book.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
public class Book {
    /**
     * Id.
     */
    private Long id;

    /**
     * Title.
     */
    private String title;

    /**
     * Constructor.
     */
    public Book() {
    }

    /**
     * Constructor.
     */
    public Book(String title) {
        this.title = title;
    }

    /**
     * Constructor.
     */
    public Book(final Long id, final String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title Title
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @param id Id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return Id
     */
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
