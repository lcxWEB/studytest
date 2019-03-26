package com.star.thinkInJava.c8polymorphism.music;

//：奋斗奋斗
public class Music {

    /**
     *
     * @param i
     */
    public static void tune(Instrument i) {
        i.play(Note.C_SHARP);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        tune(wind);
    }

} ///：～
