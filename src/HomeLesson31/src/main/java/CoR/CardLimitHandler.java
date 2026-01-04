package CoR;

public class CardLimitHandler extends TransactionHandler {
    @Override
    public void handle(Transaction transaction) {
        System.out.println("Проверка лимита карты...");
        double availableLimit = transaction.getCard().getAvailableLimit();
        if (transaction.getAmount() > availableLimit) {
            System.out.println("Отказ: превышен лимит карты (доступно: " + availableLimit + ")");
            return;
        }
        passToNext(transaction);
    }
}
