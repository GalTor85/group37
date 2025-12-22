package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Sender smsSender = new SMSSender();
        smsSender.sendMessage("Hello");

        Sender telegramSender = new TelegramSender();
        telegramSender.sendMessage("World");
    }
}
