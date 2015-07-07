package com.savinoordine.espressoplayground;


import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import org.junit.runner.RunWith;

import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoWebView {

    /**
     * Click id_of_view button on web view page
     */
    private void clickButtonOnWebView() {

        onWebView()
                .withElement(findElement(Locator.ID, "id_of_view"))
                .perform(webClick());
    }
}
