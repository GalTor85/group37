package Prototype;

public class CityCar extends Car {
    public CityCar() {
    }

    public CityCar(CityCar cityCar) {
        super(cityCar);
    }

    @Override
    public Car clone() {
        return new CityCar(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
