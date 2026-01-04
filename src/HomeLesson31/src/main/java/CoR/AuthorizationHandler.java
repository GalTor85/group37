package CoR;

public class AuthorizationHandler extends TransactionHandler {
    @Override
    public void handle(Transaction transaction) {
        System.out.println("Финальная авторизация...");
        if (transaction.isRequiresConfirmation()) {
            System.out.println("Транзакция ожидает подтверждения пользователя.");
        } else {
            System.out.println("Транзакция авторизована успешно!");
            transaction.setStatus("APPROVED");
        }
        passToNext(transaction);
    }
}
