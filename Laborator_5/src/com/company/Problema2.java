package com.company;

class MyList {
    private Node head;
    private int size;

    public MyList() {
        head = new Node(null);
        size = 0;
    }

    //Adauga un obiect in lista
    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        size++;
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for(int i = 0; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }

    public Object get(int index) {
        if(index < 0 && index >= this.size) {
            return null;
        } else {
            Node current = head.getNext();
            for(int i = 0; i < index; i++) {
                if(current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) {
            return false;
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Node current = head.getNext();
        String result = "";
        while(current != null) {
            result += "[" + current.getData() + "] ";
            current = current.getNext();
        }
        return result;
    }


    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.next = null;
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

class Graph extends MyList{

    private MyList[] v;
    private int[] vizitat;

    public Graph(int n) {
        int i;

        v = new MyList[n + 1];
        vizitat = new int[n + 1];
        for (i = 1; i <= n; i++) {
            v[i] = new MyList();
        }
        for (i = 1; i <= n; i++) {
            vizitat[i] = 0;
        }
    }

    public void add(int i, int j) {
        v[i].add(j);
    }

    public void dfs(int nod) {
        System.out.print(nod + " ");
        vizitat[nod] = 1;
        if (v[nod].size() != 0) {
            for (int i = 0; i < v[nod].size(); i++) {
                if (vizitat[(int) v[nod].get(i)] == 0) {
                    dfs((int) v[nod].get(i));
                }
            }
        }
    }

    public String toString() {
        int i;
        StringBuffer str = new StringBuffer();

        for (i = 1; i <= v.length - 1; i++) {
            if (v[i].size() != 0) {
                str.append("Lista vecinilor nodului ").append(i).append(": ")
                .append(v[i]).append("\n");
            }
        }
        return str.toString();
    }
}


class TestGraph {
    public static void main(String args[]) {
        Graph g = new Graph(8);
        g.add(1, 2);
        g.add(1, 5);
        g.add(1, 8);
        g.add(2, 3);
        g.add(5, 6);
        g.add(4, 2);
        g.add(6, 3);
        g.add(6, 7);
        g.add(6, 8);
        g.add(3, 4);
        System.out.println(g);
        System.out.print("Parcurgere in adancime: ");
        System.out.println();
        g.dfs(1);
    }
}