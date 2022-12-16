package com.project.clicker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Fante extends Personaggio {

    public Fante(String text, Skin skin) {
        super(text, skin);
        this.costo=0;
        this.attacco=50;
    }
}



