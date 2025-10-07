package Lesson17.Home5;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    /**
     * Задача5
     */
    public static void main(String[] args) {

        Supplier<String> reverse = () -> {
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder(sc.nextLine());
            sc.close();
            return sb.reverse().toString();
        };

        System.out.println("Введите строку: ");
        System.out.println("Строка задом наперёд :\n" + reverse.get());
    }
}
