package Lesson8.Practic1;
/**
 * 1. Смоделируй поведение животного Создай интерфейс Animal с методами makeSound(), move(), eat(), sleep();
 * Реализуй его в классах Dog и Bird.
 */ public class Main {
    public static void main(String[] args) {
Dog sharik =  new Dog();
Bird bird = new Bird();
sharik.makeSound();
sharik.move();
sharik.eat();
sharik.sleep();
bird.makeSound();
bird.move();
bird.eat();
bird.sleep();
    }

 }
