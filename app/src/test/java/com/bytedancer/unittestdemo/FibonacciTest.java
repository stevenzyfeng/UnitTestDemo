package com.bytedancer.unittestdemo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

// Parameterized is a standard runner that implements parameterized tests.
// When running a parameterized test class,
// instances are created for the cross-product of the test methods and the test data elements.

// JavaDoc: http://junit.org/javadoc/latest/org/junit/runners/Parameterized.html

@RunWith(Parameterized.class)
public class FibonacciTest {

    // Each instance of FibonacciTest will be constructed using the two-argument constructor
    // and the data values in the @Parameters method.
    @Parameters
    // In order to easily identify the individual test cases in a Parameterized test,
    // you may provide a name using the @Parameters annotation.
    // This name is allowed to contain placeholders that are replaced at runtime:
    // {index}: the current parameter index
    // {0}, {1}, …: the first, second, and so on, parameter value.
    // NOTE: single quotes ' should be escaped as two single quotes ''.
    // @Parameters(name = "{index}: fib({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}
        });
    }

    private int fInput;

    private int fExpected;

    public FibonacciTest(int input, int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
