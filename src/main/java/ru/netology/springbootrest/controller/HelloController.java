package ru.netology.springbootrest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.springbootrest.domain.Person;

// @RestController - уже добалена анатация @RequestBody включены функции сериализации и десериализации
@RestController
public class HelloController {
    @Value("myApp")
    private String from;

    // @Validated - установка валидных настроек
    //@PostMapping("/hello")
    @GetMapping("/hello")
    // @RequestBody  - обязательно указываем, иначе данные о person не дойдут. информация на вход
    //public String hello(@RequestBody @Validated Person guest) {
    public String hello(@Validated Person guest) {
        return String.format("Hello form %s to name %s age %d!", from, guest.getName(), guest.getAge());
    }
}
