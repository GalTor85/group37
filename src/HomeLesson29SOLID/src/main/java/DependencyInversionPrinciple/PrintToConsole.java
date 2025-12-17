package DependencyInversionPrinciple;

public class PrintToConsole  implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
