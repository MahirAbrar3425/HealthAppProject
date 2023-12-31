package com.example.healthappproject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class SignUpActUITest {
    @Rule
    public ActivityScenarioRule<signupActivity> activityRule =
            new ActivityScenarioRule<>(signupActivity.class);

    @Test
    public void testSignUpAct(){
        onView(withId(R.id.SignupActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.SignUpScrollView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView3)).check(matches(isDisplayed()));
        onView(withId(R.id.name)).check(matches(isDisplayed()));
        onView(withId(R.id.SignUpEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.pass)).check(matches(isDisplayed()));
        onView(withId(R.id.pass2)).check(matches(isDisplayed()));
        onView(withId(R.id.high)).check(matches(isDisplayed()));
        onView(withId(R.id.idd2)).check(matches(isDisplayed()));
        onView(withId(R.id.SignUp_2)).check(matches(isDisplayed()));
        onView(withId(R.id.name)).perform(typeText("Abrar"));
        onView(withId(R.id.SignUpEmail)).perform(typeText("uitest2@gmail.com"));
        onView(withId(R.id.pass_edit1)).perform(typeText("123456"));
        onView(withId(R.id.editpass2)).perform(scrollTo(),typeText("123456"));
        onView(withId(R.id.editheight)).perform(scrollTo(),typeText("1.5"));
        onView(withId(R.id.Weight)).perform(scrollTo(),typeText("78"));
        onView(withId(R.id.SignUp_2)).perform(scrollTo(),click());

    }
}
