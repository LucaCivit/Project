package com.project.clicker;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Nemico extends Actor {
    private int danno;
   // private int life;
    private Texture reg;
    public Nemico(Texture regi){
        super();
        this.danno = 0;
        //this.life=life;
        this.reg = regi;
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

   /* public int getLife() {
        return life;
    }

    */
}
