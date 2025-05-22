/*
 * Задание 1.3
 * Создайте сущность Имя, которая описывается тремя параметрами: Фамилия, Личное имя,
 * Отчество. Имя может быть приведено к строковому виду, включающему традиционное
 * представление всех трех параметров: Фамилия Имя Отчество. Необходимо предусмотреть
 * возможность того, что какой-либо из параметров может быть не задан, и в этом случае
 * он не учитывается при приведении к текстовому виду.
 * Необходимо создать следующие имена:
 * - Клеопатра
 * - Пушкин Александр Сергеевич
 * - Маяковский Владимир
 */

package ru.beklemysheva.name;

public class Name {
    private final String lastName;
    private final String firstName;
    private final String patronymic;

    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = lastName != null ? lastName : "";
        this.firstName = firstName != null ? firstName : "";
        this.patronymic = patronymic != null ? patronymic : "";
    }

    public Name(String firstName) {
        this("", firstName, "");
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, "");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!lastName.isEmpty()) {
            sb.append(lastName);
        }

        if (!firstName.isEmpty()) {
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(firstName);
        }

        if (!patronymic.isEmpty()) {
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(patronymic);
        }

        return sb.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }
}