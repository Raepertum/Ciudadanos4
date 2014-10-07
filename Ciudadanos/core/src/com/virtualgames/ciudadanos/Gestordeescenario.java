package com.virtualgames.ciudadanos;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Gestordeescenario {

	Byte[] escenarioLayer1;
	
	//La array de tierras, necesaria para el renderizado
	public Array <Tierra> tierras;
	//La array de transici�n entre tierras, necesaria para suavizar los l�mites entre distintas
	//texturas
	public Array <Transiciontierra> transiciontierras;
	
	//N�mero de columnas del mapa, es el primer valor de la array del escenario layer 1
	int numerodecolumnasmapa;
	//N�mero de filas del mapa, lo vamos a calcular al dividir el tama�o del escenario entre el 
	//N�mero de columnas (En este punto, el resultado de multiplicar el n�mero de filas por el 
	//n�mero de columnas no nos da como resultado la cantidad de casillas de terreno que existen
	//ya que el mapa puede estar "incompleto"
	int numerodefilasmapa;
    
	
	
	public Gestordeescenario(Nivel1 nivel1){
		
		//Esta clase va a crear y a actualizar gr�ficamente 
		//(Mediante la actualizaci�n de la variable de frame)
		//El escenario.
		
		//Cuando la iniciamos, lo primero que hacemos es recoger una array que nos va a decir
		//d�nde va situada cada porci�n del escenario
		
		//Aqu� vamos a tener la disposici�n del terreno (Mar, tierra, desierto...)
		escenarioLayer1 = nivel1.devolverescenariolayer1();
		
		//Necesitamos el n�mero de columnas, que est� almacenado como el �ltimo valor de la
		//byte array del escenario
	    numerodecolumnasmapa = escenarioLayer1[escenarioLayer1.length-1];
	    //Calculamos el n�mero de filas
	    numerodefilasmapa = Math.abs((escenarioLayer1.length-2)/numerodecolumnasmapa)+1;
		
		//Aqu� vamos a poner las tierras y las "transiciones" entre terrenos
		
		tierras = new Array<Tierra>();
		transiciontierras = new Array<Transiciontierra>();
		
		
		//Ahora vamos a utilizar los valores contenidos en el primer layer para ir a�adiendo 
		//los objetos que se van a renderizar, en este caso el suelo
		
		for (int i=0; i<escenarioLayer1.length-1; i++){
			
			    Tierra tierra = new Tierra();
			    tierra.establecertipodedetierra(escenarioLayer1[i]);
				tierra.posicionX+=i-numerodecolumnasmapa*Math.abs(i/numerodecolumnasmapa);
				tierra.posicionY-=Math.abs(i/numerodecolumnasmapa)*1.0f;
				//Para poder crear las transiciones, almacenaremos en cada tierra el n�mero de 
				//fila y el n�mero de mapa en que se encuentran
				tierra.asignarfila(Math.abs(i/numerodecolumnasmapa));
				tierra.asignarcolumna(Math.abs(i-Math.abs(i/numerodecolumnasmapa)*numerodecolumnasmapa));
				tierras.add(tierra);
			}
		
		//Ahora vamos a a�adir las transiciones, pero primero tenemos que calcular el n�mero
		//de transiciones necesarias
		
		
		//El segundo layer es el que calcula las transiciones entre terrenos
		//Casos:
		//Primera fila: Primer cuadro, salvo por el �ltimo cuadro: Calculamos la transici�n 
		//con el de la derecha
		for(int i=0;i<tierras.size;i++){
			//Si estamos en la primera fila
			if((tierras.get(i).recuperarfila()==0)){
				//Si no es la �ltima columna
				if((tierras.get(i).recuperarcolumna())!=numerodecolumnasmapa-1){
					creartransicionhorizontal(tierras.get(i).recuperartipodetierra(),tierras.get(i+1).recuperartipodetierra(),i);
				}
				//Primera fila: �ltimo cuadro. No calculamos ninguna frontera.
			}
			//Si estamos en la segunda fila o posteriores
			else if((tierras.get(i).recuperarfila()>0)){
			
			//Si no se trata del �ltimo cuadro	
			//Calculamos con el de arriba y con el de la derecha.				
			if(!(i==tierras.size-1)){
				//Si no se trata del �ltimo cuadro de una fila
				if(tierras.get(i).recuperarfila()==tierras.get(i+1).recuperarfila()){
					creartransicionhorizontal(tierras.get(i).recuperartipodetierra(),tierras.get(i+1).recuperartipodetierra(),i);
				}
				//Creamos transici�n vertical
				creartransicionvertical(tierras.get(i).recuperartipodetierra(),tierras.get(i-numerodecolumnasmapa).recuperartipodetierra(),i);
			}
			//Si es el �ltimo cuadro, s�lo creamos la transici�n vertical
			else{
				creartransicionvertical(tierras.get(i).recuperartipodetierra(),tierras.get(i-numerodecolumnasmapa).recuperartipodetierra(),i);
			}
				
			}
		}
		}
		
		
		public void creartransicionhorizontal(int primeratierra, int segundatierra, int indiceprimeratierra){
			
			if(primeratierra!=segundatierra){
			
			Transiciontierra transiciontierra = new Transiciontierra();
			
			if(primeratierra==0){
				if(segundatierra == 1){
				transiciontierra.establecertipodetransicion(0);	
				}
				else if(segundatierra == 2){
				transiciontierra.establecertipodetransicion(4);	
				}
			}
			else if(primeratierra==1){
				if(segundatierra == 0){
				transiciontierra.establecertipodetransicion(2);	
				}
				else if(segundatierra == 2){
				transiciontierra.establecertipodetransicion(8);	
				}
			}
			else if(primeratierra==2){
				if(segundatierra ==0){
				transiciontierra.establecertipodetransicion(6);	
				}
				else if(segundatierra ==1){
				transiciontierra.establecertipodetransicion(10);	
				}
			}
			
			transiciontierra.posicionX=(tierras.get(indiceprimeratierra)).posicionX+1.0f;
			transiciontierra.posicionY=tierras.get(indiceprimeratierra).posicionY;
			
			transiciontierra.dimensionX=0.20f;
			
			transiciontierras.add(transiciontierra);	
			}
		}
		public void creartransicionvertical(int primeratierra, int segundatierra, int indiceprimeratierra){
			
			if(primeratierra!=segundatierra){
				
			Transiciontierra transiciontierra = new Transiciontierra();
            //La primera tierra es la tierra de abajo
			if(primeratierra==0){
				if(segundatierra == 1){
				transiciontierra.establecertipodetransicion(1);	
				}
				else if(segundatierra == 2){
				transiciontierra.establecertipodetransicion(5);	
				}
			}
			else if(primeratierra==1){
				if(segundatierra == 0){
				transiciontierra.establecertipodetransicion(3);	
				}
				else if(segundatierra == 2){
				transiciontierra.establecertipodetransicion(9);	
				}
			}
			else if(primeratierra==2){
				if(segundatierra ==0){
				transiciontierra.establecertipodetransicion(7);	
				}
				else if(segundatierra ==1){
				transiciontierra.establecertipodetransicion(11);	
				}
			}
			
			
			transiciontierra.posicionX=tierras.get(indiceprimeratierra).posicionX;
			transiciontierra.posicionY=(tierras.get(indiceprimeratierra)).posicionY+1.0f;
			
			transiciontierra.dimensionY=0.20f;
			
			transiciontierras.add(transiciontierra);
			
			System.out.println("Creada transicion vertical");
			
			transiciontierras.add(transiciontierra);
			}
		}
		
		
	};
	

