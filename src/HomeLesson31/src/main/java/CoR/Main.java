package CoR;

public class Main {
    public static void main(String[] args) {
        // Создаём обработчики
        TransactionHandler minAmountHandler = new MinAmountHandler();
        TransactionHandler cardLimitHandler = new CardLimitHandler();
        TransactionHandler fraudHandler = new FraudDetectionHandler();
        TransactionHandler authHandler = new AuthorizationHandler();

        // Строим цепочку: порядок важен!
        minAmountHandler.setNext(cardLimitHandler);
        cardLimitHandler.setNext(fraudHandler);
        fraudHandler.setNext(authHandler);

        // Создаём транзакцию
        Card card = new Card("1234-5678-9012-3456", 1500.0);
        Transaction transaction1 = new Transaction("TX1001", 500.0, card, false);

        System.out.println("=== Обработка транзакции 1 ===");
        minAmountHandler.handle(transaction1);

        System.out.println("\n=== Обработка транзакции 2 ===");
        Transaction transaction2 = new Transaction("TX1002", 1200.0, card, true);
        minAmountHandler.handle(transaction2);

        System.out.println("\n=== Обработка транзакции 3 ===");
        Transaction transaction3 = new Transaction("TX1003", 0.5, card, false);
        minAmountHandler.handle(transaction3);
    }
}
