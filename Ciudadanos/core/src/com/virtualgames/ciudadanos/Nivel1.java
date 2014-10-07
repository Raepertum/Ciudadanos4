package com.virtualgames.ciudadanos;

import com.badlogic.gdx.utils.Array;

//Deber�a extender un nivel abstracto
public class Nivel1 {
	
	//En un futuro tendr� que incluir m�s cosas (Como los edificios que aparecen construidos de base en
	//cada nivel). Por el momento s�lo har�n las funciones de array de eventos
	
	Array <Evento> arrayDeEventos;
	
	//Esta array nos indica el orden en el que aparecer�n cada una de las porciones o secciones
	//del escenario.
	
	Byte[] escenarioLayer1;
	
	
	public Nivel1(Registrodeeventos registrodeeventos){
	
	arrayDeEventos = new Array<Evento>();	
		
	arrayDeEventos.add(registrodeeventos.devolverevento(0));
	
	//Esta array tiene 40 valores
	escenarioLayer1 = new Byte[]
			{0,1,2,0,2,0,0,1,2,0,0,1,2,0,1,2,0,1,2,0,1,2,0,0,0,0,0,0,0,0,0,0,8};
	}
	
	public Array<Evento> solicitareventosdelnivel(){
		
		return arrayDeEventos;
	}
	
	public Byte[] devolverescenariolayer1(){
		return escenarioLayer1;
	};

}
