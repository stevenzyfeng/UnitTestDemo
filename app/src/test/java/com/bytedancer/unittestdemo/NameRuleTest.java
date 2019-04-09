package com.bytedancer.unittestdemo;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.*;

// The TestName Rule makes the current test name available inside test methods:

public class NameRuleTest {

    @Rule
    public final TestName name = new TestName();

    @Test
    public void testA() {
        assertEquals("testA", name.getMethodName());
    }

    @Test
    public void testB() {
        assertEquals("testB", name.getMethodName());
    }
}