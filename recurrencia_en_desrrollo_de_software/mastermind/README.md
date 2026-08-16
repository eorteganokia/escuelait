# Curso: Recurrencia en el Desarrollo de Software — Máster de Desarrollo de Software.
## Ejercicio: Modelado de dominio para el juego Mastermind

Usando UML y la herramiento PlantUML, se crearon los diagramas de dominio y de estado para describir las reglas del juego.

### Descripción del juego

* Dos jugadores: codificador (crea la clave secreta) y descifrador (intenta acertarla).
* La clave secreta es una combinación de 5 colores elegidos de una paleta fija (no se permiten repetidos en esta versión).
* En cada turno, el descifrador propone una combinación de 5 colores.
* El codificador devuelve un resultado:
	- número de colores bien colocados (en posición correcta), y
	- número de colores presentes pero en posición incorrecta.
* El juego termina cuando el descifrador adivina la clave o agota el número máximo de turnos (configurable, por defecto 10).


|    **Documento**    |    **Descrición**    |
| :----:              | :----                |
| mastermind_diagrama_estado.png          |Imagen del diagrama de estado modelando los estados y sus transiciones|
| mastermind_domain_model.plantuml          |Archivo fuente en PlantUML para el diagrama de estados|
| mastermind_modelo_dominio.png          |Image del modelo de dominio describiendo las entidades y sus relaciones que dan alcance a la solución del juego|
| mastermind_domain_state_diagram.plantuml          |Archivo fuente en PlantUML para el modelo de dominio|

