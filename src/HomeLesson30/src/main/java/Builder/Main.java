package Builder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director(new TankBuilder());
        Tank lightTank = director.buildLightTank();
        Tank mediumTank = director.buildMediumTank();
        Tank heavyTank = director.buildHeavyTank();
        System.out.println(lightTank);
        System.out.println(mediumTank);
        System.out.println(heavyTank);
    }
}
