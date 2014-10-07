package com.virtualgames.ciudadanos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;

public class Texturasysonidos implements Disposable, AssetErrorListener{

	//Para gestionar los archivos y recoger errores y excepciones
	private AssetManager assetmanager;
	public static final Texturasysonidos texturasysonidos = new Texturasysonidos();
	
	//Para que s�lo se pueda instanciar una vez
	private Texturasysonidos(){};
	
	//Para los objetos de juego
	TextureAtlas atlasdetodaslastexturas;
	
	//Para el gui
	TextureAtlas atlasdetexturasdelgui;
	
	//Las fuentes
	public Fuentes fuentes;	
	//La Torre
	public TorreGrafica torre;
	//La tierra (Y el campo m�s adelante)
	public TierraGrafica tierra;
	//Las transiciones entre tierras
	public Transiciones transiciones;
	//Los botones del juego
	public BotonesGrafica botones;
	//Estilos y actores
	public Estilosyactores estilosyactores;
	
	
	
	public void init(AssetManager assetmanager){
		this.assetmanager = assetmanager;
		assetmanager.setErrorListener(this);
		
		assetmanager.load(Constantes.TEXTURE_ATLAS, TextureAtlas.class);
		assetmanager.load(Constantes.TEXTURE_ATLAS_GUI, TextureAtlas.class);
		assetmanager.finishLoading();
		
	atlasdetodaslastexturas = assetmanager.get(Constantes.TEXTURE_ATLAS);
	for (Texture t : atlasdetodaslastexturas.getTextures())
		t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	atlasdetexturasdelgui = assetmanager.get(Constantes.TEXTURE_ATLAS_GUI);
	for (Texture t : atlasdetexturasdelgui.getTextures())
		t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
	
	
	//Cada vez que creemos un nuevo objeto, hay que registrar aqu� los gr�ficos
	
	fuentes = new Fuentes();
	torre = new TorreGrafica(atlasdetodaslastexturas);
	transiciones = new Transiciones(atlasdetodaslastexturas);
	tierra = new TierraGrafica(atlasdetodaslastexturas);
	botones = new BotonesGrafica(atlasdetodaslastexturas);
	
	estilosyactores = new Estilosyactores();
	
	
	}
	
	@Override
	public void error(AssetDescriptor arg0, Throwable arg1) {
		System.out.println("No se ha podido cargar la textura");
	}

	@Override
	public void dispose() {
		assetmanager.dispose();
		fuentes.ComicBlanca.dispose();
		fuentes.ComicNegra.dispose();
		
	}
	
	
		
    public class Estilosyactores{
		
    	//La skin com�n a todos los widgets
    	public Skin skindelgui;
    	public TextButtonStyle estilobotondefault;
    	public LabelStyle estilolabeldefault;
    	public ScrollPaneStyle estiloscrollpanedefault;
    	
    	//Necesitas dos variables por cada estado de un widget, la texture region y la texture region drawable
    	public TextureRegion textureregionbotonarriba;
    	public TextureRegion textureregionbotonsobre;
    	public TextureRegion textureregionbotonabajo;
    	private TextureRegionDrawable textureregiondrawablebotonarriba;
    	private TextureRegionDrawable textureregiondrawablebotonsobre;
    	private TextureRegionDrawable textureregiondrawablebotonabajo;
    	
    	
    	//Las im�genes que se emplean para los fondos de los men�s
    	public TextureRegion fondoMenuAlmacen;
    	public TextureRegion fondoEvento;
    	
