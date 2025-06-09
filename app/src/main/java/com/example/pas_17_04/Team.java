package com.example.pas_17_04;

public class Team {
    private String strTeam;
    private String strStadium;
    private String strBadge;
    public Team(String strTeam, String strStadium) {
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strBadge = strBadge;
    }

    public String getStrBadge() { return strBadge; }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }
}
