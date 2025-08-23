package Lesson2;

import java.util.Scanner;

public class Less2HomeZ {
    /*                   Задача *:
Напишите программу, где пользователь вводит любое целое положительное число. А
программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
ввести некорректные данные.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите любое целое положительное число:");
        if (sc.hasNextInt()) {                           //Проверка  на целые INT
            int a = sc.nextInt();
            int sum = a;
            if (a > 1) {
                for (int i = 1; i < a; i++) {            //Цикл суммирования
                    sum = sum + i;
                }
                System.out.println(sum);                 //Вывод суммы
            } else {
                System.out.println("Введено число меньше 1 суммирование невозможно."); //Прерывание по значению меньше 1
            }
        } else {
            System.out.println("Введены некорректные значения."); //Прерывание по некорретным данным
        }
    }
}
