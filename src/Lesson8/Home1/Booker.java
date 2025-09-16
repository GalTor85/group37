package Lesson8.Home1;

public class Booker implements JobMethod {
    private String metaDescription = "Бухгалтер";

    @Override
    public void printJobTitle() {
        System.out.println(metaDescription);
    }
}