    	//Las im�genes que se emplean dentro de los men�s
    	public TextureRegion edificioalmacenmenu;
    	
    	
    	public Estilosyactores(){
    		//Inicializaci�n de variables
    		skindelgui = new Skin();
    		estilobotondefault = new TextButtonStyle();
    		estilolabeldefault = new LabelStyle();
    		estiloscrollpanedefault = new ScrollPaneStyle();
    		
    		//A�adir todas las texturas que vayan a formar parte del gui
    		skindelgui.addRegions(Texturasysonidos.texturasysonidos.atlasdetexturasdelgui);
    		//A�adir todas las fuentes que vayan a formar parte del gui
    		skindelgui.add("arial-15", Texturasysonidos.texturasysonidos.fuentes.Arial15);
    		skindelgui.add("comicb", Texturasysonidos.texturasysonidos.fuentes.ComicBlanca);
    		skindelgui.add("comicn", Texturasysonidos.texturasysonidos.fuentes.ComicNegra);
    		
    		//Para los fondos
    		fondoMenuAlmacen = skindelgui.get("fondomenualmacen", TextureRegion.class);
    		fondoEvento = skindelgui.get("fondoevento", TextureRegion.class);
    		
    		//Para las im�genes que se emplean dentro de los men�s
    		edificioalmacenmenu = skindelgui.get("EdificioAlmacen", TextureRegion.class);
    		
    		//Para los widget tipo bot�n
    		//Necesitas una textureregion
    		textureregionbotonarriba = skindelgui.get("botonnopresionado",TextureRegion.class);
    		textureregionbotonsobre = skindelgui.get("botonsobre",TextureRegion.class);
    		textureregionbotonabajo = skindelgui.get("botonpresionado",TextureRegion.class);
    		
    		//Necesitas una textureregiondrawable
    		textureregiondrawablebotonarriba = new TextureRegionDrawable(textureregionbotonarriba);
    		textureregiondrawablebotonsobre = new TextureRegionDrawable(textureregionbotonsobre);    		
    		textureregiondrawablebotonabajo = new TextureRegionDrawable(textureregionbotonabajo);
    		    		
    		//Definir el estilo del label
    		estilolabeldefault.font = skindelgui.getFont("arial-15");
    		   		
    		//Definir el estilo del bot�n
    		estilobotondefault.font = skindelgui.getFont("arial-15");
    		estilobotondefault.up = skindelgui.newDrawable(skindelgui.newDrawable(textureregiondrawablebotonarriba));
    		estilobotondefault.over = skindelgui.newDrawable(skindelgui.newDrawable(textureregiondrawablebotonsobre));
    		estilobotondefault.down = skindelgui.newDrawable(skindelgui.newDrawable(textureregiondrawablebotonabajo));
    		
    		//Definir el estilo del scrollpane
    		estiloscrollpanedefault.background = estilobotondefault.up;
    		estiloscrollpanedefault.corner = estilobotondefault.up;
    		estiloscrollpanedefault.hScroll = estilobotondefault.up;
    		estiloscrollpanedefault.hScrollKnob = estilobotondefault.up;
    		estiloscrollpanedefault.vScroll = estilobotondefault.up;
    		estiloscrollpanedefault.vScrollKnob = estilobotondefault.up;
    		
    		//A�adir a la skin (Aunque creo que esto no es necesario)
    		skindelgui.add("defaultlabel", estilolabeldefault);
    		skindelgui.add("defaultboton", estilobotondefault);
    		
    		//Las im�genes del men�
    		
    	}    	
	};
	
	public class Fuentes{
		public final BitmapFont ComicNegra;
		public final BitmapFont ComicBlanca;
		public final BitmapFont Arial15;
		
		public Fuentes(){
			ComicNegra=new BitmapFont(Gdx.files.internal("Fuentes/ComicBlack.fnt"),false);
			ComicBlanca=new BitmapFont(Gdx.files.internal("Fuentes/ComicWhite.fnt"),false);
			Arial15 = new BitmapFont(Gdx.files.internal("Fuentes/arial-15.fnt"),false);
			
			//Escala
			ComicNegra.setScale(1f);
			ComicBlanca.setScale(1f);
			//Filtro
			ComicBlanca.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			ComicNegra.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
	}
	
	
	public class TorreGrafica{
		public final AtlasRegion base;
		public final AtlasRegion medio;
		public final AtlasRegion copa;
		
