package com.mishinyura.books;

import com.mishinyura.books.db.ConnectionManager;
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
            log.info("Your database is: {}", con.getCatalog());
        } catch (Exception e) {

        }
    }
}
