package Adapter;

public class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int square() {
        return radius * radius;
    }
}
