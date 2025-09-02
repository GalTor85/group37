package Lesson6.Home1;

public class CreditCard {
    long numAcc;
    double balance = 0;

    //конструктор
    public CreditCard(long numAcc, double balance) {
        this.numAcc = numAcc;
        this.balance = balance;
    }

    //альтернативный конструктор
    public CreditCard(long numAcc) {
        this.numAcc = numAcc;
    }

    //метод внесения суммы
    void calc(double sum) {
        if (sum >= 0) {
            balance = balance + sum;
        } else {
            System.out.println("Ошибка - вы не можете прибавить отрицательную сумму!");

        }
    }
    //метод снятия суммы
    void remove(double sum) {
        if (sum <= balance) {
            balance = balance - sum;
        } else {
            System.out.println("Ошибка не хватает средств на балансе!");
        }
    }

    //метод перевода
    void transfer(CreditCard card, double amount) {
        if (card.numAcc != numAcc && amount <= balance) {
            balance -= amount;
            card.balance += amount;

        } else {
            System.out.println("Ошибка транзакции");
        }
    }
    //метод вывода баланса
    void getBalance() {
        System.out.println("Карта № " + numAcc + "  баланс: " + balance);
    }


}
