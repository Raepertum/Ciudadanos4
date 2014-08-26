package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Botondeeventos extends Actor {
	
	
	private float posicionx = 725;
	private float posiciony = 575;
	
	
	private TextureRegion texturabotondeeventos;
	
	
	public Botondeeventos(Stage stage){
		init();
	};
	private void init(){
		texturabotondeeventos = Texturasysonidos.texturasysonidos.botones.botoneventos;
		this.setBounds(725, 575, 25, 25);
		
		this.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int actor){
				texturabotondeeventos = Texturasysonidos.texturasysonidos.botones.botoneventospulsado;
				return true;
			};
			public void enter(InputEvent event, float x, float y, int pointer, Actor actor){
			     texturabotondeeventos = Texturasysonidos.texturasysonidos.botones.botoneventossobre;
			};
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
			     texturabotondeeventos = Texturasysonidos.texturasysonidos.botones.botoneventos;
			}
		 	public void exit(InputEvent event, float x, float y, int pointer, Actor actor){
			     texturabotondeeventos = Texturasysonidos.texturasysonidos.botones.botoneventos; 
		 	};
		});
	};
	
	public void draw(Batch batch, float alpha){
		
		 batch.draw(texturabotondeeventos,posicionx,posiciony);
}
};
