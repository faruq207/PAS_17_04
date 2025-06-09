package com.example.pas_17_04;

public class Jatwal {
    private String strEvent;
    private String strSeason;
    private String strFilename;
    private String strLeagueBadge;
    public Jatwal(String strEvent, String strSeason) {
        this.strEvent = strEvent;
        this.strSeason = strSeason;
        this.strFilename = strFilename;
        this.strLeagueBadge = strLeagueBadge;
    }

    public String getStrFilename() { return strFilename; }

    public String getStrLeagueBadge() { return strLeagueBadge; }

    public String getStrEvent() {
        return strEvent;
    }

    public String getStrSeason() {
        return strSeason;
    }
}
