package com.mishinyura.books.entities;

import com.mishinyura.books.domain.Book;

import java.time.LocalDateTime;

/**
 * Class Book.
 * Implements Book Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
public class BookV1 extends Book {
    /**
     * Created at.
     */
    private LocalDateTime createdAt;

    /**
     * Updated at.
     */
    private LocalDateTime updatedAt;

    /**
     * Version.
     */
    private Long version;

    /**
     * Constructor.
     */
    public BookV1() {
        super();
    }

    /**
     * Constructor.
     *
     * @param title Title
     */
    public BookV1(final String title) {
        super(title);
    }


    /**
     * Constructor.
     *
     * @param id    Id
     * @param title Title
     */
    public BookV1(final Long id, final String title) {
        super(id, title);
    }

    public BookV1(
            final Long id,
            final String title,
            final LocalDateTime createdAt,
            final LocalDateTime updatedAt,
            final Long version) {

        super(id, title);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.version = version;
    }

    @Override
    public String toString() {
        return "BookV1{" +
                "id=" + this.getId() +
                ", title=" + this.getTitle() +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", version=" + version +
                '}';
    }
}
