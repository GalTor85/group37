package Lesson2;

import java.util.Scanner;

public class Less2Home2 {
    /*                         Задача 2:
Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold». */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите температуру на улице:");
        if (scanner.hasNextDouble()) {
            double temp = scanner.nextDouble();  //Fix double
            if (temp > -5) {
                System.out.println("Warm");
            } else if (temp <= -20) {
                System.out.println("Cold");
            } else {
                System.out.println("Normal");
            }
        } else {
            System.out.println("Вы ввели неправильное значение!!!");
        }
    }
}