		public TorreGrafica(TextureAtlas atlas){
			base = atlas.findRegion("Base");
			copa = atlas.findRegion("Copa");
			medio = atlas.findRegion("Medio");
		}
	}
	public class TierraGrafica{
		public final AtlasRegion tierrasinabonar;
		public final AtlasRegion tierraflorecida;
		public final AtlasRegion tierraseca;
		public final AtlasRegion tierraconcharcos;
		public final AtlasRegion tierranevada;
		
		
		//Nuevo sistema de tierras
		public final AtlasRegion tierramarron;
		public final AtlasRegion desierto;
		public final AtlasRegion pedregosa;
		
		
		
		
		public TierraGrafica(TextureAtlas atlas){
			tierrasinabonar = atlas.findRegion("tierra");
			tierraflorecida = atlas.findRegion("tierraflorecida");
			tierraseca = atlas.findRegion("tierraseca");
			tierraconcharcos = atlas.findRegion("tierraconcharcos");
			tierranevada = atlas.findRegion("tierranevada");
			
			//Nuevo sistema de tierras
			tierramarron = atlas.findRegion("tierramarron");
			desierto = atlas.findRegion("desierto");
			pedregosa = atlas.findRegion("pedregosa");
		
			
		}
	}
	public class BotonesGrafica{
		public final AtlasRegion botoncomercio;
		public final AtlasRegion botoncomerciosobre;
		public final AtlasRegion botoncomerciopulsado;
		public final AtlasRegion botonespionaje;
		public final AtlasRegion botonespionajesobre;
		public final AtlasRegion botonespionajepulsado;
	    public final AtlasRegion botoneventos;
		public final AtlasRegion botoneventossobre;
		public final AtlasRegion botoneventospulsado;
		public final AtlasRegion botonsocial;
		public final AtlasRegion botonsocialsobre;
		public final AtlasRegion botonsocialpulsado;
		public final AtlasRegion botonalmacen;
		public final AtlasRegion botonalmacensobre;
		public final AtlasRegion botonalmacenpulsado;
		public final AtlasRegion botonejercito;
		public final AtlasRegion botonejercitosobre;
		public final AtlasRegion botonejercitopulsado;
		
		public BotonesGrafica(TextureAtlas atlas){
			botoncomercio = atlas.findRegion("BotonComercio");
			botoncomerciosobre = atlas.findRegion("BotonComercioSobre");
			botoncomerciopulsado = atlas.findRegion("BotonComercioPulsado");
			botonespionaje = atlas.findRegion("BotonEspionaje");
			botonespionajesobre = atlas.findRegion("BotonEspionajeSobre");
			botonespionajepulsado = atlas.findRegion("BotonEspionajePulsado");
			botoneventos = atlas.findRegion("BotonEventos");
			botoneventossobre = atlas.findRegion("BotonEventosSobre");
			botoneventospulsado = atlas.findRegion("BotonEventosPulsado");
			botonsocial = atlas.findRegion("BotonSocial");
			botonsocialsobre = atlas.findRegion("BotonSocialSobre");
			botonsocialpulsado = atlas.findRegion("BotonSocialPulsado");
			botonalmacen = atlas.findRegion("botonalmacen");
			botonalmacensobre = atlas.findRegion("BotonAlmacenSobre");
			botonalmacenpulsado = atlas.findRegion("BotonAlmacenPulsado");
			botonejercito = atlas.findRegion("BotonEjercito");
			botonejercitosobre = atlas.findRegion("BotonEjercitoSobre");
			botonejercitopulsado = atlas.findRegion("BotonEjercitoPulsado");			
		};
		
	}
	
	public class Transiciones{
		
		public final AtlasRegion transhorizontalmd;
		public final AtlasRegion transverticalmd;
		public final AtlasRegion transhorizontaldm;
		public final AtlasRegion transverticaldm;
		public final AtlasRegion transhorizontalmp;
		public final AtlasRegion transverticalmp;
	    public final AtlasRegion transhorizontalpm;
		public final AtlasRegion transverticalpm;
		public final AtlasRegion transhorizontaldp;
		public final AtlasRegion transverticaldp;
		public final AtlasRegion transhorizontalpd;
		public final AtlasRegion transverticalpd;
		
		public Transiciones(TextureAtlas atlas){
		
			transhorizontalmd = atlas.findRegion("transhorizontalmd");
			transverticalmd = atlas.findRegion("transverticalmd");
			transhorizontaldm = atlas.findRegion("transhorizontaldm");
			transverticaldm = atlas.findRegion("transverticaldm");
			transhorizontalmp = atlas.findRegion("transhorizontalmp");
			transverticalmp = atlas.findRegion("transverticalmp");
		    transhorizontalpm = atlas.findRegion("transhorizontalpm");
			transverticalpm = atlas.findRegion("transverticalpm");
			transhorizontaldp = atlas.findRegion("transhorizontaldp");
			transverticaldp = atlas.findRegion("transverticaldp");
			transhorizontalpd = atlas.findRegion("transhorizontalpd");
			transverticalpd = atlas.findRegion("transverticalpd");
			
		}
		
	}
};
	

