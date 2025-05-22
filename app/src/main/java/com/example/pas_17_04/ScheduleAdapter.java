package com.example.pas_17_04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.UserViewHolder> {

    private List<Jatwal> jatwalList;

    public ScheduleAdapter(List<Jatwal> users) {
        this.jatwalList = users;
    }

    public void setJatwalList(List<Jatwal> jatwals) {
        this.jatwalList = jatwals;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerlayout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Jatwal jatwal = jatwalList.get(position);
        holder.tvnama.setText(jatwal.getStrEvent());
        holder.tvstadium.setText(jatwal.getStrSeason());
    }

    @Override
    public int getItemCount() {
        return jatwalList != null ? jatwalList.size() : 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvnama;
        TextView tvstadium;

        public UserViewHolder(View view) {
            super(view);
            tvnama = view.findViewById(R.id.tvnama);
            tvstadium = view.findViewById(R.id.tvstadium);
        }
    }
}

