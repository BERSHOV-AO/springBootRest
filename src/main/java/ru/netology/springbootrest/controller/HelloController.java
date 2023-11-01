package ru.netology.springbootrest.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.netology.springbootrest.domain.Person;


// @RestController уже добалена анатация @RequestBody включены функции сериализации и десериализации
@RestController
public class HelloController {
    @Value("myApp")
    private String from;

    // @GetMapping("/") это уже будет не getMapping так как мы передаем персона, он передается
    // в теле запроса значит post
//    @PostMapping("/hello")
//    // @RequestBody  - обязательно указываем, иначе данные о person не дойдут. информация на вход
//    public String hello(@RequestBody Person guest) {
//        return String.format("Hello form %s to name %s age %d!", from, guest.getName(), guest.getAge());
//    }

    //--------------------------------------1 вариант через get запрос в url-------------------------------------------

    // таким образом можно передовать через query параметрны, то есть в url
//    @GetMapping("/hello")
//    // @RequestParam  - разбор нашего запроса
//    // public String hello(@RequestParam Person guest) {
//    // для общего запроса нет необходимсти укзывать @RequestParam
//    // если тылько мы не хотим что то конкретное типа получить : -> @RequestParam("name") String name
//    public String hello(Person guest) {
//        return String.format("Hello form %s to name %s age %d!",
//                from, guest.getName(), guest.getAge());
//    }

    //--------------------------------------2 вариант через get запрос в url-------------------------------------------
    // не забываем правильно указать типы полей, иначе ошибка 500
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name,
                        @RequestParam("age") int age) {
        return String.format("Hello form %s to name %s age %d!",
                from, name, age);
    }
}
