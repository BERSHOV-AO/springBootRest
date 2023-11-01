package ru.netology.springbootrest.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Person {

    // Ставми настройки
    // Size(минимальное количество символов должно состоять из двух min=2, max=20)
    // @NotBlank - строчка не содержит пробельные символы
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    // Устанавливаем границы минимального и максимального возраста
    @Min(0)
    @Max(150)
    private int age;


    // для работы с сериализацией и десериализацией используем библиотеку jakson
    // для данной библиотеки необходим пустой конструктор, и геттеры и сеттеры
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
