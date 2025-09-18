package Lesson13.Home1_Star;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
