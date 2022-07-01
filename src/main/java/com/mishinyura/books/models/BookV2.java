package com.mishinyura.books.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class BookV2.
 * Implements Book Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.05.2022
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class BookV2 {
    /**
     * Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title.
     */
    @Pattern(regexp = "[A-Z]\\w+", message = "Incorrect pattern!")
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 50, message = "Title should be between 2 and 50")
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    /**
     * Created at.
     */
    @EqualsAndHashCode.Exclude
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * Updated at.
     */
    @EqualsAndHashCode.Exclude
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /**
     * Version.
     */
    @EqualsAndHashCode.Exclude
    @Version
    private Long version = 1L;

    /**
     * Constructor.
     *
     * @param title Title
     */
    public BookV2(final String title) {
        this.title = title;
    }

    /**
     * Constructor.
     *
     * @param id    Id
     * @param title Title
     */
    public BookV2(final Long id, final String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookV2 bookV2 = (BookV2) o;
        return id.equals(bookV2.id)
                && title.equals(bookV2.title)
                && createdAt.equals(bookV2.createdAt)
                && updatedAt.equals(bookV2.updatedAt)
                && version.equals(bookV2.version);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, title, createdAt, updatedAt, version);
    }
}
