package Lesson10.HomeStar;

import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * Задача *:
     * Создать программу для реализации поверхностного и глубокого клонирования объекта
     * класса User. Пусть на вход программе будет передаваться тип операции клонирования
     * (поверхностное клонирование или глубокое), а также id юзера для клонирования.
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        User[] users = new User[10];

        String[] names = {"Даниил", "Максим", "Владислав", "Никита", "Артем", "Иван", "Кирилл",
                "Егор", "Илья", "Андрей"};
        String[] middleName = {"Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич",
                "Сергеевич", "Викторович", "Михайлович", "Артемович", "Андреевич"};
        String[] surname = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов",
                "Лазарев", "Медведев", "Ершов"};
        String[] osNames = {"Windows 7", "Ubuntu 11", "Windows 8", "Windows 10", "Windows 11"};

        System.out.println("Список пользователей (генерация) :");

        for (int i = 0; i < users.length; i++) {
            users[i] = new User();
            Random random = new Random();
            int rN = random.nextInt(names.length);
            int rM = random.nextInt(middleName.length);
            int rS = random.nextInt(surname.length);
            int rO = random.nextInt(osNames.length);
            users[i].setName(names[rN] + " " + middleName[rM] + " " + surname[rS]);
            users[i].setId(i + 1);
            users[i].userOS = new UserOS(osNames[rO]);
            System.out.println(users[i].toString());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите метод клонирования глубокий (\"deep\") или  поверхностный (\"surface\"):");
        String method = sc.nextLine();
        System.out.print("Введите id - пользователя для клонирования : ");
        int id = sc.nextInt();
        System.out.println();
        User copyed = new User();
        if ((Clone.clone(users[id].getId(), method, users) != null) && (id > 0 && id <= users.length)) {
            copyed = Clone.clone(id, method, users);
        }else {
            System.out.println("Error");
            sc.close();
            System.exit(0);
        }

        sc.close();
        System.out.println("Демонстрация работы метода " + method + " (меняем Имя и ОС у скопированного пользователя: "
                + users[id - 1].toString());
        copyed.setName("Иванов Иван Иваныч");
        copyed.userOS.setOperatingSystemName("Mac OS X");
        System.out.println(users[id - 1].toString());
        System.out.println(copyed.toString());

    }

}