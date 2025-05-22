/*
 * Задание 1.2. Человек
 * Создайте сущность Человек, которая описывается:
 * - Имя: строка
 * - Рост: целое число
 * Может возвращать текстовое представление вида "Name, рост: height"
 * Необходимо создать и вывести на экран следующих людей:
 * - Человек с именем "Клеопатра" и ростом 152
 * - Человек с именем "Пушкин" и ростом 167
 * - Человек с именем "Владимир" и ростом 189
 */

package ru.beklemysheva.person;

public class Person {
    private String name;
    private int height;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}