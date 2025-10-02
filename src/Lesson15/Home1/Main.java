package Lesson15.Home1;

import java.util.*;

public class Main {
    /**
     * Задача 1:
     * Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
     * 4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
     * При решении использовать коллекции.
     */
    public static void main(String[] args) {
        System.out.println("Введите числа через запятую:");
        Scanner sc = new Scanner(System.in);
        HashSet<String> list = new HashSet<>();
        list.addAll(Arrays.asList(sc.nextLine().replaceAll(" ", "").split(",")));
        System.out.println(list);
        sc.close();
    }
}
