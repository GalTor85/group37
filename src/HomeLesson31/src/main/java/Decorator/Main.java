package Decorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new SyrupDecorator(coffee);
        System.out.println(coffee.getDescription() + " - " + coffee.getCost());
    }
}
