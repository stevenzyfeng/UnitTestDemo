package com.bytedancer.unittestdemo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;

public class MyLoggerTest {

    @Rule
    public final TestLogger logger = new TestLogger();

    @Test
    public void checkOutMyLogger() {
        final Logger log = logger.getLogger();
        log.log(Level.WARNING, "Your test is showing!");
    }

}
