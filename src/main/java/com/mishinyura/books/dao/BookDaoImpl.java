package com.mishinyura.books.dao;

import com.mishinyura.books.dto.BookFilter;
import com.mishinyura.books.entity.BookV1;
import com.mishinyura.books.exception.DaoException;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

/**
 * Class BookDaoImpl.
 * Implements Book DAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
@Slf4j
public class BookDaoImpl implements Dao<Long, BookV1> {
    /**
     * INSTANCE.
     */
    private static final BookDaoImpl INSTANCE = new BookDaoImpl();

    /**
     * BookEntityMapper.
     */
    public static final BookEntityMapper MAPPER = new BookEntityMapper();

    /**
     * Constructor.
     */
    private BookDaoImpl() {
    }

    /**
     * @return INSTANCE
     */
    public static BookDaoImpl getInstance() {
        return INSTANCE;
    }

    /**
     * Method saves book.
     *
     * @param book BookV1
     * @param conn Connection
     * @return BookV1
     */
    public BookV1 save(final BookV1 book, final Connection conn) {
        try (PreparedStatement ps = conn.prepareStatement(SqlQueries.INSERT_BOOK, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, book.getTitle());
            log.info("{} row(s) inserted", ps.executeUpdate());
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    book.setId(keys.getLong("id"));
                }
            }
            return book;
        } catch (SQLException e) {
            log.error(
                    "Exception caught while performing save book: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }

    /**
     * Method gets all books.
     *
     * @param conn Connection
     * @return List<BookV1>
     */
    public List<BookV1> findAll(final Connection conn) {
        try (PreparedStatement ps = conn.prepareStatement(SqlQueries.FIND_ALL_BOOKS)) {
            List<BookV1> books = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    books.add(MAPPER.map(rs));
                }
            }
            log.info("{} row(s) fetched", books.size());
            return books;
        } catch (SQLException e) {
            log.error(
                    "Exception caught while performing find all: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }

    /**
     * Method finds book by id.
     *
     * @param id   Id
     * @param conn Connection
     * @return Optional<BookV1>
     */
    public Optional<BookV1> findById(final Long id, final Connection conn) {
        try (PreparedStatement ps = conn.prepareStatement(SqlQueries.FIND_BOOK_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            BookV1 book = null;
            if (rs.next()) {
                book = MAPPER.map(rs);
            }
            Optional<BookV1> bookReturn = Optional.ofNullable(book);
            bookReturn.ifPresentOrElse(
                    bookV1 -> log.info("1 row found"),
                    () -> log.info("0 row found")
            );
            return bookReturn;

        } catch (SQLException e) {
            log.error(
                    "Exception caught while performing find by id: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }

    /**
     * Method updates book.
     *
     * @param book BookV1
     * @param conn Connection
     */
    public void update(final BookV1 book, final Connection conn) {
        try (PreparedStatement ps = conn.prepareStatement(SqlQueries.UPDATE_BOOK_BY_ID)) {
            ps.setString(1, book.getTitle());
            ps.setLong(2, book.getId());
            log.info("{} row updated", ps.executeUpdate());

        } catch (SQLException e) {
            log.error(
                    "Exception caught while performing update book: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }

    /**
     * Method deletes book by id.
     *
     * @param id   Id
     * @param conn Connection
     * @return boolean
     */
    public boolean delete(final Long id, final Connection conn) {
        try (PreparedStatement ps = conn.prepareStatement(SqlQueries.DELETE_BOOK_BY_ID)) {
            ps.setLong(1, id);
            boolean result = ps.executeUpdate() > 0;
            if (result) {
                log.info("1 row deleted");
            } else {
                log.info("0 row deleted");

            }
            return result;
        } catch (SQLException e) {
            log.error(
                    "Exception caught while performing delete book: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }

    /**
     * Method gets books between two dates.
     *
     * @param conn  Connection
     * @param start Start
     * @param end   End
     * @return List<BookV1>
     */
    public List<BookV1> getBooksBetweenTwoDates(
            final Connection conn,
            final LocalDateTime start,
            final LocalDateTime end) {
        try (PreparedStatement ps = conn.prepareStatement(SqlQueries.GET_BOOKS_BETWEEN_TWO_DATES)) {
            ps.setTimestamp(1, Timestamp.valueOf(start));
            ps.setTimestamp(2, Timestamp.valueOf(end));
            log.debug(ps.toString());
            List<BookV1> books = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    books.add(MAPPER.map(rs));
                }
            }
            log.info("{} row(s) fetched", books.size());
            return books;
        } catch (SQLException e) {
            log.error(
                    "Exception caught while performing getBooksBetween(): {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }

    /**
     * Method gets all books.
     *
     * @param filter Filter
     * @param conn   Connection
     * @return List<Book>
     */
    public List<BookV1> findAll(final BookFilter filter, final Connection conn) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereSql = new ArrayList<>();
        if (filter.title() != null) {
            whereSql.add("title = ?");
            parameters.add(filter.title());
        }

        parameters.add(filter.limit());
        parameters.add(filter.offset());

        String where = whereSql
                .stream()
                .collect(joining(" AND ", " WHERE ", " LIMIT ? OFFSET ?"));

        String sql = SqlQueries.FIND_ALL_BOOKS + where;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < parameters.size(); i++) {
                ps.setObject(i + 1, parameters.get(i));
            }

            List<BookV1> books = new ArrayList<>();
            log.debug(ps.toString());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    books.add(MAPPER.map(rs));
                }
            }
            log.info("{} row(s) fetched", books.size());
            return books;
        } catch (SQLException e) {
            log.error(
                    "Exception caught while performing find all by filter: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }
}
