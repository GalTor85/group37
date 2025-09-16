package Lesson10.Home1;

public class Main {
    /**
     * Задача 1:
     * Создать класс для описания пользователя системы. Переопределить в классе методы
     * toString,hashcode и equals. Создать несколько экземпляров класса с одним и тем же
     * значением полей и сравнить с помощью метода equals.
     */
    public static void main(String[] args) {
        User userOne = new User("Джек", 27, "мужской");
        User userTwo = new User("Джек", 27, "мужской");
        User userThree = new User("Борис", 30, "мужской");

        System.out.println(userOne.equals(userTwo));
        System.out.println(userOne.equals(userThree));
        System.out.println(userOne.hashCode());
        System.out.println(userTwo.hashCode());
        System.out.println(userThree.hashCode());
    }
}
