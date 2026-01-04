package Decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Обычный кофе";
    }
}
