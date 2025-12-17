package InterfaceSegregationPrinciple;

public class Wasp extends Insect implements Poisonous, Flyable {
    public Wasp(String name) {
        super(name);
    }

    @Override
    public void poison() {
        System.out.println(name + " is poisonous");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }
}
