package com.junhwa.doitmission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 100;
    EditText editId, editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.editID);
        editPass = findViewById(R.id.editPass);

        Button button = findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editId.getText().toString().length() == 0 || editPass.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "아이디와 패스워드를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU && resultCode == RESULT_OK) {
            String selected = null;
            try {
                selected = data.getStringExtra("select");
            } catch (Exception e) {
                selected = "";
            } finally {
                selected = "From " + selected;
            }

            Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_LONG).show();
        }
    }
}
