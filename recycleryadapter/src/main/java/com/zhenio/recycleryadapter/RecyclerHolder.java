package com.zhenio.recycleryadapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerHolder<T> extends RecyclerView.ViewHolder {
    public RecyclerHolder(@NonNull View itemView) {
        super(itemView);
    }
    public abstract void setData(View view, T data, int position);
}

