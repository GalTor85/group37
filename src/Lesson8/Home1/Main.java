package Lesson8.Home1;
public class Main {
    /**
     * Задача 1:
     * Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом,
     * который печатает название должности и имплементировать этот метод в созданные
     * классы.
     */
    public static void main(String[] args) {
        Director director = new Director();
        director.printJobTitle();
        Booker booker = new Booker();
        booker.printJobTitle();
        Worker worker = new Worker();
        worker.printJobTitle();
    }
}
