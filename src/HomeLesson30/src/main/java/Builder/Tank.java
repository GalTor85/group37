package Builder;

public class Tank {
    private final TankType tankType;
    private final int health;
    private final int armor;
    private final Engine engine;
    private final Weapon weapon;
    private int fuel;

    public Tank(TankType tankType, int health, int armor, Engine engine, Weapon weapon, int fuel) {
        this.tankType = tankType;
        this.health = health;
        this.armor = armor;
        this.engine = engine;
        this.weapon = weapon;
        this.fuel = fuel;
    }

    public TankType getTankType() {
        return tankType;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "tankType=" + tankType +
                ", health=" + health +
                ", armor=" + armor +
                ", engine=" + engine +
                ", weapon=" + weapon +
                ", fuel=" + fuel +
                '}';
    }
}