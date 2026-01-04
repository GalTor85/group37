package CoR;

public abstract class TransactionHandler {
    protected TransactionHandler nextHandler;

    // Устанавливаем следующий обработчик в цепочке
    public void setNext(TransactionHandler handler) {
        this.nextHandler = handler;
    }

    // Основной метод обработки
    public abstract void handle(Transaction transaction);

    // Вспомогательный метод для передачи запроса дальше по цепочке
    protected void passToNext(Transaction transaction) {
        if (nextHandler != null) {
            nextHandler.handle(transaction);
        } else {
            System.out.println("Транзакция обработана полностью.");
        }
    }
}
