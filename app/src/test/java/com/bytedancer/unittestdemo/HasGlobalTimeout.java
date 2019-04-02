package com.bytedancer.unittestdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.rules.*;

// Tests that 'runaway' or take too long, can be automatically failed.

public class HasGlobalTimeout {

    public static String log;
    private final CountDownLatch latch = new CountDownLatch(1);

    // The ClassRule annotation extends the idea of method-level Rules,
    // adding static fields that can affect the operation of a whole class.
    @ClassRule
    public static Timeout classTimeout = Timeout.seconds(20);

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    @Test
    public void testSleepForTooLong() throws Exception {
        log += "ran1";
        TimeUnit.SECONDS.sleep(100); // sleep for 100 seconds
    }

    @Test
    public void testBlockForever() throws Exception {
        log += "ran2";
        latch.await(); // will block
    }

    // testMaxTimeout = min {classTimeout, @Test(timeout)}
    // testMaxTimeout = 1000ms
    @Test(timeout = 1000)
    public void testWithTimeoutLessThanGlobalTimeout() throws Exception {
        log += "ran3";
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    // // testMaxTimeout = min {classTimeout, @Test(timeout)}
    // testMaxTimeout = 10s
    @Test(timeout = 20000)
    public void testWithTimeoutMoreThanGlobalTimeout() throws Exception {
        log += "ran3";
        TimeUnit.MILLISECONDS.sleep(15000);
    }

    // The timeout specified in the Timeout rule applies to the entire test fixture,
    // including any @Before or @After methods.
    // If the test method is in an infinite loop (or is otherwise not responsive to interrupts)
    // then @After methods will not be called.
    @After
    public void testAfter() {
        System.out.println("AFTER");
    }
}
