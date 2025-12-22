package Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance("Hello");
        Singleton instance2 = Singleton.getInstance("World");
        System.out.println(instance1 == instance2);
        System.out.println(instance1.value);
        System.out.println(instance2.value);
}   }

