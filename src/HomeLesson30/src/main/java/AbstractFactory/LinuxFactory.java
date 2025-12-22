package AbstractFactory;

import AbstractFactory.Linux.LinuxBrowser;
import AbstractFactory.Linux.LinuxLauncher;

public class LinuxFactory implements AbstractFactory {
    @Override
    public Launcher createLauncher() {
        return new LinuxLauncher();
    }

    @Override
    public Browser createBrowser() {
        return new LinuxBrowser();
    }
}
