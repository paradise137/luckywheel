package com.example.liangxintong.luckywheel;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<RecyclerViewData> mDatalist;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView UserName;
        TextView Time;
        TextView Presented;
        View mRootView;

        public ViewHolder(View itemView) {
            super(itemView);

            UserName = (TextView) itemView.findViewById(R.id.user);
            Time = (TextView) itemView.findViewById(R.id.datetime);
            Presented = (TextView) itemView.findViewById(R.id.present);
            mRootView = itemView.findViewById(R.id.root_view);
        }
    }
    public RecyclerViewAdapter(List<RecyclerViewData> recyclerViewDataList){
        mDatalist = recyclerViewDataList;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_data,parent,false);
        ViewHolder holder = new ViewHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        RecyclerViewData recyclerViewData = mDatalist.get(position);
        holder.UserName.setText(recyclerViewData.getUser());
        holder.Presented.setText(recyclerViewData.getPresent());
        holder.Time.setText(recyclerViewData.getTime());
        if (position % 2 == 0){
            holder.mRootView.setBackgroundColor(Color.parseColor("#30291B"));
        }


    }

    @Override
    public int getItemCount() {
        return mDatalist.size();
    }
}
