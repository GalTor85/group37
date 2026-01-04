package Strategy;

public class PostalDelivery implements DeliveryStrategy {
    @Override
    public double calculateCost(double weight, double distance) {
        double baseCost = 10;
        return baseCost + weight * 2;
    }
}
