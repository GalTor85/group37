package FactoryMethod;

public class SMSMessage implements Message {
    @Override
    public void send(String text) {
        System.out.println("Sending SMS: " + text);
    }
}
