package com.junhwa.doitmission03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ScrollView scrollView2;
    ImageView imageView;
    ImageView imageView2;
    BitmapDrawable bitmap;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        scrollView2 = findViewById(R.id.scrollView2);
        imageView = findViewById(R.id.imageView10);
        imageView2 = findViewById(R.id.imageView11);
        scrollView.setHorizontalScrollBarEnabled(true);
        scrollView2.setHorizontalScrollBarEnabled(true);

        bitmap = (BitmapDrawable) getResources().getDrawable(R.drawable.image01, null);
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
        imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
        index = 0;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
            }
        });
    }

    private void changeImage() {
        if (index == 0) {
            imageView.setImageDrawable(null);
            imageView2.setImageDrawable(bitmap);
            imageView2.getLayoutParams().width = bitmap.getIntrinsicWidth();
            imageView2.getLayoutParams().height = bitmap.getIntrinsicHeight();
            index = 1;
        } else {
            imageView2.setImageDrawable(null);
            imageView.setImageDrawable(bitmap);
            imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
            imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
            index = 0;
        }
    }
}
