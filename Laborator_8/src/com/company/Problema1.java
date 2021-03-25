package com.company;

import java.util.*;

class ArrayMap<Q, R> extends AbstractMap<Q, R> {

    private ArrayList<ArrayMapEntry<Q, R>> dict;

    public ArrayMap() {
        dict = new ArrayList<>();
    }

    public int size() {
        return dict.size();
    }

    public R put(Q key, R value) {
        dict.add(new ArrayMapEntry<>(key, value));
        return value;
    }

    @Override
    public Set<Entry<Q, R>> entrySet() {
        return new HashSet<>(dict);
    }

    class ArrayMapEntry<K extends Q, V extends R> implements Map.Entry<K, V>{

        private K key;
        private V value;
        
        public ArrayMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V aux = this.value;
            this.value = value;
            return aux;
        }

        @Override
        public String toString() {
            return "ArrayMapEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            ArrayMapEntry<K, V> that = (ArrayMapEntry<K, V>) o;
            return Objects.equals(key, that.key) &&
                    Objects.equals(value, that.value);
        }
    }
}

class Task1 {

    public static void main(String args[]) {
        ArrayMap<Integer, String> map = new ArrayMap<>();

        System.out.println("Populam colectia...");
        map.put(7, "Colectii si genericitate");
        map.put(8, "Clase interne");
        map.put(5, "Fluxuri");

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + map);

        if (map.size() != 3) {
            System.err.println("ArrayMap.size() (" + map.size() + ") a fost implementata gresit.");
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        if (entries.size() != 3) {
            System.err.println("ArrayMap.entrySet() a fost implementata gresit.");
        }

        for (Map.Entry<Integer, String> e : entries) {
            map.put(e.getKey(), new StringBuffer(e.getValue()).reverse().toString());
            if (!map.entrySet().contains(e)) {
                System.err.println("ArrayMap.put() nu inlocuieste vechea valoare.");
            }
            if ((!e.toString().contains(e.getKey().toString()) || (!e.toString().contains(e.getValue())))) {
                System.err.println("ArrayMap.ArrayMapEntry.toString() a fost implementata gresit.");
            }
        }

        for (Map.Entry<Integer, String> e1 : entries) {
            for (Map.Entry<Integer, String> e2 : entries) {
                if ((e1 == e2) != (e1.equals(e2))) {
                    System.err.println("ArrayMap.ArrayMapEntry.equals() a fost implementata gresit.");
                }
                if ((e1 == e2) != (e1.hashCode() == e2.hashCode())) {
                    System.err.println("ArrayMap.ArrayMapEntry.hashCode() a fost implementata gresit.");
                }
            }
        }
    }
}

