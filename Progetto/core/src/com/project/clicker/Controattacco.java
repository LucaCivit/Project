package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.Random;

public class Controattacco {
    Label l;
    int conta=0;
    int punteggio;
    int start=(int)System.currentTimeMillis();
    Random rnd;

    public Controattacco(Label l) {
        this.l = l;
    }

    public void combatti() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            conta = (int) System.currentTimeMillis() - start;
            if (conta > 10) {
                punteggio = Integer.parseInt(String.valueOf(l.getText()));
                l.setText(Integer.toString(punteggio - rnd.nextInt(conta)));
            }
        }
    }
}
