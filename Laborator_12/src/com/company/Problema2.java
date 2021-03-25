package com.company;

import java.util.ArrayList;
import java.util.Objects;

class Test2 {

    static public void addProduct(Product2 p) {
        ShopSingleton2 singleton = ShopSingleton2.getInstance();
        singleton.products.add(p);
    }

    static public void removeProduct(Product2 p) {
        ShopSingleton2 singleton = ShopSingleton2.getInstance();
        singleton.products.remove(p);
    }

    public static void main(String args[]) {
        ShopSingleton2 singleton = ShopSingleton2.getInstance("Kauflland", new ArrayList<>());
        ProductFactory productFactory = new ProductFactory();

        Product2 p1 = productFactory.factory("Food", "Salam", 40d);
        Product2 p2 = productFactory.factory("FOOD", "Parizer", 10d);
        Product2 p3 = productFactory.factory("Computer", "PC", 10000d);
        Product2 p4 = productFactory.factory("Beverage", "Vin", 100d);
        Product2 p5 = productFactory.factory("Book", "Harry Potter", 50d);

        Test2.addProduct(p1);
        Test2.addProduct(p2);
        Test2.addProduct(p3);
        Test2.addProduct(p4);
        Test2.addProduct(p5);
        singleton.showProducts();

        /*
        System.out.println();
        Test2.removeProduct(p2);
        Test2.removeProduct(p5);
        singleton.showProducts();
        Test2.removeProduct(p2);

         */

        System.out.println();
        for(Product2 i : singleton.products)
            System.out.println("Pretul redus al produsului " + i.name + " este " + i.getPriceReduced());
    }
}


class ShopSingleton2 {
    public String name;
    public ArrayList<Product2> products;
    private static ShopSingleton2 single_instance = null;

    private ShopSingleton2(String name, ArrayList<Product2> products) {
        this.name = name;
        this.products = products;
    }

    private ShopSingleton2() {
        this("", new ArrayList<>());
    }

    public void showProducts() {
        for(Product2 i : products)
            System.out.println(i);
    }

    public static ShopSingleton2 getInstance(String name, ArrayList<Product2> products)
    {
        if (single_instance == null)
            single_instance = new ShopSingleton2(name, products);

        return single_instance;
    }

    public static ShopSingleton2 getInstance() {
        return single_instance;
    }
}


class ProductFactory {

    public Product2 factory(String type, String nameProduct, double productPrice) {
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("BOOK")){
            return new Book(nameProduct, productPrice);

        } else if(type.equalsIgnoreCase("FOOD")){
            return new Food(nameProduct, productPrice);

        } else if(type.equalsIgnoreCase("BEVERAGE")){
            return new Beverage(nameProduct, productPrice);

        } else if(type.equalsIgnoreCase("COMPUTER"))
            return new Computer(nameProduct, productPrice);

        return null;
    }
}

abstract class Product2  {
    String name;
    double price;

    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product2() {
        this("", 0d);
    }

    public abstract double getPriceReduced();

    @Override
    public String toString() {
        return "Product: " + " name = " + name + "; " +" price=" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product2 product2 = (Product2) o;
        return Double.compare(product2.price, price) == 0 &&
                Objects.equals(name, product2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

class Book extends Product2 {

    public Book(String name, double price) {
        super(name, price);
    }

    public Book() {
        super();
    }
    @Override
    public double getPriceReduced() {
        return price - 15 * price / 100;
    }
}

class Food extends Product2 {

    public Food(String name, double price) {
        super(name, price);
    }

    public Food() {
        super();
    }

    @Override
    public double getPriceReduced() {
        return price - 20 * price / 100;
    }
}

class Beverage extends Product2 {

    public Beverage(String name, double price) {
        super(name, price);
    }

    public Beverage() {
        super();
    }

    @Override
    public double getPriceReduced() {
        return price - 5 * price / 100;
    }
}

class Computer extends Product2 {

    public Computer(String name, double price) {
        super(name, price);
    }

    public Computer() {
        super();
    }

    @Override
    public double getPriceReduced() {
        return price - 10 * price / 100;
    }
}