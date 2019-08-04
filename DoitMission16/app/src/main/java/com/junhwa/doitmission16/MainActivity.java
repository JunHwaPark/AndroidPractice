package com.junhwa.doitmission16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    Button button;
    EditText editText;
    boolean textState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PanelSlidingAnimationListener listener = new PanelSlidingAnimationListener();

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Animation anim = null;
                if (textState)
                    anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.panel_hide);
                else
                    anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.panel_appear);
                anim.setAnimationListener(listener);
                editText.startAnimation(anim);
            }
        });
    }

    private class PanelSlidingAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
            if (textState) {
                button.setText("패널 열기");
                webView.loadUrl(editText.getText().toString());
            }
            else
                button.setText("이동");
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (textState)
                editText.setVisibility(View.GONE);
            else
                editText.setVisibility(View.VISIBLE);
            textState = !textState;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {}
    }
}
