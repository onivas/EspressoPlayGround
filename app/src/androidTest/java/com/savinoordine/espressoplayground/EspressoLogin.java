package com.savinoordine.espressoplayground;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoLogin {

    private static final String EMAIL_OK = "emailok@domain.it";
    private static final String EMAIL_KO = "emailko@domain.it";
    private static final String PWD_OK = "pwd";
    private static final String PWD_KO = "blabla";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {

        onView(withId(R.id.button_login))
                .perform(click());
    }

    /**
     * Check new activity after login perform
     */
    @Test
    public void loginOk() {

        performLogin(EMAIL_OK, PWD_OK);

        onView(withText(R.string.successfully_login_message))
                .check(matches(isDisplayed()));

        // press back
        onView(isRoot()).perform(ViewActions.pressBack());

    }

    /**
     * Check error message after wrong login perform
     */
    @Test
    public void loginKo() {

        performLogin(EMAIL_KO, PWD_KO);

        onView(allOf(withId(R.id.error), withText(R.string.fail_login_message))).check(matches(isDisplayed()));

    }

    public void performLogin(String email, String pwd) {

        onView(withId(R.id.email))
                .perform(clearText(), typeText(email));

        onView(withId(R.id.password))
                .perform(clearText(), typeText(pwd));

        onView(withId(R.id.email_sign_in_button))
                .perform(click());
    }
}
