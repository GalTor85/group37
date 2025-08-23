package Lesson2;

import java.util.Scanner;

public class Less2Home1 {
    /*                                Задача 1:
Напишите программу, которая будет принимать на вход число из консоли и на выход
будет выводить сообщение четное число или нет. Для определения четности числа
используйте операцию получения остатка от деления (операция выглядит так: '% 2').  */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите любое целое число без разделителей в диапазоне -2,147,483,648 до 2,147,483,647: ");
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            if (x % 2 == 0) {
                System.out.println("Число четное.");
            } else {
                System.out.println("Число нечетное.");
            }
        } else {
            System.out.println("Вы ввели не целое число, либо недопустмое значение!!!");
        }
    }
}
