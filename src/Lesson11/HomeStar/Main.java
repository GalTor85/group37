package Lesson11.HomeStar;

import java.util.Scanner;

public class Main {
    /**
     * Задача *:
     * Дана строка произвольной длины с произвольными словами. Написать программу для
     * проверки является ли любое выбранное слово в строке палиндромом.
     * Например, есть строка, вводится число 3, значит необходимо проверить является ли
     * 3-е слово в этой строке палиндромом.
     * Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций:
     * например, в строке 5 слов, а на вход программе передали число 500.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку : ");
        String string = sc.nextLine();
        System.out.println("Какое по счёту слово проверить на палиндром? : ");
        sc.reset();
        int position;
        if (sc.hasNextInt()) {
            position = sc.nextInt();
            sc.close();
            if (palindromeChek(string, position)) {
                System.out.println("Слово палиндром");
            } else {
                System.out.println("Слово не палиндром");
            }
        } else {
            sc.close();
            System.out.println("Неверный ввод");
        }
    }

    static boolean palindromeChek(String string, int positon) {
        String[] words = string.split("\\s+");
        if ((positon >= 1) && (positon <= words.length)) {
            StringBuilder sb = new StringBuilder(words[positon - 1]);
            sb.reverse();
            return sb.toString().equals(words[positon - 1]);
        } else {
            System.out.println("Неверный ввод");
            return false;
        }
    }
}
