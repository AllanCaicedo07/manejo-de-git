# Programacion
***

15. ¿Cuáles son los tipos de datos primitivos en Java?

## R:
### Datos Primitivos en Java

Java tiene **8 tipos de datos primitivos** que representan valores simples. Estos tipos son la base del lenguaje y se almacenan directamente en la memoria (no son objetos).

## Los 8 tipos primitivos

Java clasifica sus tipos primitivos en 4 categorías:

1. **Enteros** (4 tipos): `byte`, `short`, `int`, `long`
2. **Punto flotante** (2 tipos): `float`, `double`
3. **Carácter** (1 tipo): `char`
4. **Booleano** (1 tipo): `boolean`

## 1. Tipos Enteros

### byte

```java
// Almacena números enteros pequeños
byte edad = 25;
byte temperatura = -10;
```

**Características:**
- **Tamaño:** 8 bits (1 byte)
- **Rango:** -128 a 127
- **Valor por defecto:** 0
- **Uso típico:** Ahorrar memoria en arrays grandes, trabajar con datos binarios

**Ejemplos:**
```java
byte minimo = -128;
byte maximo = 127;
byte cero = 0;

// Error: fuera de rango
// byte error = 200;  // ❌ No compila
```

### short

```java
// Números enteros medianos
short año = 2026;
short poblacion = 30000;
```

**Características:**
- **Tamaño:** 16 bits (2 bytes)
- **Rango:** -32,768 a 32,767
- **Valor por defecto:** 0
- **Uso típico:** Ahorrar memoria cuando int es demasiado grande

**Ejemplos:**
```java
short minimo = -32768;
short maximo = 32767;
short cantidad = 1000;
```

### int

```java
// Tipo entero más común
int edad = 30;
int poblacion = 1000000;
int temperatura = -15;
```

**Características:**
- **Tamaño:** 32 bits (4 bytes)
- **Rango:** -2,147,483,648 a 2,147,483,647
- **Valor por defecto:** 0
- **Uso típico:** Tipo entero estándar para la mayoría de casos

**Ejemplos:**
```java
int contador = 0;
int suma = 100 + 200;
int negativo = -500;

// Diferentes notaciones
int decimal = 100;
int binario = 0b1100100;    // 100 en binario
int hexadecimal = 0x64;     // 100 en hexadecimal
int octal = 0144;           // 100 en octal

// Separadores para legibilidad (Java 7+)
int millon = 1_000_000;
int tarjeta = 1234_5678_9012_3456;
```

### long

```java
// Números enteros muy grandes
long poblacionMundial = 8000000000L;
long distancia = 384400000L;  // Distancia a la Luna en metros
```

**Características:**
- **Tamaño:** 64 bits (8 bytes)
- **Rango:** -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
- **Valor por defecto:** 0L
- **Uso típico:** Números muy grandes, timestamps, cálculos científicos
- **Importante:** Debe terminar en `L` o `l` (se recomienda `L`)

**Ejemplos:**
```java
long grande = 10000000000L;
long timestamp = System.currentTimeMillis();
long bytes = 1024L * 1024L * 1024L;  // 1 GB en bytes

// Diferentes notaciones
long hex = 0xFFFFFFFFL;
long binario = 0b11111111_11111111_11111111_11111111L;
```

## 2. Tipos de Punto Flotante

### float

```java
// Números decimales de precisión simple
float precio = 19.99f;
float pi = 3.14159f;
```

**Características:**
- **Tamaño:** 32 bits (4 bytes)
- **Rango:** ±3.4 × 10^38 (aproximadamente)
- **Precisión:** ~6-7 dígitos decimales
- **Valor por defecto:** 0.0f
- **Importante:** Debe terminar en `f` o `F`

**Ejemplos:**
```java
float altura = 1.75f;
float temperatura = -10.5f;
float peso = 70.5f;

// Notación científica
float cientifico = 1.5e3f;  // 1.5 × 10³ = 1500.0
float pequeno = 2.5e-3f;    // 2.5 × 10⁻³ = 0.0025
```

### double

```java
// Números decimales de precisión doble (más común)
double precio = 19.99;
double pi = 3.141592653589793;
```

**Características:**
- **Tamaño:** 64 bits (8 bytes)
- **Rango:** ±1.7 × 10^308 (aproximadamente)
- **Precisión:** ~15-16 dígitos decimales
- **Valor por defecto:** 0.0d o 0.0
- **Uso típico:** Tipo decimal estándar, cálculos científicos

**Ejemplos:**
```java
double salario = 50000.50;
double resultado = 10.0 / 3.0;
double euler = 2.718281828459045;

// Notación científica
double grande = 1.23e100;
double pequeno = 4.56e-50;

// Valores especiales
double infinito = Double.POSITIVE_INFINITY;
double negInfinito = Double.NEGATIVE_INFINITY;
double noNumero = Double.NaN;  // Not a Number
```

## 3. Tipo Carácter

### char

```java
// Almacena un único carácter Unicode
char letra = 'A';
char digito = '5';
char simbolo = '@';
```

**Características:**
- **Tamaño:** 16 bits (2 bytes)
- **Rango:** 0 a 65,535 (caracteres Unicode)
- **Valor por defecto:** '\u0000' (carácter nulo)
- **Importante:** Usa comillas simples `' '`

**Ejemplos:**
```java
char mayuscula = 'A';
char minuscula = 'z';
char numero = '7';
char espacio = ' ';

// Caracteres Unicode
char aroba = '\u0040';      // @
char corazon = '\u2665';    // ♥
char emoji = '\u263A';      // ☺

// Caracteres de escape
char nuevaLinea = '\n';
char tabulador = '\t';
char comillaSimple = '\'';
char backslash = '\\';

// Valor numérico del carácter
char letraA = 65;           // 'A' en ASCII/Unicode
```

## 4. Tipo Booleano

### boolean

```java
// Almacena valores de verdad
boolean esVerdadero = true;
boolean esFalso = false;
```

**Características:**
- **Tamaño:** No está definido (JVM decide, típicamente 1 bit)
- **Valores:** Solo `true` o `false`
- **Valor por defecto:** `false`
- **Uso típico:** Condiciones, flags, estados

**Ejemplos:**
```java
boolean mayorDeEdad = true;
boolean estaLloviendo = false;
boolean aprobado = (nota >= 60);

// Operaciones lógicas
boolean resultado = true && false;  // AND
boolean resultado2 = true || false; // OR
boolean negacion = !true;           // NOT

// Comparaciones
boolean esIgual = (5 == 5);         // true
boolean esMayor = (10 > 5);         // true
boolean esMenor = (3 < 2);          // false
```

## Tabla comparativa completa

| Tipo | Tamaño | Rango | Valor por defecto | Ejemplo |
|------|--------|-------|-------------------|---------|
| `byte` | 8 bits | -128 a 127 | 0 | `byte b = 100;` |
| `short` | 16 bits | -32,768 a 32,767 | 0 | `short s = 1000;` |
| `int` | 32 bits | -2,147,483,648 a 2,147,483,647 | 0 | `int i = 100000;` |
| `long` | 64 bits | -9.22×10¹⁸ a 9.22×10¹⁸ | 0L | `long l = 100000L;` |
| `float` | 32 bits | ±3.4×10³⁸ | 0.0f | `float f = 10.5f;` |
| `double` | 64 bits | ±1.7×10³⁰⁸ | 0.0d | `double d = 10.5;` |
| `char` | 16 bits | 0 a 65,535 | '\u0000' | `char c = 'A';` |
| `boolean` | no definido | true, false | false | `boolean b = true;` |

## Conversiones entre tipos (Casting)

### Conversión implícita (automática - widening):

```java
// De menor a mayor capacidad (no hay pérdida de datos)
byte b = 10;
short s = b;    // byte → short
int i = s;      // short → int
long l = i;     // int → long
float f = l;    // long → float
double d = f;   // float → double

// Ejemplo completo
byte valor = 100;
int entero = valor;     // Automático
double decimal = entero; // Automático
```

**Jerarquía de conversión automática:**
```
byte → short → int → long → float → double
       char →
```

### Conversión explícita (casting - narrowing):

```java
// De mayor a menor capacidad (puede haber pérdida de datos)
double d = 10.99;
int i = (int) d;        // i = 10 (se pierde .99)

long l = 100000L;
int i2 = (int) l;       // Conversión explícita

float f = 3.14f;
int i3 = (int) f;       // i3 = 3

// Pérdida de datos
int grande = 130;
byte pequeño = (byte) grande;  // pequeño = -126 (overflow)
```

## Valores por defecto

```java
public class ValoresPorDefecto {
    // Variables de instancia (tienen valores por defecto)
    byte b;       // 0
    short s;      // 0
    int i;        // 0
    long l;       // 0L
    float f;      // 0.0f
    double d;     // 0.0d
    char c;       // '\u0000'
    boolean bool; // false
    
    public void mostrarValores() {
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: '" + c + "'");
        System.out.println("boolean: " + bool);
    }
}
```

**Nota importante:** Las variables locales NO tienen valores por defecto y deben inicializarse antes de usarse.

```java
public void metodo() {
    int x;
    // System.out.println(x);  // ❌ Error: variable no inicializada
    
    int y = 0;
    System.out.println(y);     // ✅ OK
}
```

## Operaciones con tipos primitivos

### Operaciones aritméticas:

```java
int a = 10;
int b = 3;

int suma = a + b;           // 13
int resta = a - b;          // 7
int multiplicacion = a * b; // 30
int division = a / b;       // 3 (división entera)
int modulo = a % b;         // 1 (resto)

// División con decimales
double divisionDecimal = (double) a / b;  // 3.333...
```

### Incremento y decremento:

```java
int x = 5;

x++;        // Post-incremento: x = 6
++x;        // Pre-incremento: x = 7
x--;        // Post-decremento: x = 6
--x;        // Pre-decremento: x = 5

// Diferencia entre pre y post
int y = 5;
int resultado1 = y++;  // resultado1 = 5, y = 6
int resultado2 = ++y;  // resultado2 = 7, y = 7
```

### Operaciones con asignación:

```java
int numero = 10;

numero += 5;   // numero = numero + 5  → 15
numero -= 3;   // numero = numero - 3  → 12
numero *= 2;   // numero = numero * 2  → 24
numero /= 4;   // numero = numero / 4  → 6
numero %= 4;   // numero = numero % 4  → 2
```

## Literales especiales

### Literales enteros:

```java
// Decimal (base 10)
int decimal = 100;

// Binario (base 2) - prefijo 0b
int binario = 0b1100100;

// Octal (base 8) - prefijo 0
int octal = 0144;

// Hexadecimal (base 16) - prefijo 0x
int hexadecimal = 0x64;

// Con separadores
int legible = 1_000_000;
```

### Literales de punto flotante:

```java
// Notación decimal
double d1 = 123.456;

// Notación científica
double d2 = 1.23e2;     // 123.0
double d3 = 1.23e-2;    // 0.0123

// Float requiere sufijo f
float f1 = 123.456f;
float f2 = 1.23e2f;
```

### Literales de caracteres:

```java
// Carácter normal
char letra = 'A';

// Secuencias de escape
char nuevaLinea = '\n';
char tabulacion = '\t';
char retroceso = '\b';
char retornoCarro = '\r';
char comillaSimple = '\'';
char comillaDoble = '\"';
char backslash = '\\';

// Unicode
char unicode = '\u0041';  // 'A'
```

## Límites de los tipos (constantes)

```java
// Límites de byte
System.out.println("Byte MIN: " + Byte.MIN_VALUE);      // -128
System.out.println("Byte MAX: " + Byte.MAX_VALUE);      // 127

// Límites de short
System.out.println("Short MIN: " + Short.MIN_VALUE);    // -32768
System.out.println("Short MAX: " + Short.MAX_VALUE);    // 32767

// Límites de int
System.out.println("Int MIN: " + Integer.MIN_VALUE);    // -2147483648
System.out.println("Int MAX: " + Integer.MAX_VALUE);    // 2147483647

// Límites de long
System.out.println("Long MIN: " + Long.MIN_VALUE);
System.out.println("Long MAX: " + Long.MAX_VALUE);

// Límites de float
System.out.println("Float MIN: " + Float.MIN_VALUE);
System.out.println("Float MAX: " + Float.MAX_VALUE);

// Límites de double
System.out.println("Double MIN: " + Double.MIN_VALUE);
System.out.println("Double MAX: " + Double.MAX_VALUE);

// Límites de char
System.out.println("Char MIN: " + (int)Character.MIN_VALUE);  // 0
System.out.println("Char MAX: " + (int)Character.MAX_VALUE);  // 65535
```

