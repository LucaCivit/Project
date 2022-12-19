package com.project.clicker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class Fante extends Personaggio {

    public Fante(String text, Skin skin, Label label) {
        super(text, skin,label);
        this.costo=0;
        this.attacco=50;
        setDisabled(false);
    }
}



