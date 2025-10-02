package Lesson16.Home1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * Задача 1
     */
    public static void main(String[] args) {
        String[] arrString = {"aa", "b", "c", "d", "e", "f", "aa", "b", "c", "e", "c"};
        Map<String, Boolean> map = new HashMap<>();
        for (String s : arrString) {
            if (map.containsKey(s)) {
                map.put(s, true); //проверка вхождений

            } else {
                map.put(s, false); //если нет вхождений
            }
        }
        System.out.println(map);
    }
}
