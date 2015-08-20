package com.ansa;

import com.ansa.hierarchy.AudioDisc;
import com.ansa.hierarchy.Disc;
import com.ansa.hierarchy.DiscService;


public class MainClass {
    public static void main(String[] args) {
        DiscService discService = new DiscService();

        Disc disc = new Disc(100, "disc1");

        AudioDisc audioDisc = new AudioDisc(10, "audio disc", 5, "Elton");

        discService.saveDisc(audioDisc);

        discService.saveDisc(disc);

        for (Disc d : discService.getAll()){
            System.out.println(d.getName());
        }
    }
}
