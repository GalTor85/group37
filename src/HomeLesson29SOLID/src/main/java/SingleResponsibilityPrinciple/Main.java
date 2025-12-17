package SingleResponsibilityPrinciple;

public class Main   {
    public static void main(String[] args) {
        ScanToConsole scanToConsole = new ScanToConsole();
        PrintToMonitor printToMonitor = new PrintToMonitor();
        String input = scanToConsole.scan();
        printToMonitor.print(input);
    }
}
