package Lesson8.HomeStar;

public class Main {
    /**
     * Задача *:
     * Самостоятельно изучить и показать пример работы интерфейса-маркера Cloneable.
     */
    public static void main(String[] args) throws ClassNotFoundException, CloneNotSupportedException {
        Book book = new Book("Структуры данных и алгоритмы Java", "Роберт Лафор", "ООО Издательство «Питер»", 702);

        Book book2 = book.clone();
        book2.setTitle("Ява для чайников");
        book2.setAuthor("Барри Берд");
        book2.setPublisher("Компьютерное Издательство \"Диалектика\"");
        book2.setPages(625);
        System.out.println(book);
        System.out.println(book2);
    }
}
