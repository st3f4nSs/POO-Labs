package com.company;

import java.util.Vector;

abstract class Warrior {

    private int health;
    private String name;

    public Warrior (int health, String name) {
        this.health = health;
        this.name = name;
    }

    public Warrior() {
        this(0, "");
    }

    public int getHealth() { return health; }
    public String getName() { return name; }
    public void setHealth(int health) { this.health = health; }
    public void setName(String name) { this.name = name; }
    public String toString() {
        return this.getClass().getName() + " " + this.name + " " + this.health;
    }
    public abstract int getDamage();
}

class SnakeWarrior extends Warrior {
    public SnakeWarrior(int health, String name) {
        super(health, name);
    }

    public SnakeWarrior() {
        super(0, "");
    }

    public int getDamage() { return 10;}
}

class OgreWarrior extends Warrior {
    public OgreWarrior(int health, String name) {
        super(health, name);
    }

    public OgreWarrior() {
        super(0, "");
    }

    public int getDamage() { return 6;}
}

class MarshmallowWarrior extends Warrior {
    public MarshmallowWarrior(int health, String name) {
        super(health, name);
    }

    public MarshmallowWarrior() {
        super(0, "");
    }

    public int getDamage() { return 1;}
}

class WarriorPack {
    private Vector<Warrior> warriors ;

    public WarriorPack () {
        warriors = new Vector<>();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public Vector<Warrior> getWarriors() {
        return warriors ;
    }

    public int calculateDamage() {
        int damage = 0;
        for (int i = 0; i < warriors.size(); i++) {
            damage += warriors.get(i).getDamage();
        }
        return damage;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();

        for(Warrior i : warriors) {
            str.append(i).append(" ").append(", cu dmg-ul: ").append(i.getDamage()).append("\n");
        }
        return str.toString();
    }
}

class Test4 {
    public static void main(String args[]) {
        WarriorPack obj = new WarriorPack();

        obj.addWarrior(new SnakeWarrior(100, "Sarpele1"));
        obj.addWarrior(new SnakeWarrior(100, "Sarpele2"));
        obj.addWarrior(new SnakeWarrior(100, "Sarpele3"));

        obj.addWarrior(new OgreWarrior(100, "Ogre1"));
        obj.addWarrior(new OgreWarrior(100, "Ogre2"));
        obj.addWarrior(new OgreWarrior(100, "Ogre3"));

        obj.addWarrior(new MarshmallowWarrior(100, "Bezea1"));
        obj.addWarrior(new MarshmallowWarrior(100, "Bezea2"));
        obj.addWarrior(new MarshmallowWarrior(100, "Bezea3"));

        System.out.println(obj);
        System.out.println("Damage ul total este: " + obj.calculateDamage());
    }
}