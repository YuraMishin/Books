package com.mishinyura.books;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Class ApplicationRunner.
 * Implements Application runner.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 15.05.2022
 */
@SpringBootApplication
@Slf4j
public class ApplicationRunner {
    /**
     * The entry point of a Java application.
     *
     * @param args Args
     */
    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication
                .run(ApplicationRunner.class, args);
        log.info("Hello, Yura!");
    }
}
