package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Gigante extends Personaggio{
    public Gigante(String text, Skin skin, Label label){
        super(text,skin,label);
        this.costo=1000;
        this.attacco=50000;
    }
}
