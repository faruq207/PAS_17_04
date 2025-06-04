package com.example.pas_17_04;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceSchedule {
    @GET("3/eventsseason.php?id=4328&s=2014-2015")
    Call<JatwalResponse> getUsers(@Query("league") String league);
}