## Clases Wrapper (Envolventes)

Cada tipo primitivo tiene una clase wrapper que lo envuelve:

```java
// Primitivo → Wrapper
byte    → Byte
short   → Short
int     → Integer
long    → Long
float   → Float
double  → Double
char    → Character
boolean → Boolean
```

### Autoboxing y Unboxing:

```java
// Autoboxing (primitivo → objeto)
Integer obj = 100;  // Automático: Integer.valueOf(100)

// Unboxing (objeto → primitivo)
int primitivo = obj;  // Automático: obj.intValue()

// Ejemplos
Double d = 3.14;           // Autoboxing
double valor = d;          // Unboxing

Boolean b = true;          // Autoboxing
boolean flag = b;          // Unboxing
```

## Mejores prácticas

### ✅ Recomendaciones:

```java
// Usar int para enteros por defecto
int contador = 0;

// Usar double para decimales por defecto
double precio = 19.99;

// Usar long para timestamps y números muy grandes
long timestamp = System.currentTimeMillis();

// Usar boolean para condiciones
boolean esValido = true;

// Usar byte/short solo cuando el ahorro de memoria es crítico
byte[] datosGrandes = new byte[1000000];  // Arrays grandes

// Sufijo L para long (mayúscula, más legible)
long grande = 1000000000L;  // ✅
long grande2 = 1000000000l; // ❌ Confuso (parece 1)

// Sufijo f para float
float numero = 3.14f;  // ✅
```

### ❌ Evitar:

```java
// No usar == para comparar wrappers
Integer a = 1000;
Integer b = 1000;
if (a == b) { }  // ❌ Compara referencias
if (a.equals(b)) { }  // ✅ Compara valores

// No mezclar float y double innecesariamente
float f = 3.14;  // ❌ Error: pérdida de precisión
float f = 3.14f; // ✅ Correcto

// No usar byte/short para ahorrar memoria sin razón
byte edad = 25;  // ❌ Innecesario, usar int
int edad = 25;   // ✅ Más simple
```

## Resumen rápido

```java
// ENTEROS
byte b = 100;           // -128 a 127
short s = 1000;         // -32,768 a 32,767
int i = 100000;         // ~-2 mil millones a 2 mil millones
long l = 10000000000L;  // Números muy grandes

// DECIMALES
float f = 3.14f;        // Precisión simple
double d = 3.14159;     // Precisión doble (preferido)

// CARÁCTER
char c = 'A';           // Un solo carácter Unicode

// BOOLEANO
boolean flag = true;    // true o false
```

Los tipos primitivos son la base de Java y entender sus características, rangos y usos apropiados es fundamental para escribir código eficiente y correcto.

***

16. ¿Cómo funcionan las estructuras de control de flujo como if, else, switch y bucles en Java?

## R:
# Estructuras de control de flujo en Java

## Introducción

Las **estructuras de control de flujo** permiten controlar el orden en que se ejecutan las instrucciones de un programa. En Java existen tres tipos principales:

1. **Estructuras condicionales**: `if`, `else`, `else if`, `switch`
2. **Estructuras repetitivas (bucles)**: `for`, `while`, `do-while`
3. **Estructuras de control**: `break`, `continue`, `return`

## 1. Estructuras Condicionales

### if - Condicional simple

Ejecuta un bloque de código solo si la condición es verdadera.

```java
// Sintaxis básica
if (condicion) {
    // Código a ejecutar si la condición es true
}

// Ejemplos
int edad = 18;

if (edad >= 18) {
    System.out.println("Eres mayor de edad");
}

int temperatura = 35;

if (temperatura > 30) {
    System.out.println("Hace calor");
}

// if sin llaves (solo una instrucción)
if (edad >= 18)
    System.out.println("Mayor de edad");  // ✅ Válido pero no recomendado
```

### if-else - Alternativa binaria

Ejecuta un bloque si la condición es verdadera, otro si es falsa.

```java
// Sintaxis
if (condicion) {
    // Código si es true
} else {
    // Código si es false
}

// Ejemplos
int nota = 65;

if (nota >= 60) {
    System.out.println("Aprobado");
} else {
    System.out.println("Reprobado");
}

int edad = 15;

if (edad >= 18) {
    System.out.println("Puede votar");
} else {
    System.out.println("No puede votar");
}

// Operador ternario (alternativa compacta)
String resultado = (nota >= 60) ? "Aprobado" : "Reprobado";
```

### if-else if-else - Múltiples condiciones

Evalúa múltiples condiciones en secuencia.

```java
// Sintaxis
if (condicion1) {
    // Código si condicion1 es true
} else if (condicion2) {
    // Código si condicion2 es true
} else if (condicion3) {
    // Código si condicion3 es true
} else {
    // Código si ninguna condición es true
}

// Ejemplo: Calificaciones
int nota = 85;

if (nota >= 90) {
    System.out.println("Calificación: A");
} else if (nota >= 80) {
    System.out.println("Calificación: B");
} else if (nota >= 70) {
    System.out.println("Calificación: C");
} else if (nota >= 60) {
    System.out.println("Calificación: D");
} else {
    System.out.println("Calificación: F");
}

// Ejemplo: Categorías de edad
int edad = 25;

if (edad < 13) {
    System.out.println("Niño");
} else if (edad < 18) {
    System.out.println("Adolescente");
} else if (edad < 65) {
    System.out.println("Adulto");
} else {
    System.out.println("Adulto mayor");
}
```

### if anidados

```java
// if dentro de otro if
int edad = 20;
boolean tieneID = true;

if (edad >= 18) {
    if (tieneID) {
        System.out.println("Puede entrar al evento");
    } else {
        System.out.println("Necesita identificación");
    }
} else {
    System.out.println("Debe ser mayor de edad");
}

// Ejemplo con múltiples condiciones
int nota = 85;
int asistencia = 80;

if (nota >= 60) {
    if (asistencia >= 75) {
        System.out.println("Aprobado con buena asistencia");
    } else {
        System.out.println("Aprobado pero baja asistencia");
    }
} else {
    System.out.println("Reprobado");
}
```

### Operadores lógicos en condiciones

```java
int edad = 25;
boolean tienePermiso = true;

// AND (&&) - Ambas condiciones deben ser true
if (edad >= 18 && tienePermiso) {
    System.out.println("Puede conducir");
}

// OR (||) - Al menos una condición debe ser true
if (edad < 18 || edad > 65) {
    System.out.println("Descuento especial");
}

// NOT (!) - Niega la condición
if (!tienePermiso) {
    System.out.println("No tiene permiso");
}

// Combinación de operadores
if ((edad >= 18 && edad <= 25) || tienePermiso) {
    System.out.println("Elegible");
}
```

## 2. Switch - Selección múltiple

Evalúa una expresión y ejecuta el caso que coincida.

### Switch tradicional (Java < 14)

```java
// Sintaxis
switch (expresion) {
    case valor1:
        // Código para valor1
        break;
    case valor2:
        // Código para valor2
        break;
    case valor3:
        // Código para valor3
        break;
    default:
        // Código si ningún caso coincide
}

// Ejemplo: Días de la semana
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    case 3:
        System.out.println("Miércoles");
        break;
    case 4:
        System.out.println("Jueves");
        break;
    case 5:
        System.out.println("Viernes");
        break;
    case 6:
        System.out.println("Sábado");
        break;
    case 7:
        System.out.println("Domingo");
        break;
    default:
        System.out.println("Día inválido");
}

// Ejemplo: Meses
String mes = "Enero";

switch (mes) {
    case "Enero":
    case "Marzo":
    case "Mayo":
    case "Julio":
    case "Agosto":
    case "Octubre":
    case "Diciembre":
        System.out.println("31 días");
        break;
    case "Abril":
    case "Junio":
    case "Septiembre":
    case "Noviembre":
        System.out.println("30 días");
        break;
    case "Febrero":
        System.out.println("28 o 29 días");
        break;
    default:
        System.out.println("Mes inválido");
}
```

### Switch expressions (Java 14+)

```java
// Sintaxis moderna con arrow (->)
String dia = "Lunes";

String tipo = switch (dia) {
    case "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" -> "Día laboral";
    case "Sábado", "Domingo" -> "Fin de semana";
    default -> "Día inválido";
};

System.out.println(tipo);

// Ejemplo con bloques
int mes = 3;

int dias = switch (mes) {
    case 1, 3, 5, 7, 8, 10, 12 -> 31;
    case 4, 6, 9, 11 -> 30;
    case 2 -> 28;
    default -> {
        System.out.println("Mes inválido");
        yield 0;  // yield para retornar valor en bloques
    }
};

System.out.println("Días del mes: " + dias);
```

### Fall-through en switch

```java
// Sin break, el código "cae" al siguiente caso
int numero = 2;

switch (numero) {
    case 1:
        System.out.println("Uno");
        // No hay break, continúa al caso 2
    case 2:
        System.out.println("Dos");
        // No hay break, continúa al caso 3
    case 3:
        System.out.println("Tres");
        break;
    default:
        System.out.println("Otro");
}

// Salida:
// Dos
// Tres

// Uso intencional del fall-through
int calificacion = 85;
String comentario = "";

switch (calificacion / 10) {
    case 10:
    case 9:
        comentario = "Excelente";
        break;
    case 8:
        comentario = "Muy bien";
        break;
    case 7:
        comentario = "Bien";
        break;
    case 6:
        comentario = "Suficiente";
        break;
    default:
        comentario = "Insuficiente";
}
```

## 3. Bucle for - Iteración con contador

### for tradicional

```java
// Sintaxis
for (inicializacion; condicion; incremento) {
    // Código a repetir
}

// Ejemplo básico: contar del 1 al 10
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}

// Ejemplo: contar hacia atrás
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}

// Incremento de 2 en 2
for (int i = 0; i <= 20; i += 2) {
    System.out.println(i);  // 0, 2, 4, 6, ...
}

// Múltiples variables
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.println("i: " + i + ", j: " + j);
}
```

### for-each (enhanced for)

```java
// Sintaxis
for (tipo variable : coleccion) {
    // Código usando la variable
}

// Ejemplo con arrays
int[] numeros = {1, 2, 3, 4, 5};

for (int numero : numeros) {
    System.out.println(numero);
}

// Ejemplo con Strings
String[] nombres = {"Ana", "Juan", "María"};

for (String nombre : nombres) {
    System.out.println("Hola, " + nombre);
}

// Ejemplo: Sumar elementos
int[] valores = {10, 20, 30, 40, 50};
int suma = 0;

for (int valor : valores) {
    suma += valor;
}

System.out.println("Suma total: " + suma);
```

### Bucles for anidados

```java
// Tabla de multiplicar
for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {
        System.out.print(i * j + "\t");
    }
    System.out.println();
}

// Patrón de asteriscos
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}

// Salida:
// *
// **
// ***
// ****
// *****

// Matriz
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
    System.out.println();
}
```

## 4. Bucle while - Iteración condicional

### while - Evaluación al inicio

```java
// Sintaxis
while (condicion) {
    // Código a repetir
}

// Ejemplo: contador simple
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}

// Ejemplo: suma acumulativa
int suma = 0;
int numero = 1;

while (numero <= 100) {
    suma += numero;
    numero++;
}

System.out.println("Suma de 1 a 100: " + suma);

// Ejemplo: validación de entrada
Scanner scanner = new Scanner(System.in);
int edad = -1;

while (edad < 0 || edad > 120) {
    System.out.print("Ingrese edad válida (0-120): ");
    edad = scanner.nextInt();
}

System.out.println("Edad registrada: " + edad);
```

### Bucle infinito controlado

