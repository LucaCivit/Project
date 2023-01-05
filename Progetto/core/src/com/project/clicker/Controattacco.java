package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.Random;

public class Controattacco extends Thread {
    Label l;
    int conta;
    int punteggio;
    Random rnd=new Random();
    float timeel= 0;
    public Controattacco(Label l) {
        super();
        this.l = l;
        conta=0;
    }

    public void run() {

        if (timeel > 10) {
                punteggio = Integer.parseInt(String.valueOf(l.getText()));
                l.setText(Integer.toString(punteggio - rnd.nextInt(20)));
                timeel = 0;
            }
        timeel++;
    }




    }

