package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        AbstractFactory factory;
        if (os.startsWith("Windows")) {
            factory = new WindowsFactory();
        } else if (os.startsWith("Linux")) {
            factory = new LinuxFactory();
        } else if (os.startsWith("Android")) {
            factory = new AndroidFactory();
        } else {
            throw new IllegalArgumentException("Unsupported OS: " + os);
        }
        Application app = new Application(factory);
        app.run();
    }

}
