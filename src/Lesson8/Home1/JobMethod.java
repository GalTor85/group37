package Lesson8.Home1;

public interface JobMethod {
    default void printJobTitle() {
        System.out.println(getClass().getSimpleName());
    }
}
