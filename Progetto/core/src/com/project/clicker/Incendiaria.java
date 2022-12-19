package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Incendiaria extends Personaggio{
    public Incendiaria(String text, Skin skin, Label label ){
        super(text,skin,label);
        this.costo=500;
        this.attacco=150000;
    }

}
