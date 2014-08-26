package com.virtualgames.ciudadanos;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class Evento extends Stack {
	
	Table tabledebase;
	Table tabledetexto;
	Table tabledebotones;
	//El fondo para el evento
	Image fondoevento;
	//El texto del evento
	Label textoevento;
	LabelStyle estilolabel;
	//Espacio en blanco
	Label espacioenblanco;
	//El tiempo en el que se va a ejecutar
	int tiempodeejecucion;
	//Estáactivo recoge si el evento es activable. Luego habrá que detallarlo más, para eventos recurrentes
	boolean estaactivo = true;
	
	
	public Evento(String textoEvento, Opcion[] opciones, int tiempodeejecucionensegundos){
		
		//El momento en el que se va a ejecutar
		tiempodeejecucion = tiempodeejecucionensegundos;
		
		//El estilo del label (Para el espacio en blanco)
		estilolabel = Texturasysonidos.texturasysonidos.estilosyactores.estilolabeldefault;
		
		//Fondo que incluye el dibujo
		fondoevento = new Image(Texturasysonidos.texturasysonidos.estilosyactores.fondoEvento);
				
		//Las propiedades del stack 
		this.setSize(740, 540);
		this.setPosition(30, 30);
		
		//Espacio en blanco
		espacioenblanco = new Label("", estilolabel);		
		
		//Table de base (Comprende el fondo)
		tabledebase = new Table();
		tabledebase.padTop(20);
		this.add(tabledebase);
		
		//Table de texto (Donde se añade la pregunta)
		tabledetexto = new Table();
		tabledetexto.padTop(20);
		this.add(tabledetexto);
		
		//Table de botones (Donde se añaden las opciones)
		tabledebotones = new Table();
		tabledebotones.padTop(20);
		this.add(tabledebotones);
		
		
		//Probamos a añadir el fondo a la table de evento
		tabledebase.add(fondoevento);
		//El texto del evento
		estilolabel = Texturasysonidos.texturasysonidos.estilosyactores.estilolabeldefault;
		
		textoevento = new Label(textoEvento,estilolabel);
		textoevento.setAlignment(1);
		textoevento.setWrap(true);
		
		tabledetexto.top().row();
		tabledetexto.add(espacioenblanco).height(60);
		tabledetexto.row().width(600);
		tabledetexto.add(textoevento);
		
		tabledebotones.top().row().width(600);
		tabledebotones.setClip(true);
		tabledebotones.add(espacioenblanco).height(250);
		
		
		
		for(int i=0;i<opciones.length;i++){
			tabledebotones.row().width(600).padTop(20);
			tabledebotones.add(opciones[i]);
		
		};
				
		
	};
	
	public void ejecutarevento(Stage contexto){
		
		//Mostrar evento en pantalla, añadiéndolo a la stage
		contexto.addActor(this);
		
		//Subir el contador de eventos
	}
	
	public int devolvertiempodeejecucion(){
		return tiempodeejecucion;
	}
	
	
	public Evento comprobarsiesnull(){
		return this;
	}
	
	public boolean estaactivo(){
		return estaactivo;
	}
	
	public void pasarainactivo(){
		estaactivo=false;
	}

}
