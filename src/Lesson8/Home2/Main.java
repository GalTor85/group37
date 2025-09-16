package Lesson8.Home2;

import java.util.Arrays;

public class Main {
    /**
     * Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг. Реализовать
     * функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя
     * абстрактный класс/методы). Создать массив из 5 разных фигур. Вывести на экран сумму
     * периметра всех фигур в массиве.
     */
    public static void main(String[] args) {
        Figure[] figures = new Figure[5];
        figures[0]=new Triangle(5.0,5.0,50.0);
        figures[1]=new Rectangle(4.0,5.5);
        figures[2]=new Circle(5.0);
        figures[3]=new Rectangle(5.0,5.0);
        figures[4]=new Circle(7.0);

        Double sumArea = 0.0;
        Double sumPerimeter = 0.0;
        for (Figure figure : figures) {
            sumPerimeter=sumPerimeter+figure.perimeter();
        }
        System.out.println("Сумма периметров фигур :"+sumPerimeter);

    }


}