```java
// Bucle que se rompe con break
while (true) {
    System.out.print("¿Continuar? (s/n): ");
    String respuesta = scanner.nextLine();
    
    if (respuesta.equalsIgnoreCase("n")) {
        break;  // Sale del bucle
    }
    
    System.out.println("Continuando...");
}

// Menú interactivo
int opcion = 0;

while (opcion != 4) {
    System.out.println("\n=== MENÚ ===");
    System.out.println("1. Opción 1");
    System.out.println("2. Opción 2");
    System.out.println("3. Opción 3");
    System.out.println("4. Salir");
    System.out.print("Seleccione: ");
    
    opcion = scanner.nextInt();
    
    switch (opcion) {
        case 1:
            System.out.println("Opción 1 seleccionada");
            break;
        case 2:
            System.out.println("Opción 2 seleccionada");
            break;
        case 3:
            System.out.println("Opción 3 seleccionada");
            break;
        case 4:
            System.out.println("Saliendo...");
            break;
        default:
            System.out.println("Opción inválida");
    }
}
```

## 5. Bucle do-while - Evaluación al final

Ejecuta el bloque al menos una vez, luego evalúa la condición.

```java
// Sintaxis
do {
    // Código a ejecutar
} while (condicion);

// Ejemplo: menú que se muestra al menos una vez
int opcion;

do {
    System.out.println("\n=== MENÚ ===");
    System.out.println("1. Nueva partida");
    System.out.println("2. Cargar partida");
    System.out.println("3. Opciones");
    System.out.println("0. Salir");
    System.out.print("Seleccione: ");
    
    opcion = scanner.nextInt();
    
    if (opcion >= 1 && opcion <= 3) {
        System.out.println("Opción " + opcion + " seleccionada");
    } else if (opcion != 0) {
        System.out.println("Opción inválida");
    }
} while (opcion != 0);

// Ejemplo: validación con do-while
String password;

do {
    System.out.print("Ingrese contraseña (mínimo 8 caracteres): ");
    password = scanner.nextLine();
} while (password.length() < 8);

System.out.println("Contraseña válida");
```

### Diferencia entre while y do-while

```java
// while: puede no ejecutarse nunca
int i = 10;

while (i < 5) {
    System.out.println("Este código NO se ejecuta");
    i++;
}

// do-while: se ejecuta al menos una vez
int j = 10;

do {
    System.out.println("Este código SÍ se ejecuta una vez");
    j++;
} while (j < 5);
```

## 6. Instrucciones de control

### break - Salir del bucle

```java
// Salir completamente del bucle
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // Sale del bucle cuando i es 5
    }
    System.out.println(i);
}
// Salida: 1, 2, 3, 4

// Buscar elemento en array
int[] numeros = {10, 20, 30, 40, 50};
int buscar = 30;
boolean encontrado = false;

for (int numero : numeros) {
    if (numero == buscar) {
        encontrado = true;
        break;  // Sale cuando encuentra el número
    }
}

System.out.println("Encontrado: " + encontrado);

// break con etiquetas (bucles anidados)
bucleExterno:
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) {
            break bucleExterno;  // Sale de ambos bucles
        }
        System.out.println("i: " + i + ", j: " + j);
    }
}
```

### continue - Saltar a siguiente iteración

```java
// Saltar iteración actual
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // Salta números pares
    }
    System.out.println(i);
}
// Salida: 1, 3, 5, 7, 9 (solo impares)

// Ejemplo: filtrar valores negativos
int[] numeros = {10, -5, 20, -3, 30, -8};

for (int numero : numeros) {
    if (numero < 0) {
        continue;  // Salta números negativos
    }
    System.out.println(numero);
}
// Salida: 10, 20, 30

// continue con etiquetas
bucleExterno:
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (j == 2) {
            continue bucleExterno;  // Salta a siguiente i
        }
        System.out.println("i: " + i + ", j: " + j);
    }
}
```

### return - Salir del método

```java
// return termina la ejecución del método
public static int buscarPosicion(int[] array, int valor) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == valor) {
            return i;  // Sale del método y retorna el índice
        }
    }
    return -1;  // No encontrado
}

// return en void
public static void validarEdad(int edad) {
    if (edad < 0) {
        System.out.println("Edad inválida");
        return;  // Sale del método sin ejecutar más código
    }
    
    System.out.println("Edad válida: " + edad);
}
```

## 7. Ejemplos prácticos completos

### Ejemplo 1: Calculadora básica

```java
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n=== CALCULADORA ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Primer número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Segundo número: ");
                double num2 = scanner.nextDouble();
                
                double resultado = 0;
                
                switch (opcion) {
                    case 1:
                        resultado = num1 + num2;
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 2:
                        resultado = num1 - num2;
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 3:
                        resultado = num1 * num2;
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 4:
                        if (num2 != 0) {
                            resultado = num1 / num2;
                            System.out.println("Resultado: " + resultado);
                        } else {
                            System.out.println("Error: División por cero");
                        }
                        break;
                }
            } else if (opcion != 0) {
                System.out.println("Opción inválida");
            }
        } while (opcion != 0);
        
        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}
```

### Ejemplo 2: Validación de contraseña

```java
import java.util.Scanner;

public class ValidadorPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        boolean esValida;
        
        do {
            System.out.print("Ingrese contraseña: ");
            password = scanner.nextLine();
            
            esValida = true;
            
            // Validar longitud
            if (password.length() < 8) {
                System.out.println("❌ Debe tener al menos 8 caracteres");
                esValida = false;
            }
            
            // Validar mayúscula
            boolean tieneMayuscula = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    tieneMayuscula = true;
                    break;
                }
            }
            
            if (!tieneMayuscula) {
                System.out.println("❌ Debe contener al menos una mayúscula");
                esValida = false;
            }
            
            // Validar número
            boolean tieneNumero = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    tieneNumero = true;
                    break;
                }
            }
            
            if (!tieneNumero) {
                System.out.println("❌ Debe contener al menos un número");
                esValida = false;
            }
            
            if (esValida) {
                System.out.println("✓ Contraseña válida");
            } else {
                System.out.println("\nIntente nuevamente:\n");
            }
            
        } while (!esValida);
        
        scanner.close();
    }
}
```

### Ejemplo 3: Números primos

```java
public class NumerosPrimos {
    public static void main(String[] args) {
        System.out.println("Números primos del 1 al 100:");
        
        for (int numero = 2; numero <= 100; numero++) {
            boolean esPrimo = true;
            
            // Verificar si es primo
            for (int divisor = 2; divisor <= Math.sqrt(numero); divisor++) {
                if (numero % divisor == 0) {
                    esPrimo = false;
                    break;  // No es primo, salir del bucle
                }
            }
            
            if (esPrimo) {
                System.out.print(numero + " ");
            }
        }
    }
}
```

## 8. Buenas prácticas

### ✅ Recomendaciones:

```java
// Usar llaves siempre, incluso con una línea
if (condicion) {
    instruccion();  // ✅ Más claro y seguro
}

// NO:
if (condicion)
    instruccion();  // ❌ Puede causar errores

// Evitar condiciones complejas
if ((edad >= 18 && tieneID) || (esEstudiante && tienePase)) {  // ❌ Difícil de leer
    // código
}

// MEJOR:
boolean puedeEntrar = (edad >= 18 && tieneID) || (esEstudiante && tienePase);
if (puedeEntrar) {  // ✅ Más legible
    // código
}

// Usar switch para múltiples valores constantes
switch (dia) {  // ✅ Más claro
    case 1: return "Lunes";
    case 2: return "Martes";
    // ...
}

// NO usar muchos if-else encadenados
if (dia == 1) return "Lunes";
else if (dia == 2) return "Martes";  // ❌ Menos eficiente
// ...
```

### ❌ Evitar:

```java
// Bucles infinitos sin control
while (true) {  // ❌ Peligroso sin break
    // código sin salida
}

// Modificar variable de control en for
for (int i = 0; i < 10; i++) {
    i = i + 5;  // ❌ Confuso
}

// Usar == con objetos
String s1 = "Hola";
String s2 = "Hola";
if (s1 == s2) { }  // ❌ Compara referencias
if (s1.equals(s2)) { }  // ✅ Compara contenido
```

## Resumen de estructuras

| Estructura | Uso | Cuándo usar |
|------------|-----|-------------|
| `if` | Decisión simple | Ejecutar código condicionalmente |
| `if-else` | Alternativa binaria | Elegir entre dos opciones |
| `if-else if` | Múltiples condiciones | Evaluar varias condiciones |
| `switch` | Selección múltiple | Comparar valor con constantes |
| `for` | Iteración con contador | Número conocido de repeticiones |
| `for-each` | Recorrer colecciones | Iterar sobre arrays/colecciones |
| `while` | Iteración condicional | Repetir mientras condición sea true |
| `do-while` | Al menos una ejecución | Ejecutar y luego verificar |
| `break` | Salir del bucle | Terminar iteración anticipadamente |
| `continue` | Saltar iteración | Pasar a siguiente iteración |

Las estructuras de control son fundamentales para crear programas dinámicos y eficientes en Java. Dominarlas te permite escribir código que responde a diferentes situaciones y procesa datos de manera efectiva.
***

17. ¿Por qué es importante usar nombres significativos para variables y métodos?
### R:

# Por qué es importante usar nombres significativos para variables y métodos

## Introducción

Los nombres significativos son fundamentales en la programación porque **el código se lee mucho más veces de las que se escribe**. Un buen nombre hace que el código sea autoexplicativo, reduciendo la necesidad de comentarios y facilitando el mantenimiento.

> "El código debe leerse como prosa bien escrita" - Robert C. Martin (Clean Code)

## Razones principales

### 1. Legibilidad y comprensión

El código con nombres significativos es fácil de entender sin necesidad de contexto adicional.

#### ❌ Código con nombres malos:

```java
public class X {
    public static void main(String[] args) {
        int a = 25;
        int b = 30;
        int c = a + b;
        double d = c * 0.16;
        double e = c + d;
        
        System.out.println("T: " + e);
    }
}
```

**Problemas:**
- ¿Qué significan a, b, c, d, e?
- ¿Qué representa 0.16?
- ¿Qué es "T"?
- Necesitas analizar toda la lógica para entender el propósito

#### ✅ Código con nombres buenos:

```java
public class CalculadoraFactura {
    public static void main(String[] args) {
        int precioProducto1 = 25;
        int precioProducto2 = 30;
        int subtotal = precioProducto1 + precioProducto2;
        double impuesto = subtotal * 0.16;
        double totalAPagar = subtotal + impuesto;
        
        System.out.println("Total a pagar: $" + totalAPagar);
    }
}
```

**Ventajas:**
- ✅ Se entiende inmediatamente qué hace el código
- ✅ El propósito de cada variable es claro
- ✅ Los cálculos tienen sentido lógico
- ✅ No necesitas comentarios adicionales

### 2. Mantenimiento del código

El código se modifica constantemente. Los nombres claros facilitan hacer cambios sin introducir errores.

#### ❌ Difícil de mantener:

```java
public class App {
    public void p(int x, int y) {
        int z = x * y;
        if (z > 100) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}
```

**Preguntas que surgen:**
- ¿Qué hace el método `p`?
- ¿Qué son x, y, z?
- ¿Por qué 100 es el límite?
- ¿Qué significan "A" y "B"?

#### ✅ Fácil de mantener:

```java
public class GestorInventario {
    private static final int LIMITE_STOCK_CRITICO = 100;
    
    public void verificarNivelStock(int cantidadActual, int cantidadMinima) {
        int stockDisponible = cantidadActual - cantidadMinima;
        
        if (stockDisponible > LIMITE_STOCK_CRITICO) {
            System.out.println("Stock suficiente");
        } else {
            System.out.println("Stock crítico - Ordenar más producto");
        }
    }
}
```

**Ventajas:**
- ✅ Cualquier desarrollador entiende el código
- ✅ Es fácil modificar el límite crítico
- ✅ Se puede agregar funcionalidad sin confusión
- ✅ Los errores son más fáciles de detectar

### 3. Trabajo en equipo

Los equipos necesitan entender el código de otros rápidamente.

#### ❌ Código críptico:

```java
public class Calc {
    public double calc(double n, int t) {
        double r = 0.05;
        return n * Math.pow(1 + r, t);
    }
}
```

