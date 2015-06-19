package com.savinoordine.espressoplayground;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoListing {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {

        onView(withId(R.id.button_listing))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    /**
     ******** THIS TEST FAILS
     *
     * android.support.test.espresso.AmbiguousViewMatcherException: 'with text: is "3"' matches multiple views in the hierarchy.
     * Problem views are marked with '****MATCHES****' below.
     *
     *
     * +-------->TextView{id=2131492946, res-name=item_number, visibility=VISIBLE, width=42, height=101, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=30.0, text=3, input-type=0, ime-target=false, has-links=false} ****MATCHES****
     |
     +------->RelativeLayout{id=-1, visibility=VISIBLE, width=984, height=191, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=573.0, child-count=2}
     |
     +-------->Button{id=2131492945, res-name=item_title, visibility=VISIBLE, width=834, height=161, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=150.0, y=30.0, text=Four, input-type=0, ime-target=false, has-links=false}
     |
     +-------->TextView{id=2131492946, res-name=item_number, visibility=VISIBLE, width=42, height=101, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=30.0, text=3, input-type=0, ime-target=false, has-links=false} ****MATCHES****
     |
     +------->RelativeLayout{id=-1, visibility=VISIBLE, width=984, height=191, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=764.0, child-count=2}
     |
     +-------->Button{id=2131492945, res-name=item_title, visibility=VISIBLE, width=834, height=161, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=150.0, y=30.0, text=Five, input-type=0, ime-target=false, has-links=false}
     |
     +-------->TextView{id=2131492946, res-name=item_number, visibility=VISIBLE, width=42, height=101, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=30.0, text=3, input-type=0, ime-target=false, has-links=false} ****MATCHES****
     |
     */
    @Test
    public void clickOnItem(){

        onView(withText("3")).perform(click());
    }

    // To avoid the fails of clickOnItem(), we can do as follow.
    @Test
    public void clickOnItemWithSibling(){

        onView(allOf(withText("3"), hasSibling(withText("Four"))))
                .perform(click());
    }
}

