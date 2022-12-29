package com.project.clicker;

import com.badlogic.gdx.Game;

public class MyApp extends Game {
    @Override
    public void create() {
        this.setScreen(new StartPage(this));
    }
    public void render(){
        super.render();
    }
    public void dispose(){

    }
}