**Problemas en equipo:**
- Cada persona debe descifrar qué hace
- Se pierde tiempo en reuniones explicando
- Aumentan los malentendidos
- Más probabilidad de errores

#### ✅ Código colaborativo:

```java
public class CalculadoraInversion {
    private static final double TASA_INTERES_ANUAL = 0.05;
    
    public double calcularInversionFutura(double capitalInicial, int años) {
        return capitalInicial * Math.pow(1 + TASA_INTERES_ANUAL, años);
    }
}
```

**Ventajas en equipo:**
- ✅ Todos entienden inmediatamente
- ✅ Menos tiempo en explicaciones
- ✅ Onboarding más rápido para nuevos miembros
- ✅ Code reviews más eficientes

### 4. Documentación implícita

Los buenos nombres actúan como documentación en línea.

#### ❌ Necesita muchos comentarios:

```java
public class U {
    // Este método calcula el área de un rectángulo
    // Parámetros:
    // w - ancho del rectángulo
    // h - alto del rectángulo
    // Retorna: el área calculada
    public int calc(int w, int h) {
        // Multiplica ancho por alto
        return w * h;
    }
}
```

#### ✅ Autoexplicativo:

```java
public class CalculadoraGeometrica {
    public int calcularAreaRectangulo(int ancho, int alto) {
        return ancho * alto;
    }
}
```

**Ventajas:**
- ✅ No necesita comentarios
- ✅ El nombre del método explica QUÉ hace
- ✅ Los parámetros explican QUÉ necesita
- ✅ El tipo de retorno explica QUÉ devuelve

### 5. Depuración (debugging)

Encontrar errores es mucho más fácil con nombres claros.

#### ❌ Difícil de depurar:

```java
public class P {
    public void m(int[] arr) {
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            t += arr[i];
        }
        System.out.println(t);
    }
}

// ¿Dónde está el error si t es incorrecto?
// ¿Qué es t?
// ¿Es un error en el bucle o en el cálculo?
```

#### ✅ Fácil de depurar:

```java
public class CalculadoraEstadisticas {
    public void imprimirSumaTotal(int[] calificaciones) {
        int sumaTotal = 0;
        
        for (int i = 0; i < calificaciones.length; i++) {
            sumaTotal += calificaciones[i];
        }
        
        System.out.println("Suma total de calificaciones: " + sumaTotal);
    }
}

// Si sumaTotal es incorrecto, sabes que:
// - Es un problema con la suma de calificaciones
// - Puedes verificar el array de calificaciones
// - El bucle está sumando calificaciones
```

### 6. Búsqueda y refactoring

Encontrar y modificar código es más eficiente.

```java
// ❌ Buscar "calc" en un proyecto grande
// Resultado: 500 coincidencias de métodos llamados "calc"

// ✅ Buscar "calcularImpuestoVentas"
// Resultado: Exactamente el método que necesitas
```

## Principios para nombres significativos

### 1. Usar nombres que revelen intención

```java
// ❌ Malo
int d; // días transcurridos

// ✅ Bueno
int diasTranscurridos;
int diasDesdeCreacion;
int diasDesdeModificacion;
```

### 2. Evitar desinformación

```java
// ❌ Malo
int accountList;  // No es una List, es un int

// ✅ Bueno
int numeroDeCuentas;
List<Account> listaDeCuentas;
```

### 3. Hacer distinciones significativas

```java
// ❌ Malo
public void copiarArchivos(String archivo1, String archivo2) {
    // ¿Cuál es origen y cuál es destino?
}

// ✅ Bueno
public void copiarArchivos(String archivoOrigen, String archivoDestino) {
    // Claramente identificados
}
```

### 4. Usar nombres pronunciables

```java
// ❌ Malo
int genymdhms; // generation year, month, day, hour, minute, second

// ✅ Bueno
int fechaGeneracion;
LocalDateTime fechaHoraGeneracion;
```

### 5. Usar nombres buscables

```java
// ❌ Malo
for (int i = 0; i < 5; i++) {
    // ¿Qué significa 5?
}

// ✅ Bueno
final int DIAS_LABORALES_POR_SEMANA = 5;
for (int dia = 0; dia < DIAS_LABORALES_POR_SEMANA; dia++) {
    // Claro y buscable
}
```

### 6. Evitar codificación innecesaria

```java
// ❌ Malo (notación húngara)
String strNombre;
int iEdad;
boolean bActivo;

// ✅ Bueno
String nombre;
int edad;
boolean activo;
```

## Convenciones de nombres en Java

### Variables y métodos: camelCase

```java
// Variables
int edad;
String nombreCompleto;
double saldoCuentaBancaria;

// Métodos
public void calcularTotal() { }
public String obtenerNombreUsuario() { }
public boolean esNumeroPositivo() { }
```

### Constantes: UPPER_SNAKE_CASE

```java
public static final int EDAD_MINIMA = 18;
public static final double TASA_IMPUESTO = 0.16;
public static final String MENSAJE_BIENVENIDA = "Hola";
```

### Clases e interfaces: PascalCase

```java
public class CalculadoraFinanciera { }
public class GestorUsuarios { }
public interface ServicioAutenticacion { }
```

### Paquetes: lowercase

```java
package com.empresa.proyecto.servicios;
package com.ejemplo.utilidades;
```

## Ejemplos comparativos completos

### Ejemplo 1: Sistema de biblioteca

#### ❌ Código malo:

```java
public class Lib {
    public void p(String b, String u) {
        int d = 7;
        System.out.println(u + " " + b + " " + d);
    }
    
    public boolean c(int id) {
        // lógica
        return true;
    }
}
```

#### ✅ Código bueno:

```java
public class GestorBiblioteca {
    private static final int DIAS_PRESTAMO_ESTANDAR = 7;
    
    public void prestarLibro(String tituloLibro, String nombreUsuario) {
        System.out.println(nombreUsuario + " ha prestado '" + tituloLibro + 
                         "' por " + DIAS_PRESTAMO_ESTANDAR + " días");
    }
    
    public boolean verificarDisponibilidadLibro(int idLibro) {
        // Verifica si el libro está disponible para préstamo
        return consultarBaseDatos(idLibro);
    }
    
    private boolean consultarBaseDatos(int idLibro) {
        // Implementación
        return true;
    }
}
```

### Ejemplo 2: Procesamiento de pedidos

#### ❌ Código malo:

```java
public class Proc {
    public double calc(double p, int q, double d) {
        double t = p * q;
        double disc = t * d;
        return t - disc;
    }
}
```

#### ✅ Código bueno:

```java
public class ProcesadorPedidos {
    public double calcularTotalConDescuento(
            double precioUnitario, 
            int cantidad, 
            double porcentajeDescuento) {
        
        double subtotal = precioUnitario * cantidad;
        double montoDescuento = subtotal * porcentajeDescuento;
        double totalFinal = subtotal - montoDescuento;
        
        return totalFinal;
    }
}
```

### Ejemplo 3: Validación de datos

#### ❌ Código malo:

```java
public class V {
    public boolean v(String s) {
        return s != null && s.length() > 0 && s.length() < 50;
    }
}
```

#### ✅ Código bueno:

```java
public class ValidadorDatos {
    private static final int LONGITUD_MINIMA_NOMBRE = 1;
    private static final int LONGITUD_MAXIMA_NOMBRE = 50;
    
    public boolean validarNombreUsuario(String nombre) {
        if (nombre == null) {
            return false;
        }
        
        int longitudNombre = nombre.length();
        boolean longitudValida = longitudNombre >= LONGITUD_MINIMA_NOMBRE && 
                                longitudNombre <= LONGITUD_MAXIMA_NOMBRE;
        
        return longitudValida;
    }
}
```

## Nombres de métodos según propósito

### Métodos que retornan boolean: usar "es", "tiene", "puede"

```java
// ✅ Buenos nombres
public boolean esUsuarioActivo() { }
public boolean tienePermisosAdmin() { }
public boolean puedeEditarDocumento() { }
public boolean estaDisponible() { }

// ❌ Malos nombres
public boolean verificar() { }
public boolean check() { }
public boolean proceso() { }
```

### Métodos de acción: usar verbos

```java
// ✅ Buenos nombres
public void guardarUsuario() { }
public void eliminarProducto() { }
public void actualizarPerfil() { }
public void enviarNotificacion() { }

// ❌ Malos nombres
public void usuario() { }
public void producto() { }
public void perfil() { }
```

### Métodos que retornan valores: usar "obtener", "calcular", "buscar"

```java
// ✅ Buenos nombres
public String obtenerNombreCompleto() { }
public double calcularPromedio() { }
public Usuario buscarPorId(int id) { }
public List<Producto> filtrarPorCategoria(String categoria) { }

// ❌ Malos nombres
public String nombre() { }
public double promedio() { }
public Usuario usuario(int id) { }
```

## Impacto en métricas del proyecto

### Tiempo de desarrollo

```
Proyecto con nombres malos:
- Tiempo para entender código: 30 min por función
- Debugging: 2-3 horas por bug
- Code review: 1-2 horas por 100 líneas

Proyecto con nombres buenos:
- Tiempo para entender código: 5 min por función ✅
- Debugging: 30 min - 1 hora por bug ✅
- Code review: 15-30 min por 100 líneas ✅

Ahorro de tiempo: ~60-70%
```

### Calidad del código

```
Nombres malos:
- Bugs introducidos: 5-10 por feature
- Malentendidos en equipo: frecuentes
- Necesidad de documentación: alta

Nombres buenos:
- Bugs introducidos: 1-2 por feature ✅
- Malentendidos en equipo: raros ✅
- Necesidad de documentación: baja ✅
```

## Checklist de buenos nombres

Antes de finalizar tu código, verifica:

- [ ] ¿El nombre explica claramente el propósito?
- [ ] ¿Evita abreviaciones crípticas?
- [ ] ¿Sigue las convenciones de Java?
- [ ] ¿Es pronunciable y buscable?
- [ ] ¿Otro desarrollador lo entendería sin contexto?
- [ ] ¿Evita nombres genéricos como "data", "info", "temp"?
- [ ] ¿El nombre es específico y no ambiguo?
- [ ] ¿Refleja el dominio del problema?

## Errores comunes a evitar

### ❌ Nombres demasiado cortos

```java
// Malo
int n;
String s;
double x;

// Bueno
int numeroPaginas;
String nombreUsuario;
double precioTotal;
```

### ❌ Nombres demasiado largos

```java
// Malo
int numeroDeDiasTranscurridosDesdeUltimaActualizacionDelPerfilDelUsuario;

// Bueno
int diasDesdeUltimaActualizacion;
```

### ❌ Nombres ambiguos

```java
// Malo
public void procesar() { }  // ¿Procesar qué?
public void hacer() { }     // ¿Hacer qué?

// Bueno
public void procesarPagos() { }
public void hacerCalculoImpuestos() { }
```

### ❌ Usar números en nombres

```java
// Malo
String valor1;
String valor2;
int resultado3;

// Bueno
String nombreProducto;
String descripcionProducto;
int totalVentas;
```

## Resumen

| Aspecto | Con nombres malos | Con nombres buenos |
|---------|------------------|-------------------|
| **Legibilidad** | Difícil de entender | Autoexplicativo |
| **Mantenimiento** | Costoso y lento | Rápido y seguro |
| **Colaboración** | Requiere explicaciones | Intuitivo |
| **Documentación** | Necesaria extensamente | Mínima |
| **Debugging** | Complejo | Directo |
| **Búsqueda** | Difícil | Eficiente |
| **Onboarding** | Semanas | Días |
| **Bugs** | Más frecuentes | Menos frecuentes |

## Conclusión

Usar nombres significativos no es solo una "buena práctica" o preferencia estilística - es una **inversión en la calidad y sostenibilidad del código**. El tiempo extra que tomas pensando en un buen nombre se recupera múltiples veces durante el ciclo de vida del proyecto.

**Recuerda:** El código se escribe una vez pero se lee cientos de veces. Escribe para quien va a leer tu código, incluyendo tu yo del futuro.

> "Cualquier tonto puede escribir código que una computadora entienda. Buenos programadores escriben código que los humanos pueden entender." - Martin Fowler
***

