package com.mishinyura.books.entity;

import com.mishinyura.books.domain.Book;

/**
 * Class Book.
 * Implements Book Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
public class BookV1 extends Book {
    public BookV1() {
        super();
    }

    public BookV1(String title) {
        super(title);
    }

    public BookV1(Long id, String title) {
        super(id, title);
    }
}
