package AbstractFactory;

import AbstractFactory.Windows.WindowsBrowser;
import AbstractFactory.Windows.WindowsLauncher;

public class WindowsFactory implements AbstractFactory {
    @Override
    public Launcher createLauncher() {
        return new WindowsLauncher();
    }

    @Override
    public Browser createBrowser() {
        return new WindowsBrowser();
    }
}
