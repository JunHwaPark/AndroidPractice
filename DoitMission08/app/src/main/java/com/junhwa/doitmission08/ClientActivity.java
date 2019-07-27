package com.junhwa.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Client Management");

        Button btnToMenu, btnToLogin;
        btnToMenu = findViewById(R.id.btnToMenu);
        btnToLogin = findViewById(R.id.btnToLogin);

        btnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("select", "client");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("select", "Login");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
