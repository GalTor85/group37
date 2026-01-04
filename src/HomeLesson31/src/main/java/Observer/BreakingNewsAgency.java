package Observer;

import java.util.ArrayList;
import java.util.List;

public class BreakingNewsAgency implements NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestNews;

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getName() + " подписался на новости");
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber.getName() + " отписался от новостей");
    }

    @Override
    public void notifySubscribers(String news) {
        this.latestNews = news;
        System.out.println("\n[НОВОСТЬ] " + news);
        for (Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }

    public String getLatestNews() {
        return latestNews;
    }
}