package com.savinoordine.espressoplayground.matcher;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.view.ViewGroup;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


public class EspressoMatcher {

    /**
     * If you have a view parent with childs that have no id, you can get access to a child using this matcher
     *
     * HOW TO USE: Get the first child of a view with id: email_field
     *
     * onView(getChildAtPositon(withId(R.id.email_field), 1))
     *          .perform(clearText(), typeText(EMAIL_OK));
     */
    public static Matcher<View> getChildAtPositon(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("with childs view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {

                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }

                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(position).equals(view);
            }
        };
    }

    /**
     * If you have a RecyclerView and want to click a specific item of it, use this matcher.
     * Note: with RecyclerView you have the same element (id and sometimes name too are duplicated)
     *      in all the row of the RecyclerView
     *
     * HOT TO USE: Tap btn on row 0 of the RecyclerView
     *
     * onView(withId(R.id.my_list))
     *      .perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildViewWithId(R.id.btn)));
     */
    public static ViewAction clickChildViewWithId(final int id) {

        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                if (v != null) {
                    v.performClick();
                }
            }
        };
    }
}
