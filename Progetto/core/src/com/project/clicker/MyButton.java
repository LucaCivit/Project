package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class MyButton extends TextButton {
    int attacco = 0;
    int costo = 0;
    String name;
    public MyButton(String text, Skin skin,String nome) {
        super(text, skin);
        this.name = nome;
    }


    public int getCosto() {
        return costo;
    }

    public int getAttacco() {
        return attacco;
    }
    public void setCosto(int valorecosto) {
        this.costo = valorecosto;
    }

    public void setAttacco(int valoreattacco) {
        this.attacco = valoreattacco;
    }

}
