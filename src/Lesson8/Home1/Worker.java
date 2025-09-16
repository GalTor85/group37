package Lesson8.Home1;

public class Worker implements JobMethod {
    private String metaDescription = "Рабочий";

    @Override
    public void printJobTitle() {
        System.out.println(metaDescription);
    }
}
