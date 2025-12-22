package Prototype;

public class TruckCar extends Car {
    private String turboEngine;
    private int cargoCapacity;


    public String getTurboEngine() {
        return turboEngine;
    }

    public void setTurboEngine(String turboEngine) {
        this.turboEngine = turboEngine;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public TruckCar() {
    }

    public TruckCar(TruckCar truckCar) {
        super(truckCar);
        if (truckCar == null) return;
        this.turboEngine = truckCar.turboEngine;
        this.cargoCapacity = truckCar.cargoCapacity;
    }

    @Override
    public Car clone() {
        return new TruckCar(this);
    }

    @Override
    public String toString() {
        return super.toString() + ", Turbo Engine: " + turboEngine + ", Cargo Capacity: " + cargoCapacity;
    }
}
