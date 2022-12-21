package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Catapulta extends Personaggio{
    public Catapulta(String text, Skin skin){
        super(text,skin);
        this.costo=120;
        this.attacco=10000;
    }
}
