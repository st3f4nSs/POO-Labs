package com.company;

class Binding{
    public static void main(String args[]) {
        Hero h1 = new Warrior(), h2 = new Ninja();
        Hero h3 = new Rogue();
        BadLuck bl = new StormFire();
        bl.execute(h1);
        bl.execute(h2);
        bl.execute(h3);
    }
}

abstract class BadLuck {
    abstract void execute(Hero h);
}

class StormFire extends BadLuck {
    @Override
    void execute(Hero h) {
        h.burning();
    }
}


abstract class Hero {
    abstract public void burning();
}

class Warrior extends Hero {
    @Override
    public void burning() { System.out.println("A ars un razboinic"); }
}

class Ninja extends Hero {
    @Override
    public void burning() { System.out.println("A ars un ninja."); }
}

class Rogue extends Hero {
    @Override
    public void burning() {
        System.out.println("A ars un rogue.");
    }
}
