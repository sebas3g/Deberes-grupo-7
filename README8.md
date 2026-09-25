## Integrantes

- Francis Bonifaz
- Sebastian Navas
- David Punina
- Dixon Prado

## Objetivo

Desarrollar y fortalecer el conocimiento sobre el uso de ciclos en Java, aplicando estructuras repetitivas como `while`, `do-while` y `for` para resolver diferentes problemas mediante programas sencillos y prácticos.

## Descripción de los ejercicios

## Ejercicio 8. Detector y depurador de errores

Analice el siguiente código:

```java
int numero = 1;

while (numero <= 10) {
    System.out.println(numero);
}
```

El estudiante deberá:

- identificar el problema;
- explicar por qué ocurre;
- corregirlo;
- elaborar una tabla de trazas;
- demostrar la solución ejecutándose correctamente.

Posteriormente deberá crear voluntariamente otro ejemplo que produzca un error relacionado con ciclos y corregirlo.

### Estructuras utilizadas

| Estructura | Uso en el Ejercicio 8 |
| :--- | :--- |
| `while` | Ciclo del código original que se analiza y corrige (imprimir del 1 al 10). |
| `for` | Ciclo del segundo ejemplo creado por el equipo (suma de 1 a 10). |
| Variable de control | `numero` en el `while` e `i` en el `for`; deben actualizarse y compararse correctamente. |
| Operador de incremento | `numero++` es la corrección que hace que el `while` termine. |
| Acumulador | `suma` guarda la suma de los números en el segundo ejemplo. |

**Caso límite obligatorio:** comprobar que el valor 10 sí se imprime (y se suma) y que el ciclo se detiene cuando la variable llega a 11.

### Análisis

**Entradas**

- No hay datos ingresados por el usuario; el valor inicial está en el código (`numero = 1`, `i = 1`).

**Restricciones y validaciones**

- Todo ciclo debe tener una variable de control que cambie en cada vuelta y acerque la condición a ser falsa.
- La condición del ciclo debe incluir correctamente el último valor esperado (`<=` en lugar de `<`).

**Procesos**

- Revisar el código original y detectar que `numero` nunca cambia.
- Agregar `numero++` dentro del ciclo.
- Elaborar la tabla de trazas del código corregido.
- Crear un segundo error (off-by-one en un `for`) y corregirlo.

**Salidas**

- Los números del 1 al 10, uno por línea.
- La suma con error (45) y la suma corregida (55) del segundo ejemplo.

### Diagrama de flujo

<img width="429" height="982" alt="Ejercicio08" src="https://github.com/user-attachments/assets/e0b33525-621e-46bd-9470-7456ab57d890" />


### Pseudocódigo

```
Algoritmo DepuradorCiclos
    Definir numero, i, suma Como Entero

    // Parte 1: código del enunciado corregido
    numero <- 1
    Mientras numero <= 10 Hacer
        Escribir numero
        numero <- numero + 1      // corrección: se actualiza la variable
    FinMientras

    // Parte 2: error creado por el equipo, ya corregido
    suma <- 0
    Para i <- 1 Hasta 10 Con Paso 1 Hacer     // antes: i < 10
        suma <- suma + i
    FinPara
    Escribir "Suma de 1 a 10: ", suma

FinAlgoritmo
```

### Documentación de errores

#### Error 1 — Código del enunciado

**ERROR ENCONTRADO:**
El programa imprime el número `1` una y otra vez sin detenerse (ciclo infinito).

**CAUSA:**
La variable de control `numero` nunca cambia dentro del ciclo. Siempre vale 1, entonces la condición `numero <= 10` siempre es verdadera y el `while` nunca termina.

**SOLUCIÓN:**
Incrementar la variable de control en cada vuelta:

```java
int numero = 1;

while (numero <= 10) {
    System.out.println(numero);
    numero++; // se agrega el incremento
}
```

**RESULTADO:**
El programa imprime los números del 1 al 10 y termina cuando `numero` llega a 11.

#### Error 2 — Ejemplo creado por el equipo

Se quiere sumar los números del 1 al 10 (el resultado correcto es 55):

```java
int suma = 0;
for (int i = 1; i < 10; i++) {
    suma += i;
}
System.out.println(suma); // muestra 45
```

**ERROR ENCONTRADO:**
El programa muestra `45` en lugar de `55`.

