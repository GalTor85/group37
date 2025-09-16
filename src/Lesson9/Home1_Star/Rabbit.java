package Lesson9.Home1_Star;

public class Rabbit extends Animal {
    @Override
    void eat(String food) {
        food.toLowerCase();
        food = food.replaceAll("\\r\\n", "");
        if ("травка".equals(food)|"морковь".equals(food)) {
            System.out.println("Кролик "+getName()+" любит есть "+food +".");
        } else System.out.println("Кролик "+getName()+" не любит есть "+food +".");

    }

    @Override
    void voice() {
        System.out.println("Я кролик");

    }

    @Override
    public String toString() {
        return "Кролик";
    }
}
