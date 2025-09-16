package Lesson8.Practic1;

public class Bird implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Чик чирык");
    }

    @Override
    public void move() {
        System.out.println("Птица полетела");

    }

    @Override
    public void eat() {
        System.out.println("Птичка клюёт зерно");

    }

    @Override
    public void sleep() {
        System.out.println("Птица спит");

    }
}
