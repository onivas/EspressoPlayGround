package com.savinoordine.espressoplayground;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoViews {

    private static final String HINT_ONLY = "I have hint only";
    private static final String ID_ONLY = "I have id only";
    private static final String TEXT_ONLY = "I have text only";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void setUp() {

        onView(withId(R.id.button_views))
                .check(matches(isDisplayed()))
                .perform(click());

        checkTextViewActivity();
    }

    @After
    public void tearDown() {

        // press back
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    /**
     * This test is executed on device only.
     * Change @RequiresDevice to @Test to see it on emulator
     */
    @Test
    public void checkBox() {

        // find checkbox using TEXT
        onView(withText(R.string.checkbox1))
                .check(matches(allOf(isClickable(), isDisplayed())))
                .perform(click())
                .check(matches(isChecked()));

        onView(withId(R.id.checkbox2)).perform(doubleClick());

        // find checkbox with TEXT and ID combo
        onView(allOf(withId(R.id.checkbox3), withText(R.string.checkbox3)))
                .check(matches(not(isChecked())));
    }

    @Test
    public void editTextHint() {

        onView(withHint(R.string.et_only_hint))
                .perform(click())
                .check(matches(hasFocus()))
                .perform(clearText(), typeText(HINT_ONLY));
    }

    @Test
    public void editTextID() {

        onView(withId(R.id.id_only_et))
                .check(matches(isDisplayed()))
                .perform(clearText(), typeText(ID_ONLY));

        onView(withText(ID_ONLY))
                .check(matches(withText(ID_ONLY)));

    }

    /**
     * type, clear and type again on EditText
     */
    @Test
    public void editTextText() {

        onView(withText(R.string.ev_only_text)).perform(typeText(TEXT_ONLY));
        //onView(withText(R.string.ev_only_text)).perform(clearText()).check(matches(hasProperty("text", withText(""))));

    }

    @Test
    public void radioButton() {

        // find radiobutton using ID
        onView(withId(R.id.radiobutton1))
                .check(matches(isDisplayed()))
                .perform(click());

        onView(withId(R.id.radiobutton2))
                .check(matches(isDisplayed()))
                .perform(click());

        onView(withId(R.id.radiobutton1))
                .check(matches(not(isChecked())));

        onView(withId(R.id.radiobutton2))
                .check(matches(isChecked()));
    }

    /**
     * This is not a @Test, but it is called from setUp() and performs
     *  some check on text view after the activity_view is loaded
     */
    public void checkTextViewActivity() {

        onView(withText(R.string.tv_only_text))
                .check(matches(isDisplayed()));

        onView(withId(R.id.tv_only_id))
                .check(matches(isDisplayed()));

        onView(withHint(R.string.tv_only_hint))
                .check(matches(isDisplayed()));
    }
}
