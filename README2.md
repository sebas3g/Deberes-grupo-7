## EJERCICIO 2

## Objetivo

Desarrollar y fortalecer el conocimiento sobre el uso de ciclos en Java, aplicando estructuras repetitivas como `while`, `do-while` y `for` para resolver diferentes problemas mediante programas sencillos y prácticos.

## Descripción de los ejercicios

## Ejercicio 2. Tabla de multiplicar configurable

Solicite dos números:

- tabla inicial;
- tabla final.

Por ejemplo:

```
Tabla inicial: 3
Tabla final: 5
```

El programa deberá generar:

```
TABLA DEL 3
3 x 1 = 3
...
3 x 10 = 30

TABLA DEL 4
...

TABLA DEL 5
...
```

Debe validar que la tabla inicial no sea mayor que la tabla final.

**Estructura obligatoria:** ciclos `for` anidados.

**Desafío:** permitir que el usuario determine también hasta qué multiplicador desea generar las tablas.

### Estructuras utilizadas

| Estructura | Uso en el Ejercicio 2 |
| :--- | :--- |
| `while` | Validar que la tabla inicial no sea mayor que la tabla final y que el multiplicador límite sea mayor o igual a 1. |
| `for` externo | Recorrer cada tabla desde `tablaInicial` hasta `tablaFinal`. |
| `for` interno (anidado) | Recorrer los multiplicadores desde 1 hasta `limite` para cada tabla. |
| Variable de control | `t` (tabla actual) y `m` (multiplicador actual). |

**Caso límite obligatorio:** tabla inicial igual a la tabla final (por ejemplo, 4 y 4) y tabla inicial mayor que la final (por ejemplo, 5 y 3).

### Análisis

**Entradas**

- `tablaInicial`: número de la primera tabla a generar.
- `tablaFinal`: número de la última tabla a generar.
- `limite`: multiplicador máximo hasta el que se genera cada tabla (desafío).

**Restricciones y validaciones**

- Uso de la estructura `while` para validar que `tablaInicial <= tablaFinal`; si no se cumple, se vuelven a pedir ambos valores.
- Uso de la estructura `while` para validar que `limite >= 1`.

**Procesos**

- Ciclo `for` externo: `t` va desde `tablaInicial` hasta `tablaFinal`.
- Ciclo `for` interno: `m` va desde 1 hasta `limite`.
- En cada vuelta del ciclo interno se calcula `resultado = t * m`.
- Total de líneas generadas: `(tablaFinal - tablaInicial + 1) * limite`.

**Salidas**

- El encabezado `TABLA DEL t` por cada tabla.
- Las líneas `t x m = resultado` para cada multiplicador.

### Diagrama de flujo


<img width="1840" height="6652" alt="image" src="https://github.com/user-attachments/assets/157a1a1e-aebc-4767-b1b0-dd07429f464e" />




### Pseudocódigo

```
Algoritmo TablaMultiplicarConfigurable
    Definir tablaInicial, tablaFinal, limite, t, m, resultado Como Entero

    // Lectura y validación del rango de tablas
    Escribir "Tabla inicial: "
    Leer tablaInicial
    Escribir "Tabla final: "
    Leer tablaFinal

    Mientras tablaInicial > tablaFinal Hacer
        Escribir "La tabla inicial no puede ser mayor que la tabla final"
        Escribir "Tabla inicial: "
        Leer tablaInicial
        Escribir "Tabla final: "
        Leer tablaFinal
    FinMientras

    // multiplicador límite definido por el usuario
    Escribir "Hasta que multiplicador desea generar las tablas: "
    Leer limite

    Mientras limite < 1 Hacer
        Escribir "El multiplicador debe ser mayor o igual a 1"
        Escribir "Hasta que multiplicador desea generar las tablas: "
        Leer limite
    FinMientras

    // Ciclos Para (for) anidados
    Para t <- tablaInicial Hasta tablaFinal Con Paso 1 Hacer
        Escribir ""
        Escribir "TABLA DEL ", t
        Para m <- 1 Hasta limite Con Paso 1 Hacer
            resultado <- t * m
            Escribir t, " x ", m, " = ", resultado
        FinPara
    FinPara

FinAlgoritmo
```

