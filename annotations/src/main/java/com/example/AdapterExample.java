package com.example;

class OldSystem {
    void doOldThing() {
        System.out.println("Do old thing");
    }
}

interface NewSystem {
    void doNewThing();
}

class Adapter implements NewSystem {
    public OldSystem oldSystem;
    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    };

    @Override
    public void doNewThing() {
        oldSystem.doOldThing();
        System.out.println("Do new thing");
    }
}

// Important when integrating legacy systems or third parties system into a new system
public class AdapterExample {
    public static void main(String[] args) {
        NewSystem newSystem = new Adapter(new OldSystem());
        newSystem.doNewThing();
    }
}
