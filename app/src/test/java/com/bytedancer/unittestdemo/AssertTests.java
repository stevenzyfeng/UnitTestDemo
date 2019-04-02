package com.bytedancer.unittestdemo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import org.hamcrest.core.*;
import org.junit.*;

// JUnit provides overloaded assertion methods for all **primitive types** and **Objects** and **arrays** (of primitives or Objects).
// The parameter order is **expected value** followed by **actual value**.

// Optionally the first parameter can be a String message that is output on failure.

// There is a slightly different assertion,
// assertThat that has parameters of the optional failure message, the actual value, and a Matcher object.
// Note that expected and actual are reversed compared to the other assert methods.

// For more information: http://junit.sourceforge.net/javadoc/org/junit/Assert.html

public class AssertTests {

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }

    @Test
    public void testAssertFalse() {
        assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertNull() {
        assertNull("should be null", null);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());
    }

    @Test
    public void testAssertEquals() {
        // assertEquals: Asserts that two objects are equal.
        //               uses the equals() method, or if no equals() method was overridden,
        //               compares the reference between the 2 objects.
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAssertNotEquals() {
        assertNotEquals("failure - strings are equal", "text", "TEXT");
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = Integer.valueOf(768);
        // assertSame: Asserts that two objects refer to the same object.
        //             compares the reference between the 2 objects.
        assertSame("should be same", aNumber, aNumber);
    }

    @Test
    public void testAssertNotSame() {
        assertNotSame("should not be same Object", new Object(), new Object());
    }

    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

    // JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatHasItems() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }

    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList(new String[]{"fun", "ban", "net"}), everyItem(containsString("n")));
    }

    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }
}

