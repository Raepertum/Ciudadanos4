package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Botondealmacen extends Actor{

	private float posicionx = 750;
	private float posiciony = 575;
	private Stage stage;
	
	private TextureRegion texturabotondealmacen;
	
	public Botondealmacen(Stage stage){
		this.stage = stage;
		stage.addActor(this);
		init();
	};
	private void init(){
				
		texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacen;
		this.setBounds(750, 575, 25, 25);
		
		this.addListener(new InputListener(){
			
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int actor){
				texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacenpulsado;
				abrirmenualmacen();
				return true;
			};
			public void enter(InputEvent event, float x, float y, int pointer, Actor actor){
				texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacensobre;
			};
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacen;
			}
		 	public void exit(InputEvent event, float x, float y, int pointer, Actor actor){
		 		texturabotondealmacen = Texturasysonidos.texturasysonidos.botones.botonalmacen; 
		 	};
		});
	};
	
	private void abrirmenualmacen() {
		
		if (Eventosymenu.eventosymenu.menuvisible!=Eventosymenu.eventosymenu.menualmacen){		
			//Deja de verse el menú que hubiera
			//Si no es nulo
			if(Eventosymenu.eventosymenu.menuvisible!=null){
			Eventosymenu.eventosymenu.menuvisible.remove();
			}
			//Se establece que el menú sea el del almacén
			Eventosymenu.eventosymenu.SetMenu(Eventosymenu.eventosymenu.menualmacen);
			//Se añade a la stage para que sea visible
			stage.addActor(Eventosymenu.eventosymenu.menuvisible);
			}
		    //Si el menú almacén está abierto
			else if (Eventosymenu.eventosymenu.menuvisible==Eventosymenu.eventosymenu.menualmacen){
			//Lo quitamos
			Eventosymenu.eventosymenu.menuvisible.remove();
			//Establecemos que el menú sea nulo
			Eventosymenu.eventosymenu.SetMenu(null);
			}
	};

	
	public void draw(Batch batch, float alpha){
        batch.draw(texturabotondealmacen,posicionx,posiciony);
}
	public void act(float deltatime){
	}
};


