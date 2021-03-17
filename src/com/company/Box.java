package com.company;

class Box<T> {
    private T element;

    public T get() {
        return element;
    }

    public void put(final T element2) {
        this.element = element2;
    }
}