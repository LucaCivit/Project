package com.project.clicker;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Game extends ApplicationAdapter {

	private Stage stage;
	private Skin skin;
	private Table table1;
	private Table table2;
	private Table table3;
	private Sprite sprite;
	private SpriteBatch batch;
	LinkedList<Personaggio> buttons1 = new LinkedList<Personaggio>();
    LinkedList<Personaggio> buttons2=new LinkedList<Personaggio>();
    private Label l;
	Guadagno g=new Guadagno();
	int count=0;
	Personaggio p;
	private int conta=0;

	public void create() {
		stage = new Stage(new ScreenViewport());
		table1=new Table();
		table2=new Table();
		table1.setWidth(stage.getWidth());
		table1.setHeight(stage.getHeight());
		table2.setWidth((stage.getWidth()));
		table2.setHeight(stage.getHeight());
		table3=new Table();
		table3.setWidth(stage.getWidth());
		table3.setHeight(stage.getHeight());
		skin = new Skin(Gdx.files.internal("skin/freezing-ui.json"));
		l=new Label(g.toString(),skin);
		final Fante Fanteb = new Fante("Fante c:0", skin,l);
		buttons1.add(Fanteb);
		final Spadaccino Spadaccinob = new Spadaccino("Spadaccino c:5", skin,l);
		buttons1.add(Spadaccinob);
		final Cavaliere Cavaliereb = new Cavaliere("Cavaliere c:10", skin,l);
		buttons1.add(Cavaliereb);
		final Arciere Arciereb = new Arciere("Arciere c:20", skin,l);
		buttons1.add(Arciereb);
		final Mago Magob = new Mago("Mago c:50", skin,l);
		buttons1.add(Magob);
		final Catapulta Catapultab = new Catapulta("Catapulta c:120", skin,l);
		buttons2.add(Catapultab);
		final Cannone Cannoneb = new Cannone("Cannone c:200", skin,l);
		buttons2.add(Cannoneb);
		final Incendiaria Incendiariab = new Incendiaria("Incendiaria c:500", skin,l);
		buttons2.add(Incendiariab);
		final Gigante Giganteb = new Gigante("Gigante c:1000", skin,l);
		buttons2.add(Giganteb);
		final Drago Dragob = new Drago("Drago c:5000", skin,l);
		buttons2.add(Dragob);
        table1.align(Align.left);
        table1.padLeft(50);
		for (final Personaggio a : buttons1) {
			a.setTransform(true);
			a.setScale(0.7f);
			table1.add(a).padBottom(5);
            table1.row();
            if(a!=Fanteb){
            	a.setDisabled(true);
			}
		}
		table2.align(Align.right);
		table2.padRight(5);
		for (Personaggio a : buttons2) {
			a.setTransform(true);
			a.setScale(0.7f);
			table2.add(a).padBottom(5);
			table2.row();
			a.setDisabled(true);
		}
		table1.padTop(150);
		table2.padTop(150);
		table1.padBottom(40);
		table2.padBottom(40);
        table3.align(Align.top);
        //oppure rendo la label un attore e ci attacco un listener:quando la label cambia fa
		//il controllo sui bottoni e li abilita
        while(count<10){
        	for(Personaggio a:buttons1){
        		if (a.getCosto()<=Integer.getInteger(String.valueOf(l.getText()))){
        			a.setDisabled(false);
        			count++;
				}
			}
			for(Personaggio a:buttons2){
				if (a.getCosto()<=Integer.getInteger(String.valueOf(l.getText()))){
					a.setDisabled(false);
					count++;
				}
			}
		}
        stage.addActor(table1);
        stage.addActor(table2);
        stage.addActor(l);
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("gotimage.jpg")));
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());



		Gdx.input.setInputProcessor(stage);
	}

	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		stage.draw();
	}

		public void dispose(){
			stage.dispose();
		}

}