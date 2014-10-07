package com.virtualgames.ciudadanos;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Gestordeescenario {

	Byte[] escenarioLayer1;
	
	//La array de tierras, necesaria para el renderizado
	public Array <Tierra> tierras;
	
	//N�mero de filas del mapa, es el primer valor de la array del escenario layer 1
	int numerodefilasmapa;
    
	
	
	public Gestordeescenario(Nivel1 nivel1){
		
		//Esta clase va a crear y a actualizar gr�ficamente 
		//(Mediante la actualizaci�n de la variable de frame)
		//El escenario.
		
		//Cuando la iniciamos, lo primero que hacemos es recoger una array que nos va a decir
		//d�nde va situada cada porci�n del escenario
		
		//Aqu� vamos a tener la disposici�n del terreno (Mar, tierra, desierto...)
		escenarioLayer1 = nivel1.devolverescenariolayer1();
		
		//Necesitamos el n�mero de filas, que est� almacenado como el �ltimo valor de la
		//byte array del escenario
	    numerodefilasmapa = escenarioLayer1[escenarioLayer1.length-1];
		
		//Aqu� vamos a poner las "transiciones" entre terrenos
		
		tierras = new Array<Tierra>();
		
		
		//Ahora vamos a utilizar los valores contenidos en el primer layer para ir a�adiendo 
		//los objetos que se van a renderizar, en este caso el suelo
		
		for (int i=0; i<escenarioLayer1.length-1; i++){
			
			    Tierra tierra = new Tierra();
			    tierra.establecertipodedetierra(escenarioLayer1[i]);
				tierra.posicionX+=i-numerodefilasmapa*Math.abs(i/numerodefilasmapa);
				tierra.posicionY-=Math.abs(i/numerodefilasmapa)*1.0f;
				tierras.add(tierra);
			}
		
		System.out.println("N�mero de filas:"+(Math.abs((escenarioLayer1.length-2)/numerodefilasmapa)+1));
		System.out.println("N�mero de columnas del escenario:"+numerodefilasmapa);
		
		
		
		//El segundo layer es el que calcula las transiciones entre terrenos
		//Casos:
		//Primera fila: Primer cuadro. S�lo calculamos frontera con el de la derecha
		//Primera fila: A partir del primer cuadro. Calculamos la transici�n con el de la derecha
		//Primera fila: �ltimo cuadro. No calculamos ninguna frontera.
		
		//Segunda fila: Calculamos con el de arriba y con el de la derecha.
		//Segunda fila: �ltimo cuadro. Calculamos con el de arriba, nada m�s
		
		//�ltima fila: Calculamos con el de arriba y con el de la derecha
		//�ltima fila: �ltimo cuadro. Calculamos con el de arriba, nada m�s.
		
		
			
			
		}
		
		
		
		
		//Las tierras
		/*
				tierras = new Array<Tierra>();
				for(int i=0;i<22;i++){
				for(int j=0;j<8;j++){
				Tierra tierra = new Tierra();
				tierra.posicionX+=i*1.0f-10;
				tierra.posicionY-=j*1.0f;
				tierras.add(tierra);
				};
				};
			*/	
		
		//La actualizaci�n
		/*for(Tierra tierra:tierras){
			if ((MathUtils.random(0, 30)==0)){
			tierra.actualizarestacion(estacion);
			}
		};*/
		
		
	};
	

