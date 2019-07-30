package com.junhwa.doitmission14;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements OnItemClickListner {
    ArrayList<Item> items = new ArrayList<>();
    OnItemClickListner listener;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2, textView3;
        ImageView imageView;

        public ViewHolder(View itemView, final OnItemClickListner listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView2);
            textView2 = itemView.findViewById(R.id.textView3);
            textView3 = itemView.findViewById(R.id.textView4);
            imageView = itemView.findViewById(R.id.imageView);

/*            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getWidth());
            imageView.setLayoutParams(layoutParams);*/

            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int position = getAdapterPosition();
                    if (listener != null)
                        listener.onItemClick(ViewHolder.this, view, position);
                    return false;
                }
            });
        }

        public void setItem(Item item) {
            String price = item.getPrice() + "원";
            textView.setText(item.getName());
            textView2.setText(price);
            textView3.setText(item.getDetail());
        }
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemClick(ItemAdapter.ViewHolder holder, View view, int position) {
        if(listener != null)
            listener.onItemClick(holder, view, position);
    }

    public void setOnItemClickListener(OnItemClickListner listener) {
        this.listener = listener;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(int position) {
        return items.get(position);
    }
}
