package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Cannone extends Personaggio{
    public Cannone(String text, Skin skin, Label label){
        super(text,skin,label);
        this.costo=200;
        this.attacco=50000;
    }
}
