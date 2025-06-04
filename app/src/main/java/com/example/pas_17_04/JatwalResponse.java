package com.example.pas_17_04;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JatwalResponse {
    @SerializedName("events")
    private List<Jatwal> jatwals;

    public List<Jatwal> getJatwals() { return jatwals ;}

    public void setJatwals(List<Jatwal> jatwals) {
        this.jatwals = jatwals;
    }
}