package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Botondecomercio extends Actor{

		private float posicionx = 775;
		private float posiciony = 575;
		private Stage stage;
		
		private TextureRegion texturabotondecomercio;
		
		public Botondecomercio(Stage stage){
			this.stage = stage;
			init();
		};
		private void init(){
			texturabotondecomercio = Texturasysonidos.texturasysonidos.botones.botoncomercio;
			this.setBounds(775, 575, 25, 25);
			
			this.addListener(new InputListener(){
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int actor){
					texturabotondecomercio = Texturasysonidos.texturasysonidos.botones.botoncomerciopulsado;
					abrirmenucomercio();
					return true;
				};
				public void enter(InputEvent event, float x, float y, int pointer, Actor actor){
					texturabotondecomercio = Texturasysonidos.texturasysonidos.botones.botoncomerciosobre;
				};
				public void touchUp(InputEvent event, float x, float y, int pointer, int button){
					texturabotondecomercio = Texturasysonidos.texturasysonidos.botones.botoncomercio;
				}
			 	public void exit(InputEvent event, float x, float y, int pointer, Actor actor){
			 		texturabotondecomercio = Texturasysonidos.texturasysonidos.botones.botoncomercio; 
			 	};
			});
		};
		
		private void abrirmenucomercio() {
			
			if (Eventosymenu.eventosymenu.menuvisible!=Eventosymenu.eventosymenu.menucomercio){		
				//Deja de verse el menú que hubiera
				//Si no es nulo
				if(Eventosymenu.eventosymenu.menuvisible!=null){
				Eventosymenu.eventosymenu.menuvisible.remove();
				}
				//Se establece que el menú sea el del almacén
				Eventosymenu.eventosymenu.SetMenu(Eventosymenu.eventosymenu.menucomercio);
				//Se añade a la stage para que sea visible
				stage.addActor(Eventosymenu.eventosymenu.menuvisible);
				}
			    //Si el menú almacén está abierto
				else if (Eventosymenu.eventosymenu.menuvisible==Eventosymenu.eventosymenu.menucomercio){
				//Lo quitamos
				Eventosymenu.eventosymenu.menuvisible.remove();
				//Establecemos que el menú sea nulo
				Eventosymenu.eventosymenu.SetMenu(null);
				}
		};
		
		public void draw(Batch batch, float alpha){
	        batch.draw(texturabotondecomercio,posicionx,posiciony);
	}
	};