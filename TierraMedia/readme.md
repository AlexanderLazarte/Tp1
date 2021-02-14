
#Tp1 Turismo en Tierra Media

#1)Nombres de los integrantes del grupo:

Alexander Lazarte
Esteban Gonzalez

#2)Decisiones de diseno tomadas

-Se ah decidido el uso de listas para el manejo de los objetos de atracciones, usuarios y promociones, con variables del tipo correspondientes.

-Se ah decidido una clase padre abstracta Promocion, que contiene los atributos genericos para el resto de atracciones, las cuales heredan y establecen esos atributos acorde a sus individualidades.

-Se ah decidido un Lector como clase aparte, que devolvera las referencias a objetos creados en una lista, segun los datos levantados de un *txt.

-Se ah diseñado pruebas unitarias Junit de las clases necesarias. La clase ParqueDeAtraccionesMedievales utiliza los metodos de las demas clases que necesita segun corresponda.


#3)Paquetes dentro de la carpeta src/main/java

#Clase principal

ParqueDeAtraccionesMedievales.java
Clase principal que va a ofrecer sugerencias de atracciones a los usuarios.

#Manejo de datos

LeerDatos.java
Clase encargada de leer los datos de los  *.txt de usuarios, promociones o atracciones y asignarlos a tres diferentes listas.

Itinerario.java
Clase que maneja el itinerario de los usuarios del parque, el cual imprime en pantalla su estado al consultarlo o al cerrarlo.

Escritor.java
Clase que es invocada luego de cerrar un itinerario y escribe un *txt con el itinerario del usuario en cuestion.

#Promocion

Promocion.java
Clase abstracta que contiene los atributos de clase que utilizarán sus hijos.

Porcentual.java
Clase que se extiende de promocion, la cual aplica un descuento porcentual al costo total de dos atracciones del mismo tipo.

Fijo.java
Clase que se extiende de promocion, que aplica un descuento fijo en monedas de oro al contratar dos atracciones incluidas en esta promoción.

DosPorUno.java
Clase que se extiende de promocion y que al contratar dos atracciones incluidas en esta promocion, una tercera del mismo tipo se contrata gratis siempre y cuando haya cupo en dicha atracción y el usuario tenga tiempo disponible.



TipoDeAtraccion.java
Clase que enumera los tipo de atracción "DEGUSTACION", "PAISAJE" y "AVENTURA".

Usuario.java
Clase que maneja los datos de los usuarios como puede ser su presupuesto, o el tiempo disponible y sus métodos para modificarlos a medida que aceptan atracciones.

Atracion.java
Clase que contiene los atributos de las atracciones, su costo, tiempo de duración, cupo, etc. 

#Test
ItinerarioTest.java
LeerDatosTest.java
AtraccionTest.java
DosPorUnoTest.java
FijoTest.java
PorcentualTest.java
UsuarioTest.java
Se ejecutan todos los test que fueron necesarios para que el proyecto funcione

#4)Conclusion

Este trabajo práctico fué un desafío muy bueno para afianzar conceptos e incorporar nuevas herramientas que ibamos conociendo a lo largo de la cursada hasta ahora, por ejemplo ArrayList. Se trató de ser claros en el código, en la creación de los métodos, en los nombres de las variables y en la forma de desmenuzar grandes problemas para convertirlos en problemas mas pequeños y de simple resolucion. Este trabajo practico nos ayudó a trabajar mucho en equipo y como ejercitación para lo que viene. 