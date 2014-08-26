package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Camara extends OrthographicCamera {


	double aceleracion = 0.02;
	double velocidadmaxima = 0.06;
	double velocidadX = 0;
	double velocidadY = 0;
	double rozamiento=0.005;
	double zoomcamara = 0.05f;
	
	public Camara(float anchodelvisor, float altodelvisor){
		super(anchodelvisor,altodelvisor);
	}
	public void mandaralorigen(){
		this.position.set(0,0,0);
	};	
	public void acercarzoom(){
		if(this.zoom+zoomcamara<1.40f){
		this.zoom+=zoomcamara;
		this.update();
		}
	};
	public void alejarzoom(){
		if(this.zoom-zoomcamara>0.10f){
		this.zoom-=zoomcamara;
		this.update();
		}
	};
	
	
	public void moverCamaraXnegativo(){
		
		if(velocidadX<=velocidadmaxima){
			velocidadX+=aceleracion;
		}
		else{
			velocidadX=velocidadmaxima;
		}
		if(!(this.position.x>=Constantes.LOMASALAIZQUIERDAQUEPUEDEIRLACAMARA)){
		this.position.x+=velocidadX;
		this.update();
		}
	};
	public void moverCamaraXpositivo(){
		
		if(velocidadX>=-velocidadmaxima){
			velocidadX-=aceleracion;
		}
		else{
			velocidadX=-velocidadmaxima;
		}
		if(!(this.position.x<=Constantes.LOMASALADERECHAQUEPUEDEIRLACAMARA)){
		this.position.x+=velocidadX;
		this.update();
		}
	};
	public void moverCamaraYnegativo(){
		if(velocidadY>=velocidadmaxima){
			velocidadY-=aceleracion;
		}
		else{
			velocidadY=velocidadmaxima;
		}
		if(!(this.position.y>=Constantes.LOMASBAJOQUEPUEDEIRLACAMARA)){
		this.position.y+=velocidadY;
		this.update();
		}
	};
	public void moverCamaraYpositivo(){
		if(velocidadY<=-velocidadmaxima){
			velocidadY+=aceleracion;
		}
		else{
			velocidadY=-velocidadmaxima;
		}
		if(!(this.position.y<=Constantes.LOMASALTOQUEPUEDEIRLACAMARA)){
		this.position.y+=velocidadY;
		this.update();
		}
	};
	
	
	public void desacelerarCamara(){
		if(velocidadX>0){
			velocidadX-=rozamiento;
		}
		if(velocidadX<0){
			velocidadX+=rozamiento;
		}
		if(velocidadY>0){
			velocidadY-=rozamiento;
		}
		if(velocidadY<0){
			velocidadY+=rozamiento;
		}
		this.update();
	}
	
	
	public void update(){
		super.update();
	}
}
