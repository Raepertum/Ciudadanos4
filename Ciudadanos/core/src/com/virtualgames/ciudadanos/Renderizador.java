package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class Renderizador implements Disposable{
	
	private Camara camara;
	private OrthographicCamera camaraparalagui;
	private SpriteBatch batch;
	private Logica logica;	
	
public Renderizador(Logica logica){
	this.logica = logica;
	iniciarclase();
	
}

private void iniciarclase(){
	batch = new SpriteBatch();
	camara = new Camara(Constantes.ANCHODELVISOR, Constantes.ALTODELVISOR);
	camara.mandaralorigen();
	camara.update();
	
	camaraparalagui = new OrthographicCamera(Constantes.ANCHODELVISORGUI, Constantes.ALTODELVISORGUI);
	camaraparalagui.position.set(0,0,0);
	camaraparalagui.setToOrtho(true);
	camaraparalagui.update();
	
};
	
public void render(){
	
	actualizarMovimientoCamara();
	actualizarZoomCamara();
	renderizarObjetos();
	renderizarHud();
	

};

public void actualizarZoomCamara(){
	if(logica.zoomcamara==-1){
		camara.alejarzoom();
		logica.zoomcamara=0;
	}
	else if(logica.zoomcamara==1){
		camara.acercarzoom();
		logica.zoomcamara=0;
	}
};

public void resize(int width, int height){
	camara.viewportWidth= (Constantes.ALTODELVISOR/height)*width;
	camara.update();
	camaraparalagui.viewportHeight = Constantes.ANCHODELVISORGUI;
	camaraparalagui.viewportWidth = (Constantes.ALTODELVISORGUI/(float)height)*(float)width;
	camaraparalagui.position.set(camaraparalagui.viewportWidth/2, camaraparalagui.viewportHeight/2, 0);
	camaraparalagui.update();
};

@Override
public void dispose() {
	batch.dispose();
}

private void renderizarObjetos(){
	
	//Objetos
	batch.setProjectionMatrix(camara.combined);
	batch.begin();	
	for(Tierra tierra:logica.gestordeescenario.tierras){
		tierra.render(batch);
	};
	for Transiciontierra transiciontierra:logica.gestordeescenario.transiciontierras){
		transiciontierra.render(batch);
	};
	
	logica.torre.render(batch);
	batch.end();
}

private void actualizarMovimientoCamara(){
	if ((logica.pulsandoW==true)&&(logica.pulsandoS==false)){
		camara.moverCamaraYnegativo();
	}
	if ((logica.pulsandoS==true)&&(logica.pulsandoW==false)){
		camara.moverCamaraYpositivo();
	}
	if ((logica.pulsandoD==true)&&(logica.pulsandoA==false)){
		camara.moverCamaraXnegativo();
	}
	if ((logica.pulsandoA==true)&&(logica.pulsandoD==false)){
		camara.moverCamaraXpositivo();
	}
	else{
		camara.desacelerarCamara();
	}
}

private void renderizarHud(){

	//Gui
	batch.setProjectionMatrix(camaraparalagui.combined);
	batch.begin();
	logica.contenedorhud.render(batch);
	batch.end();	

}


};
