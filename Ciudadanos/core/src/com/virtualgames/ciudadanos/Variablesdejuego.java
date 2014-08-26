package com.virtualgames.ciudadanos;

public class Variablesdejuego {

public static final Variablesdejuego variablesdejuego = new Variablesdejuego();	
	
//Tipos de variables provisionales. En muchos casos, lo más sensato será crear vectores
	
Almacen almacen = new Almacen();
Comercio comercio = new Comercio();
Ejercito ejercito = new Ejercito();
Espionaje espionaje = new Espionaje();
Social social = new Social();

String espacioenblanco = "";

public class Almacen{

	//Variables para almacen
	//PM: Producción mensual
	//GM: Gasto mensual
	//NM: Neto mensual
	//PA: Producción anual
	//GA: Gasto anual
	//NA: Neto anual
	//RE: Reservas
	//CP: Próxima caducidad
	
//ALMACÉN

String titulo = "ALMACÉN";

String[] nombreslabelsalmacencaducablesmes;
String[] nombreslabelsalmacencaducablesano;
String[] nombreslabelsalmacencaducablestotal;
String[] nombreslabelsalmacennocaducablesmes;
String[] nombreslabelsalmacennocaducablesano;
String[] nombreslabelsalmacennocaducablestotal;

String [] stringsdealmacenalimentos;
int[] intsdealmacenalimentosmes;
int[] intsdealmacenalimentosano;
int[] intsdealmacenalimentostotal;
String [] stringsdealmacenmatprimas;
int[] intsdealmacenmatprimasmes;
int[] intsdealmacenmatprimasano;
int[] intsdealmacenmatprimastotal;
String [] stringsdealmacenarmas;
int[] intsdealmacenarmasmes;
int[] intsdealmacenarmasano;
int[] intsdealmacenarmastotal;
String [] stringsdealmacenartesania;
int[] intsdealmacenartesaniames;
int[] intsdealmacenartesaniaano;
int[] intsdealmacenartesaniatotal;
String [] stringsdealmacenbieneslujo;
int[] intsdealmacenbieneslujomes;
int[] intsdealmacenbieneslujoano;
int[] intsdealmacenbieneslujototal;
	

//Trigo en almacén (8 cada una: PM, GM, NM, PA, GA, NA, RE, CP)
//Fruta en almacén
//Carne en almacén
//Carne salada en almacén
//Pescado en almacén
//Miel en almacén

public Almacen(){
	
	
	//Labels de almacén de productos que pueden caducar
	nombreslabelsalmacencaducablesmes = new String[]{"Producción mes", "Gasto mes", "Caducidad mes", "Neto mes","Reservas"};
	nombreslabelsalmacencaducablesano = new String[]{"Producción año", "Gasto año", "Caducidad año", "Neto año", "Reservas"};
	nombreslabelsalmacencaducablestotal = new String[]{"Producción total","Gasto total", "Caducidad total", "Neto total", "Reservas"};
	
	//Labels de almacén de productos que no caducan
	nombreslabelsalmacennocaducablesmes = new String[]{"Producción mes", "Gasto mes", "Neto mes", "Reservas"};
	nombreslabelsalmacennocaducablesano = new String[]{"Producción año", "Gasto año", "Neto año", "Reservas"};
	nombreslabelsalmacennocaducablestotal = new String[]{"Producción total", "Gasto total", "Neto total","Reservas"};
	
    //Alimentos
	stringsdealmacenalimentos = new String[]{"Trigo", "Fruta", "Carne", "Carne sal.", "Pescado", "Miel"};
	
	
	intsdealmacenalimentosmes = new int[25];
	for (int i=0; i<25; i++){
		intsdealmacenalimentosmes[i] = 0;
	}
	intsdealmacenalimentosano = new int[25];
	for (int i=0; i<25; i++){
		intsdealmacenalimentosano[i] = 0;
	}
	intsdealmacenalimentostotal = new int[25];
	for (int i=0; i<25; i++){
		intsdealmacenalimentostotal[i] = 0;
	}
	
	//Materias Primas
	stringsdealmacenmatprimas = new String[]{"Sal", "Madera", "Piedra", "Hierro", "Cobre", "Estaño", "Plata",
			"Oro", "Mercurio", "Azufre"};
	
	intsdealmacenmatprimasmes = new int[32];
	for (int i=0; i<32; i++){
		intsdealmacenmatprimasmes[i] = 0;
	}
	intsdealmacenmatprimasano = new int[32];
	for (int i=0; i<32; i++){
		intsdealmacenmatprimasano[i] = 0;
	}
	intsdealmacenmatprimastotal = new int[32];
	for (int i=0; i<32; i++){
		intsdealmacenmatprimastotal[i] = 0;
	}
	//Armas
	stringsdealmacenarmas = new String[]{"Espadas", "Hachas", "Arcos", "Lanzas", "Mazos", "Cetros",
			"Armad. cuero", "Armad. hierro"};
	
	intsdealmacenarmasmes = new int[28];
	for (int i=0; i<28; i++){
		intsdealmacenarmasmes[i] = 0;
	}
	intsdealmacenarmasano = new int[28];
	for (int i=0; i<28; i++){
		intsdealmacenarmasano[i] = 0;
	}
	intsdealmacenarmastotal = new int[28];
	for (int i=0; i<28; i++){
		intsdealmacenarmastotal[i] = 0;
	}
	
	//Artesanía
	stringsdealmacenartesania = new String[]{"Ropa", "Alfarería", "Cristalería", "Herramientas", "Instrumentos"};
	
    intsdealmacenartesaniames = new int[20];
	for (int i=0; i<20; i++){
		intsdealmacenartesaniames[i] = 0;
	}
	intsdealmacenartesaniaano = new int[20];
	for (int i=0; i<20; i++){
		intsdealmacenartesaniaano[i] = 0;
	}
	intsdealmacenartesaniatotal = new int[20];
	for (int i=0; i<20; i++){
		intsdealmacenartesaniatotal[i] = 0;
	}
    
	
	//Bienes de lujo
	stringsdealmacenbieneslujo = new String[]{"Joyería", "Marfil", "Seda", "Especias", "Armas expo."};
	    
    intsdealmacenbieneslujomes = new int[20];
	for (int i=0; i<20; i++){
		intsdealmacenbieneslujomes[i] = 0;
	}
	intsdealmacenbieneslujoano = new int[20];
	for (int i=0; i<20; i++){
		intsdealmacenbieneslujoano[i] = 0;
	}
	intsdealmacenbieneslujototal = new int[20];
	for (int i=0; i<20; i++){
		intsdealmacenbieneslujototal[i] = 0;
	}
    
}

public void Actualizaralmacen(){
//Debería servir para actualizar, aunque sólo se está usando para hacer pruebas	
};

}


public class Comercio{
	
