package com.bytedancer.unittestdemo;

public class Fibonacci {

    public static int compute(int input) {
        if (input <= 1) {
            return input;
        } else {
            return Fibonacci.compute(input - 1) + Fibonacci.compute(input - 2);
        }
    }
}
