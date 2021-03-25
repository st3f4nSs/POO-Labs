package com.company;

import java.util.ArrayList;
import java.util.Objects;

class Test {

    static public void addProduct(Product p) {
        ShopSingleton singleton = ShopSingleton.getInstance();
        singleton.products.add(p);
    }

    static public void removeProduct(Product p) {
        ShopSingleton singleton = ShopSingleton.getInstance();
        singleton.products.remove(p);
    }

    public static void main(String args[]) {
        ShopSingleton singleton = ShopSingleton.getInstance("Kauflland", new ArrayList<>());

        Product p1 = new Product("Salam", 40d);
        Product p2 = new Product("Parizer", 10d);
        Product p3 = new Product("Ciocolata", 20d);
        Product p4 = new Product("Mici", 20d);
        Product p5 = new Product("Budinca", 60d);

        Test.addProduct(p1);
        Test.addProduct(p2);
        Test.addProduct(p3);
        Test.addProduct(p4);
        Test.addProduct(p5);
        singleton.showProducts();

        System.out.println();
        Test.removeProduct(p2);
        Test.removeProduct(p5);
        singleton.showProducts();
        Test.removeProduct(p2);
    }
}


class ShopSingleton {
    public String name;
    public ArrayList<Product> products;
    private static ShopSingleton single_instance = null;

    private ShopSingleton(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }

    private ShopSingleton() {
        this("", new ArrayList<>());
    }

    public void showProducts() {
        for(Product i : products)
            System.out.println(i);
    }

    public static ShopSingleton getInstance(String name, ArrayList<Product> products)
    {
        if (single_instance == null)
            single_instance = new ShopSingleton(name, products);

        return single_instance;
    }

    public static ShopSingleton getInstance() {
        return single_instance;
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
        this("", 0d);
    }

    @Override
    public String toString() {
        return "Product: " + " name = " + name + "; " +" price=" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}