**CAUSA:**
Error de "uno menos" (off-by-one): la condición `i < 10` hace que el ciclo termine cuando `i` vale 10, así que el 10 nunca se suma.

**SOLUCIÓN:**
Cambiar la condición para incluir el último valor:

```java
int suma = 0;
for (int i = 1; i <= 10; i++) {
    suma += i;
}
System.out.println(suma); // muestra 55
```

**RESULTADO:**
El programa suma correctamente del 1 al 10 y muestra `55`.

### Casos de prueba

#### Tabla de trazas — Código original (con error)

| Vuelta | `numero` | `numero <= 10` | Salida |
| :---: | :---: | :---: | :---: |
| 1 | 1 | Verdadero | 1 |
| 2 | 1 | Verdadero | 1 |
| 3 | 1 | Verdadero | 1 |
| ... | 1 | Verdadero | 1 (nunca termina) |

#### Tabla de trazas — Código corregido

| Vuelta | `numero` (antes) | `numero <= 10` | Salida | `numero` (después de `numero++`) |
| :---: | :---: | :---: | :---: | :---: |
| 1 | 1 | Verdadero | 1 | 2 |
| 2 | 2 | Verdadero | 2 | 3 |
| 3 | 3 | Verdadero | 3 | 4 |
| 4 | 4 | Verdadero | 4 | 5 |
| 5 | 5 | Verdadero | 5 | 6 |
| 6 | 6 | Verdadero | 6 | 7 |
| 7 | 7 | Verdadero | 7 | 8 |
| 8 | 8 | Verdadero | 8 | 9 |
| 9 | 9 | Verdadero | 9 | 10 |
| 10 | 10 | Verdadero | 10 | 11 |
| **Fin** | 11 | **Falso** | - | Sale del ciclo |

#### Tabla de trazas — Error 2 (con error vs. corregido)

| `i` | `suma` con `i < 10` | `suma` con `i <= 10` |
| :---: | :---: | :---: |
| 1 | 1 | 1 |
| 2 | 3 | 3 |
| 3 | 6 | 6 |
| 4 | 10 | 10 |
| 5 | 15 | 15 |
| 6 | 21 | 21 |
| 7 | 28 | 28 |
| 8 | 36 | 36 |
| 9 | 45 | 45 |
| 10 | No entra (10 < 10 es falso) | **55** |
| **Resultado** | **45** (incorrecto) | **55** (correcto) |

#### Casos de validación

| Caso | Código | Resultado esperado |
| :--- | :--- | :--- |
| Código original | `while` sin `numero++` | Ciclo infinito imprimiendo `1`. |
| Código corregido | `while` con `numero++` | Imprime del 1 al 10 y termina. |
| Límite superior | `numero = 10` | Se imprime (10 <= 10 es verdadero). |
| Salida del ciclo | `numero = 11` | No se imprime; el ciclo termina. |
| Error 2 con `i < 10` | `for` de 1 a 9 | Suma = 45 (incorrecto). |
| Error 2 con `i <= 10` | `for` de 1 a 10 | Suma = 55 (correcto). |

### Capturas o evidencias

<img width="339" height="191" alt="Captura de pantalla 2026-09-25 092720" src="https://github.com/user-attachments/assets/df89506a-9a2b-4382-a9f7-71d3058be9f6" />

<img width="517" height="61" alt="Captura de pantalla 2026-09-25 092738" src="https://github.com/user-attachments/assets/fcfa85f4-f05a-4a40-a5cd-52279753c33a" />

<img width="294" height="135" alt="Captura de pantalla 2026-09-25 092752" src="https://github.com/user-attachments/assets/45e962ca-8930-4ceb-8143-e3f83ef4a9fc" />


### Conclusiones

- Un ciclo `while` necesita que su variable de control cambie dentro del cuerpo; si no, la condición nunca se vuelve falsa y se produce un ciclo infinito.
- Las tablas de trazas permiten ver vuelta por vuelta el valor de las variables y detectar fácilmente por qué un ciclo no termina o da un resultado incorrecto.
- Los errores de "uno menos" (`<` en lugar de `<=`) no detienen el programa, pero producen resultados incorrectos, por eso siempre hay que probar los valores límite.
- Depurar un ciclo consiste en revisar tres partes: el valor inicial, la condición y la actualización de la variable de control.
