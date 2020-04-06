package com.example.moean_p;

public class Map {
    private double longtitute,latitute;
    public Map() {
    }

    public Map(double longtitute, double latitute) {
        this.longtitute = longtitute;
        this.latitute = latitute;
    }

    public double getLongtitute() {
        return longtitute;
    }

    public void setLongtitute(double longtitute) {
        this.longtitute = longtitute;
    }

    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }
}
