package com.mishinyura.books.dao;

import com.mishinyura.books.entities.BookV1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Class BookEntityMapper.
 * Implements Book entities mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.03.2022
 */
public class BookEntityMapper {
    /**
     * Method maps Book Record to Book Entity.
     *
     * @param rs ResultSet
     * @return Book
     * @throws SQLException SQLException
     */
    public BookV1 map(final ResultSet rs) throws SQLException {
        return new BookV1(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getObject("created_at", LocalDateTime.class),
                rs.getObject("updated_at", LocalDateTime.class),
                Long.parseLong(rs.getString("version"))
        );
    }
}
