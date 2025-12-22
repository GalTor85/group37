package AbstractFactory;

import AbstractFactory.Android.AndroidBrowser;
import AbstractFactory.Android.AndroidLauncher;

public class AndroidFactory implements AbstractFactory {
    @Override
    public Launcher createLauncher() {
        return new AndroidLauncher();
    }

    @Override
    public Browser createBrowser() {
        return new AndroidBrowser();
    }
}
