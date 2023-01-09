package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.LinkedList;

public class MyClickListener extends ClickListener {
    public Label label;
    public Nemico enemy;
    public int costo;
    public int attacco;
    public MyButton button;
    public ProgressBar pro;

    public MyClickListener(Label l,int costo,int attacco,MyButton bn,Nemico enemy,ProgressBar progressBar) {
        this.pro = progressBar;
        this.label = l;
        this.costo = costo;
        this.attacco = attacco;
        this.button = bn;
        this.enemy=enemy;
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
            enemy.danneggia(attacco);
            pro.setValue(pro.getMaxValue()-enemy.getDanno());

        }
    }
}
