package AbstractFactory.Windows;

import AbstractFactory.Browser;

public class WindowsBrowser implements Browser {
    @Override
    public void browse() {
        System.out.println("Browsing Windows app");
    }
}
