# Curso: Diseño Orientada a Objetos — Máster de Desarrollo de Software.
## Mastermind: Implementación del diagrama de dominio aplicando vistas y modelos


### Descripción general

Conforme al diagrama de dominio básico, se implementan las clases Board, Combination, SecretCombination, Console y Mastermind, adicionalmente se el enumerado Color en el módulo de models y en el módulos views las clases para el manejo de la interacción con el usuario y el despliegue de información por consola.

La clase Mastermind define el metodo main como entrada de ejecución del juego. Utiliza la clase Board para jugar y Console para mostrar información en pantalla.

### Clases views

* PlayView: Entrada principal al juego y controla si se inicia una nueva partida o no.
* GameView: Controla los intentos del juego hasta finalizar mostrando el resultado de la partida.
* AttemptView: Solicita al usuario una combinación y valida si el usurio es ganador o no.
* ProposedCombnationView: Solicita y captura una combinación del usuario.
* ResultView: Mustra el resultado de la partida indicando si el usuario ganó operdió.

### Interfaz del juego

**Ingreso de combinación propuesta e intentos**

```
# ----- MASTERMIND -----
# 1 attempt(s)
# Propose a combination: rgpm
.
.
.
```

**Ganador del juego**

```
# You have Won!!!
```

**Reiniciar juego o salir**

```
# Resume? (y/n): y
```