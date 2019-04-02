package com.bytedancer.unittestdemo;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

// When a class is annotated with @RunWith or extends a class annotated with @RunWith,
// JUnit will invoke the class it references to run the tests in that class instead of the runner built into JUnit.

// JavaDoc for @RunWith http://junit.org/javadoc/latest/org/junit/runner/RunWith.html

// The default runner is BlockJUnit4ClassRunner which supersedes the older JUnit4ClassRunner
// Annotating a class with @RunWith(JUnit4.class) will always invoke the default JUnit 4 runner in the current version of JUnit,
// this class aliases the current default JUnit 4 class runner.

// Suite is a standard runner that allows you to manually build a suite containing tests from many classes.

// JavaDoc: http://junit.org/javadoc/latest/org/junit/runners/Suite.html

@RunWith(Suite.class)
@Suite.SuiteClasses({AssertTests.class, ExampleUnitTest.class, /*Any test class you want to run*/})
public class TestSuite {

    // Please note this case won't run. It will only run cases which
    // are configured in @Suite.SuiteClasses
    @Test
    public void testPrint() {
        System.out.println("Hello RunWith(Suit.class)");
    }
}
