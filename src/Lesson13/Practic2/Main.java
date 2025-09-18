package Lesson13.Practic2;

public class Main {
    /**
     * Задача 2:
     * Создать собственное исключение которое будет выбрасываться в классе Person при
     * создании объекта, если ему меньше 18 лет. Попробовать создать объект Person до и
     * после 18 лет в методе main.
     */
    public static void main(String[] args) {
    Person person = new Person();
    person.setName("John");
    try {
        person.setAge(10);
        System.out.println(person);
        person.setAge(20);
        System.out.println(person);

    } catch (Exception e) {}


    }


}
