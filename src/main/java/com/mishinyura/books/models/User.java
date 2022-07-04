package com.mishinyura.books.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Class User.
 * Implements User Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 01.07.2022
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    /**
     * Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username.
     */
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 50, message = "Username should be between 2 and 50")
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    /**
     * Password.
     */
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 2, max = 50, message = "Password should be between 2 and 50")
    @Column(name = "password", length = 50, nullable = false)
    private String password;
}
