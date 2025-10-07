package Lesson17.Home3_4;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    /**
     * Задача3-4
     */
    public static void main(String[] args) {

        Function<String, Double> courseBYNDollar = sum -> {
            final double course = 0.3291;
            String[] val = sum.split(" ");
            if (val[0].matches("\\d+|(\\d+\\.{1}\\d+)") && ("BYN".equals(val[1]))) {
                return Double.parseDouble(val[0]) * course;
            } else {
                return null;
            }
        };

        Consumer<String> courseBYNUSD = (string) -> {
            final double course = 0.3291;
            String[] val = string.split(" ");
            if (val[0].matches("\\d+|(\\d+\\.{1}\\d+)") && ("BYN".equals(val[1]))) {
                System.out.println((Double.parseDouble(val[0]) * course) + " USD");
            } else {
                System.out.println("Неверный ввод");
            }
        };

        System.out.println(courseBYNDollar.apply("1 BYN"));
        System.out.println(courseBYNDollar.apply("0.50 BYN"));
        System.out.println(courseBYNDollar.apply("63.53 BYN"));
        courseBYNUSD.accept("1 BYN");
        courseBYNUSD.accept("0.50 BYN");
        courseBYNUSD.accept("63.53 BYN");
    }
}
