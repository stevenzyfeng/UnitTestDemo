package com.bytedancer.unittestdemo;

import org.junit.experimental.categories.*;
import org.junit.experimental.categories.Categories.*;
import org.junit.runner.*;
import org.junit.runners.Suite.*;

@RunWith(Categories.class)
@IncludeCategory(MatchersAssertThatSuiteTests.class) // @ExcludeCategory(JUnitAssertTests.class)
@SuiteClasses(AssertTests.class) // Note that Categories is a kind of Suite
public class MatchersAssertThatSuiteTests {

}
