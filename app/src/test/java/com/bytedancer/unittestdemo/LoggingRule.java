package com.bytedancer.unittestdemo;

import org.junit.rules.*;
import org.junit.runner.*;
import org.junit.runners.model.*;

public class LoggingRule implements TestRule {

    String message;

    public LoggingRule(String message) {
        this.message = message;
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    System.out.println("starting" + message);
                    base.evaluate(); // This will run the test.
                } finally {
                    System.out.println("finished" + message);
                }
            }
        };
    }
}

