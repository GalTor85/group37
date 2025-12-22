package AbstractFactory.Android;

import AbstractFactory.Launcher;

public class AndroidLauncher implements Launcher {
    @Override
    public void launch() {
        System.out.println("Launching Android app");
    }
}
