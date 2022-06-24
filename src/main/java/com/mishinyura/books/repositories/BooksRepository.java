package com.mishinyura.books.repositories;

import com.mishinyura.books.models.BookV2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interface BooksRepository.
 * Declares Books Repository.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.05.2022
 */
public interface BooksRepository extends JpaRepository<BookV2, Long> {
    /**
     * Method finds book by title.
     *
     * @param title Title
     * @return Optional<BookV2>
     */
    Optional<BookV2> findByTitle(String title);

    /**
     * Method finds book by title starting with some letters.
     *
     * @param title Title
     * @return List<BookV2>
     */
    List<BookV2> findByTitleStartingWith(String title);
}
