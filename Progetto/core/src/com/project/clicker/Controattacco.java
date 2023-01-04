package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.Random;

public class Controattacco {
    Label l;
    int conta=0;
    int punteggio;
    long start= System.currentTimeMillis();
    Random rnd;

    public Controattacco(Label l) {
        this.l = l;
    }

    public void combatti() {
        while (true) {
            if ((System.currentTimeMillis() - start)> 10) {
                punteggio = Integer.parseInt(String.valueOf(l.getText()));
                l.setText(Integer.toString(punteggio - rnd.nextInt(1000)));
            }
                else{
                    continue;
                }
            }
        }
    }

