package com.virtualgames.ciudadanos;

import com.badlogic.gdx.utils.Array;

//Debería extender un nivel abstracto
public class Nivel1 {
	
	//En un futuro tendrá que incluir más cosas (Como los edificios que aparecen construidos de base en
	//cada nivel). Por el momento sólo harán las funciones de array de eventos
	
	Array <Evento> arrayDeEventos;
	
	//Esta array nos indica el orden en el que aparecerán cada una de las porciones o secciones
	//del escenario.
	
	//Almacena los tipos de tierra
	Byte[] escenarioLayer1;
	//Almacena el mar
	Boolean[] escenarioLayer2;
	
	
	public Nivel1(Registrodeeventos registrodeeventos){
	
	arrayDeEventos = new Array<Evento>();	
		
	arrayDeEventos.add(registrodeeventos.devolverevento(0));
	
	//Esta array tiene 32 valores + el número de columnas
	escenarioLayer1 = new Byte[]
			{0,1,2,0,2,0,0,1,2,0,0,1,2,0,1,2,0,1,2,0,1,2,0,0,0,0,0,0,0,0,0,0,
			
			0,0,0,0,0,0,0,0,
			
			0,0,0,0,0,0,0,0,
			
			8};
	//Esta array ha de contener, entonces, 32*9= 288 valores (No se precisa el valor del número de columnas, ya que el gestor de escenario
	//Lo recoge del número de columnas del escenario
	escenarioLayer2 = new Boolean[]
	{false, true, true, true, true, false, false, true, false, true, false, false, false, false, false, false, true, false, true, false,
	true, false, true, false, false, false, false, false, false, true, false, false, false, false, true, true, false, false, true, 
	true, false, false, false, false, false, false, true, true, true, false, true, false, false, false, false, false, true, false,
	false, true, true, true, true, false, false, true, true, true, false, false, false, false, false, false, true, false, true, false,
	true, false, true, false, false, false, false, false, false, true, false, false, false, false, true, true, false, false, true, 
	true, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, true, false,
	false, true, true, true, true, false, false, true, true, true, false, false, false, false, false, false, true, false, true, false,
	true, false, true, false, false, false, false, false, false, true, false, false, false, false, true, true, false, false, true, 
	true, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, true, false,
	false, true, true, true, true, false, false, true, true, true, false, false, false, false, false, false, true, false, true, false,
	true, false, true, false, false, false, false, false, false, true, false, false, false, false, true, true, false, false, true, 
	true, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, true, false,	
	false, true, true, true, true, false, false, true, true, true, false, false, false, false, false, false, true, false, true, false,
	false, true, true, true, true, false, false, true, true, true, false, false, false, false, false, false, true, false, true, false,
	false,false,false,false,false,false,false,false,false, false, false, false, false, false, false, false};
	}
	

	
	public Array<Evento> solicitareventosdelnivel(){
		
		return arrayDeEventos;
	
	}
	
	public Byte[] devolverescenariolayer1(){
		return escenarioLayer1;
	};
	public Boolean[] devolverescenariolayer2(){
		return escenarioLayer2;
	};

}
