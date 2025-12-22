package FactoryMethod;

public class TelegramMessage implements Message {
    @Override
    public void send(String text) {
        System.out.println("Sending Telegram: " + text);
    }
}
