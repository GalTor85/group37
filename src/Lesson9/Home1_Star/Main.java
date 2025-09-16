package Lesson9.Home1_Star;

import java.util.Scanner;

public class Main {
    /**
     * Задача 1:
     * Создать логически верную иерархию следующих классов: Animal, Dog, Tiger, Rabbit.
     * Переопределить методы voice(), eat(String food) чтобы они выводили верную
     * информацию. Метод eat может принимать “Meat”, “Grass” и другие строки.
     * Например, если мы создадим объект класса Rabbit, вызовем метод eat() и передадим
     * туда “Grass” он должен написать в консоли что любит есть травку. Если передадим “Meat”
     * или другую строку то он будет недоволен.
     */
    public static void main(String[] args) {
        Dog d = new Dog();
        d.setName("Шарик");
        Scanner sc = new Scanner(System.in);
        System.out.print("У нас есть "+d.toString().toLowerCase()+" "+d.getName()+" чем его покормим? :");
        String food = sc.nextLine();

        d.eat(food);
    }
}