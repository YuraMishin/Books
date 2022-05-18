package com.mishinyura.books.db;

/**
 * Class SqlQueries.
 * Implements Sql Queries storage.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
public final class SqlQueries {
    /**
     * Constructor.
     */
    private SqlQueries() {
    }

    /**
     * Insert a book into Books Table.
     */
    public static final String INSERT_BOOK = """
            INSERT INTO books (title) VALUES (?);
            """;

    /**
     * Find all books.
     */
    public static final String FIND_ALL_BOOKS = """
            SELECT id, title
            FROM books
            """;
}
