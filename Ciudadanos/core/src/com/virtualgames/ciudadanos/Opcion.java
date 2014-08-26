package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

//Es una table que añadimos debajo de la imagen y el texto del evento
public class Opcion extends TextButton{
	
	String textodeopcion;
	String textodeconfirmacion;
	int codigodeefecto;
	int numeroopcion;
	Aviso avisodelaopcion;
	Stage contexto;
  
	

	public Opcion(String textodeopcion, Aviso aviso, Stage contexto, int codigo, int numeroopcion){

		super(textodeopcion,Texturasysonidos.texturasysonidos.estilosyactores.estilobotondefault);
		
		this.avisodelaopcion = aviso;
		this.textodeopcion = textodeopcion;
		this.contexto = contexto;
		this.codigodeefecto = codigo;
		this.numeroopcion = numeroopcion;
		
		this.addListener(new InputListener(){
			
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int actor){
			    ejecutaraviso();
			    ejecutarfuncionespecifica();
			    suprimirevento();
				return true;
		}

		
			
		});
	};
		
	public String gettextodeopcion(){
		return this.textodeopcion;
	}
	
	public int getcodigodeefecto(){
		return this.codigodeefecto;
	}
	
	private void ejecutarfuncionespecifica(){
		Registrodefunciones.registrodefunciones.distribuidordefunciones(codigodeefecto, numeroopcion);
	};
	

	
	
	private void ejecutaraviso(){
		
		avisodelaopcion.mostraraviso(contexto);
		
	};
	

	private void suprimirevento(){
		//Habrá que rehacerlo cuando todo se cree en el generador de eventos y se modifique la manera de crearlos
		this.getParent().getParent().remove();

	};
	
	
	
	
}


