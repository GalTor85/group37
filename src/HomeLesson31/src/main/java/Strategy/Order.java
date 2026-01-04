package Strategy;

public class Order {
    private DeliveryStrategy deliveryStrategy;
    private double weight;
    private double distance;

    public Order(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public double calculateCost() {
        if (deliveryStrategy == null) {
            throw new IllegalStateException("Способ доставки не выбран");
        }
        return deliveryStrategy.calculateCost(weight, distance);
    }
}
