package com.mishinyura.books;

import com.mishinyura.books.util.DBUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
        log.info("Hello, Yura!");
        log.info("Your database is: {}", DBUtils.getDBName());
    }
}
