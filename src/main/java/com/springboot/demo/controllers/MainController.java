package com.springboot.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 4:50 PM
 */

@RestController
public class MainController {

    @GetMapping
    public String hello() {
        return "hello api";
    }

}
