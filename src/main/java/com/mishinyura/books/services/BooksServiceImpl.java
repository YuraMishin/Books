package com.mishinyura.books.services;

import com.mishinyura.books.dao.BookV2Mapper;
import com.mishinyura.books.dao.SqlQueries;
import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.repositories.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * JdbcTemplate.
     */
    private final JdbcTemplate jdbcTemplate;

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
     * Method gets all the books.
     *
     * @return List<BookV2>
     */
    public List<BookV2> findAllViaJDBCTemplate() {
        return jdbcTemplate
                .query(SqlQueries.FIND_ALL_BOOKS, new BookV2Mapper());
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

    /**
     * Method retrieves the specific book by id.
     *
     * @param id Id
     * @return BookV2
     */
    public BookV2 findByIdViaJDBCTemplate(final Long id) {
//        Optional<BookV2> book = booksRepository.findById(id);
//        if (bookFound.isEmpty()) {
//            throw new RuntimeException("Book not found!");
//        }
//        return bookFound.get(0);
        return jdbcTemplate
                .query(
                        SqlQueries.FIND_BOOK_BY_ID,
                        new BeanPropertyRowMapper<>(BookV2.class),
                        id)
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    /**
     * Method saves the book.
     *
     * @param book Book
     * @return BookV2
     */
    @Override
    @Transactional
    public BookV2 save(final BookV2 book) {
        return booksRepository.save(book);
    }

    /**
     * Method deletes book by id.
     *
     * @param id Id
     */
    @Override
    public void deleteById(final Long id) {
//        booksRepository.deleteById(id);
        jdbcTemplate.update(SqlQueries.DELETE_BOOK_BY_ID, id);
    }
}
