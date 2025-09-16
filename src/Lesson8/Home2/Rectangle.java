package Lesson8.Home2;

public class Rectangle extends Figure {

    public Rectangle(Double a, Double b) {
        a = Math.abs(a);
        b = Math.abs(b);
        area = a * b;
        perimeter = 2 * a + 2 * b;

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
