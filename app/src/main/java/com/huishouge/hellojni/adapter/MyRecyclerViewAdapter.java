package com.huishouge.hellojni.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huishouge.hellojni.R;

import java.util.List;

/**
 * Created by lenovo on 2017/4/25.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> data;
    private CallBack callBack;

    public String getItem(int position) {
        return null != data ? data.get(position) : null;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View v;
        TextView tv;

        public ViewHolder(View view) {
            super(view);
            this.v = view;
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }

    public MyRecyclerViewAdapter(CallBack callBack) {
        this.callBack = callBack;
    }

    public MyRecyclerViewAdapter(List<String> data, CallBack callBack) {
        this.data = data;
        this.callBack = callBack;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public interface CallBack {
        void rVOnItemClick(int position);
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (LayoutInflater.from(parent.getContext())).inflate(R.layout.item_main, parent, false);
        final ViewHolder vh = new ViewHolder(v);
        vh.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                callBack.rVOnItemClick(position);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return null != data ? data.size() : 0;
    }
}
