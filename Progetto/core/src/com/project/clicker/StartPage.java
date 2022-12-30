package com.project.clicker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class StartPage  implements Screen {
    private Stage stage;
    private Skin skin;
    private TextButton buttonstart;
    private TextButton buttonexit;
    private TextButton buttoncontinue;
    private TextButton ok;
    private Label name;
    private Table table1;
    private Table table2;
    private Dialog dlgcontinue;
    private com.badlogic.gdx.Game myg;

    public StartPage(final com.badlogic.gdx.Game g) {
        myg=g;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table1 = new Table();
        table2 = new Table();
        table1.setSize(stage.getWidth(), stage.getHeight());
        table2.setSize(stage.getWidth(), stage.getHeight());
        skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        name = new Label("Game", skin);
        buttonstart = new TextButton("Start", skin);
        buttonexit = new TextButton("Exit", skin);
        buttoncontinue=new TextButton("Continue",skin);
        ok=new TextButton("ok",skin);

        dlgcontinue=new Dialog("",skin);
        dlgcontinue.text("You gained tot points");
        dlgcontinue.button(ok);
        buttoncontinue.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                dlgcontinue.show(stage);
            }
        });

        buttonexit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                dispose();
            }
        });
        table1.add(name);
        table2.add(buttonstart);
        table2.add(buttonexit);
        table2.add(buttoncontinue);
        table1.padTop(20);
        table1.align(Align.top);
        table2.padBottom(50);
        table2.align(Align.bottom);
        stage.addActor(table1);
        stage.addActor(table2);

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(buttonstart.isPressed()){
            myg.setScreen(new Game(myg));
        }
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    stage.dispose();
    }
}



