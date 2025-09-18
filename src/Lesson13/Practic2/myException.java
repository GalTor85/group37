package Lesson13.Practic2;

public class myException extends Exception {
    @Override
    public String toString() {
        return getMessage();
    }

    public myException(int age, String messege) {
        super("Ошибка "+age+messege);
    }
}
