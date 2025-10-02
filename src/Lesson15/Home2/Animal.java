package Lesson15.Home2;

import java.util.ArrayList;

class Animal {
    private final ArrayList<String> names;

    public Animal() {
        this.names = new ArrayList<String>();
    }

    public ArrayList<String> getNames() {
        return this.names;
    }

    public void addNames(String names) {
        this.names.addFirst(names);
    }

    public void delNames() {
        this.names.removeLast();
    }
}


