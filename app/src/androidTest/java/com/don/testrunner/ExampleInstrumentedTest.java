package com.don.testrunner;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
  private UiDevice mDevice;

  //  @Test
//  public void useAppContext() throws Exception {
//    // Context of the app under test.
//    Context appContext = InstrumentationRegistry.getTargetContext();
//
//    assertEquals("com.don.testrunner", appContext.getPackageName());
//  }
  @Before
  public void setUp() {
    // Initialize UiDevice instance
    mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

  }

  @Test
  public void onClickPuTest() {
    UiObject tab = mDevice.findObject(new UiSelector()
      .className("com.instagram.base.activity.tabactivity.IgTabWidget")
      .resourceIdMatches("android:id/tabs")
      .childSelector(new UiSelector()
        .className("android.widget.FrameLayout").index(2)));

    try {
      tab.clickAndWaitForNewWindow();
    } catch (UiObjectNotFoundException e) {
      e.printStackTrace();
    }

    UiObject photo = mDevice.findObject(new UiSelector()
      .resourceIdMatches("com.instagram.android:id/media_picker_grid_view")
      .childSelector(new UiSelector()
        .className("android.view.View").index(7)));

    try {
      photo.clickAndWaitForNewWindow(2000);
    } catch (UiObjectNotFoundException e) {
      e.printStackTrace();
    }

    UiObject nextAfterPick = mDevice.findObject(new UiSelector()
    .resourceIdMatches("com.instagram.android:id/next_button_textview"));

    try {
      nextAfterPick.clickAndWaitForNewWindow(2000);
    } catch (UiObjectNotFoundException e) {
      e.printStackTrace();
    }

    try {
      nextAfterPick.clickAndWaitForNewWindow(2000);
    } catch (UiObjectNotFoundException e) {
      e.printStackTrace();
    }


    UiObject shareEdit = mDevice.findObject(new UiSelector()
    .resourceIdMatches("com.instagram.android:id/caption_text_view"));

    try {
      shareEdit.setText("so cute " + System.currentTimeMillis());
    } catch (UiObjectNotFoundException e) {
      e.printStackTrace();
    }

    UiObject shareButton = mDevice.findObject(new UiSelector()
    .resourceIdMatches("com.instagram.android:id/next_button_textview"));

    try {
      shareButton.clickAndWaitForNewWindow(5000);
    } catch (UiObjectNotFoundException e) {
      e.printStackTrace();
    }
  }
}
