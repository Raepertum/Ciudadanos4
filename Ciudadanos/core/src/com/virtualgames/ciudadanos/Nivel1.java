package com.virtualgames.ciudadanos;

import com.badlogic.gdx.utils.Array;

//Debería extender un nivel abstracto
public class Nivel1 {
	
	//En un futuro tendrá que incluir más cosas (Como los edificios que aparecen construidos de base en
	//cada nivel). Por el momento sólo harán las funciones de array de eventos
	
	Array <Evento> arrayDeEventos;
	
	public Nivel1(Registrodeeventos registrodeeventos){
	
	arrayDeEventos = new Array<Evento>();	
		
	arrayDeEventos.add(registrodeeventos.devolverevento(0));
	
	
	
	}
	
	public Array<Evento> solicitareventosdelnivel(){
		
		return arrayDeEventos;
	}

}
