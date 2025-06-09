package com.example.pas_17_04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
                .inflate(R.layout.recyclerlayoutschedule, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Jatwal jatwal = jatwalList.get(position);
        holder.tvnama.setText(jatwal.getStrEvent());
        holder.tvstadium.setText(jatwal.getStrSeason());
        holder.tvfilename.setText(jatwal.getStrFilename());

        Glide.with(holder.itemView.getContext())
                .load(jatwal.getStrLeagueBadge())
                .into(holder.ivforimageview);
    }

    @Override
    public int getItemCount() {
        return jatwalList != null ? jatwalList.size() : 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvnama;
        TextView tvstadium;
        TextView tvfilename;
        ImageView ivforimageview;
        public UserViewHolder(View view) {
            super(view);
            tvnama = view.findViewById(R.id.tvnama);
            tvstadium = view.findViewById(R.id.tvstadium);
            tvfilename = view.findViewById(R.id.tvfilename);
            ivforimageview = view.findViewById(R.id.ivforimageview);
        }
    }
}

