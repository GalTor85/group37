package Lesson16.Home2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * Задача2
     */
    public static void main(String[] args) {
        String[] arrString = {"main", "void", "valid", "bug", "code", "moon", "man", "night", "circle", "epic"};
        Map<String, String> map = new HashMap<>();
        for (String s : arrString) {
            if (s.length() > 0) {  //проверка на пустую строку
                map.put(String.valueOf(s.charAt(0)), String.valueOf(s.charAt(s.length() - 1)));
            }
        }
        System.out.println(map);
    }
}
