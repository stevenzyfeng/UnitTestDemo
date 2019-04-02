package com.bytedancer.unittestdemo;

import org.junit.*;
import org.junit.runners.*;

// @FixMethodOrder(MethodSorters.DEFAULT)
// From version 4.11, JUnit will by default use a deterministic,
// but not predictable, order (MethodSorters.DEFAULT)

// @FixMethodOrder(MethodSorters.JVM)
// Sorts the test methods by method name, in lexicographic order.

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MethodOrderTest {

    @Test
    public void testA() {
        System.out.println("first");
    }

    @Test
    public void testB() {
        System.out.println("second");
    }

    @Test
    public void testC() {
        System.out.println("third");
    }
}