18. ¿Qué es la Programación Orientada a Objetos (POO)?


## R:
# ¿Qué es la Programación Orientada a Objetos (POO)?

## Introducción

La **Programación Orientada a Objetos (POO)** es un paradigma de programación que organiza el código alrededor de **objetos** en lugar de funciones y lógica. Los objetos son entidades que combinan datos (atributos) y comportamientos (métodos) relacionados.

> "La POO modela el mundo real: los objetos tienen características y pueden realizar acciones"

## Conceptos fundamentales

### ¿Qué es un objeto?

Un **objeto** es una instancia de una clase que representa una entidad del mundo real o conceptual.

```java
// Ejemplo del mundo real
Persona juan = new Persona("Juan", 25);
Carro miCarro = new Carro("Toyota", "Corolla", 2024);
CuentaBancaria cuenta = new CuentaBancaria("123456", 1000.0);
```

**Características de un objeto:**
- Tiene **estado** (atributos/propiedades)
- Tiene **comportamiento** (métodos/acciones)
- Tiene **identidad** única

### ¿Qué es una clase?

Una **clase** es un molde o plantilla para crear objetos. Define qué atributos y métodos tendrán los objetos.

```java
public class Persona {
    // Atributos (estado)
    private String nombre;
    private int edad;
    
    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    // Métodos (comportamiento)
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
    
    public void cumplirAños() {
        edad++;
        System.out.println("Ahora tengo " + edad + " años");
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
}

// Uso de la clase
public class Main {
    public static void main(String[] args) {
        // Crear objetos (instanciar la clase)
        Persona juan = new Persona("Juan", 25);
        Persona maria = new Persona("María", 30);
        
        // Usar los objetos
        juan.saludar();           // "Hola, soy Juan"
        maria.saludar();          // "Hola, soy María"
        
        juan.cumplirAños();       // "Ahora tengo 26 años"
        
        System.out.println("Edad de María: " + maria.getEdad());  // 30
    }
}
```

## Los 4 pilares de la POO

### 1. Encapsulamiento

**Ocultar los detalles internos** de un objeto y exponer solo lo necesario a través de métodos públicos.

```java
// ❌ Sin encapsulamiento (malo)
public class CuentaBancaria {
    public double saldo;  // Cualquiera puede modificarlo directamente
}

// Uso inseguro
CuentaBancaria cuenta = new CuentaBancaria();
cuenta.saldo = -1000;  // ❌ Puede establecer valores inválidos

// ✅ Con encapsulamiento (bueno)
public class CuentaBancaria {
    private double saldo;  // Atributo privado
    
    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
        }
    }
    
    // Método público con validación
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("El monto debe ser positivo");
        }
    }
    
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes o monto inválido");
        }
    }
    
    public double consultarSaldo() {
        return saldo;
    }
}

// Uso seguro
CuentaBancaria cuenta = new CuentaBancaria(1000);
cuenta.depositar(500);    // ✅ Validado
cuenta.retirar(200);      // ✅ Validado
// cuenta.saldo = -100;   // ❌ Error de compilación (saldo es privado)
```

**Ventajas del encapsulamiento:**
- ✅ Protege la integridad de los datos
- ✅ Permite validaciones
- ✅ Facilita el mantenimiento
- ✅ Oculta la complejidad interna

### 2. Herencia

**Permite crear nuevas clases** basadas en clases existentes, heredando sus atributos y métodos.

```java
// Clase base (superclase o padre)
public class Animal {
    protected String nombre;
    protected int edad;
    
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void comer() {
        System.out.println(nombre + " está comiendo");
    }
    
    public void dormir() {
        System.out.println(nombre + " está durmiendo");
    }
}

// Clase derivada (subclase o hija)
public class Perro extends Animal {
    private String raza;
    
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);  // Llama al constructor del padre
        this.raza = raza;
    }
    
    // Método específico de Perro
    public void ladrar() {
        System.out.println(nombre + " está ladrando: ¡Guau!");
    }
    
    // Método específico
    public void traerPelota() {
        System.out.println(nombre + " trae la pelota");
    }
}

// Otra clase derivada
public class Gato extends Animal {
    private String color;
    
    public Gato(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }
    
    // Método específico de Gato
    public void maullar() {
        System.out.println(nombre + " está maullando: ¡Miau!");
    }
    
    public void ronronear() {
        System.out.println(nombre + " está ronroneando");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Max", 3, "Labrador");
        Gato miGato = new Gato("Luna", 2, "Blanco");
        
        // Métodos heredados de Animal
        miPerro.comer();      // "Max está comiendo"
        miPerro.dormir();     // "Max está durmiendo"
        
        // Métodos propios de Perro
        miPerro.ladrar();     // "Max está ladrando: ¡Guau!"
        miPerro.traerPelota(); // "Max trae la pelota"
        
        // Métodos heredados de Animal
        miGato.comer();       // "Luna está comiendo"
        
        // Métodos propios de Gato
        miGato.maullar();     // "Luna está maullando: ¡Miau!"
        miGato.ronronear();   // "Luna está ronroneando"
    }
}
```

**Ventajas de la herencia:**
- ✅ Reutilización de código
- ✅ Jerarquía lógica de clases
- ✅ Facilita el mantenimiento
- ✅ Reduce duplicación

### 3. Polimorfismo

**Permite que objetos de diferentes clases** respondan al mismo mensaje de forma diferente.

```java
// Clase base
public class Empleado {
    protected String nombre;
    protected double salarioBase;
    
    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    
    // Método que será sobrescrito (overridden)
    public double calcularSalario() {
        return salarioBase;
    }
    
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Salario: $" + calcularSalario());
    }
}

// Empleado permanente con bonos
public class EmpleadoPermanente extends Empleado {
    private double bono;
    
    public EmpleadoPermanente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + bono;
    }
}

// Empleado por horas
public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double tarifaPorHora;
    
    public EmpleadoPorHoras(String nombre, int horasTrabajadas, double tarifaPorHora) {
        super(nombre, 0);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    
    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }
}

// Contratista
public class Contratista extends Empleado {
    private double montoPorProyecto;
    
    public Contratista(String nombre, double montoPorProyecto) {
        super(nombre, 0);
        this.montoPorProyecto = montoPorProyecto;
    }
    
    @Override
    public double calcularSalario() {
        return montoPorProyecto;
    }
}

// Uso del polimorfismo
public class Main {
    public static void main(String[] args) {
        // Todos son Empleado, pero calculan salario diferente
        Empleado emp1 = new EmpleadoPermanente("Juan", 3000, 500);
        Empleado emp2 = new EmpleadoPorHoras("María", 160, 25);
        Empleado emp3 = new Contratista("Pedro", 5000);
        
        // Array de empleados (polimorfismo)
        Empleado[] empleados = {emp1, emp2, emp3};
        
        // Mismo método, comportamiento diferente
        for (Empleado emp : empleados) {
            emp.mostrarInfo();
            System.out.println();
        }
        
        // Salida:
        // Empleado: Juan
        // Salario: $3500.0
        //
        // Empleado: María
        // Salario: $4000.0
        //
        // Empleado: Pedro
        // Salario: $5000.0
    }
}
```

**Ventajas del polimorfismo:**
- ✅ Flexibilidad en el diseño
- ✅ Código más genérico y reutilizable
- ✅ Facilita extensiones futuras
- ✅ Permite programar a nivel de abstracción

### 4. Abstracción

**Ocultar la complejidad** y mostrar solo las características esenciales de un objeto.

```java
// Clase abstracta (no se puede instanciar directamente)
public abstract class FiguraGeometrica {
    protected String color;
    
    public FiguraGeometrica(String color) {
        this.color = color;
    }
    
    // Método abstracto (debe ser implementado por subclases)
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
    // Método concreto (compartido por todas las figuras)
    public void mostrarInfo() {
        System.out.println("Figura de color: " + color);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}

// Implementación concreta: Círculo
public class Circulo extends FiguraGeometrica {
    private double radio;
    
    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

// Implementación concreta: Rectángulo
public class Rectangulo extends FiguraGeometrica {
    private double ancho;
    private double alto;
    
    public Rectangulo(String color, double ancho, double alto) {
        super(color);
        this.ancho = ancho;
        this.alto = alto;
    }
    
    @Override
    public double calcularArea() {
        return ancho * alto;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        // FiguraGeometrica fig = new FiguraGeometrica("Rojo"); // ❌ Error: clase abstracta
        
        FiguraGeometrica circulo = new Circulo("Rojo", 5);
        FiguraGeometrica rectangulo = new Rectangulo("Azul", 4, 6);
        
        circulo.mostrarInfo();
        System.out.println();
        rectangulo.mostrarInfo();
    }
}
```

**Ventajas de la abstracción:**
- ✅ Simplifica el uso de objetos complejos
- ✅ Define contratos claros (interfaces)
- ✅ Permite cambios internos sin afectar código externo
- ✅ Organiza jerarquías de clases

## Interfaces en Java

Las **interfaces** definen un contrato que las clases deben cumplir.

```java
// Definir interfaz
public interface Reproducible {
    void reproducir();
    void pausar();
    void detener();
}

// Implementar interfaz
public class ReproductorMusica implements Reproducible {
    private String cancionActual;
    
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo: " + cancionActual);
    }
    
    @Override
    public void pausar() {
        System.out.println("Música pausada");
    }
    
    @Override
    public void detener() {
        System.out.println("Música detenida");
        cancionActual = null;
    }
    
    public void cargarCancion(String cancion) {
        this.cancionActual = cancion;
    }
}

public class ReproductorVideo implements Reproducible {
    private String videoActual;
    
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo video: " + videoActual);
    }
    
    @Override
    public void pausar() {
        System.out.println("Video pausado");
    }
    
    @Override
    public void detener() {
        System.out.println("Video detenido");
        videoActual = null;
    }
    
    public void cargarVideo(String video) {
        this.videoActual = video;
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Reproducible musica = new ReproductorMusica();
        Reproducible video = new ReproductorVideo();
        
        ((ReproductorMusica) musica).cargarCancion("Canción.mp3");
        musica.reproducir();
        musica.pausar();
        
        ((ReproductorVideo) video).cargarVideo("Video.mp4");
        video.reproducir();
        video.detener();
    }
}
```

## Ejemplo completo: Sistema de gestión de vehículos

```java
// Clase abstracta base
public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int año;
    protected double kilometraje;
    
    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.kilometraje = 0;
    }
    
    // Método abstracto
    public abstract double calcularConsumo(double distancia);
    
    // Método concreto
    public void conducir(double distancia) {
        kilometraje += distancia;
        double consumo = calcularConsumo(distancia);
        System.out.println("Conduciendo " + distancia + " km");
        System.out.println("Consumo: " + consumo + " litros");
    }
    
    public void mostrarInfo() {
        System.out.println("=== " + marca + " " + modelo + " ===");
        System.out.println("Año: " + año);
        System.out.println("Kilometraje: " + kilometraje + " km");
    }
}

// Subclase: Auto
public class Auto extends Vehiculo {
    private int numeroPuertas;
    private static final double CONSUMO_POR_KM = 0.08; // 8 litros/100km
    
    public Auto(String marca, String modelo, int año, int numeroPuertas) {
        super(marca, modelo, año);
        this.numeroPuertas = numeroPuertas;
    }
    
    @Override
    public double calcularConsumo(double distancia) {
        return distancia * CONSUMO_POR_KM;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numeroPuertas);
    }
}

// Subclase: Motocicleta
public class Motocicleta extends Vehiculo {
    private int cilindrada;
    private static final double CONSUMO_POR_KM = 0.04; // 4 litros/100km
    
    public Motocicleta(String marca, String modelo, int año, int cilindrada) {
        super(marca, modelo, año);
        this.cilindrada = cilindrada;
    }
    
    @Override
    public double calcularConsumo(double distancia) {
        return distancia * CONSUMO_POR_KM;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cilindrada: " + cilindrada + " cc");
    }
}

// Subclase: Camión
public class Camion extends Vehiculo {
    private double capacidadCarga;
    private static final double CONSUMO_POR_KM = 0.25; // 25 litros/100km
    
    public Camion(String marca, String modelo, int año, double capacidadCarga) {
        super(marca, modelo, año);
        this.capacidadCarga = capacidadCarga;
    }
    
    @Override
    public double calcularConsumo(double distancia) {
        return distancia * CONSUMO_POR_KM;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Capacidad de carga: " + capacidadCarga + " toneladas");
    }
}

// Sistema de gestión
public class Main {
    public static void main(String[] args) {
        // Crear diferentes vehículos
        Vehiculo auto = new Auto("Toyota", "Corolla", 2024, 4);
        Vehiculo moto = new Motocicleta("Honda", "CBR", 2023, 600);
        Vehiculo camion = new Camion("Volvo", "FH16", 2024, 20);
        
        // Array de vehículos (polimorfismo)
        Vehiculo[] flota = {auto, moto, camion};
        
        // Conducir todos los vehículos
        for (Vehiculo v : flota) {
            v.mostrarInfo();
            v.conducir(100);
            System.out.println();
        }
    }
}
```

