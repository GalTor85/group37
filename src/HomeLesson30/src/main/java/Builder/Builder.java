package Builder;

public interface Builder {
    void setType(TankType type);

    void setHealth(int health);

    void setArmor(int armor);

    void setEngine(Engine engine);

    void setWeapon(Weapon weapon);

    void setFuel(int fuel);

    Tank build();
}
