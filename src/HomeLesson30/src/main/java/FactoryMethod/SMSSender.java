package FactoryMethod;

public class SMSSender extends Sender {
    @Override
    protected Message createMessage() {
        return new SMSMessage();
    }
}
