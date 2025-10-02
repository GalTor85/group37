package Lesson16.HomeStar;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * Задача *
     */
    public static void main(String[] args) {
        String string1 = "{([])}";
        String string2 = "{([)]}";
        String string3 = "{dsdf([sf]s/sw)}afs";
        String string4 = "{([(])}";
        Main main = new Main();
        System.out.println(main.balance(string1));
        System.out.println(main.balance(string2));
        System.out.println(main.balance(string3));
        System.out.println(main.balance(string4));
    }

    //метод удаление лишних символов
    String strip(String string) {
        string = string.replaceAll("[^\\(\\)\\[\\]\\{\\}]", "");
        return string;
    }

    //метод проверки сбалансированности скобок
    Boolean balance(String string) {
        Map<Character, Character> pattern = new HashMap<>() {{  //паттерн для сравнения
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Main main = new Main();
        string = main.strip(string);
        Map<Character, Character> suite = new HashMap<>();
        Boolean balance = false;
        for (int i = 0; i < string.length() / 2; i++) {
            suite.put(string.charAt(i), string.charAt(string.length() - 1 - i)); //сборка набора для сравнения с паттерном
        }
        if (pattern.equals(suite) && string.length() % 2 == 0) { //сравнение паттерна и набора + отсечение одиночных значений в середине строки
            balance = true;
        }
        return balance;
    }
}
