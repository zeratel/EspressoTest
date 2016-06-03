package com.lhf.test.espressotest;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        Assert.assertThat(calculator.add(1d,1d), CoreMatchers.is(CoreMatchers.equalTo(2d)));
    }

    @Test
    public void testAdd2() throws Exception {
        Assert.assertThat(calculator.add(2d,1d), CoreMatchers.is(CoreMatchers.equalTo(500d)));
    }

    @Test
    public void testSub() throws Exception {
        Assert.assertThat(calculator.sub(3d,2d), CoreMatchers.is(CoreMatchers.equalTo(1d)));
    }

    @Test
    public void testDiv() throws Exception {
        Assert.assertThat(calculator.div(4d,2d), CoreMatchers.is(CoreMatchers.equalTo(2d)));
    }

    @Test
    public void testMul() throws Exception {
        Assert.assertThat(calculator.mul(1d,1d), CoreMatchers.is(CoreMatchers.equalTo(1d)));
    }
}