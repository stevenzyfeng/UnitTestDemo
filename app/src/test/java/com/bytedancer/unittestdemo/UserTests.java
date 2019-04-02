package com.bytedancer.unittestdemo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assume.*;

import org.junit.experimental.theories.*;
import org.junit.runner.*;

@RunWith(Theories.class)
public class UserTests {

    // UserTest will attempt to run filenameIncludesUsername on every compatible DataPoint defined in the class.
    // If any of the assumptions fail, the data point is silently ignored.
    // If all of the assumptions pass, but an assertion fails, the test fails.
    @DataPoint
    public static String GOOD_USERNAME = "optimus";
    @DataPoint
    public static String USERNAME_WITH_SLASH = "optimus/prime";

    @Theory
    public void filenameIncludesUsername(String username) {
        assumeThat(username, not(containsString("/")));
        assertThat(new User(username).configFileName(), containsString(username));
    }
}
