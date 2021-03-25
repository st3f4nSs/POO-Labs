package com.company;

import com.sun.nio.sctp.PeerAddressChangeNotification;

public class Problema1 {
    public static void main(String args[]) {
        IceCream iceCream = new Vanilla(new Chocolate(new BasicIceCream()));
        System.out.println("Ingrediente: " + iceCream.getDescription());
        System.out.println("Cost: " + iceCream.getCost());
    }
}

interface IceCream {
    public String getDescription();
    public double getCost();
}

abstract class ToppingDecorator implements IceCream {
    public IceCream tempiceCream;
    public ToppingDecorator(IceCream iceCream) {
        tempiceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return tempiceCream.getDescription();
    }

    @Override
    public double getCost() {
        return tempiceCream.getCost();
    }
}

class BasicIceCream implements IceCream {

    public BasicIceCream() {
        System.out.println("Adding cone");
    }
    @Override
    public String getDescription() {
        return "cone ";
    }

    @Override
    public double getCost() {
        return 0.5d;
    }
}

class Chocolate extends ToppingDecorator {
    public Chocolate(IceCream iceCream) {
        super(iceCream);
        System.out.println("Adding chocolate.");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "chocolate ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5d;
    }
}

class Vanilla extends ToppingDecorator {
    public Vanilla(IceCream iceCream) {
        super(iceCream);
        System.out.println("Adding vanilla.");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "vanilla ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2;
    }
}