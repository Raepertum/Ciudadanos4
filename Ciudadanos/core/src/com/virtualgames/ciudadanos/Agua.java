package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Agua extends Objetodejuego {

	private TextureRegion textura = null;
	
	//Tipos de agua
	
	int tipodeagua;
	private TextureRegion poza;
	
	
	public int fila;
	public int columna;
	public float dimensionX = 0.20f;
	public float dimensionY = 0.20f;
	public int posicionX=-(4/3);
	public int posicionY=0;
	
	
	public Agua(){
		
		poza = Texturasysonidos.texturasysonidos.agua.poza;
		
		
	}
	
	
	public void establecertipodeagua(int tipodeagua){
		
		this.tipodeagua = tipodeagua;
		if(tipodeagua==0){
			//Poza
			textura=poza;
		}
	};
	
	public int recuperartipodeagua(){
		return tipodeagua;
	}
	
	
	public void asignarfila(int fila){
		this.fila=fila;
	}
	public void asignarcolumna(int columna){
		this.columna=columna;
	}
	public int recuperarfila(){
		return this.fila;
	}
	public int recuperarcolumna(){
		return this.columna;
	}
	
	
	
	public void render(SpriteBatch batch) {
		batch.draw(textura.getTexture(),posicionX, posicionY,origenX,origenY,dimensionX,dimensionY,
				escalaX, escalaY,rotacion,textura.getRegionX(),textura.getRegionY(),
				textura.getRegionWidth(),textura.getRegionHeight(),false,false);
	}

}
