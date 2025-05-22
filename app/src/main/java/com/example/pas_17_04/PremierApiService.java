package com.example.pas_17_04;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PremierApiService {
    @GET("3/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamsResponse> getUsers(@Query("league") String league);
}

