package com.example.alcapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

public class MyProfileActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

		// Set the image for profile
		ImageView myProfile = findViewById(R.id.profile_imageView);
		int imageResource = getResources().getIdentifier("@drawable/jeff", null, this.getPackageName());
		myProfile.setImageResource(imageResource);
	}

}
