package com.mishinyura.books.services;

import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.repositories.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Class BooksServiceImpl.
 * Implements Books Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.05.2022
 */
@RequiredArgsConstructor
@Service
public class BooksServiceImpl implements BooksService {
    /**
     * BooksRepository.
     */
    private final BooksRepository booksRepository;

    /**
     * Method gets all the books.
     *
     * @return List<BookV2>
     */
    @Override
    public List<BookV2> findAll() {
        return StreamSupport
                .stream(booksRepository.findAll().spliterator(), false)
                .toList();
    }

    /**
     * Method retrieves the specific book by id.
     *
     * @param id Id
     * @return BookV2
     */
    @Override
    public BookV2 findById(final Long id) {
        Optional<BookV2> book = booksRepository.findById(id);
        if (book.isEmpty()) {
            throw new RuntimeException("Book not found!");
        }
        return book.get();
    }
}
