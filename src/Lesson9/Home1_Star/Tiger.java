package Lesson9.Home1_Star;

public class Tiger extends Animal{

    @Override
    void eat(String food) {
        food.toLowerCase();
        food = food.replaceAll("\\r\\n", "");
        if ("мясо".equals(food)) {
            System.out.println("Тигр "+getName()+" любит есть "+food +".");
        } else System.out.println("Тигр "+getName()+" не любит есть "+food +".");

    }

    @Override
    public String toString() {
        return "Тигр";
    }

    @Override
    void voice() {
        System.out.println("Рррррр");

    }
}
