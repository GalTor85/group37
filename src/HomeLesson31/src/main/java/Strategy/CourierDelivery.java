package Strategy;

public class CourierDelivery implements DeliveryStrategy {
    @Override
    public double calculateCost(double weight, double distance) {
        return weight * 0.1 + distance * 0.5;
    }
}
