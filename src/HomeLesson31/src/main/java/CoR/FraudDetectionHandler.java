package CoR;

public class FraudDetectionHandler extends TransactionHandler {
    @Override
    public void handle(Transaction transaction) {
        System.out.println("Проверка на мошенничество...");
        // Упрощённая логика: если сумма > 1000 и новый получатель — подозрение
        if (transaction.getAmount() > 1000.0 &&
                transaction.isNewRecipient()) {
            System.out.println("Предупреждение: подозрительная операция! Требуется подтверждение.");
            transaction.setRequiresConfirmation(true);
        }
        passToNext(transaction);
    }
}
