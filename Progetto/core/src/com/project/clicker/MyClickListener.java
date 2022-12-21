package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MyClickListener extends ClickListener {
    public Label label;
    public int costo;
    public int attacco;
    public MyButton button;

    public MyClickListener(Label l,int costo,int attacco,MyButton bn) {
        this.label = l;
        this.costo = costo;
        this.attacco = attacco;
        this.button = bn;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        int punteggio = Integer.parseInt(String.valueOf(label.getText()));
        if(button.isDisabled()){
            if(punteggio >= costo) {
                label.setText(Integer.toString(punteggio - costo));
                button.setText(button.name +"\n A:" + String.valueOf(button.getAttacco()));
                button.setDisabled(false);
            }
        }
        else{
            label.setText(Integer.toString(punteggio+attacco));
        }
    }
}
