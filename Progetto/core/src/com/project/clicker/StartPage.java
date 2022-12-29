package com.project.clicker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.event.InputEvent;

public class StartPage extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    private TextButton buttonstart;
    private TextButton buttonexit;
    private TextField name;
    private Table table1;
    private Table table2;

    public void create(){
    stage=new Stage(new ScreenViewport());
    Gdx.input.setInputProcessor(stage);
    table1=new Table();
    table2=new Table();
    table1.setSize(stage.getWidth(),stage.getHeight()/2);
    table2.setSize(stage.getWidth(),stage.getHeight()/2);
    skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
    name=new TextField("Game",skin);
    buttonstart=new TextButton("Start",skin);
    buttonexit=new TextButton("Exit",skin);
    buttonstart.addListener(new ClickListener(){
        public void clicked(InputEvent e,float x,float y){
            ((com.badlogic.gdx.Game)Gdx.app.getApplicationListener()).setScreen(new Game());
        }
    });
    table1.add(name);
    table2.add(buttonstart);
    table2.add(buttonexit);
    table1.padTop(50);
    table1.align(Align.top);
    table2.padBottom(50);
    table2.align(Align.bottom);
    stage.addActor(table1);
    stage.addActor(table2);

    }

    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    public void dispose(){
        stage.dispose();
    }
    }
}
