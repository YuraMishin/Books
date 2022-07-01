package com.mishinyura.books.controllers;

import com.mishinyura.books.security.PersonDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class UsersController.
 * Implements Users Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 01.07.2022
 */
@Slf4j
@Controller
@RequestMapping("/users")
public class UsersController {
    /**
     * Method logs current user info.
     * GET: /users/current
     *
     * @return books/index page view
     */
    @GetMapping(value = "/current")
    public String getUser() {
        var authentication = SecurityContextHolder
                .getContext().getAuthentication();
        var personDetails = (PersonDetails) authentication.getPrincipal();
        log.info(personDetails.getUser().toString());
        return "books/index";
    }
}
