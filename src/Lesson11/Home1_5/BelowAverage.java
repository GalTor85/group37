package Lesson11.Home1_5;

import java.util.Arrays;

public class BelowAverage {
    static void load(String... arraysString) {
        if (arraysString.length % 2 != 0) {
            for (int i = 0; i < arraysString.length; i++) {
                if (arraysString[i].length() < arraysString[(int) arraysString.length / 2].length()) {
                    System.out.println("Строка: "+arraysString[(i)] +" - меньше средней, её длина: "+ arraysString[i].length());
                }
            }
        } else {
            System.out.println("Error");
        }
    }
}