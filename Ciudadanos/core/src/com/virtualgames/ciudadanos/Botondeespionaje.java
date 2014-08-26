package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Botondeespionaje extends Actor {

private float posicionx = 750;
private float posiciony = 550;
private Stage stage;		
		
		private TextureRegion texturabotonespionaje;
		
		
		public Botondeespionaje(Stage stage){
			this.stage = stage;
			init();
		};
		private void init(){
			texturabotonespionaje = Texturasysonidos.texturasysonidos.botones.botonespionaje;
			this.setBounds(750, 550, 25, 25);
			
			this.addListener(new InputListener(){
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int actor){
					abrirmenuespionaje();
					texturabotonespionaje = Texturasysonidos.texturasysonidos.botones.botonespionajepulsado;
					return true;
				};
				public void enter(InputEvent event, float x, float y, int pointer, Actor actor){
					texturabotonespionaje = Texturasysonidos.texturasysonidos.botones.botonespionajesobre;
				};
				public void touchUp(InputEvent event, float x, float y, int pointer, int button){
					texturabotonespionaje = Texturasysonidos.texturasysonidos.botones.botonespionaje;
				}
			 	public void exit(InputEvent event, float x, float y, int pointer, Actor actor){
			 		texturabotonespionaje = Texturasysonidos.texturasysonidos.botones.botonespionaje; 
			 	};
			});
		};
		
		
        private void abrirmenuespionaje() {
			
			if (Eventosymenu.eventosymenu.menuvisible!=Eventosymenu.eventosymenu.menuespionaje){		
				//Deja de verse el menú que hubiera
				//Si no es nulo
				if(Eventosymenu.eventosymenu.menuvisible!=null){
				Eventosymenu.eventosymenu.menuvisible.remove();
				}
				//Se establece que el menú sea el del almacén
				Eventosymenu.eventosymenu.SetMenu(Eventosymenu.eventosymenu.menuespionaje);
				//Se añade a la stage para que sea visible
				stage.addActor(Eventosymenu.eventosymenu.menuvisible);
				}
			    //Si el menú almacén está abierto
				else if (Eventosymenu.eventosymenu.menuvisible==Eventosymenu.eventosymenu.menuespionaje){
				//Lo quitamos
				Eventosymenu.eventosymenu.menuvisible.remove();
				//Establecemos que el menú sea nulo
				Eventosymenu.eventosymenu.SetMenu(null);
				}
		};
		
		public void draw(Batch batch, float alpha){
	        batch.draw(texturabotonespionaje,posicionx,posiciony);
	}
	};

