package Lesson17.Home2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    /**
     * Задача2
     */
    public static void main(String[] args) {
        Predicate<Double> isPositive = x -> x > 0;
        double[] mathArray = new double[10];
        for (int i = 0; i < mathArray.length; i++) {
            mathArray[i] = Math.random() * 100 - Math.random() * 100;
            if (isPositive.test(mathArray[i])) {
                System.out.println(mathArray[i]);
            }
        }
    }
}
