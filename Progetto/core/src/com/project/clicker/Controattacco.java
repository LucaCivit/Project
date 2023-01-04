package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.Random;

public class Controattacco extends Thread {
    Label l;
    int conta;
    int punteggio;
    Random rnd=new Random();

    public Controattacco(Label l) {
        super();
        this.l = l;
        conta=0;
    }

    public void run() {
            if ((conta)> 10) {
                punteggio = Integer.parseInt(String.valueOf(l.getText()));
                l.setText(Integer.toString(punteggio - rnd.nextInt(conta)));
            }
                else{
                    conta++;
                }
            }
    }

