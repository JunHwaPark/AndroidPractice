package com.junhwa.samplepaint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PaintBoard view = new PaintBoard(this);
        BestPaintBoard view = new BestPaintBoard(this);
        setContentView(view);
    }
}
