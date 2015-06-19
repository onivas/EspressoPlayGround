package com.savinoordine.espressoplayground;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoEditText {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {

        onView(withId(R.id.button_edit))
                .perform(click());
    }

    /**
     * @NOTE: THIS FAILS WITHOUT SLEEP!
     *
     * If the keyboard cover an EditText, and you try to write on the hidden one, you should hide the keyboard otherwise the view is not visible,
     * but even if you do, Espresso doesn't understand when the keyboard is close, keep failing.. (errore below)
     *
     * android.support.test.espresso.PerformException: Error performing 'single click' on view 'with id: com.savinoordine.espressoplayground:id/edittext2'.
     * [...]
     * Caused by: android.support.test.espresso.PerformException: Error performing 'Send down montion event' on view 'unknown'.
     * [...]
     * Caused by: android.support.test.espresso.InjectEventSecurityException: java.lang.SecurityException: Injecting to another application requires INJECT_EVENTS permission
     *
     * ---> Need to add a small sleep to avoid this problem (uncomment the line below)
     *
     */
    @Test
    public void editTextNotVisibleBecauseKeyboard() {

        onView(withId(R.id.edittext1))
                .perform(click());

        closeSoftKeyboard();

        //SystemClock.sleep(500);  // Uncomment this line to let the test pass.

        onView(withId(R.id.edittext2))
                .perform(typeText("Not enough visible"));


    }
}
