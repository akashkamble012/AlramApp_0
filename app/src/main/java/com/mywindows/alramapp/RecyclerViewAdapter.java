package com.mywindows.alramapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    public ArrayList<Alarm> alarms = new ArrayList<>();

    public RecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_recycler_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Started");
        holder.alarmMessage.setText(alarms.get(position).getMessage());
        String time = alarms.get(position).getHours() + " : " + alarms.get(position).getMinutes();
        holder.alarmTime.setText(time);

    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView alarmMessage;
        private TextView alarmTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            alarmMessage = itemView.findViewById(R.id.message);
            alarmTime = itemView.findViewById(R.id.time);


        }


    }

    public void setAlarms(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
        notifyDataSetChanged();
    }
}
