package Lesson2;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //создание объекта Scanner
        int age = scanner.nextInt();
        System.out.println(age);

        String firstName = scanner.nextLine(); //TODO fdgjhhk
        System.out.println(firstName);

        scanner.close();


    }
}
