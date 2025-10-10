package Lesson18.HomeStar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Main {
    /**
     * Задача
     **/
    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>() {{
            put(1, "Иван");
            put(2, "Сергей");
            put(3, "Анатолий");
            put(4, "Анна");
            put(5, "Игорь");
            put(6, "Владимир");
            put(7, "Олег");
            put(8, "Антон");
            put(9, "Виктор");
            put(10, "Жанна");
            put(11, "Павел");
            put(12, "Никита");
            put(13, "Степан");
            put(14, "Николай");
            put(15, "Ольга");
            put(16, "Ника");
            put(17, "Денис");
            put(18, "Дмитрий");
            put(19, "Роман");
            put(20, "Маргарита");
        }};
        List<Integer> id = Arrays.asList(1, 2, 5, 8, 9, 13);
        List<String> resultNames = new ArrayList<>();
        names.entrySet().stream().
                filter(value -> (id.stream().anyMatch(key -> value.getKey().equals(key)))).
                filter(value -> value.getValue().length() % 2 != 0).
                forEach(value -> {
                    resultNames.add(value.getValue().transform(StringBuilder::new).reverse().toString());
                });
        System.out.println(resultNames);
    }
}
