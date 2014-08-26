package com.virtualgames.ciudadanos;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class Ciudadanos3 extends ApplicationAdapter {
	private Logica logica;
	private Renderizador renderizador;
	private boolean pausa;
	public Variablesdejuego variablesdejuego;
			
	
	@Override
	public void create() {
		//Modo debug (Para ver cómo funciona)
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		//Cargar las texturas y los sonidos
		Texturasysonidos.texturasysonidos.init(new AssetManager());
		//Cargar las variables
		Variablesdejuego.variablesdejuego.iniciar();
		//Instanciar la lógica y el renderizador
		logica = new Logica();
		renderizador = new Renderizador(logica);
		pausa = false;
	}
	
	

	@Override
	public void dispose() {
		renderizador.dispose();	
		Texturasysonidos.texturasysonidos.dispose();
		
	}

	@Override
	public void render() {
		
		if(!pausa){
		logica.actualizaralframerate(Gdx.graphics.getDeltaTime());
		};
		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderizador.render();
		
	}

	@Override
	public void resize(int width, int height) {
		
		renderizador.resize(width, height);
		
	}

	@Override
	public void pause() {
		pausa=true;
	}

	@Override
	public void resume() {
		Texturasysonidos.texturasysonidos.init(new AssetManager());
		pausa=false;
	}
}
