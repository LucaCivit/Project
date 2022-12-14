package com.project.clicker;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
	private Sprite sprite;
	private SpriteBatch batch;
	LinkedList<TextButton> buttons1 = new LinkedList<TextButton>();
    LinkedList<TextButton> buttons2=new LinkedList<TextButton>();
	public void create() {
		stage = new Stage(new ScreenViewport());
		table1=new Table();
		table2=new Table();
		table1.setWidth(stage.getWidth());
		table1.setHeight(stage.getHeight());
		table2.setWidth((stage.getWidth()));
		table2.setHeight(stage.getHeight());
		skin = new Skin(Gdx.files.internal("skin/freezing-ui.json"));
		final TextButton Fanteb = new TextButton("Fante", skin);
		buttons1.add(Fanteb);
		final TextButton Spadaccinob = new TextButton("Spadaccino", skin);
		buttons1.add(Spadaccinob);
		final TextButton Cavaliereb = new TextButton("Cavaliere", skin);
		buttons1.add(Cavaliereb);
		final TextButton Arciereb = new TextButton("Arciere", skin);
		buttons1.add(Arciereb);
		final TextButton Magob = new TextButton("Mago", skin);
		buttons1.add(Magob);
		final TextButton Catapultab = new TextButton("Catapulta", skin);
		buttons2.add(Catapultab);
		final TextButton Cannoneb = new TextButton("Cannone", skin);
		buttons2.add(Cannoneb);
		final TextButton Incendiariab = new TextButton("Incendiaria", skin);
		buttons2.add(Incendiariab);
		final TextButton Giganteb = new TextButton("Gigante", skin);
		buttons2.add(Giganteb);
		final TextButton Dragob = new TextButton("Drago", skin);
		buttons2.add(Dragob);
        table1.align(Align.left);
        table1.padLeft(50);
		for (TextButton a : buttons1) {
			a.setTransform(true);
			a.setScale(0.7f);
			table1.add(a).padBottom(5);
            table1.row();
		}
		table2.align(Align.right);
		table2.padRight(5);
		for (TextButton a : buttons2) {
			a.setTransform(true);
			a.setScale(0.7f);
			table2.add(a).padBottom(5);
			table2.row();
		}
		table1.padTop(150);
		table2.padTop(150);
		table1.padBottom(40);
		table2.padBottom(40);

        stage.addActor(table1);
        stage.addActor(table2);
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