package com.virtualgames.ciudadanos;

import com.badlogic.gdx.utils.Array;

//Deber�a extender un nivel abstracto
public class Nivel1 {
	
	//En un futuro tendr� que incluir m�s cosas (Como los edificios que aparecen construidos de base en
	//cada nivel). Por el momento s�lo har�n las funciones de array de eventos
	
	Array <Evento> arrayDeEventos;
	
	//Esta array nos indica el orden en el que aparecer�n cada una de las porciones o secciones
	//del escenario.
	
	//Almacena los tipos de tierra
	Byte[] escenarioLayer1;
	//Almacena el mar
	Boolean[] escenarioLayer2;
	
	
	public Nivel1(Registrodeeventos registrodeeventos){
	
	arrayDeEventos = new Array<Evento>();	
		
	arrayDeEventos.add(registrodeeventos.devolverevento(0));
	
	//Esta array tiene 32 valores + el n�mero de columnas
	escenarioLayer1 = new Byte[]
			{0,1,2,0,2,0,0,1,2,0,0,1,2,0,1,2,0,1,2,0,1,2,0,0,0,0,0,0,0,0,0,0,
			
			0,0,0,0,0,0,0,0,
			
			0,0,0,0,0,0,0,0,
			
			8};
	//Esta array ha de contener, entonces, 32*9= 288 valores (No se precisa el valor del n�mero de columnas, ya que el gestor de escenario
	//Lo recoge del n�mero de columnas del escenario
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