## Ventajas de la POO

### 1. Modularidad
```java
// Cada clase es un módulo independiente
public class Usuario { }
public class Producto { }
public class Pedido { }

// Fácil de mantener y modificar
```

### 2. Reutilización de código
```java
// Crear clase base una vez
public class Animal { }

// Reutilizar en múltiples subclases
public class Perro extends Animal { }
public class Gato extends Animal { }
public class Pajaro extends Animal { }
```

### 3. Mantenibilidad
```java
// Cambios en una clase no afectan otras
public class CuentaBancaria {
    private void validarSaldo() {
        // Cambiar esta lógica no afecta código externo
    }
}
```

### 4. Escalabilidad
```java
// Fácil agregar nuevas funcionalidades
public class NuevoTipoEmpleado extends Empleado {
    // Solo implementar lo específico
}
```

### 5. Seguridad
```java
// Encapsulamiento protege datos críticos
private String password;
private double saldoCuenta;
```

## POO vs Programación Estructurada

### Programación Estructurada (sin POO):

```java
// Todo son funciones y variables globales
public class ProgramaEstructurado {
    // Variables globales
    static String nombreUsuario1 = "Juan";
    static int edadUsuario1 = 25;
    static String nombreUsuario2 = "María";
    static int edadUsuario2 = 30;
    
    // Funciones sueltas
    static void saludarUsuario1() {
        System.out.println("Hola, soy " + nombreUsuario1);
    }
    
    static void saludarUsuario2() {
        System.out.println("Hola, soy " + nombreUsuario2);
    }
    
    static void cumplirAñosUsuario1() {
        edadUsuario1++;
    }
    
    // Repetición de código, difícil de escalar
}
```

### Programación Orientada a Objetos:

```java
// Modelamos con clases y objetos
public class Persona {
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
    
    public void cumplirAños() {
        edad++;
    }
}

// Uso limpio y escalable
Persona juan = new Persona("Juan", 25);
Persona maria = new Persona("María", 30);
Persona pedro = new Persona("Pedro", 35);
// Fácil crear más usuarios
```

## Principios SOLID (Buenas prácticas de POO)

### S - Single Responsibility (Responsabilidad Única)
```java
// ❌ Clase con múltiples responsabilidades
public class Usuario {
    public void guardarEnBaseDatos() { }
    public void enviarEmail() { }
    public void generarReporte() { }
}

// ✅ Cada clase una responsabilidad
public class Usuario {
    // Solo maneja datos del usuario
}

public class RepositorioUsuario {
    public void guardar(Usuario usuario) { }
}

public class ServicioEmail {
    public void enviar(Usuario usuario) { }
}
```

### O - Open/Closed (Abierto/Cerrado)
```java
// Abierto para extensión, cerrado para modificación
public abstract class Descuento {
    public abstract double calcular(double monto);
}

public class DescuentoEstudiante extends Descuento {
    public double calcular(double monto) {
        return monto * 0.10;
    }
}

public class DescuentoSenior extends Descuento {
    public double calcular(double monto) {
        return monto * 0.15;
    }
}
```

## Resumen

| Concepto | Descripción | Ejemplo |
|----------|-------------|---------|
| **Clase** | Plantilla para crear objetos | `class Persona { }` |
| **Objeto** | Instancia de una clase | `Persona juan = new Persona()` |
| **Encapsulamiento** | Ocultar detalles internos | `private int edad;` |
| **Herencia** | Reutilizar código de clase padre | `class Perro extends Animal` |
| **Polimorfismo** | Mismo método, diferente comportamiento | `@Override` |
| **Abstracción** | Ocultar complejidad | `abstract class Figura` |
| **Interfaz** | Contrato que deben cumplir las clases | `interface Reproducible` |

## Conclusión

La Programación Orientada a Objetos es un paradigma poderoso que:

✅ Organiza el código de forma natural y lógica  
✅ Facilita el mantenimiento y escalabilidad  
✅ Promueve la reutilización de código  
✅ Modela el mundo real de forma intuitiva  
✅ Mejora la colaboración en equipo  
✅ Reduce la complejidad de sistemas grandes  

**POO no es solo sintaxis, es una forma de pensar y diseñar software.**
***
19. ¿Cuáles son los cuatro pilares de la Programación Orientada a Objetos?

### R:

# Los Cuatro Pilares de la Programación Orientada a Objetos

## Introducción

La POO se fundamenta en cuatro conceptos principales que permiten crear código organizado, reutilizable y mantenible.

## 1. Encapsulamiento

**Ocultar los datos internos** de un objeto y permitir el acceso solo a través de métodos públicos.

```java
public class CuentaBancaria {
    private double saldo;  // Dato privado
    
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
    
    public double consultarSaldo() {
        return saldo;
    }
}

// Uso
CuentaBancaria cuenta = new CuentaBancaria();
cuenta.depositar(100);
// cuenta.saldo = -50;  // ❌ Error: saldo es privado
```

**Ventajas:**
- Protege los datos de modificaciones incorrectas
- Permite validar valores antes de asignarlos
- Facilita cambios internos sin afectar código externo

---

## 2. Herencia

**Crear nuevas clases basadas en clases existentes**, heredando sus atributos y métodos.

```java
// Clase padre
public class Animal {
    protected String nombre;
    
    public void comer() {
        System.out.println(nombre + " está comiendo");
    }
}

// Clase hija
public class Perro extends Animal {
    public void ladrar() {
        System.out.println(nombre + " dice: ¡Guau!");
    }
}

// Uso
Perro miPerro = new Perro();
miPerro.nombre = "Max";
miPerro.comer();    // Heredado de Animal
miPerro.ladrar();   // Propio de Perro
```

**Ventajas:**
- Reutilización de código
- Evita duplicación
- Organiza clases en jerarquías lógicas

---

## 3. Polimorfismo

**Permite que objetos de diferentes clases respondan al mismo método de forma diferente.**

```java
public class Empleado {
    public double calcularSalario() {
        return 3000;
    }
}

public class EmpleadoPermanente extends Empleado {
    @Override
    public double calcularSalario() {
        return 3000 + 500;  // Con bono
    }
}

public class EmpleadoPorHoras extends Empleado {
    @Override
    public double calcularSalario() {
        return 160 * 25;  // 160 horas × $25
    }
}

// Uso - mismo método, resultado diferente
Empleado emp1 = new EmpleadoPermanente();
Empleado emp2 = new EmpleadoPorHoras();

System.out.println(emp1.calcularSalario());  // 3500
System.out.println(emp2.calcularSalario());  // 4000
```

**Ventajas:**
- Flexibilidad en el código
- Permite tratar objetos diferentes de forma uniforme
- Facilita agregar nuevas funcionalidades

---

## 4. Abstracción

**Ocultar la complejidad y mostrar solo lo esencial.** Se logra con clases abstractas e interfaces.

```java
// Clase abstracta
public abstract class FiguraGeometrica {
    // Métodos que las subclases DEBEN implementar
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

// Implementación concreta
public class Circulo extends FiguraGeometrica {
    private double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

// Uso
FiguraGeometrica figura = new Circulo(5);
System.out.println("Área: " + figura.calcularArea());
```

**Ventajas:**
- Simplifica el uso de objetos complejos
- Define "contratos" que las clases deben cumplir
- Permite trabajar con conceptos generales

---

## Resumen Rápido

| Pilar | ¿Qué hace? | Ejemplo |
|-------|-----------|---------|
| **Encapsulamiento** | Oculta datos internos | `private double saldo;` |
| **Herencia** | Reutiliza código de clase padre | `class Perro extends Animal` |
| **Polimorfismo** | Mismo método, comportamiento diferente | `@Override calcularSalario()` |
| **Abstracción** | Oculta complejidad | `abstract class Figura` |

## Ejemplo Integrado

```java
// Abstracción: clase abstracta
public abstract class Vehiculo {
    // Encapsulamiento: atributo privado
    private String marca;
    
    public Vehiculo(String marca) {
        this.marca = marca;
    }
    
    // Método abstracto
    public abstract double calcularConsumo();
    
    public String getMarca() {
        return marca;
    }
}

// Herencia: extiende Vehiculo
public class Auto extends Vehiculo {
    public Auto(String marca) {
        super(marca);
    }
    
    // Polimorfismo: sobrescribe el método
    @Override
    public double calcularConsumo() {
        return 8.0;  // 8 litros/100km
    }
}

public class Moto extends Vehiculo {
    public Moto(String marca) {
        super(marca);
    }
    
    // Polimorfismo: comportamiento diferente
    @Override
    public double calcularConsumo() {
        return 4.0;  // 4 litros/100km
    }
}

// Uso de los 4 pilares
Vehiculo auto = new Auto("Toyota");
Vehiculo moto = new Moto("Honda");

System.out.println(auto.getMarca() + ": " + auto.calcularConsumo() + " L/100km");
System.out.println(moto.getMarca() + ": " + moto.calcularConsumo() + " L/100km");
```

Estos cuatro pilares trabajan juntos para crear código organizado, flexible y mantenible en la Programación Orientada a Objetos.
***

20. ¿Qué es la herencia en POO y cómo se utiliza en Java?

## R:
# Herencia en POO y Java

## ¿Qué es la herencia?

La **herencia** es un mecanismo que permite crear nuevas clases (hijas) basadas en clases existentes (padres), reutilizando sus atributos y métodos.

**Analogía:** Es como heredar características de tus padres (ojos, altura) pero también tener tus propias características únicas.

## Sintaxis básica en Java

```java
// Clase padre (superclase)
public class ClasePadre {
    // atributos y métodos
}

// Clase hija (subclase)
public class ClaseHija extends ClasePadre {
    // hereda todo de ClasePadre + puede agregar más
}
```

## Ejemplo simple

```java
// Clase padre
public class Animal {
    protected String nombre;
    protected int edad;
    
    public void comer() {
        System.out.println(nombre + " está comiendo");
    }
    
    public void dormir() {
        System.out.println(nombre + " está durmiendo");
    }
}

// Clase hija
public class Perro extends Animal {
    private String raza;
    
    // Método propio de Perro
    public void ladrar() {
        System.out.println(nombre + " dice: ¡Guau guau!");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Perro miPerro = new Perro();
        miPerro.nombre = "Max";
        
        // Métodos heredados de Animal
        miPerro.comer();    // "Max está comiendo"
        miPerro.dormir();   // "Max está durmiendo"
        
        // Método propio de Perro
        miPerro.ladrar();   // "Max dice: ¡Guau guau!"
    }
}
```

## Palabra clave `super`

`super` permite acceder a miembros de la clase padre.

```java
public class Animal {
    protected String nombre;
    
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

public class Gato extends Animal {
    private String color;
    
    // Constructor usando super
    public Gato(String nombre, String color) {
        super(nombre);  // Llama al constructor del padre
        this.color = color;
    }
    
    @Override
    public void hacerSonido() {
        super.hacerSonido();  // Llama al método del padre
        System.out.println("El gato dice: ¡Miau!");
    }
}

// Uso
Gato miGato = new Gato("Luna", "Blanco");
miGato.hacerSonido();
// Salida:
// El animal hace un sonido
// El gato dice: ¡Miau!
```

## Sobrescritura de métodos (`@Override`)

Las clases hijas pueden **cambiar el comportamiento** de métodos heredados.

