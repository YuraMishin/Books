package com.mishinyura.books;

import com.mishinyura.books.dao.BookDaoImpl;
import com.mishinyura.books.db.ConnectionManager;
import com.mishinyura.books.entity.BookV1;
import com.mishinyura.books.exception.DaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Slf4j
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
        log.info("Hello, Yura!");

        try (Connection con = ConnectionManager.open()) {
            List<BookV1> books = BookDaoImpl.getInstance().getBooksBetweenTwoDates(
                    con,
                    LocalDate.of(2022, 5, 18).atStartOfDay(),
                    LocalDate.of(2022, 5, 19).atStartOfDay()
            );
        } catch (Exception e) {
            log.error(
                    "Exception caught while performing sql: {}",
                    e.getMessage()
            );
            throw new DaoException(e);
        }
    }
}
