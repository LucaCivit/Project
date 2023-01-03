package com.project.clicker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class StartPage  implements Screen {
    private Stage stage;
    private Skin skin;
    private SpriteBatch batch;
    private Sprite sprite;
    private TextButton buttonstart;
    private TextButton buttonexit;
    private TextButton buttoncontinue;
    private TextButton ok;
    private Label name;
    private Table table1;
    private Table table2;
    private Dialog dlgcontinue;
    private com.badlogic.gdx.Game myg;
    Database db = new Database();


    public StartPage(final com.badlogic.gdx.Game g) {

        myg = g;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table1 = new Table();
        table2 = new Table();
        table1.setSize(stage.getWidth(), stage.getHeight());
        table2.setSize(stage.getWidth(), stage.getHeight());
        db.start();
        try {
            db.test();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        name = new Label("Game", skin);
        buttonstart = new TextButton("Nuovo", skin);
        buttoncontinue = new TextButton("Continua",skin);
        buttonexit = new TextButton("Esci",skin);
        ok = new TextButton("ok",skin);
        dlgcontinue=new Dialog("",skin);
        final int attacco = CalcolaGuadagno(db);
        dlgcontinue.text("Sei stato via per " + CalcolaTempo(db) + "\n e hai guadagnato "+String.valueOf(attacco)+" atk");
        dlgcontinue.button(ok);
        buttoncontinue.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                dlgcontinue.show(stage);
            }
        });
        ok.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                myg.setScreen(new Game(myg,db,(db.getScore()+attacco)));
            }
        });
        buttonexit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        table1.add(name);
        table2.add(buttonstart).padRight(40).padLeft(350);
        table2.add(buttoncontinue).padRight(200);
        table2.add(buttonexit);
        table1.padTop(20);
        table1.align(Align.top);
        table2.padBottom(50);
        table2.align(Align.bottom);
        stage.addActor(table1);
        stage.addActor(table2);
        batch = new SpriteBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("start.jpg")));
        sprite.setSize(stage.getWidth(), stage.getHeight());

    }

    public String CalcolaTempo(Database db){
        String optime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String cltime = db.getTime();
        Date date1 = new Date();
        Date date2 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        try {
            date1 = formatter.parse(optime);
            date2 = formatter.parse(cltime);
        } catch (ParseException p){
            p.printStackTrace();
        }
        long millis = date1.getTime() - date2.getTime();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));
        long hours = TimeUnit.MILLISECONDS.toHours(millis);

        StringBuilder b = new StringBuilder();
        b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) :
                String.valueOf(hours));
        b.append(":");
        b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) :
                String.valueOf(minutes));
        b.append(":");
        b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) :
                String.valueOf(seconds));
        return b.toString();

    }
    public int CalcolaGuadagno(Database db) {
        String optime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String cltime = db.getTime();
        Date date1 = new Date();
        Date date2 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        try {
            date1 = formatter.parse(optime);
            date2 = formatter.parse(cltime);
        } catch (ParseException p) {
            p.printStackTrace();
        }
        long millis = date1.getTime() - date2.getTime();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long guadagno = (hours*100) + (minutes*20) +(seconds*1);
        return (int) guadagno;
    }



    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        batch.end();
        if(buttonstart.isPressed()){
            myg.setScreen(new Game(myg,db,0));
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



