package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Spadaccino extends Personaggio{
    public Spadaccino(String text, Skin skin){
        super(text,skin);
        this.costo=5;
        this.attacco=100;
    }
}
