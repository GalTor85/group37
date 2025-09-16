package Lesson8.Practic1;

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав гав");
    }

    @Override
    public void move() {
        System.out.println("Собака побежала");

    }

    @Override
    public void eat() {
        System.out.println("Собака ест");

    }

    @Override
    public void sleep() {
        System.out.println("Собака спит");

    }
}
