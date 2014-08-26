package com.virtualgames.ciudadanos;

public class Eventosymenu {

public static final Eventosymenu eventosymenu = new Eventosymenu();

//Aquí vamos a ir reuniendo instancias de cada uno de los menús y eventos, inicializándolos y dotándolos
//de los parámetros necesarios en el caso de los eventos

MenuAlmacen menualmacen = new MenuAlmacen();
MenuEjercito menuejercito = new MenuEjercito();
MenuComercio menucomercio = new MenuComercio();
MenuEspionaje menuespionaje = new MenuEspionaje();
MenuSocial menusocial = new MenuSocial();

//También contiene la variable menúvisible, para controlar si existe algún menú abierto y cuál es
MenuAbstracto menuvisible;

private Eventosymenu(){
	menuvisible = null;
}

public void SetMenu(MenuAbstracto menu){
	menuvisible = menu;
};
public MenuAbstracto GetMenu(){
	return menuvisible;
};




}
