package com.mishinyura.books.controllers;

import com.mishinyura.books.models.User;
import com.mishinyura.books.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class AuthController.
 * Implements Auth Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 04.07.2022
 */
@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {
    /**
     * Users Service.
     */
    private final UsersService usersService;

    /**
     * Method displays custom login view.
     * GET: /auth/login
     *
     * @return auth/login custom login view
     */
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    /**
     * Method displays registration view.
     * GET: /auth/registration
     *
     * @param user User
     * @return auth/registration registration view
     */
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") final User user) {
        return "auth/registration";
    }

    /**
     * Method handles registration.
     * POST: /auth/registration
     *
     * @param user User
     * @return auth/login login view
     */
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") final User user) {
        usersService.save(user);
        return "redirect:/auth/login";
    }
}
