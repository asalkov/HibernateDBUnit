package com.ansa.hierarchy;


import javax.persistence.Entity;

@Entity
public class AudioDisc extends Disc {
    int trackCount;
    String artist;

    public AudioDisc() {
    }


    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public AudioDisc(int price, String name, int trackCount, String artist) {
        super(price, name);
        this.trackCount = trackCount;
        this.artist = artist;
    }
}
