package com.project.clicker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import java.awt.event.InputEvent;

public class Personaggio extends TextButton {
   int costo;
   int attacco;

    public Personaggio(String text, Skin skin) {
        super(text, skin);
    }

    public int getCosto() {
        return costo;
    }

    public int getAttacco() {
        return attacco;
    }

}
