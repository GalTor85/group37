package Lesson17.Home1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    /**
     * Задача1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату своего рождения в формате ГГГГ-ММ-ДД: ");
        if (sc.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
            LocalDate birthDay = LocalDate.parse(sc.nextLine());
            LocalDate hDay = LocalDate.of(100 + birthDay.getYear(), birthDay.getMonth(), birthDay.getDayOfMonth());
            System.out.println("Вам исполнится 100 лет: " + hDay);
        } else {
            System.out.println("Неверный формат даты");
        }
        sc.close();
    }
}
