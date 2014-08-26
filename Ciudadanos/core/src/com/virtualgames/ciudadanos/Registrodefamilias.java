package com.virtualgames.ciudadanos;

import com.badlogic.gdx.utils.Array;

public class Registrodefamilias {
	
public static final Registrodefamilias registrodefamilias = new Registrodefamilias();

Array <Familia> arraydefamilias;
int nuevonombre = 0;


private Registrodefamilias(){
	
	
	arraydefamilias = new Array<Familia>();
	
}

public void crearfamiliadealdeanos(int lealtadbase, int miedobase, int nivelbase){
	
	
	//Le preguntamos a la función que devuelve los nombres. Creamos una familia con ese nombre.
	Familia familia = new Familia(devolvernombreparaelregistro());
	
	//Añadimos miembros a la familia (Dos aldeanos adultos, dos aldeanos ancianos, dos aldeanos jóvenes)
	Registrodeindividuos.registrodeindividuos.crearnuevoindividuo(familia,true, 16, lealtadbase, miedobase, "campesinos", 0);
	Registrodeindividuos.registrodeindividuos.crearnuevoindividuo(familia,false, 16, lealtadbase, miedobase, "campesinos", 0);
	Registrodeindividuos.registrodeindividuos.crearnuevoindividuo(familia,true, 45, lealtadbase, miedobase, "campesinos", 0);
	Registrodeindividuos.registrodeindividuos.crearnuevoindividuo(familia,false, 45, lealtadbase, miedobase, "campesinos", 0);
	Registrodeindividuos.registrodeindividuos.crearnuevoindividuo(familia,true, 0, lealtadbase, miedobase, "campesinos", 0);
	Registrodeindividuos.registrodeindividuos.crearnuevoindividuo(familia,false, 0, lealtadbase, miedobase, "campesinos", 0);
	

	//Añadimos la familia a la array de familias
	arraydefamilias.add(familia);

}
	

public String devolvernombreparaelregistro(){
	
	if(nuevonombre==0){
		nuevonombre++;
		return "Gil";
	}
	return "";
}

public Familia devolverfamiliaporindice(int i){
	return arraydefamilias.get(i);
}


}
