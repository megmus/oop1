package de.mome.javaprofis.oop.graphics;

public class Counter {

    private static final int COUNTER_MAX = 100;

    private int value = 0;
    private int overflowCount = 0;

    public int currentValue() {
        return value;
    }

    public void increment() {
        if (value == COUNTER_MAX - 1) {
            value = 0;
            overflowCount++;
        } else {
            value++;
        }
    }

    public void reset() {
        value = 0;
    }
}
