package com.mishinyura.books;

import com.mishinyura.books.dao.BookDaoImpl;
import com.mishinyura.books.db.ConnectionManager;
import com.mishinyura.books.exception.DaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
@Slf4j
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
        log.info("Hello, Yura!");

        try (Connection con = ConnectionManager.open()) {
            BookDaoImpl.getInstance()
                    .delete(10L, con);
        } catch (Exception e) {
            log.error(
                    "Exception caught while performing sql: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }
}
