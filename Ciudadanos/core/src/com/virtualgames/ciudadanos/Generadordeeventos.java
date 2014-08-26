package com.virtualgames.ciudadanos;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Generadordeeventos {

	Array <Evento> arraydeeventos;
	Stage contexto;
	
	public Generadordeeventos(Nivel1 nivel1, Stage contexto){
	
	arraydeeventos = nivel1.solicitareventosdelnivel();
	this.contexto = contexto;
	
	}
	
	public void actualizar(int tiempoensegundos){
	
		
		//Si hay un evento y si no hemos llegado al final de la array de eventos
		
		for(int i=0;i<arraydeeventos.size;i++){
			
			if((arraydeeventos.get(i).devolvertiempodeejecucion()==tiempoensegundos)
				&&(arraydeeventos.get(i).estaactivo()==true)){
				arraydeeventos.get(i).pasarainactivo();
				arraydeeventos.get(i).ejecutarevento(contexto);
			}
			
		}
		
				
		
	};
	
	public void anadirnuevoevento(Evento evento){
		
		arraydeeventos.add(evento);
		
	}
}
