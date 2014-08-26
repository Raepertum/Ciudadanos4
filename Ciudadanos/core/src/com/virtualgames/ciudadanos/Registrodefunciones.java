package com.virtualgames.ciudadanos;

import com.badlogic.gdx.utils.Array;

public class Registrodefunciones {

	public static final Registrodefunciones registrodefunciones = new Registrodefunciones();
	
	//Almacenamos los códigos de nuevos eventos que se incorporarán al generador de eventos
	Array <Integer> codigosdeeventos= new Array <Integer>();
	//Almacenamos los eventos que corresponden a dichos códigos
	Array <Evento> eventospendientes = new Array <Evento>();;
	
	private Registrodefunciones(){
		
	//Registro de funciones usa clases accesibles desde cualquier sitio:
	//Variablesdejuego, registro de individuos, registro de granjas...
		
		
	}
	
	//Funciones sociales
	
	public void distribuidordefunciones(int codigo, int numerodeopcion){
		switch(codigo){
		//Evento 1: "Unos campesinos quieren ocupar uno de tus campos y cultivarlo." +
		//" A cambio se comprometen a ofrecerte la mitad de sus cosechas."
		case 100:switch (numerodeopcion){
		//Se instala una familia de aldeanos, cuyo miedo y lealtad base depende de las opciones escogidas
		case 0: instalaciondenuevosciudadanos("campesinos",100,20,0);
		        //PRUEBA
		        anadiralacoladeeventospendientes(1);
		break;
		case 1: instalaciondenuevosciudadanos("campesinos",80,30,0);
		break;
		case 2: instalaciondenuevosciudadanos("campesinos",70,50,0);
		break;
		case 3: instalaciondenuevosciudadanos("campesinos",60,60,0);
		break;
		case 4: instalaciondenuevosciudadanos("campesinos",50,80,0);
		break;
		}
		
		}
	};
	
	
	private void instalaciondenuevosciudadanos(String tipodeciudadanos, int lealtadbase, int miedobase, int habilidadbase){
		
		//Esta llamada nos va a crear una familia de seis miembros
		if(tipodeciudadanos=="campesinos"){
		Registrodefamilias.registrodefamilias.crearfamiliadealdeanos(lealtadbase, miedobase, habilidadbase);
		}
		
		
	};
	
	//Funciones lógicas
	
	//Primero añadimos códigos (Esto se hace desde el propio registro de funciones)
	private void anadiralacoladeeventospendientes(Integer codigonumericodevento){
		codigosdeeventos.add(codigonumericodevento);
	};
	
	//Desde lógica preguntamos por el tamaño de la array de códigos
	public int devolvertamanoarraydecodigos(){
		return codigosdeeventos.size;
	}	
	
	//Desde lógica devolvemos los códigos
	public int devolvercodigosdeeventos(int indice){
		return codigosdeeventos.get(indice);
	}
	
	//Desde lógica vamos a pedir que se nos manden los eventos que hay que ir añadiendo	
	public void convertircodigoseneventos(Evento evento){
		eventospendientes.add(evento);	
	}
	
	//Desde lógica devolvemos la array de eventos pendientes
	public Evento devolvereventospendientes(int indice){
		return eventospendientes.get(indice);
	};
	
	public int devolvertamañoarraydeeventos(){
		return eventospendientes.size;
	}
	
	public void limpiareventospendientes(){
		//Limpia los códigos y limpia los eventos
		eventospendientes.clear();
		codigosdeeventos.clear();
		
	}
	
	
	
	
}
