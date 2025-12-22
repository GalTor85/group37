package AbstractFactory.Linux;

import AbstractFactory.Launcher;

public class LinuxLauncher implements Launcher {
    @Override
    public void launch() {
        System.out.println("Launching Linux app");
    }
}
