package FactoryMethod;

public class TelegramSender extends Sender {
    @Override
    protected Message createMessage() {
        return new TelegramMessage();
    }
}
