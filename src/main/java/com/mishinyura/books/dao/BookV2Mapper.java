package com.mishinyura.books.dao;

import com.mishinyura.books.models.BookV2;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Class BookV2Mapper.
 * Implements BookV2 Mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 09.06.2022
 */
public class BookV2Mapper implements RowMapper<BookV2> {
    @Override
    public BookV2 mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        BookV2 book = new BookV2();
        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setCreatedAt(rs.getObject("created_at", LocalDateTime.class));
        book.setUpdatedAt(rs.getObject("updated_at", LocalDateTime.class));
        book.setVersion(Long.parseLong(rs.getString("version")));
        return book;
    }
}
