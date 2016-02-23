package com.bemach.aep.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class, AssertTests.class})
public class AllTests {

}
