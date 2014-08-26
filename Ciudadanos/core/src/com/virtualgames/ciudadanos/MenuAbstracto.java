package com.virtualgames.ciudadanos;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;

public class MenuAbstracto extends Stack{

public TableActualizable crearTabla2(int numerodefilas, int numerodecolumnas, String[] nombresdelascolumnas, String[]nombredelasfilas,
		int[]valoresdelasfilas){
	
	//Instanciamos la tabla actualizable
	TableActualizable tablaactualizable = new TableActualizable();
	
	//Instanciamos la tabla
	Table tabla = new Table();
	
	//Instanciamos el array de labels que se va a actualizar. El número de labels que se va a actualizar es el siguiente:
	//Número de filas menos la primera, por el número de columnas menos la primera, menos el label en blanco
	Label[] arraydelabels = new Label[(numerodefilas-1)*(numerodecolumnas-1)];
	
	//El espacio en blanco nos permite introducir huecos
	LabelStyle estilolabel =  Texturasysonidos.texturasysonidos.estilosyactores.estilolabeldefault;
	Label espacioenblanco = new Label(Variablesdejuego.variablesdejuego.espacioenblanco,estilolabel);
	
	//La altura del espacio en blanco va a venir medida por el número de columnas (Por ahora usaremos un escalar, ya que es lo que se ha venido
	//haciendo
	int alturaespacioenblanco = 37;
	
	//El ancho de la columna viene determinado por el número de columnas
	int anchocolumna = Math.abs(600/numerodecolumnas);
	
	//Vamos a añadir una primera fila, que va a ser la de los nombres de las columnas
	//Para ello añadiremos tantos nombres como columnas haya, pero hay que tener en cuenta que existe el espacio en blanco, que cuenta
	//para el número de columnas, pero no para el número de columnas de datos ni para los nombres de las columnas, así que iteraremos hasta
	//(numero de columnas - 1)
	//Antes únicamente añadiremos el label de espacio en blanco para dejar las cosas bien encuadradas
	
	tabla.add(espacioenblanco).height(alturaespacioenblanco);
	
	for(int i=0;i<numerodecolumnas-1;i++){
	
		
	//Creamos un label que no añadiremos a ninguna parte, puesto que no va a tener que ser actualizado
	Label label = new Label(nombresdelascolumnas[i], estilolabel);
	//Lo alineamos y lo añadimos
	label.setAlignment(1);
	tabla.add(label).width(anchocolumna);    
	}
	
	//Ahora vamos a crear el contenido de cada fila y aquí viene lo espinoso
	//Lo primero es pasar línea
	tabla.row();
	
	//Por cada una de las filas, teniendo en cuenta que la primera fila no cuenta porque sólo contiene el nombre de las columnas
	for (int i=0;i<numerodefilas-1;i++){
		
		//La primera columna lo que va a hacer es poner el nombre
		Label labelconnombredelafila = new Label(nombredelasfilas[i], estilolabel);
		labelconnombredelafila.setAlignment(1);
		tabla.add(labelconnombredelafila).width(anchocolumna);
		
		int limiteinferior = ((numerodecolumnas-1)*i);
		int limitesuperior = ((numerodecolumnas-1)*(i+1)-1);
		
		for (int j=limiteinferior; j<=limitesuperior; j++){
			
			
			Label label = new Label(""+valoresdelasfilas[j],estilolabel);
			label.setAlignment(1);
			tabla.add(label).width(anchocolumna);
			arraydelabels[j]=label;
		}
		
		tabla.row();
	
	}
		

	//Finalmente, asignamos la tabla y la array a la table actualizable
	tablaactualizable.asignartable(tabla);
	tablaactualizable.asignararraydelabels(arraydelabels);
	
	
	return tablaactualizable;
}




};
	
	

	
	

