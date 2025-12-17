package DependencyInversionPrinciple;

public class Main {
    public static void main(String[] args) {
        Printer print = new PrintToConsole();
        print.print("Hello World!");
        Printer printToWindow = new PrintToWindow();
        printToWindow.print("Hello World!");
    }
}