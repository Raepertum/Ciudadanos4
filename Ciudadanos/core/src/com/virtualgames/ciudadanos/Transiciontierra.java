package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Transiciontierra extends Objetodejuego {


private TextureRegion tierrasinabonar;

private TextureRegion tierraflorecida;
private TextureRegion tierraseca;
private TextureRegion tierraconcharcos;
private TextureRegion tierranevada;
private TextureRegion textura = null;

//Nuevo sistema de texturas
private TextureRegion tierramarron;
private TextureRegion desierto;
private TextureRegion pedregosa;

//Tipos de transicion

//Tierra y desierto
private TextureRegion transhorizontaltd;
private TextureRegion transverticaltd;
private TextureRegion transhorizontaldt;
private TextureRegion transverticaldt;

//Tierra y piedra
private TextureRegion transhorizontaltp;
private TextureRegion transverticaltp;
private TextureRegion transhorizontalpt;
private TextureRegion transverticalpt;

//Desierto y piedra
private TextureRegion transhorizontaldp;
private TextureRegion transverticaldp;
private TextureRegion transhorizontalpd;
private TextureRegion transverticalpd;


private String estacion="primavera";

		

		
		public Transiciontierra(){
			init();
		};
		
		
		private void init(){
			posicionX = -1f;
			posicionY = -0.1f;
			dimensionX = 1;
			dimensionY = 1;
			
			transhorizontaltd = Texturasysonidos.texturasysonidos.transiciones.transhorizontaltd;
			transverticaltd = Texturasysonidos.texturasysonidos.transiciones.transverticaltd;
			transhorizontaldt = Texturasysonidos.texturasysonidos.transiciones.transhorizontaldt;
			transverticaldt = Texturasysonidos.texturasysonidos.transiciones.transverticaldt;

			//Tierra y piedra
			transhorizontaltp = Texturasysonidos.texturasysonidos.transiciones.transhorizontaltp;
			transverticaltp = Texturasysonidos.texturasysonidos.transiciones.transverticaltp;
			transhorizontalpt = Texturasysonidos.texturasysonidos.transiciones.transhorizontalpt;
			transverticalpt = Texturasysonidos.texturasysonidos.transiciones.transverticalpt;

			//Desierto y piedra
			transhorizontaldp = Texturasysonidos.texturasysonidos.transiciones.transhorizontaldp;
			transverticaldp = Texturasysonidos.texturasysonidos.transiciones.transverticaldp;
			transhorizontalpd = Texturasysonidos.texturasysonidos.transiciones.transhorizontalpd;
			transverticalpd = Texturasysonidos.texturasysonidos.transiciones.transverticalpd;
			
			
			
			
			textura = tierraflorecida;
		}
		
		
		public void actualizarestacion(String estacion){
			
		};
		
		public void establecertipodedetierra(int tipodetierra){
			
			if(tipodetierra==0){
				//Tierra marrón
				textura=tierramarron;
			}
			else if(tipodetierra==1){
				//Desierto
				textura=desierto;
			}
			else if(tipodetierra==2){
				//Pedregal
				textura=pedregosa;
			}	
		};
		
		
		@Override
		public void render(SpriteBatch batch) {
		
			//Habrá que cambiar esto más adelante, por ahora sólo renderizará una base
			
			//Dibujamos una base
			batch.draw(textura.getTexture(),posicionX, posicionY-1.5f,origenX,origenY,dimensionX,dimensionY,
					escalaX, escalaY,rotacion,textura.getRegionX(),textura.getRegionY(),
					textura.getRegionWidth(),textura.getRegionHeight(),false,false);
			
		}

	}

