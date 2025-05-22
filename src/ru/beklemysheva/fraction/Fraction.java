    /*Дроби.
    *Создайте сущность Дробь со следующими особенностями:
    *Имеет числитель: целое число
    *Имеет знаменатель: целое число
    *Дробь может быть создана с указанием числителя и знаменателя
    *Может вернуть строковое представление вида “числитель/знаменатель”
    *Может выполнять операции сложения, вычитания, умножения и деления с другой Дробью
    *или целым числом. Результатом операции должна быть новая Дробь (таким образом,обе
    *исходные дроби не изменяются)
    *Затем необходимо выполнить следующие задачи:
    *1. Создать несколько экземпляров дробей.
    *2. Написать по одному примеру использования каждого метода.
    *3. Вывести на экран примеры и результаты их выполнения в формате «1/3 * 2/3 = 2/9»
    *4. Посчитать f1.sum(f2).div(f3).minus(5)
     */

package ru.beklemysheva.fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Ошибка: знаменатель не может быть нулем. Установлено значение 1.");
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
        this.numerator = numerator;
        reduce();
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        if (numerator == 0) return "0";
        if (denominator == 1) return Integer.toString(numerator);
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction other) {
        int newNum = numerator * other.denominator + other.numerator * denominator;
        int newDen = denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction minus(Fraction other) {
        int newNum = numerator * other.denominator - other.numerator * denominator;
        int newDen = denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            System.out.println("Ошибка: деление на ноль. Возвращена исходная дробь.");
            return this;
        }
        return new Fraction(numerator * other.denominator, denominator * other.numerator);
    }

    public Fraction sum(int number) {
        return sum(new Fraction(number, 1));
    }

    public Fraction minus(int number) {
        return minus(new Fraction(number, 1));
    }

    public Fraction multiply(int number) {
        return multiply(new Fraction(number, 1));
    }

    public Fraction div(int number) {
        return div(new Fraction(number, 1));
    }
}
