package com.project.clicker;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Nemico extends Actor {
    private int danno;
    private int hp;
    private TextureRegion reg;
    public Nemico(int damage,int life,TextureRegion regi){
        super();
        this.danno = damage;
        this.hp = life;
        this.reg = regi;
    }



}
