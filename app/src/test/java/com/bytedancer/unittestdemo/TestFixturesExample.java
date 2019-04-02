package com.bytedancer.unittestdemo;

import java.io.Closeable;
import org.junit.*;

// A test fixture is a fixed state of a set of objects used as a baseline for running tests.

// There are four fixture annotations: two for class-level fixtures and two for method-level ones.
// At the class level, you have @BeforeClass and @AfterClass,
// and at the method (or test) level, you have @Before and @After.

public class TestFixturesExample {

    static class ExpensiveManagedResource implements Closeable {

        @Override
        public void close() {
        }
    }

    static class ManagedResource implements Closeable {

        @Override
        public void close() {
        }
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass setUpClass");
        myExpensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass tearDownClass");
        myExpensiveManagedResource.close();
        myExpensiveManagedResource = null;
    }

    private ManagedResource myManagedResource;
    private static ExpensiveManagedResource myExpensiveManagedResource;

    private void println(String string) {
        System.out.println(string);
    }

    @Before
    public void setUp() {
        this.println("@Before setUp");
        this.myManagedResource = new ManagedResource();
    }

    @After
    public void tearDown() {
        this.println("@After tearDown");
        this.myManagedResource.close();
        this.myManagedResource = null;
    }

    @Test
    public void test1() {
        this.println("@Test test1()");
    }

    @Test
    public void test2() {
        this.println("@Test test2()");
    }
}

