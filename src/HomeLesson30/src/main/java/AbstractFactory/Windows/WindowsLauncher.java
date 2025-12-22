package AbstractFactory.Windows;

import AbstractFactory.Launcher;

public class WindowsLauncher implements Launcher {
    @Override
    public void launch() {
        System.out.println("Launching Windows app");
    }
}
