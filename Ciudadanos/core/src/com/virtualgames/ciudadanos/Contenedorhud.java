package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Contenedorhud {
	
	Stage contenedordeactores;
	Botondeeventos botondeeventos;
	Botonsocial botonsocial;
	Botondealmacen botondealmacen;
	Botondecomercio botondecomercio;
	Botondeespionaje botondeespionaje;
	Botondeejercito botondeejercito;
	int segundos;
	int minutos;
	int horas;
	
	Label reloj;
	
	public Contenedorhud(){
		init();
	};
	private void init(){
		
		contenedordeactores = new Stage();
		
		reloj = new Label(""+horas+":"+minutos+":"+segundos,Texturasysonidos.texturasysonidos.estilosyactores.estilolabeldefault);
		reloj.setY(0);
		contenedordeactores.addActor(reloj);
		
		botondeeventos = new Botondeeventos(contenedordeactores);
		botonsocial = new Botonsocial(contenedordeactores);
		botondealmacen = new Botondealmacen(contenedordeactores);		
		botondecomercio = new Botondecomercio(contenedordeactores);
		botondeespionaje = new Botondeespionaje(contenedordeactores);
		botondeejercito = new Botondeejercito(contenedordeactores);
		contenedordeactores.addActor(botondeeventos);
		contenedordeactores.addActor(botonsocial);
		contenedordeactores.addActor(botondealmacen);
		contenedordeactores.addActor(botondecomercio);
		contenedordeactores.addActor(botondeespionaje);
		contenedordeactores.addActor(botondeejercito);
		
		
		
	};
	public void actualizartiempo(int segundos,int tiempotranscurridoenminutos,int tiempotranscurridoenhoras){
	this.segundos = segundos-60*tiempotranscurridoenminutos;
	this.minutos = tiempotranscurridoenminutos-60*tiempotranscurridoenhoras;
	this.horas = tiempotranscurridoenhoras;
	}
	
	
	public void render(SpriteBatch batch){
		contenedordeactores.draw();
	};
	public void act(float deltatime){
		reloj.setText(""+horas+":"+minutos+":"+segundos);
	}
}
