package com.example.alcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// import widgets
		Button alc_about_btn = findViewById(R.id.main_about_button);
		Button my_profile_btn = findViewById(R.id.main_profile_button);

		// Launch ALC About Activity
		alc_about_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ALCActivity.class));
			}
		});

		// Launch My Profile Activity
		my_profile_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, MyProfileActivity.class));
			}
		});

	}
}
