package com.virtualgames.ciudadanos;

public class Individuo {

//Sexo: True - Hombre, False - Mujer
boolean sexo;
int edad;
int lealtad;
int miedo;
int habilidad;
String profesion;
int nivel;
boolean cansado = false;
	
public Individuo(boolean sexo, int edad, int lealtad, int miedo, String profesion, int nivel){
	this.sexo = sexo;
	this.edad = edad;
	this.lealtad = lealtad;
	this.miedo = miedo;
	this.profesion = profesion;
	this.nivel = nivel;
}

public void envejecer(){
	this.edad++;
}

public void cambiardeprofesion(String nuevaprofesion){
	this.profesion = nuevaprofesion;
}
public void subirdenivel(){
	this.nivel++;
}
public void cansarindividuo(){
	cansado=true;
}
public void descansarindividuo(){
	cansado=false;
}


//¿Cuánto trigo producen? Se produce en las granjas
//¿Cuánto trigo consumen? Se ve en el registro de individuos
//¿Cuándo mueren? Se ve en el registro de individuos
//¿Están enfermos? Se actualiza en el registro de individuos
//¿Tienen un número de identificación? Por ahora no
	
}
