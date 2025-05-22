/*
 * Задание 2.2 - Человек с именем
 * Объедините сущности Человек и Имя таким образом, чтобы имя человека
 * задавалось с использованием сущности Имя, а не строки.
 * Необходимо создать:
 * - Человека с Именем "Клеопатра" и ростом 152
 * - Человека с Именем "Пушкин Александр Сергеевич" и ростом 167
 * - Человека с Именем "Маяковский Владимир" и ростом 189
 */

package ru.beklemysheva.personn;

import ru.beklemysheva.name.Name;

public class Personn {
    private final Name name;
    private final int height;

    public Personn(Name name, int height) {
        if (height < 50 || height > 250) {
            System.out.println("Ошибка: рост должен быть от 50 до 250 см");
            this.height = 170;
        } else {
            this.height = height;
        }
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Человек с именем \"" + name + "\" и ростом " + height;
    }
}