	String titulo = "COMERCIO";
	
	String[] stringsdecomercio;
	int[] intsdecomercio;

	public Comercio(){
		
		
		//CAMBIARLO TOTALMENTE
		stringsdecomercio = new String[]{"Comercio", "", "Consumo", "Venta", "P.nom", "P.real", "Ingresos",
		"G. prod", "G. trans", "G. total", "Beneficio", "Trigo", "Fruta", "Carne", "Carne sal.", "Pescado",
		"Miel"};
				
		intsdecomercio = new int[54];
		for (int i=0; i<54; i++){
			intsdecomercio[i] = 0;
		}
		
	};
	
}

public class Ejercito{
	
	String titulo = "EJÉRCITO";
	
	public Ejercito(){
		
	}
}

public class Espionaje{
	
	String titulo = "ESPIONAJE";
	
	public Espionaje(){
		
	}
}

//SOCIAL

public class Social{
	
	String titulo = "SOCIAL";
	//Los nombres de las clases, dispuestos en la primera columna, son lo que no cambian
	String nombresclasessociales[];
	
	//Los nombres de la primera fila varían dependiendo del botón que se pulse: 
	//Media, Edad\Sexo, Lealtad\Miedo, Nivel
	
	String nombresvaloresmedios[];
	int intsvaloresmedios[];
	String nombresedadsexo[];
	int intsvaloresedadsexo[];
	String nombreslealtadmiedo[];
	int intsvaloreslealtadmiedo[];
	String nombresnivel[];
	int intsvaloresnivel[];
	
	
	public Social(){
		
	//La primera columna, con las clases sociales, nunca varía	
	nombresclasessociales = new String[]{"Campesinos", "Soldados", "Espías", "Magos" , "Nigromantes", "Nobleza",
		"TOTAL"};
	
	//Los valores medios, calculados convirtiendo en int la media de cada vector que representa
	//a un ciudadano
	nombresvaloresmedios = new String[]{"Edad", "Lealtad", "Miedo", "Nivel"};
			
	//Los valores que representan las variables edad\sexo, medidos en número de individuos
	nombresedadsexo = new String[]{"Niños", "Niñas", "Hombres", "Mujeres", "Ancianos", "Ancianas"};
	
	//Los valores que representan las variables Lealtad\Miedo
	nombreslealtadmiedo = new String[]{"Leales", "Poco leales", "Desleales", "Miedo"};
	
	//El nivel o experiencia
	nombresnivel = new String[]{"0-10", "11-20", "21-30", "31-40", "41-50"};
	
	//Inicialización de valores
	intsvaloresmedios = new int[28];
	intsvaloresedadsexo = new int[42];
	intsvaloreslealtadmiedo = new int[28];
	intsvaloresnivel = new int[35];
	
}
	
	
public void reseteararrayssociales(int[] arrayaresetear){
   for(int i=0;i<arrayaresetear.length;i++){
		arrayaresetear[i]=0;
	}
}


public void Actualizarsocial(){
	
	//Actualización de los valores individuales
	
	//Primero los ponemos todos a 0
	reseteararrayssociales(intsvaloresmedios);
	reseteararrayssociales(intsvaloresedadsexo);
	reseteararrayssociales(intsvaloreslealtadmiedo);
	reseteararrayssociales(intsvaloresnivel);
	
	//PARA LAS MEDIAS
	//MEDIAS TOTALES
	int numeradoredadmediatotal=0;
	int numeradorlealtadmediatotal=0;
	int numeradormiedomediototal=0;
	int numeradornivelmediototal=0;
	int numerodeindividuos=Registrodeindividuos.registrodeindividuos.devolverarraydeindividuos().size;

	//MEDIAS DE LOS CAMPESINOS
	int numeradoredadmediacampesinos=0;
	int numeradorlealtadmediacampesinos=0;
	int numeradormiedomediocampesinos=0;
	int numeradornivelmediocampesinos=0;
	int denominadornumerodecampesinos=0;
		
	
	//Ahora le solicitamos al registro de individuos la array de todos los individuos y, uno a uno, vamos añadiendo a los contadores correspondientes
	for (int i=0;i<numerodeindividuos;i++){
		
		Individuo individuo = Registrodeindividuos.registrodeindividuos.devolverarraydeindividuos().get(i);
		
		//Primero con los campesinos
		if(individuo.profesion=="campesinos"){
		
			denominadornumerodecampesinos++;
			numeradoredadmediatotal+=individuo.edad;
			numeradoredadmediacampesinos+=individuo.edad;
			numeradorlealtadmediatotal+=individuo.lealtad;
			numeradorlealtadmediacampesinos+=individuo.lealtad;
			numeradormiedomediototal+=individuo.miedo;
			numeradormiedomediocampesinos+=individuo.miedo;
			numeradornivelmediototal+=individuo.nivel;
			numeradornivelmediocampesinos+=individuo.nivel;
			
			//LAS  EDADES
			if(individuo.edad<16){
				//Para la media
				
				//Si es chico
				if(individuo.sexo==true){
			    intsvaloresedadsexo[0]++;
				}
				else{
				intsvaloresedadsexo[1]++;	
				}
			}
			else if((individuo.edad>=16)&&(individuo.edad<45)){
				if(individuo.sexo==true){
				    intsvaloresedadsexo[2]++;
					}
					else{
					intsvaloresedadsexo[3]++;	
					}
			}
	        else if((individuo.edad>=45)){
	        	if(individuo.sexo==true){
	    		    intsvaloresedadsexo[4]++;
	    			}
	    			else{
	    			intsvaloresedadsexo[5]++;	
	    			}
	       }
			//LA LEALTAD/MIEDO
			if(individuo.lealtad>70){
				intsvaloreslealtadmiedo[0]++;
			}
			else if((individuo.lealtad<=70)&&(individuo.lealtad>50)){
				intsvaloreslealtadmiedo[1]++;
			}
			else if(individuo.lealtad<=50){
				intsvaloreslealtadmiedo[2]++;
			};
			if(individuo.miedo>60){
				intsvaloreslealtadmiedo[3]++;
			}
			//EL NIVEL
			if(individuo.habilidad<=10){
				intsvaloresnivel[0]++;
			}
			else if((individuo.habilidad>10)&&(individuo.habilidad<=20)){
				intsvaloresnivel[1]++;
			}
	        else if((individuo.habilidad>20)&&(individuo.habilidad<=30)){
	        	intsvaloresnivel[2]++;
			}
	        else if((individuo.habilidad>30)&&(individuo.habilidad<=40)){
	        	intsvaloresnivel[3]++;
			}
	        else if((individuo.habilidad>40)&&(individuo.habilidad<=50)){
	        	intsvaloresnivel[4]++;
			}
			
		
	   }
		
	}
	
	if(denominadornumerodecampesinos!=0){
	
	intsvaloresmedios[0]=(int)(numeradoredadmediacampesinos/denominadornumerodecampesinos);
	intsvaloresmedios[1]=(int)(numeradorlealtadmediacampesinos/denominadornumerodecampesinos);
	intsvaloresmedios[2]=(int)(numeradormiedomediocampesinos/denominadornumerodecampesinos);
	intsvaloresmedios[3]=(int)(numeradornivelmediocampesinos/denominadornumerodecampesinos);
	
	}
		
	
	//Actualización de los valores totales
	//TOTAL EDAD SEXO
	intsvaloresedadsexo[36]=intsvaloresedadsexo[0]+intsvaloresedadsexo[6]+intsvaloresedadsexo[12]+intsvaloresedadsexo[18]+
			intsvaloresedadsexo[24]+intsvaloresedadsexo[30];
	intsvaloresedadsexo[37]=intsvaloresedadsexo[1]+intsvaloresedadsexo[7]+intsvaloresedadsexo[13]+intsvaloresedadsexo[19]+
			intsvaloresedadsexo[25]+intsvaloresedadsexo[31];
	intsvaloresedadsexo[38]=intsvaloresedadsexo[2]+intsvaloresedadsexo[8]+intsvaloresedadsexo[14]+intsvaloresedadsexo[20]+
			intsvaloresedadsexo[26]+intsvaloresedadsexo[32];
	intsvaloresedadsexo[39]=intsvaloresedadsexo[3]+intsvaloresedadsexo[9]+intsvaloresedadsexo[15]+intsvaloresedadsexo[21]+
			intsvaloresedadsexo[27]+intsvaloresedadsexo[33];
	intsvaloresedadsexo[40]=intsvaloresedadsexo[4]+intsvaloresedadsexo[10]+intsvaloresedadsexo[16]+intsvaloresedadsexo[22]+
			intsvaloresedadsexo[28]+intsvaloresedadsexo[34];
	intsvaloresedadsexo[41]=intsvaloresedadsexo[5]+intsvaloresedadsexo[11]+intsvaloresedadsexo[17]+intsvaloresedadsexo[23]+
			intsvaloresedadsexo[29]+intsvaloresedadsexo[35];
	
	//TOTAL LEALTAD MIEDO
	intsvaloreslealtadmiedo[24]=intsvaloreslealtadmiedo[0]+intsvaloreslealtadmiedo[4]+intsvaloreslealtadmiedo[8]+intsvaloreslealtadmiedo[12]+
			intsvaloreslealtadmiedo[16]+intsvaloreslealtadmiedo[20];
	intsvaloreslealtadmiedo[25]=intsvaloreslealtadmiedo[1]+intsvaloreslealtadmiedo[5]+intsvaloreslealtadmiedo[9]+intsvaloreslealtadmiedo[13]+
			intsvaloreslealtadmiedo[17]+intsvaloreslealtadmiedo[21];
	intsvaloreslealtadmiedo[26]=intsvaloreslealtadmiedo[2]+intsvaloreslealtadmiedo[6]+intsvaloreslealtadmiedo[10]+intsvaloreslealtadmiedo[14]+
			intsvaloreslealtadmiedo[18]+intsvaloreslealtadmiedo[22];
	intsvaloreslealtadmiedo[27]=intsvaloreslealtadmiedo[3]+intsvaloreslealtadmiedo[7]+intsvaloreslealtadmiedo[11]+intsvaloreslealtadmiedo[15]+
			intsvaloreslealtadmiedo[19]+intsvaloreslealtadmiedo[23];
	
	//TOTAL VALORES NIVEL
	intsvaloresnivel[30]=intsvaloresnivel[0]+intsvaloresnivel[5]+intsvaloresnivel[10]+intsvaloresnivel[15]+intsvaloresnivel[20]+
			intsvaloresnivel[25];
	intsvaloresnivel[31]=intsvaloresnivel[1]+intsvaloresnivel[6]+intsvaloresnivel[11]+intsvaloresnivel[16]+intsvaloresnivel[21]+
			intsvaloresnivel[26];
	intsvaloresnivel[32]=intsvaloresnivel[2]+intsvaloresnivel[7]+intsvaloresnivel[12]+intsvaloresnivel[17]+intsvaloresnivel[22]+
			intsvaloresnivel[27];
	intsvaloresnivel[33]=intsvaloresnivel[3]+intsvaloresnivel[8]+intsvaloresnivel[13]+intsvaloresnivel[18]+intsvaloresnivel[23]+
			intsvaloresnivel[28];
	intsvaloresnivel[34]=intsvaloresnivel[4]+intsvaloresnivel[9]+intsvaloresnivel[14]+intsvaloresnivel[19]+intsvaloresnivel[24]+
			intsvaloresnivel[29];
	
	
	//LAS MEDIAS
	if(numerodeindividuos!=0){
	intsvaloresmedios[24]=(int)(numeradoredadmediatotal/numerodeindividuos);
	intsvaloresmedios[25]=(int)(numeradorlealtadmediatotal/numerodeindividuos);
	intsvaloresmedios[26]=(int)(numeradormiedomediototal/numerodeindividuos);
	intsvaloresmedios[27]=(int)(numeradornivelmediototal/numerodeindividuos);
	}
};

}
	
	




private Variablesdejuego(){
	
}
public void iniciar(){

	
};



public void actualizar(){
	this.almacen.Actualizaralmacen();
	this.social.Actualizarsocial();
}
};

	
	

