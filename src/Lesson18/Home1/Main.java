package Lesson18.Home1;

import java.util.ArrayList;

public class Main {
    /**
     * Задача1
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 10));
        }
        System.out.println(list);
        System.out.println(list.stream().distinct().
                filter(num -> num % 2 == 0).
                reduce((a, b) -> a + b));
    }
}