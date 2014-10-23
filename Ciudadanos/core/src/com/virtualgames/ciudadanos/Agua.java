package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Agua extends Objetodejuego {

	private TextureRegion textura = null;
	
	//Tipos de agua
	
	int tipodeagua;
	private TextureRegion poza;
	private TextureRegion nopoza;
	private TextureRegion cruceacuatro;
	
	
	public int fila;
	public int columna;
	public float dimensionX = 0.20f;
	public float dimensionY = 0.20f;
	public float posicionX=0f;
	public float posicionY=0f;
	
	
	public Agua(){
		
		poza = Texturasysonidos.texturasysonidos.agua.poza;
		cruceacuatro = Texturasysonidos.texturasysonidos.agua.cruceacuatro;
		
		//Provisional
		nopoza = Texturasysonidos.texturasysonidos.agua.nopoza;
		
		
		
	}
	
	
	public void establecertipodeagua(int tipodeagua){
		
		this.tipodeagua = tipodeagua;
		if(tipodeagua==0){
			//Poza
			textura=poza;
		}
		else if(tipodeagua==1){
			//Provisional: No poza
			textura=nopoza;
		}
		else if(tipodeagua==2){
			//Cruce a cuatro
			textura=cruceacuatro;
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
