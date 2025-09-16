package Lesson8.Home2;

public class Triangle extends Figure {

    public Triangle(Double a, Double b, Double angle) {
        a = Math.abs(a);
        b = Math.abs(b);
        angle = Math.abs(angle);
        angle = (angle * Math.PI) / 180;
        if (angle > 180.0) {
            angle = angle % 180;
        }
        area = 0.5 * a * b * Math.sin(angle);
        perimeter = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(angle)) + a + b;
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
