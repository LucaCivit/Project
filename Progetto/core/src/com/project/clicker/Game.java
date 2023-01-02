package com.project.clicker;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;


public class Game implements Screen {
    private com.badlogic.gdx.Game g;
	private Stage stage;
	private Skin skin;
	private Table table1;
	private Table table2;
	private Table table3;
	private Table table4;
	private Table table5;
	private Sprite sprite;
	private SpriteBatch batch;
    private Label l1;
	private Label l2;
    private LinkedList<MyButton> buttons=new LinkedList<MyButton>();

	public Game(com.badlogic.gdx.Game game, final Database dat,int score) {
		this.g = game;
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		table1 = new Table();
		table2 = new Table();
		table3 = new Table();
		table4 = new Table();
		table5=new Table();
		table1.setSize(stage.getWidth(),stage.getHeight());
		table2.setSize(stage.getWidth(),stage.getHeight());
		table3.setSize(stage.getWidth(), stage.getHeight());
		table4.setSize(stage.getWidth(), stage.getHeight());
		table5.setSize(stage.getWidth(),stage.getHeight());
		table5.add(table1,table2);
		table5.padTop(50);
		table1.padTop(50);
		table2.padTop(50);
		table5.padBottom(150);
		table1.align(Align.left);
		table1.padLeft(50);
		table2.align(Align.right);
		table2.padRight(50);
		table3.align(Align.top);
		table4.align(Align.bottom);
		table5.align((Align.center));
		stage.addActor(table1);
		stage.addActor(table2);
		stage.addActor(table3);
		stage.addActor(table4);

		skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
		l1 = new Label("Attacco: ",skin);
		l2 = new Label(Integer.toString(score),skin);
		table3.add(l1);
		table3.add(l2);
		MyButton Fante = new MyButton("Fante \n A:1",skin,"Fante");
		table1.add(Fante).width(200).height(100);
		table1.row();
		buttons.add(Fante);
		Fante.setAttacco(1);

		MyButton Spadaccino = new MyButton("Spadaccino \n C:10 A:5 ",skin,"Spadaccino");
		table2.add(Spadaccino).width(200).height(100);
		table2.row();
		buttons.add(Spadaccino);
		Spadaccino.setAttacco(10);
		Spadaccino.setCosto(5);


		MyButton Cavaliere = new MyButton("Cavaliere \n C:50 A:20 ",skin,"Cavaliere");
		table1.add(Cavaliere).width(200).height(100);
		table1.row();
		buttons.add(Cavaliere);
		Cavaliere.setCosto(50);
		Cavaliere.setAttacco(20);

		MyButton Arciere = new MyButton("Arciere \n C:150 A:50 ",skin,"Arciere");
		table2.add(Arciere).width(200).height(100);
		table2.row();
		buttons.add(Arciere);
		Arciere.setCosto(150);
		Arciere.setAttacco(50);

		MyButton Catapulta = new MyButton("Catapulta \n C:500 A:100 ",skin,"Catapulta");
		table1.add(Catapulta).width(200).height(100);
		table1.row();
		buttons.add(Catapulta);
		Catapulta.setCosto(500);
		Catapulta.setAttacco(100);


		MyButton Cannone = new MyButton("Cannone \n C:1000 A:250 ",skin,"Cannone");
		table2.add(Cannone).width(200).height(100);
		table2.row();
		buttons.add(Cannone);
		Cannone.setCosto(1000);
		Cannone.setAttacco(250);

		MyButton Mago = new MyButton("Mago \n C:5000 A:500 ",skin,"Mago");
		table1.add(Mago).width(200).height(100);
		table1.row();
		buttons.add(Mago);
		Mago.setCosto(5000);
		Mago.setAttacco(500);

		MyButton Incendiaria = new MyButton("Incendiaria \n C:20000 A:700 ",skin,"Incendiaria");
		table2.add(Incendiaria).width(200).height(100);
		table2.row();
		buttons.add(Incendiaria);
		Incendiaria.setCosto(20000);
		Incendiaria.setAttacco(700);

		MyButton Gigante = new MyButton("Gigante \n C:50000 A:1000 ",skin,"Gigante");
		table1.add(Gigante).width(200).height(100);
		buttons.add(Gigante);
		Gigante.setCosto(50000);
		Gigante.setAttacco(1000);

		MyButton Drago = new MyButton("Drago \n C:1000000 A:2000 ",skin,"Drago");
		table2.add(Drago).width(200).height(100);
		buttons.add(Drago);
		Drago.setCosto(1000000);
		Drago.setAttacco(2000);

		for(MyButton a:buttons){
			if(a!=Fante){
			a.setDisabled(true);
			}
			a.addListener(new MyClickListener(l2,a.getCosto(),a.getAttacco(),a));
		}

		TextButton Save = new TextButton("Salva",skin);
		TextButton Upgrade = new TextButton("Upgrade",skin);
		table4.add(Save);
		table4.add(Upgrade);
		Save.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dat.save(Integer.valueOf(String.valueOf(l2.getText())));
			}
		});
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("sfondo.jpg")));
		sprite.setSize(stage.getWidth(), stage.getHeight());
	}


	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
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


	public void dispose(){

		stage.dispose();
		}

}