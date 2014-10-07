package com.virtualgames.ciudadanos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.UBJsonReader;

public class Logica extends InputAdapter implements InputProcessor{
	
	//Teclas
	boolean pulsandoA,pulsandoW,pulsandoS,pulsandoD;
	int zoomcamara;
	
	//Objetos
	public Torre torre;
    
    //Interfaz
	public Contenedorhud contenedorhud;
	
		
	//Para crear el reloj
	long tiempoinicial;
	long tiempotranscurridoensegundos;
	int tiempotranscurridoenminutos;
	int tiempotranscurridoenhoras;
	long ultimotiempo;
	int tiempoentreestaciones = 100;
	int agno=1;
	
	//Este tiempo se usa para el actualizador lento (El que actualiza las variables una vez al segundo)
	int segundosparaelactualizadorporsegundos=0;
	
	String estacion="primavera";
	
	//Los registros
	Registrodeavisos registrodeavisos;
	Registrodeopciones registrodeopciones;
	Registrodeeventos registrodeeventos;
	Generadordeeventos generadordeeventos;
	
	//Los niveles
	Nivel1 nivel1;
	
	//La creaci�n del terreno va a depender de una nueva clase, el gestor de escenario
	Gestordeescenario gestordeescenario;
	
	
	public Logica(){
		iniciarclase();
		
	};
	
	private void iniciarclase(){
		
		
		//La torre	
		torre = new Torre();
				
		//El contenedor hud
		contenedorhud = new Contenedorhud();
		
		//El reloj
		tiempoinicial=TimeUtils.millis();
		ultimotiempo=tiempotranscurridoensegundos=(TimeUtils.millis()-tiempoinicial)/1000;
		
		//Los registros
		registrodeavisos = new Registrodeavisos();
		registrodeopciones = new Registrodeopciones(registrodeavisos, contenedorhud.contenedordeactores);
		registrodeeventos = new Registrodeeventos(registrodeopciones);
		
		//El nivel (Todas las pruebas las haremos con el nivel 1, pero m�s adelante habr� que hacer una
		//funci�n que permita cambiarlo)
		nivel1 = new Nivel1(registrodeeventos);
		
		//El gestor de escenario asociado al nivel, que va a crear todos los gr�ficos y cuya animaci�n
		//ser� actualizada desde l�gica
		gestordeescenario = new Gestordeescenario(nivel1);
		
		
		//El generador de eventos
		generadordeeventos = new Generadordeeventos(nivel1,contenedorhud.contenedordeactores);
		
		
		//A�adir tanto la stage como la propia l�gica al marco de eventos
		Gdx.input.setInputProcessor(new InputMultiplexer(contenedorhud.contenedordeactores,this));
	
	}	

	public void actualizaralframerate(float delta){
		
		recogereventosdeteclado();
		tiempotranscurridoensegundos=(int)(TimeUtils.millis()-tiempoinicial)/1000;
		tiempotranscurridoenminutos=(int)Math.abs((float)tiempotranscurridoensegundos/60);
		tiempotranscurridoenhoras=(int)tiempotranscurridoenminutos/60;
		
		//Provisional
		actualizaralsegundo(delta);
		actualizarestaciones();
		actualizarescenario();
		actualizarmenus(delta);
		actualizargeneradordeeventos();
		
		
	
	};
	
	public void actualizaralsegundo(float delta){
		
		if((int)tiempotranscurridoensegundos>segundosparaelactualizadorporsegundos){
			segundosparaelactualizadorporsegundos=(int)tiempotranscurridoensegundos;
			actualizarvariables(delta);
		}
	}
	
