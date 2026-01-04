package Adapter;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        PrintToConsole printToConsole = new PrintToConsole();
        printToConsole.print(new StringAdapter().toString(circle.square()));
    }
}
