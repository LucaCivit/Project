package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Drago extends Personaggio{
    public Drago(String text, Skin skin){
        super(text,skin);
        this.costo=5000;
        this.attacco=1000000;
    }
}
