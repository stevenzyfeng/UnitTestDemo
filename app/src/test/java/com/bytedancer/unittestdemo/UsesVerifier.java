package com.bytedancer.unittestdemo;

// Verifier is a base class for Rules like ErrorCollector,
// which can turn otherwise passing test methods into failing tests if a verification check is failed.

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.rules.*;

public class UsesVerifier {

    private List<String> errorLog = new ArrayList<>();

    @Rule
    public Verifier verifier = new Verifier() {
        //After each method perform this check
        @Override
        public void verify() {
            Assert.assertTrue("Error Log is not Empty!", errorLog.isEmpty());
        }
    };

    @Test
    public void testWritesErrorLog() {
        //...
        errorLog.add("There is an error!");
    }
}

