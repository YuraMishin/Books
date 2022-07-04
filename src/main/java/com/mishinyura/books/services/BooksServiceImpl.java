package com.mishinyura.books.services;

import com.mishinyura.books.dao.BookV2Mapper;
import com.mishinyura.books.dao.SqlQueries;
import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.repositories.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class BooksServiceImpl.
 * Implements Books Service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.05.2022
 */
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
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
        return booksRepository.findAll(Sort.by("id"));
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
        return booksRepository
                .findById(id)
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    /**
     * Method retrieves the specific book by title.
     *
     * @param title Title
     * @return BookV2
     */
    @Override
    public Optional<BookV2> findByTitle(final String title) {
        return jdbcTemplate
                .query(
                        SqlQueries.FIND_BOOK_BY_TITLE,
                        new BeanPropertyRowMapper<>(BookV2.class),
                        title)
                .stream()
                .findAny();
    }

    /**
     * Method retrieves the specific book by title.
     *
     * @param title Title
     * @return BookV2
     */
    @Override
    public Optional<BookV2> findByTitleV2(final String title) {
        return booksRepository.findByTitle(title);
    }

    /**
     * Method retrieves the specific book by id.
     *
     * @param id Id
     * @return BookV2
     */
    public BookV2 findByIdViaJDBCTemplate(final Long id) {
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
    @Transactional
    public void deleteById(final Long id) {
        booksRepository.deleteById(id);
    }

    /**
     * Method adds ten books via batchUpdate.
     */
    public void addTenBooks() {
        jdbcTemplate.batchUpdate(
                SqlQueries.INSERT_BOOK,
                new BatchPreparedStatementSetter() {
                    Random rnd = ThreadLocalRandom.current();

                    @Override
                    public void setValues(
                            final PreparedStatement ps,
                            final int i) throws SQLException {
                        ps.setString(1, "batchUpdate" + rnd.nextInt(1000));
                    }

                    @Override
                    public int getBatchSize() {
                        return 10;
                    }
                });
    }

    /**
     * Method retrieves the specific books by title.
     *
     * @param title Title
     * @return List<BookV2>
     */
    @Override
    public List<BookV2> searchByTitle(final String title) {
        return booksRepository.findByTitleStartingWith(title);
    }

    /**
     * Method retrieves books with pagination.
     *
     * @param page         Page
     * @param booksPerPage Books per page
     * @return List<BookV2>
     */
    @Override
    public List<BookV2> findWithPagination(
            final Integer page,
            final Integer booksPerPage) {
        return booksRepository
                .findAll(PageRequest.of(page, booksPerPage, Sort.by("id")))
                .getContent();
    }
}
