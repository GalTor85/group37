package CoR;

public class MinAmountHandler extends TransactionHandler {
    private double minAmount = 1.0;

    @Override
    public void handle(Transaction transaction) {
        System.out.println("Проверка минимальной суммы...");
        if (transaction.getAmount() < minAmount) {
            System.out.println("Отказ: сумма транзакции ниже минимальной (" + minAmount + ")");
            return; // Прерываем цепочку
        }
        passToNext(transaction); // Передаём дальше
    }
}
