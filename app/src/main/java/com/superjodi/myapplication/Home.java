package com.superjodi.myapplication;

import static com.superjodi.myapplication.R.layout.activity_home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;


public class Home extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_home);

        // Find the WebView by its unique ID
         webView = findViewById(R.id.web);
         progressBar = findViewById(R.id.proBar);


        // loading https://www.geeksforgeeks.org url in the WebView.
        webView.loadUrl("https://superjodi.in/");

        // this will enable the javascript.
        webView.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
             webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}