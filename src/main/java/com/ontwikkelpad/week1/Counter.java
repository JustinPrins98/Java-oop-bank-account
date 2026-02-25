package com.ontwikkelpad.week1;

public class Counter {
    private int value;

    public void increment(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be higher than zero");
        }

        value += amount;
    }

    public void decrement(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be higher than zero");
        } else if (amount > value) {
            throw new IllegalArgumentException("Amount must be lower than the current value");
        }

        value -= amount;

    }

    public int getValue() {
        return value;
    }

}