```java
public class Vehiculo {
    public void acelerar() {
        System.out.println("El vehículo acelera");
    }
}

public class Carro extends Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("El carro acelera con motor de gasolina");
    }
}

public class Bicicleta extends Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("La bicicleta acelera pedaleando");
    }
}

// Uso
Vehiculo carro = new Carro();
Vehiculo bici = new Bicicleta();

carro.acelerar();  // "El carro acelera con motor de gasolina"
bici.acelerar();   // "La bicicleta acelera pedaleando"
```

## Modificadores de acceso en herencia

```java
public class Padre {
    public String publico;        // Accesible en clase hija ✅
    protected String protegido;   // Accesible en clase hija ✅
    private String privado;       // NO accesible en clase hija ❌
    String paquete;              // Accesible si están en mismo paquete
}

public class Hijo extends Padre {
    public void metodo() {
        System.out.println(publico);     // ✅ OK
        System.out.println(protegido);   // ✅ OK
        // System.out.println(privado);  // ❌ Error
    }
}
```

## Herencia multinivel

Una clase puede heredar de otra que ya heredó de otra.

```java
// Nivel 1
public class SerVivo {
    public void respirar() {
        System.out.println("Respirando...");
    }
}

// Nivel 2
public class Animal extends SerVivo {
    public void moverse() {
        System.out.println("Moviéndose...");
    }
}

// Nivel 3
public class Perro extends Animal {
    public void ladrar() {
        System.out.println("¡Guau!");
    }
}

// Uso
Perro miPerro = new Perro();
miPerro.respirar();  // De SerVivo
miPerro.moverse();   // De Animal
miPerro.ladrar();    // De Perro
```

## Ejemplo práctico: Sistema de empleados

```java
// Clase base
public class Empleado {
    protected String nombre;
    protected double salarioBase;
    
    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    
    public double calcularSalario() {
        return salarioBase;
    }
    
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Salario: $" + calcularSalario());
    }
}

// Empleado con bono
public class EmpleadoConBono extends Empleado {
    private double bono;
    
    public EmpleadoConBono(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + bono;
    }
}

// Gerente
public class Gerente extends Empleado {
    private double bonoGerencial;
    private int numeroEmpleados;
    
    public Gerente(String nombre, double salarioBase, int numeroEmpleados) {
        super(nombre, salarioBase);
        this.numeroEmpleados = numeroEmpleados;
        this.bonoGerencial = numeroEmpleados * 100;  // $100 por empleado
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + bonoGerencial;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Empleados a cargo: " + numeroEmpleados);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Empleado emp1 = new Empleado("Juan", 2000);
        Empleado emp2 = new EmpleadoConBono("María", 2000, 500);
        Empleado emp3 = new Gerente("Pedro", 3000, 10);
        
        emp1.mostrarInfo();
        System.out.println();
        emp2.mostrarInfo();
        System.out.println();
        emp3.mostrarInfo();
    }
}
```

**Salida:**
```
Empleado: Juan
Salario: $2000.0

Empleado: María
Salario: $2500.0

Empleado: Pedro
Salario: $4000.0
Empleados a cargo: 10
```

## Ventajas de la herencia

✅ **Reutilización de código** - No repetir código común  
✅ **Organización** - Jerarquía lógica de clases  
✅ **Mantenimiento** - Cambios en padre afectan a todos los hijos  
✅ **Extensibilidad** - Fácil agregar nuevas clases  

## Reglas importantes

1. **Java solo permite herencia simple** - Una clase solo puede heredar de una clase padre
   ```java
   // ❌ No permitido
   public class Hijo extends Padre1, Padre2 { }
   
   // ✅ Permitido
   public class Hijo extends Padre { }
   ```

2. **Usar `extends` para heredar**
   ```java
   public class ClaseHija extends ClasePadre { }
   ```

3. **La clase `Object` es la raíz de todas las clases**
   ```java
   // Toda clase hereda implícitamente de Object
   public class MiClase extends Object { }
   // Es equivalente a:
   public class MiClase { }
   ```

4. **Los constructores NO se heredan**
   ```java
   public class Padre {
       public Padre(String nombre) { }
   }
   
   public class Hijo extends Padre {
       // Debes llamar explícitamente al constructor del padre
       public Hijo(String nombre) {
           super(nombre);
       }
   }
   ```

## Cuándo usar herencia

✅ **Usa herencia cuando:**
- Existe una relación "ES-UN" (Perro ES-UN Animal)
- Quieres reutilizar código de la clase padre
- Necesitas crear jerarquías de clases relacionadas

❌ **No uses herencia cuando:**
- La relación es "TIENE-UN" (usa composición en su lugar)
- Las clases no están relacionadas conceptualmente
- Solo quieres reutilizar algunos métodos

## Ejemplo de composición vs herencia

```java
// ❌ Herencia incorrecta
public class Motor {
    public void encender() { }
}

public class Carro extends Motor {  // Mal: Carro no ES-UN Motor
}

// ✅ Composición correcta
public class Motor {
    public void encender() { }
}

public class Carro {
    private Motor motor;  // Correcto: Carro TIENE-UN Motor
    
    public Carro() {
        this.motor = new Motor();
    }
    
    public void encender() {
        motor.encender();
    }
}
```

## Resumen

| Concepto | Descripción | Sintaxis |
|----------|-------------|----------|
| **Herencia** | Clase hija hereda de padre | `class Hijo extends Padre` |
| **super** | Acceder a miembros del padre | `super.metodo()` o `super()` |
| **@Override** | Sobrescribir método del padre | `@Override public void metodo()` |
| **protected** | Accesible en clase hija | `protected String atributo;` |

La herencia es fundamental en POO para crear código reutilizable y organizado. Permite modelar relaciones jerárquicas del mundo real de forma natural en Java.
***

21. ¿Qué son los modificadores de acceso y cuáles son los más comunes en Java?

## R:
# Modificadores de Acceso en Java

## ¿Qué son los modificadores de acceso?

Los **modificadores de acceso** controlan la visibilidad y accesibilidad de clases, atributos y métodos. Determinan **quién puede usar** cada elemento del código.

## Los 4 modificadores en Java

### 1. `public` - Acceso público (para todos)

**Accesible desde cualquier parte del código.**

```java
public class Persona {
    public String nombre;  // Cualquiera puede acceder
    
    public void saludar() {  // Cualquiera puede llamar
        System.out.println("Hola, soy " + nombre);
    }
}

// Uso desde cualquier clase
public class Main {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.nombre = "Juan";  // ✅ OK - public
        p.saludar();        // ✅ OK - public
    }
}
```

**Cuándo usar:**
- Métodos que deben ser accesibles desde fuera
- Clases que otros van a instanciar
- APIs públicas

---

### 2. `private` - Acceso privado (solo la clase)

**Solo accesible dentro de la misma clase.**

```java
public class CuentaBancaria {
    private double saldo;  // Solo accesible aquí
    
    private void validarSaldo() {  // Solo se usa internamente
        if (saldo < 0) {
            saldo = 0;
        }
    }
    
    public void depositar(double monto) {
        saldo += monto;  // ✅ OK - misma clase
        validarSaldo();  // ✅ OK - misma clase
    }
    
    public double consultarSaldo() {
        return saldo;  // ✅ OK - misma clase
    }
}

// Uso desde otra clase
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.depositar(100);         // ✅ OK - public
        // cuenta.saldo = -50;         // ❌ ERROR - private
        // cuenta.validarSaldo();      // ❌ ERROR - private
        double saldo = cuenta.consultarSaldo();  // ✅ OK - public
    }
}
```

**Cuándo usar:**
- Atributos que deben protegerse
- Métodos auxiliares internos
- Implementación que no debe ser visible

---

### 3. `protected` - Acceso protegido (clase + subclases + mismo paquete)

**Accesible en la misma clase, subclases (herencia) y clases del mismo paquete.**

```java
public class Animal {
    protected String nombre;  // Accesible en subclases
    
    protected void hacerSonido() {  // Accesible en subclases
        System.out.println("Sonido genérico");
    }
}

public class Perro extends Animal {
    public void ladrar() {
        nombre = "Max";  // ✅ OK - protected en subclase
        hacerSonido();   // ✅ OK - protected en subclase
    }
}

// Desde otra clase NO relacionada
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        // animal.nombre = "Rex";      // ❌ ERROR (si están en paquetes diferentes)
        // animal.hacerSonido();       // ❌ ERROR (si están en paquetes diferentes)
    }
}
```

**Cuándo usar:**
- Atributos que las subclases necesitan acceder
- Métodos que se usarán en herencia
- Cuando quieres permitir extensión de la clase

---

### 4. (default) - Acceso de paquete (sin modificador)

**Accesible solo dentro del mismo paquete.** No se escribe ninguna palabra clave.

```java
// Archivo: Animal.java (paquete: animales)
package animales;

class Animal {  // Sin modificador = default
    String nombre;  // Sin modificador = default
    
    void comer() {  // Sin modificador = default
        System.out.println("Comiendo...");
    }
}

// Archivo: Perro.java (mismo paquete: animales)
package animales;

public class Perro {
    public void metodo() {
        Animal animal = new Animal();  // ✅ OK - mismo paquete
        animal.nombre = "Max";         // ✅ OK - mismo paquete
        animal.comer();                // ✅ OK - mismo paquete
    }
}

// Archivo: Main.java (diferente paquete: principal)
package principal;
import animales.Animal;

public class Main {
    public static void main(String[] args) {
        // Animal animal = new Animal();  // ❌ ERROR - diferente paquete
    }
}
```

**Cuándo usar:**
- Clases auxiliares internas del paquete
- Código que solo se usa dentro del módulo
- Implementación que no debe ser pública

---

## Tabla comparativa

| Modificador | Misma clase | Mismo paquete | Subclase (herencia) | Todas las clases |
|-------------|-------------|---------------|---------------------|------------------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

## Ejemplo completo

```java
public class Empleado {
    // Atributos con diferentes modificadores
    public String nombre;           // Accesible desde cualquier lugar
    protected int empleadoID;       // Accesible en subclases
    double salario;                 // Accesible en mismo paquete (default)
    private String password;        // Solo accesible aquí
    
    // Constructor público
    public Empleado(String nombre, int id, double salario, String password) {
        this.nombre = nombre;
        this.empleadoID = id;
        this.salario = salario;
        this.password = password;
    }
    
    // Método público
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + empleadoID);
    }
    
    // Método protected (para subclases)
    protected double calcularBono() {
        return salario * 0.10;
    }
    
    // Método default (mismo paquete)
    void actualizarSalario(double nuevoSalario) {
        salario = nuevoSalario;
    }
    
    // Método privado (solo interno)
    private boolean validarPassword(String pass) {
        return this.password.equals(pass);
    }
    
    // Método público que usa el privado
    public boolean autenticar(String pass) {
        return validarPassword(pass);
    }
}

// Subclase
public class Gerente extends Empleado {
    public Gerente(String nombre, int id, double salario, String password) {
        super(nombre, id, salario, password);
    }
    
    public void mostrarBono() {
        // Acceso a miembros protected
        System.out.println("ID: " + empleadoID);  // ✅ protected
        double bono = calcularBono();             // ✅ protected
        System.out.println("Bono: $" + bono);
        
        // System.out.println(password);  // ❌ ERROR - private
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Juan", 101, 3000, "pass123");
        
        // Acceso public
        System.out.println(emp.nombre);  // ✅ OK
        emp.mostrarInfo();               // ✅ OK
        
        // Acceso protected (ERROR si está en diferente paquete)
        // System.out.println(emp.empleadoID);  // ❌
        
        // Acceso default (ERROR si está en diferente paquete)
        // emp.actualizarSalario(3500);  // ❌
        
        // Acceso private
        // System.out.println(emp.password);  // ❌ ERROR
        // emp.validarPassword("pass123");    // ❌ ERROR
        
        // Pero podemos usar el método público
        boolean autenticado = emp.autenticar("pass123");  // ✅ OK
    }
}
```

## Getters y Setters (Encapsulamiento)

Los métodos `get` y `set` se usan con atributos privados para controlar el acceso.

