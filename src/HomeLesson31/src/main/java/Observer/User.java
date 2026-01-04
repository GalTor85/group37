package Observer;

public class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(NewsAgency agency) {
        System.out.println(name + " получил новость: " + ((BreakingNewsAgency) agency).getLatestNews());
    }

    @Override
    public String getName() {
        return name;
    }
}
