package Lesson9.Home1_Star;

public class Dog extends Animal {
    @Override
    void eat(String food) {
        food.toLowerCase();
        food = food.replaceAll("\\r\\n", "");
            if ("мясо".equals(food)|"педигри".equals(food)) {
                System.out.println("Собака "+getName()+" любит есть "+food +".");
        } else System.out.println("Собака "+getName()+" не любит есть "+food +".");

    }

    @Override
    public String toString() {
        return "Собака";
    }

    @Override
    void voice() {
        System.out.println("Гав гав");

    }
}
