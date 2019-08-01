package com.junhwa.sampledatabase2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText2;
    TextView textView;

    DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String databaseName = editText.getText().toString();
                createDatabase(databaseName);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = editText2.getText().toString();
                createTable(tableName);

                insertRecord();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeQuery();
            }
        });
    }

    private void createDatabase(String name) {
        println("createDatabase 호출됨.");

        databaseHelper = new DatabaseHelper(this, name, null, 1);
        database = databaseHelper.getWritableDatabase();

        println("데이터베이스 생성함 : " + name);
    }

    private void createTable(String name) {
        println("createTable 호출됨.");

        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        database.execSQL("CREATE TABLE IF NOT EXISTS " + name + "("
                + "_id integer primary key autoincrement, "
                + "name text, "
                + "age integer, "
                + "mobile text)");

        println("테이블 생성함 : " + name);
    }

    private void insertRecord() {
        println("insertRecord 호출됨.");
        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }
        if (tableName == null) {
            println("테이블을 먼저 생성하세요.");
            return;
        }

        database.execSQL("INSERT INTO " + tableName
                + "(name, age, mobile) "
                + "values "
                + "('John', 20, '010-1000-1000')");

        println("레코드 추가함.");

    }

    public void executeQuery() {
        println("executeQuery 호출됨");

        Cursor cursor = database.rawQuery("select * from EMP", null);
        int recordCount = cursor.getCount();
        println("레코드 개수 : " + recordCount);

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);

            println("레코드#" + i + " : " + id + ", " + name + ", " + age + ", " + mobile);
        }
        cursor.close();
    }

    public void println(String data) {
        textView.append(data + "\n");
    }
}
