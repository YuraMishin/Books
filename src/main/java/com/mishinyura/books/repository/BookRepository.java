package com.mishinyura.books.repository;

import com.mishinyura.books.entity.BookV2;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface BookRepository.
 * Declares Book Repository.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.05.2022
 */
public interface BookRepository extends CrudRepository<BookV2, Long> {
}
