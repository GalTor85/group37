package LiskovSubstitutionPrinciple;

public class Dragonfly extends Insect implements Flyable {
    public Dragonfly(String name) {
        super(name);
    }
    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }

}
