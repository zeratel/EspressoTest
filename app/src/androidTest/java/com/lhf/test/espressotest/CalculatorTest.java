package com.lhf.test.espressotest;

import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * com.lhf.test.espressotest
 * Created by zeratel3000
 * on 2016 05 16/5/20 16 02
 * description
 */
@RunWith(AndroidJUnit4.class)
public class CalculatorTest {

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
        Assert.assertThat(calculator.add(2d,1d), CoreMatchers.is(CoreMatchers.equalTo(3d)));
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