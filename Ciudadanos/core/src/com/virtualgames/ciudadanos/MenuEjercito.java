package com.virtualgames.ciudadanos;



	import java.util.List;

	import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

	public class MenuEjercito extends MenuAbstracto{
		
		//Tablas. La table de fondo sólo contiene la imagen de fondo.
		//La table de texto contiene los nombres y la información
		//La table de botones (Si es que no se añaden los botones a la table de texto)
		//contiene los botones
		
		Table tabledefondo;
		Table tabledeinformacion;
		Table tabledealmacenes;
		//La table de dentro del scrollpane
		Table tabledescrollpanealmacenes;
		Table tabledebotones;
		Table tabledeordenes;
		
		//Instancias de las imágenes (Una para el fondo, el resto para los iconos)	
		Image fondomenualmacen;
		Image iconoalmacen;
		
		
		//Arrays de labels que contienen texto
		Label[] arraydelabelsstring;
		
		//Array de labels que contienen variables
		Label[] arraydelabelsvars;
			
		//Estilos: Para no tener que estar escribiendo desde el principio
		LabelStyle estilolabel;
		TextButtonStyle estilobotontexto;
		ScrollPaneStyle estiloscrollpane;
		
		//Botones de la table de botones
		TextButton Informacion;
		TextButton Almacenes;
		TextButton Ordenes;
		
		//Botones de la table de órdenes
		TextButton Ordenesbasicas;
		TextButton Ordenesavanzadas;
		TextButton Ordenesmaestras;
		
		//Scrollpane de la tabla de almacenes
		ScrollPane scrollpanealmacenes;
		
		//Ancho columnas
		int anchocolumnas = 80;
			
		public MenuEjercito(){

		//Creamos las nuevas tables	
		tabledefondo = new Table();
		tabledeinformacion = new Table();
		tabledealmacenes = new Table();
		tabledebotones = new Table();
		tabledeordenes = new Table();
		tabledescrollpanealmacenes = new Table();
		
		//Posicionamos y definimos el tamaño del stack
		this.setPosition(30,30);
		this.setSize(740, 540);
		
		//Añadimos las tables en el orden correcto
		this.add(tabledefondo);
		this.add(tabledeinformacion);
		this.add(tabledealmacenes);
		this.add(tabledebotones);
		this.add(tabledeordenes);
		
		//Vamos instanciando y añadiendo los objetos (Puede que más tarde, por razones de rendimiento
	    //se pasen todos a la clase de texturasysonidos)
		
		//El fondo
		fondomenualmacen = new Image(Texturasysonidos.texturasysonidos.estilosyactores.fondoMenuAlmacen);
		
	    //Imágenes que se ponen dentro de los menús
	    iconoalmacen = new Image(Texturasysonidos.texturasysonidos.estilosyactores.edificioalmacenmenu);
	    
	    //Los estilos
	    estilolabel = Texturasysonidos.texturasysonidos.estilosyactores.estilolabeldefault;
	    estilobotontexto = Texturasysonidos.texturasysonidos.estilosyactores.estilobotondefault;
	    estiloscrollpane = Texturasysonidos.texturasysonidos.estilosyactores.estiloscrollpanedefault;
	    
	    //Para dejar espacios
	   	Label espacioenblanco = new Label(Variablesdejuego.variablesdejuego.espacioenblanco,estilolabel);
	   	
	    //El título
	   	Label titulo = new Label(Variablesdejuego.variablesdejuego.ejercito.titulo,estilolabel);
	   	
	    
	    
	    //Creamos los botones para la table de botones
	  	Informacion = new TextButton("Información", estilobotontexto);
	  	Almacenes = new TextButton("Almacenes", estilobotontexto);
	  	Ordenes = new TextButton("Órdenes", estilobotontexto);
	    
	  	//Creamos los botones para la table de órdenes
	  	Ordenesbasicas = new TextButton("Órdenes Básicas", estilobotontexto);
	  	Ordenesavanzadas = new TextButton("Órdenes Avanzadas", estilobotontexto);
	  	Ordenesmaestras = new TextButton("Órdenes Maestras", estilobotontexto);
	  	
	  	//Creamos el scroll pane para la tabla de almacenes
	  	scrollpanealmacenes = new ScrollPane(tabledescrollpanealmacenes, estiloscrollpane);
	  	
	    //El array de labels
	    arraydelabelsstring = new Label[64];
	   
	    //Las tablas
	    
	    //Empezamos por arriba a la izquierda, y establecemos los márgenes
	   	
	    //Table de fondo
	    tabledefondo.left().top();
	    tabledefondo.padLeft(20);
	    tabledefondo.padTop(20);
	    
	    //Table de información
	    tabledeinformacion.left().top();
	   	tabledeinformacion.padLeft(20);
	   	tabledeinformacion.padTop(20);
	   	
	   	//Tabla de almacenes
	   	tabledealmacenes.left().top();
	   	tabledealmacenes.padLeft(20);
	   	tabledealmacenes.padTop(20);
	   	tabledealmacenes.setVisible(false);
	   	
	   	//Tabla de órdenes
	   	tabledeordenes.center();
	   	tabledeordenes.padLeft(20);
	   	tabledeordenes.padTop(20);
	   	tabledeordenes.setVisible(false);
	   	
	   	//Tabla de título y botones
	   	tabledebotones.left().top();
	   	tabledebotones.padLeft(60);
	   	tabledebotones.padTop(60);
	   	
	   	//Añadimos el fondo
	   	tabledefondo.add(fondomenualmacen);
	   	
	   
	    //La tabla de botones
	    //Los botones
	   	tabledebotones.add(titulo);
	   	tabledebotones.add(Informacion).padLeft(50);
	    tabledebotones.add(Almacenes).padLeft(50);
	    tabledebotones.add(Ordenes).padLeft(50);
	    
	    //Las funciones de los botones
	    Informacion.addListener(new ClickListener() {
	        public void clicked(InputEvent event, float x, float y) {
	            tabledeinformacion.setVisible(true);     
	        	tabledealmacenes.setVisible(false);  
	        	tabledeordenes.setVisible(false);
	        };
	  		});
	    Almacenes.addListener(new ClickListener(){
	    	public void clicked(InputEvent event, float x, float y){
	    		tabledeinformacion.setVisible(false);
	    		tabledealmacenes.setVisible(true);
	    		tabledeordenes.setVisible(false);
	    	}
	    });
	    Ordenes.addListener(new ClickListener(){
	    	public void clicked(InputEvent event, float x, float y){
	    		tabledeinformacion.setVisible(false);
	    		tabledealmacenes.setVisible(false);
	    		tabledeordenes.setVisible(true);
	    	}
	    });
	  	
	   
	   /*	
	   	
	    //Los labels de la tabla de información   
	    
	    //Empezamos por la izquierda
	   	tabledeinformacion.left();
	    
	   	//Los strings y los ints se van alternando
	   	tabledeinformacion.row();
	   	for(int i=1; i<10; i++){
	    Label label = new Label(Variablesdejuego.variablesdejuego.almacen.stringsdealmacenalimentos[i],estilolabel);
	    label.setAlignment(1);
	    tabledeinformacion.add(label).width(anchocolumnas);
	    }
	    
		//Trigo
	    tabledeinformacion.row().height(60);
	    Label label = new Label(Variablesdejuego.variablesdejuego.almacen.stringsdealmacenalimentos[10],estilolabel);
	    label.setAlignment(1);
	    tabledeinformacion.add(label).width(anchocolumnas);
	    
	    //Las ints del trigo
	    for(int i=0; i<8; i++){
	    Label label2 = new Label(""+Variablesdejuego.variablesdejuego.almacen.intsdealmacenalimentos[i],estilolabel);
	    label2.setAlignment(1);
	    tabledeinformacion.add(label2).width(anchocolumnas);
	    }
	    
	    //Fruta
	    tabledeinformacion.row().height(60);
	    Label label3 = new Label(Variablesdejuego.variablesdejuego.almacen.stringsdealmacenalimentos[11],estilolabel);
	    label3.setAlignment(1);
	    tabledeinformacion.add(label3).width(anchocolumnas);
	    
	    //Las ints de la fruta
	    for(int i=8; i<16; i++){
	    Label label4 = new Label(""+Variablesdejuego.variablesdejuego.almacen.intsdealmacenalimentos[i],estilolabel);
	    label4.setAlignment(1);
	    tabledeinformacion.add(label4).width(anchocolumnas);
	    }
	    
	    //Carne
	    tabledeinformacion.row().height(60);
	    Label label5 = new Label(Variablesdejuego.variablesdejuego.almacen.stringsdealmacenalimentos[12],estilolabel);
	    label5.setAlignment(1);
	    tabledeinformacion.add(label5).width(anchocolumnas);
	    
	    //Las ints de la carne
	    for(int i=16; i<24; i++){
	    Label label6 = new Label(""+Variablesdejuego.variablesdejuego.almacen.intsdealmacenalimentos[i],estilolabel);
	    label6.setAlignment(1);
	    tabledeinformacion.add(label6).width(anchocolumnas);
	    }
	    
	    //Carne salada
	    
	    tabledeinformacion.row().height(60);
	    Label label7 = new Label(Variablesdejuego.variablesdejuego.almacen.stringsdealmacenalimentos[13],estilolabel);
	    label7.setAlignment(1);
	    tabledeinformacion.add(label7).width(anchocolumnas);
	   
	    
	    //Las ints de la carne salada
	    
	    for(int i=24; i<32; i++){
	    Label label8 = new Label(""+Variablesdejuego.variablesdejuego.almacen.intsdealmacenalimentos[i],estilolabel);
	    label8.setAlignment(1);
	    tabledeinformacion.add(label8).width(anchocolumnas);
	    
	    }
	    
	    //Pescado
	    
	    tabledeinformacion.row().height(60);
	    Label label9 = new Label(Variablesdejuego.variablesdejuego.almacen.stringsdealmacenalimentos[13],estilolabel);
	    label9.setAlignment(1);
	    tabledeinformacion.add(label9).width(anchocolumnas);
	   
	    
	    //Las ints del pescado
	    
	    for(int i=32; i<40; i++){
	    Label label10 = new Label(""+Variablesdejuego.variablesdejuego.almacen.intsdealmacenalimentos[i],estilolabel);
	    label10.setAlignment(1);
	    tabledeinformacion.add(label10).width(anchocolumnas);
	        }
	    
	    //Miel
	    
	    tabledeinformacion.row().height(60);
	    Label label11 = new Label(Variablesdejuego.variablesdejuego.almacen.stringsdealmacenalimentos[13],estilolabel);
	    label11.setAlignment(1);
	    tabledeinformacion.add(label11).width(anchocolumnas);
	   
	    
	    //Las ints de la miel
	    
	    for(int i=40; i<48; i++){
	    Label label12 = new Label(""+Variablesdejuego.variablesdejuego.almacen.intsdealmacenalimentos[i],estilolabel);
	    label12.setAlignment(1);
	    tabledeinformacion.add(label12).width(anchocolumnas);
	    }
	    
	   
	    //La tabla de almacenes
	    
	   Image iconoalmacen2;
	    iconoalmacen2 = new Image(Texturasysonidos.texturasysonidos.estilosyactores.edificioalmacenmenu);
	    Image iconoalmacen3;
	    iconoalmacen3 = new Image(Texturasysonidos.texturasysonidos.estilosyactores.edificioalmacenmenu);
	    Image iconoalmacen4;
	    iconoalmacen4 = new Image(Texturasysonidos.texturasysonidos.estilosyactores.edificioalmacenmenu);
	    Image iconoalmacen5;
	    iconoalmacen5 = new Image(Texturasysonidos.texturasysonidos.estilosyactores.edificioalmacenmenu);
	    Image iconoalmacen6;
	    iconoalmacen6 = new Image(Texturasysonidos.texturasysonidos.estilosyactores.edificioalmacenmenu);
	    Image iconoalmacen7;
	    iconoalmacen7 = new Image(Texturasysonidos.texturasysonidos.estilosyactores.edificioalmacenmenu);
	    
	    tabledescrollpanealmacenes.add(iconoalmacen2);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen3);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen4);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen5);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen6);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen7);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen);
	    tabledescrollpanealmacenes.row();
	    tabledescrollpanealmacenes.add(iconoalmacen);
	   
	    scrollpanealmacenes.size(200, 300);
	    scrollpanealmacenes.setOverscroll(false, false);
	    tabledealmacenes.add(scrollpanealmacenes);
	    
	   
	    
	    //La tabla de órdenes
	    
	    tabledeordenes.add(espacioenblanco).row().height(20).padTop(20).size(600,40);
	    tabledeordenes.add(Ordenesbasicas).row().height(20).padTop(20).size(600,40);
	    tabledeordenes.add(Ordenesavanzadas).row().height(20).padTop(20).size(600,40);
	    tabledeordenes.add(Ordenesmaestras).row().height(20).padTop(20).size(600,40);
	    
	    
	    */
	    
	 }  

	public void act(float deltatime){
		scrollpanealmacenes.act(deltatime);
	}
		
	}

