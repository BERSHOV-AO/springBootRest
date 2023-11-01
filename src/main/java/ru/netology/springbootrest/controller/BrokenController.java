package ru.netology.springbootrest.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BrokenController {

    // HttpStatus.I_AM_A_TEAPOT - я чайник
    // В ней сообщим что это на самом деле ResponseStatusException
    @GetMapping("/error")
    public String error() {
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
    }
}
