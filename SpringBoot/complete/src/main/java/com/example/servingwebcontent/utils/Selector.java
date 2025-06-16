package com.example.servingwebcontent.utils;

public class Sequence<T> {
    private Object[] objects;
    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(T x) {
        if (next < objects.length) {
            objects[next++] = x;
        }
    }

    class SSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == next;
        }

        public Object current() {
            return objects[i];
        }

        public void next() {
            if (i < next) i++;
        }
    }

    public Selector getSelector() {
        return new SSelector();
    }
}
