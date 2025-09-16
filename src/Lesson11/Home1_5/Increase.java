package Lesson11.Home1_5;


import java.util.Arrays;

public class Increase {
    static void load(String... arraysString) {
        String buf;
        for (int i = 0; i < arraysString.length - 1; i++) {
            for (int j = i + 1; j < arraysString.length; j++) {
                buf = arraysString[i];
                if (buf.length() > arraysString[j].length()) {
                    arraysString[i] = arraysString[j];
                    arraysString[j] = buf;
                }
            }
        }
        System.out.println("Вывод упорядоченных строк: " +Arrays.toString(arraysString));
    }
}
