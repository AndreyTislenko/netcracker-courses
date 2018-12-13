package com.netcracker.rootCounter.model;

public class Polynomial {
    private double a;
    private double b;
    private double c;
    private double countOfRoots;

    public Polynomial() {}

    public int countRoots() {
        if(a == 0) {
            if(b == 0) {
                if(c == 0) return -1; //infinity
                else return 0; //no roots
            } else {
                return 1;
            }
        }

        double D = b*b - 4*a*c;

        if(D > 0) return 2;
        else if (D == 0) return 1;

        return 0;
    }

    public double getA() { return a; }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    public double getCountOfRoots() {
        return countOfRoots;
    }
    public void setCountOfRoots(double countOfRoots) {
        this.countOfRoots = countOfRoots;
    }
}