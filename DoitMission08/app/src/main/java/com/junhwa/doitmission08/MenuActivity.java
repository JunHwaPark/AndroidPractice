package com.junhwa.doitmission08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CLIENT = 101;
    public static final int REQUEST_CODE_SALES = 102;
    public static final int REQUEST_CODE_PRODUCT = 103;

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
                Intent intent = new Intent(getApplicationContext(), ClientActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CLIENT);
            }
        });

        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SALES);
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                startActivityForResult(intent, REQUEST_CODE_PRODUCT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String from = null;
            switch (requestCode) {
                case REQUEST_CODE_CLIENT:
                    from = "client";
                    break;
                case REQUEST_CODE_PRODUCT:
                    from = "product";
                    break;
                case REQUEST_CODE_SALES:
                    from = "sales";
            }

            if (data.getStringExtra("select").equals("Login")) {
                Intent intent = new Intent();
                intent.putExtra("select", from);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "From " + from, Toast.LENGTH_LONG).show();
            }
        }
    }
}
