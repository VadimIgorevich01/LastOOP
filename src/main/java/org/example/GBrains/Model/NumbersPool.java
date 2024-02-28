package org.example.GBrains.Model;

public abstract class NumbersPool {
    private int numberA;

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }
    public int getNumberA() {
        return numberA;
    }

    abstract String getNumberType();
}
