package com.project.clicker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.awt.*;
import java.awt.event.InputEvent;

public  abstract class Personaggio extends TextButton {
   int costo;
   int attacco;
   Label l;
   Boolean b=false;
    public Personaggio(String text, Skin skin,Label label) {
        super(text, skin);
        this.l=label;
        addListener(new ClickListener(){
            public void clicked(InputEvent e, float x, float y){
                if(Integer.parseInt(l.getText())>=costo){
                    setTouchable();
                }
                else{
                    l.setText(Integer.toString(Integer.parseInt(l.getText())+attacco));
                }
            }
        });
    }

    public int getCosto() {
        return costo;
    }

    public int getAttacco() {
        return attacco;
    }

}
