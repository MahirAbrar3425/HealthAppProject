package com.example.healthappproject;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onView;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;

import androidx.core.content.ContextCompat;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class homepagetesting {
    @Rule
    public ActivityScenarioRule<loginActivity> activityRule =
            new ActivityScenarioRule<>(loginActivity.class);

    @Test
    public void testHomePage()
    {
       onView(withId(R.id.EMAIL)).perform(typeText("khanabrar570@gmail.com"));
        onView(withId(R.id.editText2)).perform(typeText("123456"));
        pressBack();
        onView(withId(R.id.Login)).perform(click());
        //loginActivity loginActivity = activityRule.getActivity();
        //Intent intent;// = new Intent(activityRule., homepage.class);
        activityRule.getScenario().onActivity(activity -> {
            // use 'activity'.
           Intent intent = new Intent(activity,homepage.class);

            activity.startActivity(intent);
        });
      onView(withId(R.id.homepage)).check(matches(isDisplayed()));
        onView(withId(R.id.headingTextView)).check(matches(isDisplayed()));
      onView(withId(R.id.label1TextView)).check(matches(isDisplayed()));
       onView(withId(R.id.label2TextView)).check(matches(isDisplayed()));
        onView(withId(R.id.label3TextView)).check(matches(isDisplayed()));
        onView(withId(R.id.llgd)).check(matches(isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.homepage)).perform(ViewActions.swipeUp());

       // onView(withId(R.id.add_new)).check(matches(isDisplayed()));
       // onView(withId(R.id.stat)).check(matches(isDisplayed()));
        onView(withId(R.id.add_new)).perform(click());
       onView(withId(R.id.alert_dialog_1)).check(matches(isDisplayed()));
        onView(withId(R.id.UpperTxt)).check(matches(withText("Insert record")));
//        onView(withId(R.id.header)).check(matches(isDisplayed()));
//        onView(withId(R.id.UpperTxt)).check(matches(isDisplayed()));
//       onView(withId(R.id.alertll1)).check(matches(isDisplayed()));
//        onView(withId(R.id.alert0)).check(matches(isDisplayed()));
        //onView(withId(R.id.heartrate)).check(matches(isDisplayed()));

        // onView(withId()).check(matches(isDisplayed()));
        //Intent intent = new Intent(homepage.class, DynamicActivity.class);
       // onView(withId(R.id.heartrate)).perform(typeText(""));
        onView(withId(R.id.heartrate)).perform(ViewActions.typeText("65")); //Type a city name

     // onView(withId(R.id.heartrate)).perform(typeText("65"));
        //pressBack();
        onView(withId(R.id.alert1)).check(matches(isDisplayed()));

        onView(withId(R.id.systolic)).perform(typeText("65"));
        pressBack();
        onView(withId(R.id.alert2)).check(matches(isDisplayed()));
        onView(withId(R.id.diastole)).perform(typeText("100"));

        onView(withId(R.id.ImgDate)).check(matches(isDisplayed()));

        onView(withId(R.id.date)).perform(typeText("2"));

        onView(withId(R.id.month)).perform(typeText("2"));

        onView(withId(R.id.year)).perform(typeText("2020"));

        onView(withId(R.id.AlertLL5)).check(matches(isDisplayed()));

        onView(withId(R.id.comment)).perform(typeText("jhvihubobsd"));
        onView(withId(R.id.Add)).perform(click());

    }
}
