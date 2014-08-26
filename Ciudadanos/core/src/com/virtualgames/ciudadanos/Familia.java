package com.virtualgames.ciudadanos;

import com.badlogic.gdx.utils.Array;

public class Familia {
	
	String nombredelafamilia; 
	Array<Individuo> miembrosdelafamilia;
	boolean habitaunedificio = false;
	
	public Familia(String nombredelafamilia){
		
		this.nombredelafamilia = nombredelafamilia;
		miembrosdelafamilia = new Array<Individuo>();
		
	}
	
	public void anadiralafamilia(Individuo individuo){
		miembrosdelafamilia.add(individuo);
	}
	
	public int devolvertamanofamilia(){
		return miembrosdelafamilia.size;
	}
	
	public String conocerelnombredelafamilia(){
		return this.nombredelafamilia;
	}
	
	public Individuo devolverindividuoconmayornivelquenoestecansadoniseamenor(){
		
		int indicedeindividuoconmayornivel=0;
		int mayornivel=0;
		
		for(int i=0; i<miembrosdelafamilia.size; i++){
			//Si el individuo tiene mayor nivel que el previamente establecido
			//Y si el individuo no está cansado
			//Y si el individuo no es menor de edad
			if ((miembrosdelafamilia.get(i).nivel>=mayornivel)&&
			((miembrosdelafamilia).get(i).cansado==false)&&
			(miembrosdelafamilia.get(i).edad>=16)){
				mayornivel=miembrosdelafamilia.get(i).nivel;
				indicedeindividuoconmayornivel = i;
			}
		}
		return miembrosdelafamilia.get(indicedeindividuoconmayornivel);
		
	}
	
	

}
