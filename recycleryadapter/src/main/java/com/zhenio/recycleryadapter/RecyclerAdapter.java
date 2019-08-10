package com.zhenio.recycleryadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerHolder<T>> {
    private Context mContext;
    private RecyclerCallback<T> mRecyclerCallback;
    private List<T> dataList = new ArrayList<>();
    private LayoutInflater inflater;
    private OnItemListener onItemListener;

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    public RecyclerAdapter(Context context, RecyclerCallback<T> recyclerCallback) {
        this.mContext = context;
        this.mRecyclerCallback = recyclerCallback;
        inflater = LayoutInflater.from(mContext);
    }

    public View getView(int layout, ViewGroup parent) {
        return inflater.inflate(layout, parent, false);
    }

    public void refreshData(List<T> newData) {
        dataList.clear();
        dataList.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerHolder<T> creator = mRecyclerCallback.creator(this, parent, viewType);
        return creator;
    }

    public T getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        T t = dataList.get(position);
        holder.setData(holder.itemView, t, position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder<T> holder, final int position, @NonNull List<Object> payloads) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemListener != null) {
                    onItemListener.onItemClickListener(view, position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemListener != null) {
                    return onItemListener.onItemLongClickListener(view, position);
                }
                return false;
            }
        });
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface RecyclerCallback<T> {
        RecyclerHolder<T> creator(RecyclerAdapter<T> adapter, ViewGroup view, int position);
    }

    public interface OnItemListener {
        public void onItemClickListener(View view, int position);

        public boolean onItemLongClickListener(View view, int position);
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerHolder<T> holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull RecyclerHolder<T> holder) {
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerHolder<T> holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerHolder<T> holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
    }

    @Override
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
    }

}


