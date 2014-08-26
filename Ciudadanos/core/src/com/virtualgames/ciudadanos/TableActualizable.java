package com.virtualgames.ciudadanos;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TableActualizable {

	Table table;
	Label[] label;


public void asignartable(Table table){
this.table = table;
}

public void asignararraydelabels(Label[] label)
{
this.label = label;	
}

public Table devolverTable(){
	return this.table;
}
public Label[] devolverarraydelabels(){
	return this.label;
}


}
