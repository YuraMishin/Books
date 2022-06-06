package com.mishinyura.books.repositories;

import com.mishinyura.books.models.BookV2;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface BooksRepository.
 * Declares Books Repository.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.05.2022
 */
public interface BooksRepository extends CrudRepository<BookV2, Long> {
}
