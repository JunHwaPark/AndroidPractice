package com.junhwa.samplerecyclerview2;

import android.view.View;

public interface OnPersonItemClickListner {
    public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position);
}
