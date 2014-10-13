package com.virtualgames.ciudadanos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tierra extends Objetodejuego {

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


private String estacion="primavera";


public int fila;
public int columna;

private int tipodetierra;
		

		
		public Tierra(){
			init();
		};
		
		private void init(){
			posicionX = -1f;
			posicionY = -0.5f;
			dimensionX = 1;
			dimensionY = 1;
			
			
			tierrasinabonar = Texturasysonidos.texturasysonidos.tierra.tierrasinabonar;
			tierraflorecida = Texturasysonidos.texturasysonidos.tierra.tierraflorecida;
			tierraseca = Texturasysonidos.texturasysonidos.tierra.tierraseca;
			tierraconcharcos = Texturasysonidos.texturasysonidos.tierra.tierraconcharcos;
			tierranevada = Texturasysonidos.texturasysonidos.tierra.tierranevada;
			
			
			//Nuevo sistema de tierras
			tierramarron = Texturasysonidos.texturasysonidos.tierra.tierramarron;
			desierto = Texturasysonidos.texturasysonidos.tierra.desierto;
			pedregosa = Texturasysonidos.texturasysonidos.tierra.pedregosa;
			
			
			
			textura = tierraflorecida;
		}
		
		
		public void actualizarestacion(String estacion){
			
			/*
			if(estacion!=this.estacion){
				this.estacion=estacion;
			};
		if (estacion=="primavera"){
			textura=tierraflorecida;
		}
		else if(estacion=="verano"){
			textura=tierraseca;
		}
		else if(estacion=="otoño"){
			textura=tierraconcharcos;	
		}
		else if(estacion=="invierno"){
			textura=tierranevada;			
		}	*/	
		};
		
		public void establecertipodedetierra(int tipodetierra){
			
			this.tipodetierra = tipodetierra;
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
		
		public int recuperartipodetierra(){
			return tipodetierra;
		}
		
		
		public void asignarfila(int fila){
			this.fila=fila;
		}
		public void asignarcolumna(int columna){
			this.columna=columna;
		}
		public int recuperarfila(){
			return this.fila;
		}
		public int recuperarcolumna(){
			return this.columna;
		}
		
		
		@Override
		public void render(SpriteBatch batch) {
		
			//Habrá que cambiar esto más adelante, por ahora sólo renderizará una base
			
			batch.draw(textura.getTexture(),posicionX, posicionY-1.5f,origenX,origenY,dimensionX,dimensionY,
					escalaX, escalaY,rotacion,textura.getRegionX(),textura.getRegionY(),
					textura.getRegionWidth(),textura.getRegionHeight(),false,false);
			
		}

	}

