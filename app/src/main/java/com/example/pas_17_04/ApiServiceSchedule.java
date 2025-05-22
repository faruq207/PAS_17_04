package com.example.pas_17_04;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceSchedule {
    @GET("3/search_all_teams.php?s=Soccer&c=Spain")
    Call<JatwalResponse> getUsers(@Query("league") String league);
}

