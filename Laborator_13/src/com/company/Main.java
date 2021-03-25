package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class C {}

class D extends C {}

class A {
    static void foo (C c) { System.out.println(1);}
    static void foo (D d) { System.out.println(2); }
}

class B extends A {
    static void foo (C c) { System.out.println(2); }
    static void foo (D d) { System.out.println(2); }
}

class Test {
    public static void main(String args[]) {
        A a = new B();
        a.
    }
}