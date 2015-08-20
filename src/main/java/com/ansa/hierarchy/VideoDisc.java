package com.ansa.hierarchy;

import javax.persistence.Entity;


@Entity
public class VideoDisc extends Disc {
    String director;
    String language;

    public VideoDisc(int price, String name, String director, String language) {
        super(price, name);
        this.director = director;
        this.language = language;
    }
}
