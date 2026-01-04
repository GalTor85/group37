package Observer;

public interface Subscriber {
    void update(NewsAgency agency);
    String getName();
}
