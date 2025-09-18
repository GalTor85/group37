package Lesson12.Home1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * Задача 1:
     * Вывести в консоль из строки которую пользователь вводит с клавиатуры все
     * аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
     * только из прописных букв, без чисел.
     */
    public static void main(String[] args) {
        System.out.println("Введите строку :");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("([a-zа-я]+[A-ZА-Я]+[a-zа-я]?+)|" +  //убираем все вида аааАААааа
                "([A-ZА-Я]+[a-zа-я]+)|" +                                      //убираем все вида ВВВввв
                "([A-ZА-Я]{2,})");          //оставляем только чистые аббревиатуры вида ААА
        Matcher matcher = p.matcher(s);
        System.out.println("Вывод Аббревиатур:");
        while (matcher.find()) {
            if (matcher.group(3) != null) {
                System.out.println(matcher.group()); //вывод
            }
        }

    }
}



