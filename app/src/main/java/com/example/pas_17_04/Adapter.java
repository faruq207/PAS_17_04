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

    public class Adapter extends RecyclerView.Adapter<Adapter.UserViewHolder> {

        private List<Team> userList;

        public Adapter(List<Team> users) {
            this.userList = users;
        }

        public void setTeams(List<Team> teams) {
            this.userList = teams;
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
            Team team = userList.get(position);
            holder.tvnama.setText(team.getStrTeam());
            holder.tvstadium.setText(team.getStrStadium());

            Glide.with(holder.itemView.getContext())
                    .load(team.getStrBadge())
                    .into(holder.picture);
        }

        @Override
        public int getItemCount() {
            return userList != null ? userList.size() : 0;
        }

        public static class UserViewHolder extends RecyclerView.ViewHolder {
            TextView tvnama;
            TextView tvstadium;
            ImageView picture;

            public UserViewHolder(View view) {
                super(view);
                tvnama = view.findViewById(R.id.tvnama);
                tvstadium = view.findViewById(R.id.tvstadium);
                picture = view.findViewById(R.id.picture);
            }
        }
    }

