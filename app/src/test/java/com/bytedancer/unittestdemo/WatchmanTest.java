package com.bytedancer.unittestdemo;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;
import org.junit.runners.model.*;

// TestWatcher (and the deprecated TestWatchman) are base classes for Rules that take note of the testing action,
// without modifying it. For example, this class will keep a log of each passing and failing test.

public class WatchmanTest {

    private static String watchedLog;

    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            watchedLog += description.getDisplayName() + " " + "success!\n";
        }

        @Override
        protected void failed(Throwable e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };

    @Test
    public void fails() {
        fail();
    }

    @Test
    @Ignore
    public void skip() {
    }

    @Test
    public void succeeds() {
    }

    @AfterClass
    public static void writeLog() {
        System.out.println(watchedLog);
    }
}
