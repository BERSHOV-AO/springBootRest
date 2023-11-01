package ru.netology.springbootrest.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.netology.springbootrest.domain.Person;


// @RestController уже добалена анатация @RequestBody включены функции сериализации и десериализации
@RestController
public class HelloController {
    @Value("myApp")
    private String from;


    @PostMapping("/hello")
    // @RequestBody  - обязательно указываем, иначе данные о person не дойдут. информация на вход
    public String hello(@RequestBody Person guest) {
        return String.format("Hello form %s to name %s age %d!", from, guest.getName(), guest.getAge());
    }
}
