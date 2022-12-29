package com.project.clicker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.event.InputEvent;

public class StartPage  implements Screen {
    private Stage stage;
    private Skin skin;
    private TextButton buttonstart;
    private TextButton buttonexit;
    private TextButton buttoncontinue;
    private Label name;
    private Table table1;
    private Table table2;
    private com.badlogic.gdx.Game myg;

    public StartPage(final com.badlogic.gdx.Game g) {
        myg=g;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table1 = new Table();
        table2 = new Table();
        table1.setSize(stage.getWidth(), stage.getHeight() / 2);
        table2.setSize(stage.getWidth(), stage.getHeight() / 2);
        skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        name = new Label("Game", skin);
        buttonstart = new TextButton("Start", skin);
        buttonexit = new TextButton("Exit", skin);
        buttoncontinue=new TextButton("Continue",skin);
        buttonstart.addListener(new InputListener() {
            public void touchUp(InputEvent e, float x, float y) {
                myg.setScreen(new Game(myg));
            }
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
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


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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



