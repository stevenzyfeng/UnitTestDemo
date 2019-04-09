package com.bytedancer.unittestdemo;

import org.junit.*;
import org.junit.rules.*;

// The ErrorCollector Rule allows execution of a test to continue after the first problem is found
// (for example, to collect all the incorrect rows in a table, and report them all at once)
public class UsesErrorCollectorTwice {

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void example() {
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
    }
}

