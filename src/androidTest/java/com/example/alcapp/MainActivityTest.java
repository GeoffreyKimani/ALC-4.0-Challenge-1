package com.example.alcapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
	@Rule
	public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


	@Test
	public void navigateToProfile() {
		// Test the clicks to the profile page
		onView(withId(R.id.main_profile_button)).perform(click());

		// check if the profile text fields are initialized with correct data
		String mTrack = "Android";
		String mCountry = "Kenya";
		String mEmail = "jeffkim207@gmail.com";
		String mPhone = "+254 729 698 969";
		String mSlack = "JeffKim";

		onView(withId(R.id.track_tv)).check(matches(withText(containsString(mTrack))));
		onView(withId(R.id.country_tv)).check(matches(withText(containsString(mCountry))));
		onView(withId(R.id.email_tv)).check(matches(withText(containsString(mEmail))));
		onView(withId(R.id.phone_tv)).check(matches(withText(containsString(mPhone))));
		onView(withId(R.id.slack_tv)).check(matches(withText(containsString(mSlack))));

		pressBack();
	}

	// Test the clicks to the profile page
	@Test
	public void navigateToAbout() {
		onView(withId(R.id.main_about_button)).perform(click());

		// load the page
		// onWebView().perform(webClick());

		pressBack();
	}

}