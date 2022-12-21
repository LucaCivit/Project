package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Arciere extends Personaggio{
    public Arciere(String text, Skin skin){
        super(text,skin);
        this.costo=20;
        this.attacco=1000;
    }
}
