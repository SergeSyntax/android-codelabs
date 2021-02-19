package com.example.twoactivities;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    private static final String TEST_STRING = "\"This is a test.\"";

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void activityLaunch() {
        onView(withId(R.id.button_main)).perform(ViewActions.click());
        onView(withId(R.id.text_header)).check(matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.button_second)).perform(ViewActions.click());
        onView(withId(R.id.text_header_reply)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void TextInputOutput() {
        onView(withId(R.id.edit_text_main)).perform(ViewActions.typeText(TEST_STRING));
        onView(withId(R.id.button_main)).perform(ViewActions.click());
        onView(withId(R.id.text_message)).check(matches(withText(TEST_STRING)));
    }
}