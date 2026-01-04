package Observer;

public class Main {
    public static void main(String[] args) {
        BreakingNewsAgency agency = new BreakingNewsAgency();
        Subscriber user1 = new User("Иван");
        Subscriber user2 = new User("Мария");
        Subscriber app1 = new MobileApp("NewsApp");

        agency.addSubscriber(user1);
        agency.addSubscriber(user2);
        agency.addSubscriber(app1);

        agency.notifySubscribers("Новый фильм в прокате!");
        agency.removeSubscriber(user1);
        agency.notifySubscribers("Скидки в магазине!");
    }
}
