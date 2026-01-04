package Observer;

public class MobileApp implements Subscriber {
    private String appName;
    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(NewsAgency agency) {
        System.out.println(appName + ": PUSH-уведомление — «" + ((BreakingNewsAgency) agency).getLatestNews() + "»");
    }

    @Override
    public String getName() {
        return appName;
    }
}
