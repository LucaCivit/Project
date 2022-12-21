package com.project.clicker;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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

public class Game extends ApplicationAdapter {

	private Stage stage;
	private Skin skin;
	private Table table1;
	private Table table2;
	private Table table3;
	private Table table4;
	private Sprite sprite;
	private SpriteBatch batch;
    private Label l1;
	private Label l2;
	Viewport viewport = new ScreenViewport();


	public void create() {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		table1 = new Table();
		table2 = new Table();
		table3 = new Table();
		table4 = new Table();
		table1.setSize(stage.getWidth(),stage.getHeight());
		table2.setSize(stage.getWidth(),stage.getHeight());
		table3.setSize(stage.getWidth(),stage.getHeight());
		table4.setSize(stage.getWidth(),stage.getHeight());
		table1.padTop(150);
		table2.padTop(150);
		table1.padBottom(40);
		table2.padBottom(40);
		table1.align(Align.left);
		table1.padLeft(50);
		table2.align(Align.right);
		table2.padRight(50);
		table3.align(Align.top);
		table4.align(Align.bottom);
		stage.addActor(table1);
		stage.addActor(table2);
		stage.addActor(table3);
		stage.addActor(table4);
		skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
		l1 = new Label("Attacco: ",skin);
		l2 = new Label("100",skin);
		table3.add(l1);
		table3.add(l2);
		MyButton Fante = new MyButton("Fante \n A:1",skin,"Fante");
		table1.add(Fante);
		Fante.setAttacco(1);
		Fante.addListener(new MyClickListener(l2,Fante.getCosto(),Fante.getAttacco(),Fante));

		MyButton Arciere = new MyButton("Arciere \n C:100 A:10 ",skin,"Arciere");
		table2.add(Arciere);
		Arciere.setAttacco(10);
		Arciere.setCosto(100);
		Arciere.setDisabled(true);
		Arciere.addListener(new MyClickListener(l2,Arciere.getCosto(),Arciere.getAttacco(),Arciere));

		MyButton Cannone = new MyButton("Cannone \n C:1000 A:500 ",skin,"Cannone");
		table2.add(Cannone);
		Cannone.setCosto(1000);
		Cannone.setAttacco(500);
		Cannone.setDisabled(true);
		Cannone.addListener(new MyClickListener(l2,Cannone.getCosto(),Cannone.getAttacco(),Cannone));


		TextButton Save = new TextButton("Salva",skin);
		TextButton Upgrade = new TextButton("Upgrade",skin);
		table4.add(Save);
		table4.add(Upgrade);
		Upgrade.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y) {
				stage.setViewport(viewport);
			}
		});
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("gotimage.jpg")));
		sprite.setSize(stage.getWidth(), stage.getHeight());
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