### Casos de prueba

#### Prueba de escritorio — Ejercicio 2 (tabla inicial 3, tabla final 5, multiplicador 3)

| Paso | `tablaInicial` | `tablaFinal` | `limite` | Validación | `t` | `m` | `resultado` | Salida |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | 3 | 5 | 3 | Válido (3 ≤ 5 y 3 ≥ 1) | - | - | - | - |
| **Tabla 1** | 3 | 5 | 3 | - | 3 | - | - | `TABLA DEL 3` |
| | | | | | 3 | 1 | 3 | `3 x 1 = 3` |
| | | | | | 3 | 2 | 6 | `3 x 2 = 6` |
| | | | | | 3 | 3 | 9 | `3 x 3 = 9` |
| **Tabla 2** | 3 | 5 | 3 | - | 4 | - | - | `TABLA DEL 4` |
| | | | | | 4 | 1 | 4 | `4 x 1 = 4` |
| | | | | | 4 | 2 | 8 | `4 x 2 = 8` |
| | | | | | 4 | 3 | 12 | `4 x 3 = 12` |
| **Tabla 3** | 3 | 5 | 3 | - | 5 | - | - | `TABLA DEL 5` |
| | | | | | 5 | 1 | 5 | `5 x 1 = 5` |
| | | | | | 5 | 2 | 10 | `5 x 2 = 10` |
| | | | | | 5 | 3 | 15 | `5 x 3 = 15` |
| **Fin del ciclo** | - | - | - | - | 6 | - | - | 3 tablas × 3 líneas = **9 líneas** |

#### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| Tabla inicial mayor que la final | `tablaInicial = 5`, `tablaFinal = 3` | Muestra "La tabla inicial no puede ser mayor que la tabla final" y vuelve a pedir ambos valores. |
| Tabla inicial igual a la final | `tablaInicial = 4`, `tablaFinal = 4`, `limite = 10` | Genera solo la `TABLA DEL 4` (de 4 x 1 a 4 x 10). |
| Multiplicador no válido | `limite = 0` o `limite = -3` | Muestra "El multiplicador debe ser mayor o igual a 1" y vuelve a pedirlo. |
| Multiplicador mínimo | `tablaInicial = 2`, `tablaFinal = 3`, `limite = 1` | Genera `2 x 1 = 2` y `3 x 1 = 3`. |
| Ejemplo del enunciado | `tablaInicial = 3`, `tablaFinal = 5`, `limite = 10` | Genera las tablas del 3, 4 y 5, cada una de x 1 a x 10 (30 líneas). |

### Capturas o evidencias


<img width="552" height="523" alt="image" src="https://github.com/user-attachments/assets/7cfc76bc-c157-47eb-97f5-f687cce27df3" />


<img width="311" height="515" alt="image" src="https://github.com/user-attachments/assets/65331141-0095-4fb4-8bde-001cc2bc692e" />


<img width="459" height="356" alt="image" src="https://github.com/user-attachments/assets/3cce60ba-43db-4659-830d-1320fc7c402d" />




### Conclusiones

- Los ciclos `for` anidados permiten recorrer dos dimensiones: el ciclo externo controla qué tabla se genera y el interno controla cada multiplicación de esa tabla.
- Por cada vuelta del ciclo externo, el ciclo interno se ejecuta completo, por eso el total de líneas es `(tablaFinal - tablaInicial + 1) * limite`.
- La validación con `while` evita rangos incorrectos (tabla inicial mayor que la final) y multiplicadores sin sentido (menores que 1).
- Permitir que el usuario elija el multiplicador límite hace que el programa sea más flexible que una tabla fija hasta 10.
