# psptarea2
Tarea 2 del modulo Programación de Servicios y Procesos.

## Descripción
Programación de Servicios y Procesos

Unidad 2. Prácticas a entregar
Práctica 1. Crear un programa que cuente el número de ocurrencias de una palabra en un texto mientras se
escribe. El proceso de contar el número de ocurrencias deberá ejecutarlo un Thread, que cada 5 segundos
deberá evaluar el texto para encontrar el número de ocurrencias de una palabra.

<img src="http://i66.tinypic.com/2n7jlvm.jpg" >

Para contar palabras deberemos hacer uso de la librería “Apache Common Lang”. Para añadirla como
dependencia en un proyecto Maven:

```
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
 <groupId>org.apache.commons</groupId>
 <artifactId>commons-lang3</artifactId>
 <version>3.8.1</version>
</dependency>
```

Ejemplo de código para contar número de ocurrencias dentro de un String utilizando la librería Apache
Commons Lang:

```
import org.apache.commons.lang3.StringUtils;
public class BuscaOcurrencias {
 public static void main(String[] args) {
 String str = "Crear un programa que cuente el número de ocurrencias de una palabra";
 System.out.println("Cadena: '" + str + "'");
 str = StringUtils.lowerCase(str);
 int coincidencias = StringUtils.countMatches(str, "de");
 System.out.println("Coincidencias de 'de' : " + coincidencias);
 }
}
```

Hubo algunas problemillas a la hora de comparar el texto con la palabra que buscamos, primero porque la comparacion
de los String se hacía sin "cortar" las plabras. Así que para el texto: "Que queremos" contaba 2 veces "que"
Así que añadimos el espacio en blanco detrás. concatenando 
``` String str2 = palabra.getText() + " "; ```
Pero claro, así contaba también los espacios si no teniamos nada escrito en la palabra a buscar.
Entonces incluimos el "mientras la palabra NO está vacía haces la comparacion":
``` 
        if (!str2.equals(" ")) {
            int coincidencias = StringUtils.countMatches(str, str2);
            contador.setText(String.valueOf(coincidencias));
            
```
            
Pantallazo de la aplicacion funcionando:

<img src="http://i66.tinypic.com/jqoy6f.jpg" >

En el codigo está todo comentado para entender que hacemos.
