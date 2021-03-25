package com.company;

public class Problema7 {

    public boolean isPrim(int x) {
        int div;

        if(x == 0)
            return false;
        if(x == 1)
            return true;
        if(x == 2)
            return true;
        if(x % 2 == 0)
            return false;
        for(div = 3; div <= Math.sqrt(x); div = div + 2) {
            if(x % div == 0) {
                return false;
            }
        }
        return true;
    }

    public void create_print(int max_even) {
        int v[], i, k, j, t;
        Problema7 obj;

        k = 0;
        obj = new Problema7();
        v = new int[max_even];
        for(i = 1; i <= max_even; i++) {
            if(obj.isPrim(i))
                v[k++] = i;
        }
        for(i = 0; i < k; i++)
            for(j = i; j < k; j++) {
                int res = v[i] + v[j];
                if(res <= max_even && res % 2 == 0)
                    System.out.println(res + " = " + v[i] + " + " + v[j]);
            }
        /*
        for(t = 2; t <= max_even; t = t + 2) {
            for(i = 0; i < k; i++)
                for(j = i; j < k; j++) {
                    int res = v[i] + v[j];
                    if(res == t && res % 2 == 0)
                        System.out.println(res + " = " + v[i] + " + " + v[j]);
                }
                Daca vrem ca sumele sa fie in ordine cresc: pentru 2, apoi 4, apoi 6 ... 2*n
        }
        */
    }

    public static void main(String args[]) {
        int n, max_even;
        Problema7 obj = new Problema7();

        n = 10;
        max_even = 2 * n;
        obj.create_print(max_even);
    }
}

/*
    Am luat cel mai mare numar par = 2 * n, n este numarul de nr pare.
    Metoda print verifica daca un nr este prim.
    Pentru acest numar par(cel mai mare) am construit un vector ce contine toate nr.
prime mai mici decat el.
    1) Metoda cu 2 for-uri: Am calculat toate sumele(perechile) si am verificat ca sumele
sa fie pare si sa fie <= max_even. Nu le afiseaza in ordine.
    2) Metoda cu 3 for-uri. Creaza sumele in ordine crescatoare.
 */
