package AbstractFactory.Android;

import AbstractFactory.Browser;

public class AndroidBrowser implements Browser {
    @Override
    public void browse() {
        System.out.println("Browsing Android app");
    }
}
