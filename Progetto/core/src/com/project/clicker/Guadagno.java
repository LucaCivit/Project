package com.project.clicker;

public class Guadagno {
    int g;

    public Guadagno() {
        this.g = 0;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    @Override
    public String toString() {
        return Integer.toString(g);
    }
}
