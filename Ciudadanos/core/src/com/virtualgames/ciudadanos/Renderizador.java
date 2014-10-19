package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Renderizador implements Disposable{
	
	private Camara camara;
	private OrthographicCamera camaraparalagui;
	private Viewport viewportgui;
	private Viewport viewport;
	private SpriteBatch batch;
	private Logica logica;
	
	
public Renderizador(Logica logica){
	this.logica = logica;
	iniciarclase();
	
}

private void iniciarclase(){
	batch = new SpriteBatch();
	camara = new Camara();
	//camara.update();
	camaraparalagui = new OrthographicCamera();
	viewportgui = new FitViewport(Constantes.ANCHODELVISORGUI,Constantes.ALTODELVISORGUI,camaraparalagui);
	viewport = new FitViewport(Constantes.ANCHODELVISOR,Constantes.ALTODELVISOR,camara);
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
	viewport.update(width, height);
	viewportgui.update(width, height);
	camara.position.x=viewport.getWorldWidth()/2;
	camara.position.y=viewport.getWorldHeight()/2;
	camaraparalagui.position.set(camaraparalagui.viewportWidth/2, camaraparalagui.viewportHeight/2, 0);
	logica.resize(viewportgui);
	camara.update();
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
	/*for (Transiciontierra transiciontierra:logica.gestordeescenario.transiciontierras){
		transiciontierra.render(batch);
	};*/
	for (Agua agua:logica.gestordeescenario.aguas){
		agua.render(batch);
	}
	
	//logica.torre.render(batch);
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
