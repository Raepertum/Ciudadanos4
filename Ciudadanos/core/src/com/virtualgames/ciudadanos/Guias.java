package com.virtualgames.ciudadanos;
//Ésta es una clase dummy que, básicamente explica lo que hay que hacer para crear cada cosa en el juego
/*1.¿Cómo crear un evento?
6/7/2014
En Lógica se instancian 4 clases que intervienen en la formación de un evento:
a) Registrodeeventos
b) Registrodeopciones
c) Registro de funciones
d) Registrodeavisos
e) Nivel1/Generadordeeventos
a) Todo evento se compone de un texto que explica el contenido del evento y de varias opciones que contienen el texto de cada posibilidad para el jugador,
así como de un mensaje de confirmación o "aviso" por cada opción pulsada.
Primer paso: Asignar un código. El primer evento tiene el número 100, el segundo el 101 y así correlativamente. Lo primero que hacemos, por tanto, 
es entrar en el Registro de eventos, crear una variable del tipo Evento con el nombre que queramos asignarle (En el caso del primer evento es 
Evento1), después comprobar la longitud de la array "todos los eventos" para evitar no tener sitio en dicha array para meter el evento.
Una vez realizados esos pasos previos, instanciamos la variable que hemos creado antes, usando el número que le corresponda, añadiendo el texto
del evento y metiéndola dentro de la array "todosloseventos".
Esta instanciación requiere que usemos el registro de opciones.
b) Recordamos el código asignado. Siguiendo el ejemplo, el 101. Entramos en Registrodeopciones.
Allí vamos a crear variables según el número de opciones. Por cada opción, vamos a reservar una variable de tipo Opcion con el siguiente formato:
"opcion"+numerodeopcion+"e"+numerodeevento
Además, vamos también a crear una array por cada evento con el siguiente formato:
"opcionese"+numerodeevento
En la instanciación, incluiremos el texto y pediremos los avisos al registro de avisos, también deberemos incluir las nuevas opciones en las 
funciones "devolveropcion" y "devolverarraydeopciones".
A diferencia de la clase "Evento", que es estética, la clase "Opción", le pasa el código de evento y función al registro de funciones, que ejecuta
el código específico de la opción pulsada.
c) Por tanto, en registro de funciones, dentro del switch contenido en la función distribuidora, hay que meter el nombre de la función que queremos
ejecutar, que se encargará de modificar las variables globales, así como de cambiar la cola de eventos si es necesario.
También en esta clase se incluyen las propias funciones.
d) En el registro de avisos, al igual que hacemos en el registro de opciones, reservamos tantas variables de aviso como variables de opciones, también
creamos la correspondiente array. En devolveraviso() hay que introducir un nuevo caso con sus correspondientes subcaso y hacer lo mismo con la
array en devolverarraydeavisos.
e) Por último, hay que entrar en las clases Generadordeeventos y Nivel1. Este código es provisional ya que, por el momento, el evento se ejecuta
en unas líneas contenidas en la función constructora de "Generadordeeventos", extrayéndolas de la array contenida en el Nivel. Así que, por el momento,
hay que modificar Nivel1 asegurándonos que su arraydeeventos tiene tamaño suficiente y llamando al registro de eventos para llenarla y, después,
modificar Generador de eventos para que ejecute la posición de la array contenida en el Nivel correspondiente. Como hay que hacer que 
generadordeeventos sea más complejo en el futuro, por ahora se harán pruebas individualizadas de cada evento metiéndolos en la función constructora.

 
 
*/
//2.¿Cómo registrar un nuevo objeto en el juego?
//3.¿Cómo funcionan los registros?
//4.¿Cómo crear un menú?
//4.2 ¿Cómo crear las tablas de valores de un menú?
//4.2.1 ¿Cómo se actualizan los valores de un menú?