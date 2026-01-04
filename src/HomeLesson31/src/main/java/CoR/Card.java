package CoR;

public class Card {
    private String number;
    private double availableLimit;

    public Card(String number, double availableLimit) {
        this.number = number;
        this.availableLimit = availableLimit;
    }

    public String getNumber() { return number; }
    public double getAvailableLimit() { return availableLimit; }
}
