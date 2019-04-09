package com.bytedancer.unittestdemo;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.*;

public class UseRuleChain {

    @Rule
    public final TestRule chain = RuleChain
            .outerRule(new LoggingRule("outer rule"))
            .around(new LoggingRule("middle rule"))
            .around(new LoggingRule("inner rule"));

    @Test
    public void example() {
        assertTrue(true);
    }
}
