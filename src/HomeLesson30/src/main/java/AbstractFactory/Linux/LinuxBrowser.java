package AbstractFactory.Linux;

import AbstractFactory.Browser;

public class LinuxBrowser implements Browser {
    @Override
    public void browse() {
        System.out.println("Browsing Linux app");
    }
}
