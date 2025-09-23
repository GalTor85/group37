package Lesson13.Practic2;

public class MyException extends Exception {
    @Override
    public String toString() {
        return getMessage();
    }

    public MyException(int age, String messege) {
        super("Ошибка "+age+messege);
    }
}
