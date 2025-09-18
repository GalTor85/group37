package Lesson13.Practic1;

public class Main {

    /**
     * 1.1 Написать код, который выбросит ArrayIndexOutOfBoundException. Обработать
     * используя try-catch конструкцию.
     * 1.2 Добавить обработку арифметического исключения к предыдущему блоку try-catch
     * используя множественные операторы.
     * 1.3 Преобразовать множественные try-catch в мульти обработчик.
     */

    public static   void main(String[] args) {
        try {
            String[] strings = new String[5];
            int i =0;
            if (50>(Math.random()*100))
            {    int j =10/i;}
            else {
                 strings[6] = "Hello";}


        } catch (ArithmeticException|ArrayIndexOutOfBoundsException e ) {
            System.out.println(e.getClass().getSimpleName());
        };

    }
}