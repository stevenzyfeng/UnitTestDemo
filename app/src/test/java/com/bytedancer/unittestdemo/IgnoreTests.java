package com.bytedancer.unittestdemo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.*;

// To ignore a test in JUnit you can either comment a method, or delete the @Test annotation;
// but the test runner will not report such a test. Alternatively,
// you can add the @Ignore annotation in front or after @Test.
// Test runners will report the number of ignored tests,
// along with the number of tests that ran and the number of tests that failed.

public class IgnoreTests {

    @Ignore("Test is ignored as a demonstration")
    @Test
    public void testSame() {
        assertThat(1, is(1));
    }
}
