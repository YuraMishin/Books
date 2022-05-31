package com.mishinyura.books.services;

import com.mishinyura.books.entities.BookV2;

import java.util.List;

/**
 * Interface BookService.
 * Declares Book Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.05.2022
 */
public interface BookService {
    /**
     * Method gets all the books.
     *
     * @return List<BookV2>
     */
    List<BookV2> findAll();
}
