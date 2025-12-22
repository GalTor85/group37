package Builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Tank buildLightTank() {
        builder.setType(TankType.LIGHT);
        builder.setArmor(100);
        builder.setHealth(500);
        builder.setEngine(Engine.DIESEL);
        builder.setWeapon(Weapon.MACHINE_GUN);
        builder.setFuel(100);
        return builder.build();
    }

    public Tank buildMediumTank() {
        builder.setType(TankType.MEDIUM);
        builder.setArmor(200);
        builder.setHealth(700);
        builder.setEngine(Engine.DIESEL);
        builder.setWeapon(Weapon.CANNON);
        builder.setFuel(150);
        return builder.build();
    }

    public Tank buildHeavyTank() {
        builder.setType(TankType.HEAVY);
        builder.setArmor(300);
        builder.setHealth(1000);
        builder.setEngine(Engine.DIESEL);
        builder.setWeapon(Weapon.MISSILE);
        builder.setFuel(200);
        return builder.build();
    }
}
