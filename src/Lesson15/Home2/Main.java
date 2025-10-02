package Lesson15.Home2;

public class Main {
    /**
     * Задача 2:
     * Создать класс, который будет хранить в себе коллекцию с названиями животных.
     * Реализовать методы удаления и добавления животных по следующим правилам:
     * добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
     * объекта этого класса в main методе другого класса.
     */
    public static void main(String[] args) {
        Animal animals = new Animal();
        animals.addNames("Корова");
        animals.addNames("Собака");
        animals.addNames("Крокодил");
        animals.addNames("Бегемот");
        animals.addNames("Кошка");
        System.out.println(animals.getNames());
        animals.delNames();
        System.out.println(animals.getNames());


    }
}
