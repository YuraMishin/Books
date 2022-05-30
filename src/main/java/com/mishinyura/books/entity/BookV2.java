package com.mishinyura.books.entity;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * Class BookV2.
 * Implements Book Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.05.2022
 */
@NoArgsConstructor
@Entity
@Table(name = "books")
public class BookV2 {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title.
     */
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    /**
     * Created at.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * Updated at.
     */
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /**
     * Version.
     */
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
}
