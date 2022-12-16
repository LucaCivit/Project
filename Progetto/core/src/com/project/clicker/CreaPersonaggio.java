package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class CreaPersonaggio {
    Personaggio p;

    public CreaPersonaggio() {
        this.p = null;
    }

    public Personaggio create(TextButton b){
        switch(b.getName()){
            case("Fanteb"): p=new Fante();
                break;
            case("Spadaccinob"): p=new Spadaccino();
                break;
            case("Cavaliereb"): p=new Cavaliere();
                break;
            case("Arciereb"): p=new Arciere();
                break;
            case("Magob"): p=new Mago();
                break;
            case("Catapultab"): p=new Catapulta();
                break;
            case("Cannoneb"): p=new Cannone();
                break;
            case("Incendiariab"): p=new Incendiaria();
                break;
            case("Giganteb"): p=new Gigante();
                break;
            case("Dragob"): p=new Drago();
                break;
        }
        return p;

    }
}
