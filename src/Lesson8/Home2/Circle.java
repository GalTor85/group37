package Lesson8.Home2;

public class Circle extends Figure {

    public Circle(Double radius) {

        radius = Math.abs(radius);
        area = Math.PI * radius * radius;
        perimeter = 2 + Math.PI * radius;
    }

    @Override
    Double area() {
        return area;
    }

    @Override
    Double perimeter() {
        return perimeter;
    }
}
