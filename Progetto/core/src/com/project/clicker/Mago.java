package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Mago extends Personaggio{
    public Mago(String text, Skin skin){
        super(text,skin);
        this.costo=50;
        this.attacco=5000;
    }
}
