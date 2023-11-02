package ru.netology.springbootrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.springbootrest.domain.Person;

// Заведомо надломенный контроллер
@RequestMapping("/another")
@RestController
public class AnotherBrokenController {

//    @GetMapping("/iae")
//    public String throwException() {
//        throw new IllegalArgumentException("throwException");
//    }

    // берем другую ошибку, наследуемую от RuntimeException
    @GetMapping("/iae")
    public String throwException() {
        throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
    }
}
