package FactoryMethod;

public abstract class Sender {
    public void sendMessage(String text) {
        Message message = createMessage();
        message.send(text);
    }
    protected abstract Message createMessage();
}
