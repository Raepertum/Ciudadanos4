package com.virtualgames.ciudadanos;


public class Registrodeeventos {

	Evento evento1;	
	Evento evento2;
	Evento[] todosloseventos;
	
	
	public Registrodeeventos(Registrodeopciones registrodeopciones){
	
	todosloseventos = new Evento[2];
		
	
	
	//Creamos cada evento
	evento1 = new Evento("Unos campesinos quieren ocupar uno de tus campos y cultivarlo." +
			" A cambio se comprometen a ofrecerte la mitad de sus cosechas.", registrodeopciones.devolverarrayopciones(100), 5);
	
	
	evento2 = new Evento("Esto es una prueba", registrodeopciones.devolverarrayopciones(200),10);
	
	
	todosloseventos[0] = evento1;
	todosloseventos[1] = evento2;
	
	};
	


public Evento devolverevento(int codigo){

return todosloseventos[codigo];
	
}


};



