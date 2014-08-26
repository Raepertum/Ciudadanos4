package com.virtualgames.ciudadanos;
import com.badlogic.gdx.utils.Array;


public class EdificioProductor {
	
	Array <Familia> familiasquehabitaneledificio;

	//Formados por un edificio y por las familias que viven en ellos
	
	public EdificioProductor(Array <Familia> familiasquehabitaneledificio, Edificio edificio){
		
		this.familiasquehabitaneledificio=familiasquehabitaneledificio;
		
	};
	
	public void anadirnuevafamilia(Familia familia){
	
		familiasquehabitaneledificio.add(familia);
		
	}
	
	public void eliminarfamilia(Familia familia){
	
		//No sé si false es el valor correcto
		familiasquehabitaneledificio.removeValue(familia, false);
	}
	

	
}
