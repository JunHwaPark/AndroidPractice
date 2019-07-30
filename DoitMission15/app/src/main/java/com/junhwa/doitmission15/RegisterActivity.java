package com.junhwa.doitmission15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegisterActivity extends AppCompatActivity {
    Animation translateLeftAnim;
    Animation translateRightAnim;
    ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rootView = getWindow().getDecorView().findViewById(android.R.id.content);

        translateLeftAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_right);
        translateRightAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                rootView.setVisibility(View.INVISIBLE);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootView.startAnimation(translateRightAnim);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        rootView.startAnimation(translateLeftAnim);
    }
}
