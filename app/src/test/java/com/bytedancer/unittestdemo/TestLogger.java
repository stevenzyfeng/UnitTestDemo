package com.bytedancer.unittestdemo;

import java.util.logging.Logger;
import org.junit.rules.*;
import org.junit.runner.*;
import org.junit.runners.model.*;

// Most custom rules can be implemented as an extension of the ExternalResource rule.
// However, if you need more information about the test class or method in question,
// you'll need to implement the TestRule interface.

public class TestLogger implements TestRule {

    private Logger logger;

    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                logger = Logger.getLogger(description.getTestClass().getName() + '.' + description.getDisplayName());
                base.evaluate();
            }
        };
    }
}

