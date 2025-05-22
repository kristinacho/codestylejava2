package ru.beklemysheva;

import ru.beklemysheva.city.City;
import ru.beklemysheva.fraction.Fraction;
import ru.beklemysheva.inputhandler.Inputhandler;
import ru.beklemysheva.inputhandler.config.*;
import ru.beklemysheva.name.Name;
import ru.beklemysheva.person.Person;
import ru.beklemysheva.personn.Personn;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> validChoices = Arrays.asList(0, 1, 2, 3, 4, 5);

        Name cleopatraName = new Name("Клеопатра", null, null);
        Name pushkinName = new Name("Александр", "Пушкин", "Сергеевич");
        Name mayakovskiyName = new Name("Владимир", "Маяковский", null);

        IntInputConfig menuConfig = new IntInputConfig.Builder()
                .setPrompt("\nВыберите задание:\n" +
                        "1 - 1.2 \n" +
                        "2 - 1.3 \n" +
                        "3 - 2.2 \n" +
                        "4 - 3.3-4.8 \n" +
                        "5 - 5.5 Дроби \n" +
                        "0 - Выход\n" +
                        "Ваш выбор: ")
                .setAllowedValues(validChoices)
                .build();

        while (true) {
            int choice = Inputhandler.getInt(menuConfig);

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            switch (choice) {
                case 1 -> handlePersonTask();
                case 2 -> handleNameTask();
                case 3 -> handlePersonWithNameTask(cleopatraName, pushkinName, mayakovskiyName);
                case 4 -> handleCityTask();
                case 5 -> handleFractionTask();
                default -> System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
        }
    }

    private static void handlePersonTask() {
        System.out.println("\n=== Задание 1.2");

        StringInputConfig nameConfig = new StringInputConfig.Builder()
                .setPrompt("Введите имя человека: ")
                .setMinLength(1)
                .setMaxLength(50)
                .allowOnlyLettersAndSpaces()
                .requireUppercaseFirstLetter()
                .build();

        IntInputConfig heightConfig = new IntInputConfig.Builder()
                .setPrompt("Введите рост (50-250 см): ")
                .setMin(50)
                .setMax(250)
                .build();

        System.out.println("Создайте 3 объекта Person:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nЧеловек #" + i);
            String name = Inputhandler.getString(nameConfig);
            int height = Inputhandler.getInt(heightConfig);

            Person person = new Person(name, height);
            System.out.println("Создан: " + person);
        }

        System.out.println("\nСтандартные объекты Person:");
        System.out.println(new Person("Клеопатра", 152));
        System.out.println(new Person("Пушкин", 167));
        System.out.println(new Person("Владимир", 189));
    }

    private static void handleNameTask() {
        System.out.println("\n=== Задание 1.3");

        StringInputConfig firstNameConfig = new StringInputConfig.Builder()
                .setPrompt("Введите имя (первая буква заглавная): ")
                .setMinLength(1)
                .setMaxLength(50)
                .allowOnlyLettersAndSpaces()
                .requireUppercaseFirstLetter()
                .build();

        StringInputConfig lastNameConfig = new StringInputConfig.Builder()
                .setPrompt("Введите фамилию (оставьте пустым, если нет): ")
                .setMaxLength(50)
                .allowOnlyLettersAndSpaces()
                .requireUppercaseFirstLetter()
                .build();

        StringInputConfig patronymicConfig = new StringInputConfig.Builder()
                .setPrompt("Введите отчество (оставьте пустым, если нет): ")
                .setMaxLength(50)
                .allowOnlyLettersAndSpaces()
                .requireUppercaseFirstLetter()
                .build();

        System.out.println("Создайте 3 объекта Name:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nОбъект #" + i);
            String firstName = Inputhandler.getString(firstNameConfig);
            String lastName = Inputhandler.getString(lastNameConfig);
            String patronymic = Inputhandler.getString(patronymicConfig);

            Name name = new Name(
                    firstName,
                    lastName.isEmpty() ? null : lastName,
                    patronymic.isEmpty() ? null : patronymic
            );
            System.out.println("Создан: " + name);
        }

        System.out.println("\nСтандартные объекты Name:");
        System.out.println(new Name("Клеопатра"));
        System.out.println(new Name("Пушкин", "Александр", "Сергеевич"));
        System.out.println(new Name("Маяковский", "Владимир"));
    }

    private static void handlePersonWithNameTask(Name cleopatraName, Name pushkinName, Name mayakovskiyName) {
        System.out.println("\n=== Задание 2.2");

        Personn cleopatra = new Personn(cleopatraName, 152);
        Personn pushkin = new Personn(pushkinName, 167);
        Personn mayakovskiy = new Personn(mayakovskiyName, 189);

        System.out.println("Стандартные объекты:");
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovskiy);

        System.out.println("\nСоздайте нового человека:");

        StringInputConfig firstNameConfig = new StringInputConfig.Builder()
                .setPrompt("Введите имя: ")
                .setMinLength(1)
                .allowOnlyLettersAndSpaces()
                .requireUppercaseFirstLetter()
                .build();

        StringInputConfig lastNameConfig = new StringInputConfig.Builder()
                .setPrompt("Введите фамилию (не обязательно): ")
                .allowOnlyLettersAndSpaces()
                .requireUppercaseFirstLetter()
                .build();

        StringInputConfig patronymicConfig = new StringInputConfig.Builder()
                .setPrompt("Введите отчество (не обязательно): ")
                .allowOnlyLettersAndSpaces()
                .requireUppercaseFirstLetter()
                .build();

        IntInputConfig heightConfig = new IntInputConfig.Builder()
                .setPrompt("Введите рост (50-250 см): ")
                .setMin(50)
                .setMax(250)
                .build();

        String firstName = Inputhandler.getString(firstNameConfig);
        String lastName = Inputhandler.getString(lastNameConfig);
        String patronymic = Inputhandler.getString(patronymicConfig);
        int height = Inputhandler.getInt(heightConfig);

        Name name = new Name(firstName,
                lastName.isEmpty() ? null : lastName,
                patronymic.isEmpty() ? null : patronymic);
        Personn personn = new Personn(name, height);

        System.out.println("Создан: " + personn);
    }

    private static void handleCityTask() {
        System.out.println("\n=== Задание 3.3 - Города ===");

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        A.addRoute(B, 5);
        A.addRoute(D, 6);
        A.addRoute(F, 1);

        B.addRoute(A, 5);
        B.addRoute(F, 1);
        B.addRoute(C, 3);

        C.addRoute(B, 3);
        C.addRoute(D, 4);

        D.addRoute(C, 4);
        D.addRoute(A, 6);
        D.addRoute(E, 2);

        E.addRoute(D, 2);
        E.addRoute(F, 2);

        F.addRoute(A, 1);
        F.addRoute(E, 2);
        F.addRoute(B, 1);

        System.out.println("\nСтандартная карта городов:");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);

        StringInputConfig cityNameConfig = new StringInputConfig.Builder()
                .setPrompt("Введите название нового города: ")
                .setMinLength(1)
                .setMaxLength(50)
                .build();

        String cityName = Inputhandler.getString(cityNameConfig);
        City newCity = new City(cityName);

        while (true) {
            StringInputConfig yesNoConfig = new StringInputConfig.Builder()
                    .setPrompt("Добавить маршрут? (y/n): ")
                    .setAllowedValues(Arrays.asList("y", "n"))
                    .build();

            String answer = Inputhandler.getString(yesNoConfig);
            if (answer.equalsIgnoreCase("n")) {
                break;
            }

            StringInputConfig destNameConfig = new StringInputConfig.Builder()
                    .setPrompt("Введите название города назначения: ")
                    .setMinLength(1)
                    .setMaxLength(50)
                    .build();

            String destName = Inputhandler.getString(destNameConfig);

            DoubleInputConfig costConfig = new DoubleInputConfig.Builder()
                    .setPrompt("Введите стоимость поездки (больше 0): ")
                    .setMin(0.01)
                    .build();

            double cost = Inputhandler.getDouble(costConfig);

            City destCity = new City(destName);
            newCity.addRoute(destCity, cost);
        }

        System.out.println("\nСоздан город:");
        System.out.println(newCity);
    }

    private static void handleFractionTask() {
        System.out.println("\n=== Задание 5.5 - Дроби ===");

        IntInputConfig numeratorConfig = new IntInputConfig.Builder()
                .setPrompt("Введите числитель первой дроби: ")
                .build();

        IntInputConfig denominatorConfig = new IntInputConfig.Builder()
                .setPrompt("Введите знаменатель первой дроби (не 0): ")
                .build();

        System.out.println("Создание первой дроби:");
        int num1 = Inputhandler.getInt(numeratorConfig);
        int den1 = Inputhandler.getInt(denominatorConfig);
        Fraction f1 = new Fraction(num1, den1);

        System.out.println("Создание второй дроби:");
        int num2 = Inputhandler.getInt(numeratorConfig);
        int den2 = Inputhandler.getInt(denominatorConfig);
        Fraction f2 = new Fraction(num2, den2);

        System.out.println("Создание третьей дроби:");
        int num3 = Inputhandler.getInt(numeratorConfig);
        int den3 = Inputhandler.getInt(denominatorConfig);
        Fraction f3 = new Fraction(num3, den3);

        System.out.println("\nРезультаты операций:");
        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));

        Fraction result = f1.sum(f2).div(f3).minus(5);
        System.out.println("\nРезультат f1.sum(f2).div(f3).minus(5) = " + result);

        IntInputConfig wholeNumberConfig = new IntInputConfig.Builder()
                .setPrompt("\nВведите целое число для операций: ")
                .build();
        int number = Inputhandler.getInt(wholeNumberConfig);

        System.out.println(f1 + " + " + number + " = " + f1.sum(number));
        System.out.println(f1 + " - " + number + " = " + f1.minus(number));
        System.out.println(f1 + " * " + number + " = " + f1.multiply(number));
        System.out.println(f1 + " / " + number + " = " + f1.div(number));
    }
}