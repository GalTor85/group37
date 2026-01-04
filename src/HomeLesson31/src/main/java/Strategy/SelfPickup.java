package Strategy;

public class SelfPickup implements DeliveryStrategy {
    @Override
    public double calculateCost(double weight, double distance) {
        return 0;
    }
}
