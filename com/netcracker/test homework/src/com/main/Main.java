package com.main;

import com.test.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int x;
    public static void main(String[] args) {
        /*Test test = new Test();
        x = 0;*/

        List<Integer> intList = new LinkedList<>();
        List<Double> dblList = new LinkedList<>();
        System.out.println("First type: " + intList.getClass());
        System.out.println("Second type:" + dblList.getClass());
    }
}

class A {
    protected void m() throws Exception {

    }
}

class B extends A {
    @Override
    public void m() throws ABException {

    }
}

class ABException extends IOException {
    public ABException(){
        super();
    }
}