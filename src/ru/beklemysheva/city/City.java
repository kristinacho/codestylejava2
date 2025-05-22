/* Задание 3.3 - Города
 * Создаем сущность Город, которая представляет точку на карте с:
 * - Названием города
 * - Набором путей к другим городам (город + стоимость поездки)
 * Должен возвращать текстовое представление в виде:
 * Название города:
 *   связанный_город1:стоимость
 *   связанный_город2:стоимость
 */

package ru.beklemysheva.city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private final String name;
    private final List<Route> routes;

    public City(String name) {
        this(name, new ArrayList<>());
    }

    public City(String name, List<Route> routes) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Ошибка: название города не может быть пустым.");
            this.name = "Город без названия";
        } else {
            this.name = name;
        }
        this.routes = new ArrayList<>(routes);
    }

    public void addRoute(City destination, double cost) {
        if (destination == null) {
            System.out.println("Ошибка: город назначения не может быть null.");
            return;
        }
        if (cost <= 0) {
            System.out.println("Ошибка: стоимость должна быть положительной.");
            return;
        }
        routes.add(new Route(destination, cost));
    }

    public String getName() {
        return name;
    }

    public List<Route> getRoutes() {
        return new ArrayList<>(routes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Route route : routes) {
            sb.append("    ")
                    .append(route.getDestination().getName())
                    .append(":")
                    .append(route.getCost())
                    .append("\n");
        }
        return sb.toString();
    }
}

class Route {
    private final City destination;
    private final double cost;

    public Route(City destination, double cost) {
        if (destination == null) {
            System.out.println("Ошибка: город назначения не может быть null.");
            this.destination = new City("Неизвестный город");
        } else {
            this.destination = destination;
        }

        if (cost <= 0) {
            System.out.println("Ошибка: стоимость должна быть положительной.");
            this.cost = 1.0;
        } else {
            this.cost = cost;
        }
    }

    public City getDestination() {
        return destination;
    }

    public double getCost() {
        return cost;
    }
}