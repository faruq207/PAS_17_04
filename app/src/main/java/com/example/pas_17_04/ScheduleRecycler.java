package com.example.pas_17_04;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScheduleRecycler extends Fragment {

    private ProgressBar pbProgress;
    private RecyclerView recyclerView;
    private ScheduleAdapter adapter;
    private final List<Jatwal> jatwalList = new ArrayList<>();
    private ApiServiceSchedule apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvLaMancha);
        pbProgress = view.findViewById(R.id.pbMancha);

        adapter = new ScheduleAdapter(jatwalList);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiServiceSchedule.class);

        fetchJatwal();
    }

    private void fetchJatwal() {
        apiService.getUsers("Schedule").enqueue(new Callback<JatwalResponse>() {
            @Override
            public void onResponse(Call<JatwalResponse> call, Response<JatwalResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("API_SUCCESS", "Data: " + new Gson().toJson(response.body()));
                    jatwalList.clear();
                    jatwalList.addAll(response.body().getJatwals());
                    adapter.notifyDataSetChanged();
                    recyclerView.setVisibility(View.VISIBLE);
                    pbProgress.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<JatwalResponse> call, Throwable t) {
                Log.e("API_FAILURE", "Error: " + t.getMessage(), t);
            }
        });
    }
}
