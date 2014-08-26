package com.virtualgames.ciudadanos;

import com.badlogic.gdx.scenes.scene2d.Stage;



public class Registrodeopciones {

	
//Opciones de evento 1
Opcion opcion1e1, opcion2e1, opcion3e1, opcion4e1, opcion5e1;
Opcion[] opcionese1;
//Opciones de evento 2
Opcion opcion1e2, opcion2e2, opcion3e2, opcion4e2, opcion5e2;
Opcion[] opcionese2;
Stage contexto;


public Registrodeopciones(Registrodeavisos registrodeavisos, Stage contexto){

	this.contexto = contexto;
	
    //Cada opción lleva asociado un aviso
	
	//Evento 100
	opcion1e1 = new Opcion("Les concedes tierras, sin pedir nada a cambio.", registrodeavisos.devolveraviso(100, 0), contexto, 100, 0);
	opcion2e1 = new Opcion("Con sólo la cuarta parte de sus cosechas será suficiente.", registrodeavisos.devolveraviso(100, 1), contexto, 100, 1);
	opcion3e1 = new Opcion("Accedes a lo que te proponen.", registrodeavisos.devolveraviso(100, 2), contexto, 100, 2);
	opcion4e1 = new Opcion("Exiges las tres cuartas partes de las cosechas a cambio de que se instalen.", registrodeavisos.devolveraviso(100, 3), contexto, 100 ,3);
	opcion5e1 = new Opcion("A las 3/4 partes de las cosechas, habrán de añadir el sacrificio anual de un niño.", registrodeavisos.devolveraviso(100, 4), contexto, 100, 4);
	
	opcionese1 = new Opcion[]{opcion1e1,opcion2e1,opcion3e1,opcion4e1,opcion5e1};

	//Evento 200
	opcion1e2 = new Opcion("Prueba 1", registrodeavisos.devolveraviso(200, 0), contexto, 200, 0);
	opcion2e2 = new Opcion("Prueba 2", registrodeavisos.devolveraviso(200, 1), contexto, 200, 1);
	opcion3e2 = new Opcion("Prueba 3", registrodeavisos.devolveraviso(200, 2), contexto, 200, 2);
	opcion4e2 = new Opcion("Prueba 4", registrodeavisos.devolveraviso(200, 3), contexto, 200 ,3);
	opcion5e2 = new Opcion("Prueba 5", registrodeavisos.devolveraviso(200, 4), contexto, 200, 4);
	
	opcionese2 = new Opcion[]{opcion1e2,opcion2e2,opcion3e2,opcion4e2,opcion5e2};
	
};

public Opcion devolveropcion(int codigo, int numerodeopcion){

	switch(codigo){
	//Evento 1
	case 100:switch (numerodeopcion){
	case 0: return opcion1e1;
	case 1: return opcion2e1;
	case 2: return opcion3e1;
	case 3: return opcion4e1;
	case 4: return opcion5e1;
	}
	case 200:switch (numerodeopcion){
	case 0: return opcion1e2;
	case 1: return opcion2e2;
	case 2: return opcion3e2;
	case 3: return opcion4e2;
	case 4: return opcion5e2;
	}
	
	}
	
	return null;
	
}

public Opcion[] devolverarrayopciones(int codigo){
	 switch (codigo) {
     case 100:    	
     return opcionese1;
     case 200:
     return opcionese2;
     default: return null;
   }
	
}

};