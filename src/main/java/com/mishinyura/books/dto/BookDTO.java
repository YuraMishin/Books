package com.mishinyura.books.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Class BookDTO.
 * Implements Book DTO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.07.2022
 */
@NoArgsConstructor
@Getter
@Setter
public final class BookDTO {
    /**
     * Title.
     */
    @Pattern(regexp = "[A-Z]\\w+", message = "Incorrect pattern!")
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 50, message = "Title should be between 2 and 50")
    @Column(name = "title", length = 50, nullable = false)
    private String title;
}
