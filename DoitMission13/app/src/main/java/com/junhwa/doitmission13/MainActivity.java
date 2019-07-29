package com.junhwa.doitmission13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        final ClientAdapter adapter = new ClientAdapter();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText, editText2, editText3;

                editText = findViewById(R.id.editText);
                editText2 = findViewById(R.id.editText2);
                editText3 = findViewById(R.id.editText3);

                String name = editText.getText().toString();
                String birth = editText2.getText().toString();
                String mobile = editText3.getText().toString();

                adapter.addItem(new Client(name, birth, mobile));
                recyclerView.setAdapter(adapter);
                TextView textView = findViewById(R.id.textView5);
                textView.setText(adapter.getItemCount() + "명");
            }
        });
    }
}
