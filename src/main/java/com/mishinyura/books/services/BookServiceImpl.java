package com.mishinyura.books.services;

import com.mishinyura.books.entities.BookV2;
import com.mishinyura.books.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Class BookServiceImpl.
 * Implements Book Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.12.2021
 */
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookV2> findAll() {
        return StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .toList();
    }
}
