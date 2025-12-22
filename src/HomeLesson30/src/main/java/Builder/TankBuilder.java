package Builder;

public class TankBuilder implements Builder {
    private TankType tankType;
    private int health;
    private int armor;
    private Engine engine;
    private Weapon weapon;
    private int fuel;


    @Override
    public void setType(TankType type) {
        this.tankType = type;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }


    public Tank build() {
        return new Tank(tankType, health, armor, engine, weapon, fuel);
    }

}
