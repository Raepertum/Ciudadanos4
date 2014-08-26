package com.virtualgames.ciudadanos;

public class Registrodeavisos {

//Avisos evento 100
Aviso aviso1evento1, aviso2evento1, aviso3evento1, aviso4evento1, aviso5evento1;
Aviso[] avisosevento1;

//Avisos evento 200
Aviso aviso1evento2, aviso2evento2, aviso3evento2, aviso4evento2, aviso5evento2;
Aviso[] avisosevento2;

public Registrodeavisos(){
	
	//Avisos evento 100
	aviso1evento1 = new Aviso("Los campesinos están tremendamente agradecidos y eso se nota en su lealtad.\n Sin embargo, algunos" +
			" interpretan tu generosidad como un signo de debilidad.\n Se instalarán en tus dominios lo antes posible.");
	aviso2evento1 = new Aviso("Los campesinos agradecen tu oferta. Se mostrarán leales\n a tu causa y cumplirán con lo acordado.");
	aviso3evento1 = new Aviso("Los campesinos se comprometen a respetar vuestro pacto.");
	aviso4evento1 = new Aviso("Algunos de los campesinos encuentran la oferta abusiva. Meditarán si les interesan tus condiciones\n " +
			"y te comunicarán su decisión lo antes posible. En todo caso, esto no afectará positivamente a su lealtad.");
	aviso5evento1 = new Aviso("Sólo la desesperación podría llevarles a aceptar tu oferta. Se reunirán y te comunicarán su resolución.\n " +
			"Algunos te odian y a otros les pareces temible. No es lo mejor para mantener la lealtad de tus aldeanos.");
	
	avisosevento1 = new Aviso[]{aviso1evento1,aviso2evento1,aviso3evento1,aviso4evento1,aviso5evento1};
	
	//Avisos evento 200
	
	aviso1evento2 = new Aviso("Prueba 1");
	aviso2evento2 = new Aviso("Prueba 2");
	aviso3evento2 = new Aviso("Prueba 3");
	aviso4evento2 = new Aviso("Prueba 4");
	aviso5evento2 = new Aviso("Prueba 5");
	
	avisosevento2 = new Aviso[]{aviso1evento2,aviso2evento2,aviso3evento2,aviso4evento2,aviso5evento2};
	
	
}

public Aviso devolveraviso(int codigo, int numerodeopcion){

	switch(codigo){
	//Evento 1
	case 100:switch (numerodeopcion){
	case 0: return aviso1evento1;
	case 1: return aviso2evento1;
	case 2: return aviso3evento1;
	case 3: return aviso4evento1;
	case 4: return aviso5evento1;
	}
	case 200:switch (numerodeopcion){
	case 0: return aviso1evento2;
	case 1: return aviso2evento2;
	case 2: return aviso3evento2;
	case 3: return aviso4evento2;
	case 4: return aviso5evento2;
	
	
	}
	}
	return null;
	
}

public Aviso[] devolverarrayavisos(int codigo){
	 switch (codigo) {
     case 100: return avisosevento1;
     case 200: return avisosevento2;
     default: return null;
   }
	
}

};