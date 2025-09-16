package Lesson11.Home1_5;


import java.util.Scanner;

public class Main {
    /**
     * 1. Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
     * найденные строки и их длину.
     * 2. Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
     * значений их длины.
     * 3. Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
     * средней, а также их длину.
     * 4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
     * Если таких слов несколько, найти первое из них.
     * 5. Вывести на консоль новую строку, которой задублирована каждая буква из
     * начальной строки. Например, "Hello" -> "HHeelllloo"
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первую строк:");
        String stringOne = sc.nextLine();
        System.out.println("Введите вторую строку:");
        String stringTwo = sc.nextLine();
        System.out.println("Введите третью строку");
        String stringThree = sc.nextLine();
        sc.close();
         //Задача 1
        MaxMin.load(stringOne, stringTwo, stringThree);
        //Задача 2
        Increase.load(stringOne, stringTwo, stringThree);
        //Задача 3
        BelowAverage.load(stringOne, stringTwo, stringThree);
        //Задача 4
        DifferentSymbols.load(stringOne, stringTwo, stringThree);
        //Задача 5
        DuplicateChar.load(stringOne);
    }
}