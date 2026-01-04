package Strategy;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(5, 20);
        order.setDeliveryStrategy(new CourierDelivery());
        System.out.println("Курьерская доставка: " + order.calculateCost());

        order.setDeliveryStrategy(new PostalDelivery());
        System.out.println("Почтовая доставка: " + order.calculateCost());

        order.setDeliveryStrategy(new SelfPickup());
        System.out.println("Самовывоз: " + order.calculateCost());
    }
}
