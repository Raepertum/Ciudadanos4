package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Transiciontierra extends Objetodejuego {

private int tipodetransicion;

private TextureRegion textura = null;

//Tipos de transicion

//Tierra y desierto
private TextureRegion transhorizontalmd;
private TextureRegion transverticalmd;
private TextureRegion transhorizontaldm;
private TextureRegion transverticaldm;

//Tierra y piedra
private TextureRegion transhorizontalmp;
private TextureRegion transverticalmp;
private TextureRegion transhorizontalpm;
private TextureRegion transverticalpm;

//Desierto y piedra
private TextureRegion transhorizontaldp;
private TextureRegion transverticaldp;
private TextureRegion transhorizontalpd;
private TextureRegion transverticalpd;



		
		public Transiciontierra(){
			init();
		};
		
		
		private void init(){
			
			
			posicionX = 0f;
			posicionY = 1f;
			dimensionX = 1f;
			dimensionY = 1f;
			
			
/*0*/		transhorizontalmd = Texturasysonidos.texturasysonidos.transiciones.transhorizontalmd;
/*1*/		transverticalmd = Texturasysonidos.texturasysonidos.transiciones.transverticalmd;
/*2*/		transhorizontaldm = Texturasysonidos.texturasysonidos.transiciones.transhorizontaldm;
/*3*/		transverticaldm = Texturasysonidos.texturasysonidos.transiciones.transverticaldm;

			//Tierra y piedra
/*4*/		transhorizontalmp = Texturasysonidos.texturasysonidos.transiciones.transhorizontalmp;
/*5*/		transverticalmp = Texturasysonidos.texturasysonidos.transiciones.transverticalmp;
/*6*/		transhorizontalpm = Texturasysonidos.texturasysonidos.transiciones.transhorizontalpm;
/*7*/		transverticalpm = Texturasysonidos.texturasysonidos.transiciones.transverticalpm;

			//Desierto y piedra
/*8*/		transhorizontaldp = Texturasysonidos.texturasysonidos.transiciones.transhorizontaldp;
/*9*/		transverticaldp = Texturasysonidos.texturasysonidos.transiciones.transverticaldp;
/*10*/		transhorizontalpd = Texturasysonidos.texturasysonidos.transiciones.transhorizontalpd;
/*11*/		transverticalpd = Texturasysonidos.texturasysonidos.transiciones.transverticalpd;
			
}
		
		public void establecertipodetransicion(int tipodetransicion){
			this.tipodetransicion = tipodetransicion;
			switch(tipodetransicion){
			case 0: textura = transhorizontalmd;
				break;
			case 1: textura = transverticalmd;
				break;
			case 2: textura = transhorizontaldm;
				break;
			case 3: textura = transverticaldm;
				break;
			case 4: textura = transhorizontalmp;
				break;
			case 5: textura = transverticalmp;
				break;
			case 6: textura = transhorizontalpm;
				break;
			case 7: textura = transverticalpm;
				break;
			case 8: textura = transhorizontaldp;
				break;
			case 9: textura = transverticaldp;
				break;
			case 10: textura = transhorizontalpd;
				break;
			case 11: textura = transverticalpd;
				break;
			}
			
			
		}
		public int devolvertipodetransicion(){
			return this.tipodetransicion;
		}
		
		
		
		@Override
		public void render(SpriteBatch batch) {
		
			
			batch.draw(textura.getTexture(),posicionX, posicionY-1.5f,origenX,origenY,dimensionX,dimensionY,
					escalaX, escalaY,rotacion,textura.getRegionX(),textura.getRegionY(),
					textura.getRegionWidth(),textura.getRegionHeight(),false,false);
			
			
		}

	}

