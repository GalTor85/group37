package AbstractFactory;

public class Application {
    private Launcher launcher;
    private Browser browser;

    public Application(AbstractFactory factory) {
        launcher = factory.createLauncher();
        browser = factory.createBrowser();
    }

    public void run() {
        launcher.launch();
        browser.browse();
    }
}
