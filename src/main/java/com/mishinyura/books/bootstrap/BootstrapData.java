package com.mishinyura.books.bootstrap;

import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.repositories.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Class BootstrapData.
 * Implements initial data loading.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.05.2022
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {
    /**
     * Book Repository.
     */
    private final BooksRepository booksRepository;

    /**
     * Method runs bootstrap code.
     *
     * @param args Args
     */
    @Override
    public void run(final String... args) {
        booksRepository.save(new BookV2("title1CLR"));
        booksRepository.save(new BookV2("title2CLR"));
        log.info("Loaded: {} book(s)", booksRepository.count());
    }
}
