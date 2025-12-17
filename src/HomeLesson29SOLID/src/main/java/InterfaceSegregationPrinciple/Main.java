package InterfaceSegregationPrinciple;

public class Main {
    public static void main(String[] args) {
        Insect dragonfly = new Dragonfly("Dragonfly");
        ((Dragonfly) dragonfly).fly();
        Insect wasp = new Wasp("Wasp");
        ((Wasp) wasp).poison();
        ((Wasp) wasp).fly();
        Insect scolopendra = new Scolopendra("Scolopendra");
        ((Scolopendra) scolopendra).poison();
        ((Scolopendra) scolopendra).crawl();
    }
}
