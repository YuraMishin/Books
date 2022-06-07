package com.mishinyura.books.services;

import com.mishinyura.books.models.BookV2;

import java.util.List;

/**
 * Interface BooksService.
 * Declares Books Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.05.2022
 */
public interface BooksService {
    /**
     * Method gets all the books.
     *
     * @return List<BookV2>
     */
    List<BookV2> findAll();

    /**
     * Method retrieves the specific book by id.
     *
     * @param id Id
     * @return BookV2
     */
    BookV2 findById(Long id);

    /**
     * Method saves the book.
     *
     * @param book Book
     * @return BookV2
     */
    BookV2 save(BookV2 book);
}
