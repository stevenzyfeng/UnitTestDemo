package com.bytedancer.unittestdemo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.*;
import org.junit.*;
import org.junit.rules.*;

public class ExpectedExceptionsTests {

    // verify that code throws exceptions as expected
    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<>().get(0);
    }

    // Try/Catch Idiom
    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<>().get(0);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    // ExpectedException Rule
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<>();

        // This rule lets you indicate not only what exception you are expecting,
        // but also the exception message you are expecting
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0); // execution will never get past this line
    }


    // The expectMessage also lets you use Matchers
    @Test
    public void shouldTestExceptionMessageMatchers() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<>();

        // This rule lets you indicate not only what exception you are expecting,
        // but also the exception message you are expecting
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage(CoreMatchers.containsString("Size: 0"));
        list.get(0); // execution will never get past this line
    }
}
