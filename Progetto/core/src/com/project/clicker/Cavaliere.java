package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Cavaliere extends Personaggio{
    public Cavaliere(String text, Skin skin, Label label ){
        super(text,skin,label);
        this.costo=10;
        this.attacco=500;
    }
}
