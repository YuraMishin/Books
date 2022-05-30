package com.mishinyura.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class IndexController.
 * Implements Index Controller.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.05.2022
 */
@Controller
public class IndexController {
    /**
     * Method displays index page.
     * GET: /, /index
     *
     * @return String
     */
    @GetMapping(value = {"", "/", "/index"})
    @ResponseBody
    public String index() {
        return "Hello World!";
    }
}
