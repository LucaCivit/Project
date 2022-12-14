package com.project.clicker;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Nemico extends Actor {
    private int danno;
    private int life;
    private Texture reg;
    public Nemico(Texture t,int vita,int dann){
        super();
        this.danno = dann;
        this.life = vita;
        this.reg = t;

    }

    public void danneggia(int danno) {
        this.danno += danno;
    }

    public void rinforza(int forza){
        this.danno-=forza;
    }

    public int getDanno() {
        return danno;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int vi){
        this.life = vi;
    }

    public Texture getTexture(){ return reg;}

    public void setTexture(Texture te){
        this.reg = te;
    }


}