```java
public class Persona {
    private String nombre;
    private int edad;
    
    // Getter - obtener valor
    public String getNombre() {
        return nombre;
    }
    
    // Setter - establecer valor con validación
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 120) {
            this.edad = edad;
        }
    }
}

// Uso
Persona p = new Persona();
p.setNombre("Juan");  // ✅ Validado
p.setEdad(25);        // ✅ Validado
System.out.println(p.getNombre());  // Juan
```

## Buenas prácticas

### ✅ Recomendado:

```java
public class BuenasPracticas {
    // Atributos privados
    private String dato;
    
    // Constructor público
    public BuenasPracticas(String dato) {
        this.dato = dato;
    }
    
    // Getters/setters públicos
    public String getDato() {
        return dato;
    }
    
    public void setDato(String dato) {
        this.dato = dato;
    }
    
    // Métodos auxiliares privados
    private void validar() {
        // lógica interna
    }
    
    // Métodos de negocio públicos
    public void procesar() {
        validar();
        // lógica pública
    }
}
```

### ❌ Evitar:

```java
public class MalasPracticas {
    // ❌ Atributos públicos sin control
    public String dato;
    public double saldo;
    
    // ❌ Todo público sin razón
    public void metodoInterno() {
        // debería ser private
    }
}
```

## Reglas de uso

1. **Atributos:** Casi siempre `private`
2. **Constructores:** Generalmente `public`
3. **Métodos públicos:** API que otros usarán → `public`
4. **Métodos auxiliares:** Solo para uso interno → `private`
5. **Herencia:** Lo que subclases necesitan → `protected`
6. **Paquete:** Código interno del módulo → default

## Resumen rápido

| Modificador | Nivel de acceso | Uso común |
|-------------|-----------------|-----------|
| `public` | 🌍 Todo el mundo | APIs, interfaces públicas |
| `protected` | 👨‍👩‍👧 Familia (herencia) | Métodos para subclases |
| (default) | 🏠 Mismo paquete | Implementación interna |
| `private` | 🔒 Solo yo | Atributos, helpers |

**Principio clave:** Usa el modificador **más restrictivo posible**. Si no estás seguro, comienza con `private` y cambia si es necesario.

Los modificadores de acceso son fundamentales para el **encapsulamiento** y la **seguridad** del código en Java.

***

22. ¿Qué es una variable de entorno y por qué son importantes para Java o la programación en general?

## R:

# Variables de Entorno en Programación y Java

## ¿Qué es una variable de entorno?

Una **variable de entorno** es un valor almacenado en el sistema operativo que los programas pueden leer. Contiene información sobre el entorno donde se ejecuta el programa.

**Analogía:** Es como tener notas pegadas en tu computadora que cualquier programa puede leer cuando las necesita.

## Ejemplos comunes

```bash
# Variables de entorno típicas
PATH=/usr/bin:/usr/local/bin
HOME=/home/usuario
USER=juan
JAVA_HOME=/usr/lib/jvm/java-17
DATABASE_URL=jdbc:mysql://localhost:3306/midb
API_KEY=abc123xyz789
```

## ¿Por qué son importantes?

### 1. Separar código de configuración

```java
// ❌ Malo: Hardcodear valores en el código
public class App {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/midb";
        String apiKey = "abc123xyz789";
        // Si cambias de servidor, debes recompilar
    }
}

// ✅ Bueno: Usar variables de entorno
public class App {
    public static void main(String[] args) {
        String dbUrl = System.getenv("DATABASE_URL");
        String apiKey = System.getenv("API_KEY");
        // Puedes cambiar valores sin recompilar
    }
}
```

### 2. Seguridad

```java
// ❌ PELIGROSO: Contraseñas en el código
public class Database {
    private String password = "miPassword123";  // ¡Visible en Git!
}

// ✅ SEGURO: Contraseñas en variables de entorno
public class Database {
    private String password = System.getenv("DB_PASSWORD");
    // No se sube a Git, cada servidor tiene la suya
}
```

### 3. Diferentes entornos (desarrollo, producción)

```java
public class App {
    public static void main(String[] args) {
        String environment = System.getenv("ENV");
        String dbUrl;
        
        if ("production".equals(environment)) {
            dbUrl = System.getenv("PROD_DB_URL");
            // Base de datos de producción
        } else {
            dbUrl = System.getenv("DEV_DB_URL");
            // Base de datos de desarrollo
        }
    }
}
```

## Cómo leer variables de entorno en Java

### Método 1: `System.getenv()`

```java
public class LeerVariables {
    public static void main(String[] args) {
        // Leer variable específica
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("JAVA_HOME: " + javaHome);
        
        // Leer con valor por defecto
        String port = System.getenv("PORT");
        if (port == null) {
            port = "8080";  // Valor por defecto
        }
        System.out.println("Puerto: " + port);
        
        // Todas las variables de entorno
        System.getenv().forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }
}
```

### Método 2: Properties (archivo .properties)

```java
// archivo: config.properties
db.url=${DATABASE_URL}
db.user=${DB_USER}
db.password=${DB_PASSWORD}

// Código Java
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        
        String dbUrl = props.getProperty("db.url");
        System.out.println("URL: " + dbUrl);
    }
}
```

## Variables importantes para Java

### JAVA_HOME

Indica dónde está instalado Java.

```bash
# Linux/Mac
export JAVA_HOME=/usr/lib/jvm/java-17
export PATH=$JAVA_HOME/bin:$PATH

# Windows
set JAVA_HOME=C:\Program Files\Java\jdk-17
set PATH=%JAVA_HOME%\bin;%PATH%
```

**¿Para qué sirve?**
- IDEs y herramientas saben dónde está Java
- Compiladores y ejecutores encuentran el JDK
- Maven, Gradle, y otras herramientas lo usan

### PATH

Lista de directorios donde el sistema busca comandos ejecutables.

```bash
# Linux/Mac
export PATH=$PATH:/nueva/ruta

# Windows
set PATH=%PATH%;C:\nueva\ruta
```

**¿Para qué sirve?**
- Ejecutar `java` y `javac` desde cualquier lugar
- No necesitas escribir la ruta completa

### CLASSPATH

Indica dónde buscar archivos `.class` y librerías.

```bash
# Linux/Mac
export CLASSPATH=.:lib/*:/ruta/a/clases

# Windows
set CLASSPATH=.;lib\*;C:\ruta\a\clases
```

## Cómo configurar variables de entorno

### En Linux/Mac (temporal)

```bash
# En la terminal actual
export DATABASE_URL="jdbc:mysql://localhost:3306/midb"
export API_KEY="abc123"

# Verificar
echo $DATABASE_URL
```

### En Linux/Mac (permanente)

```bash
# Agregar al archivo ~/.bashrc o ~/.zshrc
echo 'export JAVA_HOME=/usr/lib/jvm/java-17' >> ~/.bashrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc

# Recargar configuración
source ~/.bashrc
```

### En Windows (temporal)

```cmd
# En CMD
set DATABASE_URL=jdbc:mysql://localhost:3306/midb
set API_KEY=abc123

# Verificar
echo %DATABASE_URL%
```

### En Windows (permanente)

```
1. Click derecho en "Este equipo" → Propiedades
2. Configuración avanzada del sistema
3. Variables de entorno
4. Agregar nueva variable
```

## Ejemplo práctico: Aplicación con configuración

```java
public class DatabaseConfig {
    private String url;
    private String username;
    private String password;
    private int maxConnections;
    
    public DatabaseConfig() {
        // Leer de variables de entorno
        this.url = System.getenv("DB_URL");
        this.username = System.getenv("DB_USERNAME");
        this.password = System.getenv("DB_PASSWORD");
        
        // Con valor por defecto
        String maxConn = System.getenv("DB_MAX_CONNECTIONS");
        this.maxConnections = (maxConn != null) ? Integer.parseInt(maxConn) : 10;
        
        // Validar que existan
        validarConfiguracion();
    }
    
    private void validarConfiguracion() {
        if (url == null || username == null || password == null) {
            throw new RuntimeException(
                "Faltan variables de entorno: DB_URL, DB_USERNAME, DB_PASSWORD"
            );
        }
    }
    
    public void conectar() {
        System.out.println("Conectando a: " + url);
        System.out.println("Usuario: " + username);
        System.out.println("Max conexiones: " + maxConnections);
        // Lógica de conexión...
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConfig config = new DatabaseConfig();
            config.conectar();
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
```

**Uso:**
```bash
# Configurar variables
export DB_URL="jdbc:mysql://localhost:3306/midb"
export DB_USERNAME="admin"
export DB_PASSWORD="secreto123"
export DB_MAX_CONNECTIONS="20"

# Ejecutar programa
java Main
```

## Archivo .env (común en desarrollo)

Muchos proyectos usan archivos `.env` para desarrollo local:

```bash
# archivo: .env
DATABASE_URL=jdbc:mysql://localhost:3306/midb
DB_USERNAME=admin
DB_PASSWORD=secreto123
API_KEY=abc123xyz789
PORT=8080
```

```java
// Leer archivo .env (usando librería)
import io.github.cdimascio.dotenv.Dotenv;

public class App {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        
        String dbUrl = dotenv.get("DATABASE_URL");
        String apiKey = dotenv.get("API_KEY");
        
        System.out.println("DB: " + dbUrl);
        System.out.println("API Key: " + apiKey);
    }
}
```

**⚠️ IMPORTANTE:** 
- Agregar `.env` al `.gitignore`
- Nunca subir credenciales a Git
- Usar `.env.example` como plantilla

```bash
# .gitignore
.env
*.env

# .env.example (SÍ se sube a Git)
DATABASE_URL=jdbc:mysql://localhost:3306/nombre_base
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_password
API_KEY=tu_api_key
```

## Ventajas de usar variables de entorno

✅ **Seguridad** - Credenciales fuera del código  
✅ **Flexibilidad** - Cambiar configuración sin recompilar  
✅ **Portabilidad** - Mismo código, diferentes ambientes  
✅ **Mantenimiento** - Más fácil actualizar valores  
✅ **12-Factor App** - Buena práctica reconocida  

## Casos de uso comunes

```java
// 1. Configuración de base de datos
String dbUrl = System.getenv("DATABASE_URL");

// 2. Claves API
String stripeKey = System.getenv("STRIPE_API_KEY");

// 3. Puerto del servidor
String port = System.getenv("PORT");

// 4. Nivel de logs
String logLevel = System.getenv("LOG_LEVEL");

// 5. Ambiente de ejecución
String env = System.getenv("ENVIRONMENT");

// 6. URL de servicios externos
String apiUrl = System.getenv("EXTERNAL_API_URL");

// 7. Credenciales de email
String emailUser = System.getenv("EMAIL_USERNAME");
String emailPass = System.getenv("EMAIL_PASSWORD");
```

## Buenas prácticas

### ✅ Hacer:

```java
// Validar que existan
String apiKey = System.getenv("API_KEY");
if (apiKey == null) {
    throw new RuntimeException("API_KEY no configurada");
}

// Usar valores por defecto cuando tenga sentido
String port = System.getenv("PORT");
if (port == null) {
    port = "8080";
}

// Documentar variables requeridas
// README.md:
// Variables de entorno requeridas:
// - DATABASE_URL: URL de conexión a la base de datos
// - API_KEY: Clave de la API externa
```

### ❌ Evitar:

```java
// ❌ Hardcodear valores sensibles
String password = "miPassword123";

// ❌ Subir .env a Git
// (usar .gitignore)

// ❌ No validar variables críticas
String db = System.getenv("DB_URL");
// ¿Qué pasa si es null?
```

## Resumen

| Aspecto | Sin variables de entorno | Con variables de entorno |
|---------|-------------------------|--------------------------|
| **Seguridad** | ❌ Credenciales en código | ✅ Credenciales protegidas |
| **Flexibilidad** | ❌ Recompilar para cambios | ✅ Cambio sin recompilar |
| **Ambientes** | ❌ Código duplicado | ✅ Mismo código, diferentes configs |
| **Colaboración** | ❌ Compartir credenciales | ✅ Cada uno tiene las suyas |

Las variables de entorno son esenciales para crear aplicaciones seguras, configurables y fáciles de mantener en Java y cualquier lenguaje de programación.
***
