package com.mishinyura.books.services;

import com.mishinyura.books.models.BookV2;

import java.util.List;
import java.util.Optional;

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
     * Method retrieves the specific book by title.
     *
     * @param title Title
     * @return BookV2
     */
    Optional<BookV2> findByTitle(String title);

    /**
     * Method retrieves the specific book by title.
     *
     * @param title Title
     * @return BookV2
     */
    Optional<BookV2> findByTitleV2(String title);

    /**
     * Method saves the book.
     *
     * @param book Book
     * @return BookV2
     */
    BookV2 save(BookV2 book);

    /**
     * Method deletes book by id.
     *
     * @param id Id
     */
    void deleteById(Long id);

    /**
     * Method retrieves the specific books by title.
     *
     * @param title Title
     * @return List<BookV2>
     */
    List<BookV2> searchByTitle(String title);

    /**
     * Method retrieves books with pagination.
     *
     * @param page         Page
     * @param booksPerPage Books per page
     * @return List<BookV2>
     */
    List<BookV2> findWithPagination(Integer page, Integer booksPerPage);
}
