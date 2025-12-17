package OpenClosedPrinciple;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintToConsole();
        print.print("Hello World!");
        Print printToWindow = new PrintToWindow();
        printToWindow.print("Hello World!");
    }
}