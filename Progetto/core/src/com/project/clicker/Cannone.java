package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Cannone extends Personaggio{
    public Cannone(String text, Skin skin){
        super(text,skin);
        this.costo=200;
        this.attacco=50000;
    }
}
