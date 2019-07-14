package com.example.alcapp;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

@SuppressLint("setJavaScriptEnabled")
public class ALCActivity extends AppCompatActivity {
	private WebView ALCAboutWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alc_about);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

		// webview
		ALCAboutWebView = findViewById(R.id.alc_about_web_view);

		// enable javascript
		WebSettings webSettings = ALCAboutWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		ALCAboutWebView.setWebViewClient(new ALCWebView());
		ALCAboutWebView.loadUrl(getString(R.string.alc_about_url));
	}

	private class ALCWebView extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (Objects.equals(Uri.parse(url).getHost(), getString(R.string.alc_about_url))) {
				// This is my website, so do not override; let my WebView load the page
				return false;
			}
			// If the link is not for a page on my site, do not launch another Activity to handle it
			return false;
		}

		@Override
		public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError error) {
			if (sslErrorHandler != null) {
				sslErrorHandler.proceed();
			} else {
				super.onReceivedSslError(webView, null, error);
			}
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Check if the key event was the Back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && ALCAboutWebView.canGoBack()) {
			ALCAboutWebView.goBack();
			return true;
		}
		// If it wasn't the Back key or there's no web page history, bubble up to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}
}


