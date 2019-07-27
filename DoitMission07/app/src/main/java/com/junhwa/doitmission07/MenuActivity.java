package com.junhwa.doitmission07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button client, sales, product;
        client = findViewById(R.id.btnClientManagement);
        sales = findViewById(R.id.btnSalesManagement);
        product = findViewById(R.id.btnProductManagement);

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("select", "client");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("select", "sales");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("select", "product");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
