package com.lhf.test.espressotest;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * com.lhf.test.espressotest
 * Created by zeratel3000
 * on 2016 05 16/5/23 11 08
 * description
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalculatorInstrumentationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public CalculatorInstrumentationTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        //手动注入ActivityInstrumentationTestCase2
        injectInstrumentation(InstrumentationRegistry
                .getInstrumentation());

        mActivity = getActivity();

    }

    @Test
    public void checkPreconditions() {
        assertThat(mActivity, notNullValue());
        // Check that Instrumentation was correctly injected in setUp()
        assertThat(getInstrumentation(), notNullValue());
    }

    @Test
    public void add() {
        testView(R.id.operation_add_btn, 1d, 2d, 3d);
    }

    private void testView(int operation_add_btn, double v, double v1, double v2) {
        // 模拟输入 Espresso的onView viewMatcher的withId 然后动作
        Espresso.onView(ViewMatchers.withId(R.id.operand_one_edit_text))
                .perform(ViewActions.typeText(v + ""), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.operand_two_edit_text))
                .perform(ViewActions.typeText(v1 + ""), ViewActions.closeSoftKeyboard());

        //模拟点击
        Espresso.onView(ViewMatchers.withId(operation_add_btn)).perform(ViewActions.click());

        //对比结果
        Espresso.onView(ViewMatchers.withId(R.id.operation_result_text_view))
                .check(ViewAssertions.matches(ViewMatchers.withText(v2+"")));
    }


}