	public void actualizarmenus(float delta){
		contenedorhud.actualizartiempo((int)tiempotranscurridoensegundos,tiempotranscurridoenminutos,tiempotranscurridoenhoras);
		contenedorhud.act(delta);
		
		Eventosymenu.eventosymenu.menualmacen.act(delta);
		Eventosymenu.eventosymenu.menuejercito.act(delta);
		Eventosymenu.eventosymenu.menucomercio.act(delta);
		Eventosymenu.eventosymenu.menuespionaje.act(delta);
		Eventosymenu.eventosymenu.menusocial.act(delta);
		
	};
	public void actualizarvariables(float delta){
		Variablesdejuego.variablesdejuego.actualizar();
	}
	
	public void actualizarestaciones(){
		
		if((int)((tiempotranscurridoensegundos-ultimotiempo)/tiempoentreestaciones)==0){
			if(estacion=="invierno"){
				System.out.println("Cambio de estacion");
			}
			
			estacion="primavera";
		}
		else if((int)((tiempotranscurridoensegundos-ultimotiempo)/tiempoentreestaciones)==1){
			if(estacion=="primavera"){
				System.out.println("Cambio de estacion");
				System.out.println("Vamos a recoger parte de la cosecha");
			}
			estacion="verano";
		}
		else if((int)((tiempotranscurridoensegundos-ultimotiempo)/tiempoentreestaciones)==2){
			if(estacion=="verano"){
					System.out.println("Cambio de estacion");
					System.out.println("Vamos a recoger la otra parte de la cosecha");
			}
			estacion="oto�o";
		}
		else if((int)((tiempotranscurridoensegundos-ultimotiempo)/tiempoentreestaciones)==3){
			estacion="invierno";
			
		}
		else if((int)((tiempotranscurridoensegundos-ultimotiempo)/tiempoentreestaciones)>3){
			ultimotiempo=tiempotranscurridoensegundos;
			agno+=1;
		}
		
	};
	
	public void actualizargeneradordeeventos(){
		
		generadordeeventos.actualizar((int)tiempotranscurridoensegundos);
		
		
		//Siempre que se haya instanciado el registro de funciones, of course
		if(Registrodefunciones.registrodefunciones!=null){
			
		//Si la array de c�digos contiene alg�n c�digo
		if(Registrodefunciones.registrodefunciones.devolvertamanoarraydecodigos()>0){
			
			//Desde 0 al tama�o de la array
			for (int i= 0; i<Registrodefunciones.registrodefunciones.devolvertamanoarraydecodigos();i++){
				//Conviertes los c�digos en eventos
				Evento evento = registrodeeventos.devolverevento(Registrodefunciones.registrodefunciones.devolvercodigosdeeventos(i));
				Registrodefunciones.registrodefunciones.convertircodigoseneventos(evento);
			}
		}
		//Ahora que los c�digos est�n traspasados a la array de eventos pendientes contenida en el Registro de funciones, vamos a traspasarla
		//Al generador de eventos con otro bucle
		
		if(Registrodefunciones.registrodefunciones.devolvertama�oarraydeeventos()>0){
		for (int i=0; i<(Registrodefunciones.registrodefunciones.devolvertama�oarraydeeventos());i++){
		
			Evento evento = Registrodefunciones.registrodefunciones.devolvereventospendientes(i);
			//Y as� a�adimos al generador :-)
			generadordeeventos.anadirnuevoevento(evento);
		}
		
		//A continuaci�n, lo limpiamos todo para evitar duplicidades
		Registrodefunciones.registrodefunciones.limpiareventospendientes();
		
		}
		}
	}
	
	public void actualizarescenario(){
	
	};
	
	
	//M�todos para capturar teclas
	public void recogereventosdeteclado(){
		pulsandoW=Gdx.input.isKeyPressed(Keys.W);
		pulsandoS=Gdx.input.isKeyPressed(Keys.S);
		pulsandoA=Gdx.input.isKeyPressed(Keys.A);
		pulsandoD=Gdx.input.isKeyPressed(Keys.D);
}
	
	public boolean scrolled(int scroll){
		zoomcamara=scroll;
		return false;
	}
	


}
