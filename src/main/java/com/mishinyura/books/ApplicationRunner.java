package com.mishinyura.books;

import com.mishinyura.books.dao.BookDaoImpl;
import com.mishinyura.books.db.ConnectionManager;
import com.mishinyura.books.entity.BookV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.util.List;

@SpringBootApplication
@Slf4j
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
        log.info("Hello, Yura!");

        try (Connection con = ConnectionManager.open()) {
            List<BookV1> books = BookDaoImpl.getInstance()
                    .findAll(con);
        } catch (Exception e) {

        }
    }
}
