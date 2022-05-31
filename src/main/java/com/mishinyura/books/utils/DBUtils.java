package com.mishinyura.books.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Objects;

@Slf4j
@Component
public class DBUtils {
    private static JdbcTemplate jdbc;

    private DBUtils(JdbcTemplate jdbc) {
        DBUtils.jdbc = jdbc;
    }

    public static String getDBName() {
        try (Connection conn = Objects.requireNonNull(jdbc.getDataSource()).getConnection()) {
            return conn.getCatalog();
        } catch (Exception e) {
            log.error(
                    "Exception caught while getting DB name: {}",
                    e.getMessage()
            );
            throw new RuntimeException(e.getMessage());
        }
    }
}
