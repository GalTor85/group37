package Prototype;

public class Main {
    public static void main(String[] args) {
        Car cityCar = new CityCar();
        cityCar.setModel("City");
        cityCar.setYear(2022);
        cityCar.setColor("Red");
        System.out.println(cityCar);
        Car cityCarClone = cityCar.clone();
        cityCarClone.setModel("City Clone");
        System.out.println(cityCarClone);
        TruckCar truckCar = new TruckCar();
        truckCar.setModel("Truck");
        truckCar.setYear(2023);
        truckCar.setColor("Blue");
        truckCar.setTurboEngine("Yes");
        truckCar.setCargoCapacity(1000);
        System.out.println(truckCar);
        Car truckCarClone = truckCar.clone();
        ((TruckCar) truckCarClone).setTurboEngine("No");
        ((TruckCar) truckCarClone).setCargoCapacity(500);
        System.out.println(truckCarClone);
    }
}
