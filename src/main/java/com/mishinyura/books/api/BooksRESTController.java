package com.mishinyura.books.api;

import com.mishinyura.books.dto.BookDTO;
import com.mishinyura.books.exceptions.BookNotCreatedException;
import com.mishinyura.books.exceptions.BookNotFoundException;
import com.mishinyura.books.models.BookV2;
import com.mishinyura.books.services.BooksServiceImpl;
import com.mishinyura.books.utils.BookErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class BooksRESTController.
 * Implements Books REST Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.07.2022
 */
@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Slf4j
public class BooksRESTController {
    /**
     * Books Service.
     */
    private final BooksServiceImpl booksService;

    /**
     * ModelMapper.
     */
    private final ModelMapper modelMapper;

    /**
     * Method retrieves all the books.
     * GET: api/books/
     *
     * @return List<BookDTO>
     */
    @GetMapping("/")
    public List<BookDTO> getBooks() {
        return booksService.findAll()
                .stream()
                .map(this::convertToBookDTO)
                .toList();
    }

    /**
     * Method retrieves the specific book.
     * GET: api/books/1
     *
     * @param id Id
     * @return BookDTO
     */
    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable final Long id) {
        return convertToBookDTO(booksService.findById(id));
    }

    /**
     * Method handles BookNotFoundException.
     *
     * @param e Exception
     * @return ResponseEntity<BookErrorResponse>
     */
    @ExceptionHandler
    private ResponseEntity<BookErrorResponse> handleBookNotFoundException(final BookNotFoundException e) {
        var response = new BookErrorResponse(
                "Book not found !",
                LocalDateTime.now()
        );
        log.error("{} - Exception caught - {}", response.date(), response.message());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Method saves the book.
     * POST: api/books/
     *
     * @param bookDTO       BookDTO
     * @param bindingResult BindingResult
     * @return ResponseEntity<HttpStatus>
     */
    @PostMapping
    public ResponseEntity<HttpStatus> store(
            @RequestBody @Valid final BookDTO bookDTO,
            final BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new BookNotCreatedException(errorMsg.toString());
        }

        booksService.save(convertToBook(bookDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Method converts BookDTO into BookV2.
     *
     * @param bookDTO BookDTO
     * @return BookV2
     */
    private BookV2 convertToBook(final BookDTO bookDTO) {
        return modelMapper.map(bookDTO, BookV2.class);
    }

    /**
     * Method converts BookV2 into BookDTO.
     *
     * @param book BookV2
     * @return BookDTO
     */
    private BookDTO convertToBookDTO(final BookV2 book) {
        return modelMapper.map(book, BookDTO.class);
    }

    /**
     * Method handles BookNotCreatedException.
     *
     * @param e BookNotCreatedException
     * @return ResponseEntity<BookErrorResponse>
     */
    @ExceptionHandler
    private ResponseEntity<BookErrorResponse> handleBookNotCreatedException(final BookNotCreatedException e) {
        var response = new BookErrorResponse(
                e.getMessage(),
                LocalDateTime.now()
        );
        log.error("{} - Exception caught - {}", response.date(), response.message());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
