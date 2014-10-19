package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Objetodejuego {
	public float posicionX;
	public float posicionY;
	public float dimensionX;
	public float dimensionY;
	public int origenX;
	public int origenY;
	public int escalaX;
	public int escalaY;
	public float rotacion;
	
	public Objetodejuego(){
		dimensionX=1;
		dimensionY=1;
		escalaX=1;
		escalaY=1;
		rotacion=0;
		
	}
	
	public void actualizar(float deltatime){};
	
	public abstract void render (SpriteBatch batch);

}
