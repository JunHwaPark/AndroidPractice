package com.junhwa.doitmission14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        final ItemAdapter adapter = new ItemAdapter();

        adapter.addItem(new Item("롱코트", 160000, "명절 기획상품"));
        adapter.addItem(new Item("빈탄 와이셔츠", 80000, "특가상품"));
        adapter.addItem(new Item("조깅화", 220000, "조깅 기획상품"));
        adapter.addItem(new Item("구찌 썬글라스", 1600000, "구찌 특별상품"));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListner() {
            @Override
            public void onItemClick(ItemAdapter.ViewHolder holder, View view, int position) {
                Item item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "이름 : " + item.getName() +
                        "가격 : " + item.getPrice() + "\n" + item.getDetail(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
