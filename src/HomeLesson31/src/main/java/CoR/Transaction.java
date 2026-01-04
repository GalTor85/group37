package CoR;

public class Transaction {

    private String id;
    private double amount;
    private Card card;
    private boolean newRecipient;
    private boolean requiresConfirmation;
    private String status;

    public Transaction(String id, double amount, Card card, boolean newRecipient) {
        this.id = id;
        this.amount = amount;
        this.card = card;
        this.newRecipient = newRecipient;
        this.requiresConfirmation = false;
        this.status = "PENDING";
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Card getCard() {
        return card;
    }

    public boolean isNewRecipient() {
        return newRecipient;
    }

    public boolean isRequiresConfirmation() {
        return requiresConfirmation;
    }

    public void setRequiresConfirmation(boolean requiresConfirmation) {
        this.requiresConfirmation = requiresConfirmation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

