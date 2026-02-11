# Git

***

1. ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto “normal”?

##### R: Un **repositorio en Git** es un espacio de almacenamiento que contiene los archivos de un proyecto junto con todo su historial de cambios. Internamente, incluye una carpeta oculta llamada `.git`, donde se guardan los metadatos, versiones, ramas, confirmaciones (*commits*) y configuraciones necesarias para el control de versiones.

La principal diferencia entre un **repositorio Git** y un **proyecto “normal”** (una simple carpeta con archivos) es que el repositorio permite:

- Registrar cambios a lo largo del tiempo.
- Volver a versiones anteriores del proyecto.
- Trabajar con ramas (*branches*) para desarrollar nuevas funcionalidades sin afectar la versión principal.
- Colaborar con otros desarrolladores mediante sistemas remotos como GitHub, GitLab o Bitbucket.

En cambio, un proyecto “normal” solo contiene archivos sin ningún sistema integrado para rastrear modificaciones, comparar versiones o gestionar trabajo colaborativo de forma estructurada.

En términos prácticos, todo repositorio es un proyecto, pero no todo proyecto es un repositorio.
***

2. ¿Cuáles son las tres áreas principales de Git (working directory, staging area/index y repository) y qué papel cumple cada una?

##### R:Git organiza el flujo de trabajo en **tres áreas principales**, cada una con una función específica dentro del control de versiones:

### - Working Directory (Directorio de trabajo)

El **Working Directory** es la carpeta del proyecto donde el desarrollador crea, edita y elimina archivos.  
Aquí se realizan todos los cambios directamente sobre los archivos del sistema.

- Contiene la versión actual visible del proyecto.
- Los cambios aún **no están registrados** en el historial de Git.
- Git detecta qué archivos han sido modificados, pero todavía no forman parte de un commit.

En esta etapa, los cambios están en estado *modified* (modificados).

---

###  Staging Area (Index)

La **Staging Area**, también llamada **Index**, es un área intermedia donde se preparan los cambios antes de confirmarlos definitivamente en el repositorio.

- Se agregan archivos con el comando `git add`.
- Permite seleccionar específicamente qué cambios se incluirán en el próximo commit.
- Funciona como una “zona de preparación” o “preconfirmación”.

En esta etapa, los archivos están en estado *staged* (preparados).

---

###  Repository (Repositorio local)

El **Repository** es la base de datos interna de Git donde se almacenan permanentemente los commits.

- Contiene el historial completo del proyecto.
- Cada commit guarda una instantánea del proyecto en un momento específico.
- Permite regresar a versiones anteriores, comparar cambios y gestionar ramas.

Cuando se ejecuta `git commit`, los cambios que estaban en el *staging area* pasan al repositorio y quedan registrados en el historial.

---

## Resumen del flujo

El flujo típico de trabajo en Git es:

1. Modificar archivos → *Working Directory*  
2. Preparar cambios → `git add` → *Staging Area*  
3. Confirmar cambios → `git commit` → *Repository*

Este modelo de tres áreas es lo que diferencia a Git de otros sistemas de control de versiones, ya que permite un control granular sobre qué cambios se registran en cada commit.
***
3. ¿Cómo representa Git los cambios internamente? (objetos blob, tree, commit y tag).

##### R: Git no almacena los cambios como diferencias tradicionales entre archivos, sino como una estructura de **objetos** dentro de una base de datos interna ubicada en la carpeta `.git`. Cada elemento del historial está compuesto por cuatro tipos principales de objetos: **blob, tree, commit y tag**.

---

### 1. Blob (Binary Large Object)

Un **blob** representa el contenido de un archivo.

- No almacena el nombre del archivo ni su ruta.
- Solo guarda los datos binarios del archivo.
- Cada blob se identifica mediante un **hash SHA-1 o SHA-256** (según configuración).
- Si dos archivos tienen exactamente el mismo contenido, comparten el mismo blob.

En términos prácticos:  
> Un blob es la “instantánea del contenido” de un archivo.

---

### 2. Tree

Un **tree** representa la estructura de directorios del proyecto en un momento determinado.

- Contiene referencias a blobs (archivos).
- Puede contener referencias a otros trees (subdirectorios).
- Guarda nombres de archivos, permisos y relaciones jerárquicas.

En términos prácticos:  
> Un tree es como una carpeta que organiza blobs y otros trees.

---

### 3. Commit

Un **commit** es el objeto que registra una versión del proyecto.

Incluye:

- Una referencia a un objeto **tree** (estado completo del proyecto).
- El hash del commit padre (o varios padres si es un merge).
- Autor y fecha.
- Mensaje de confirmación.

Cada commit forma parte de una **estructura encadenada**, donde cada uno apunta al anterior, creando el historial del proyecto.

En términos prácticos:  
> Un commit es una fotografía completa del proyecto en un momento específico, junto con su contexto histórico.

---

### 4. Tag

Un **tag** es una referencia que apunta a un commit específico.

Existen dos tipos:

- **Lightweight tag**: simple referencia a un commit.
- **Annotated tag**: objeto adicional que incluye autor, fecha y mensaje.

Se usa comúnmente para marcar versiones importantes (por ejemplo, `v1.0.0`).

En términos prácticos:  
> Un tag es una etiqueta permanente que señala una versión específica del proyecto.

---

## Relación entre los objetos

La estructura interna de Git funciona así:

Commit → Tree → (Blobs y otros Trees)
Y opcionalmente: 

Tag → Commit

Esto significa que Git no guarda “cambios” como diferencias acumulativas, sino como una red de objetos interconectados mediante hashes criptográficos. Esta arquitectura garantiza:

- Integridad de datos
- Eficiencia en almacenamiento
- Trazabilidad completa del historial


***

4. ¿Cómo se crea un commit y qué información almacena un objeto commit?

##### R: 
## Creación de un commit

Un commit se crea en tres pasos simples:

1. **Modificar archivos**: Realizas cambios en tu proyecto (editar, crear o eliminar archivos)

2. **Agregar al staging area**: Seleccionas qué cambios quieres incluir en el commit
   ```bash
   git add archivo.txt
   git add .  # Agrega todos los archivos modificados
   ```

3. **Crear el commit**: Guardas los cambios con un mensaje descriptivo
   ```bash
   git commit -m "Descripción clara de los cambios realizados"
   ```

**Ejemplo completo:**
```bash
# Editar archivo
nano index.html

# Agregar al staging
git add index.html

# Crear commit
git commit -m "Agrega estructura HTML inicial"
```

## Información almacenada en un objeto commit

Cada commit almacena la siguiente información:

- **Hash SHA-1**: Identificador único de 40 caracteres (ej: `a3f2b4c8e9d1f6a7b2c4d5e6f7g8h9i0j1k2l3m4`)
- **Autor**: Nombre y email de quien creó el commit
- **Fecha y hora**: Cuándo se realizó el commit
- **Mensaje**: Descripción de los cambios realizados
- **Snapshot del proyecto**: Estado completo de todos los archivos en ese momento
- **Referencia al commit padre**: Enlace al commit anterior (creando el historial)
- **Árbol de archivos (tree)**: Estructura de directorios y archivos del proyecto

**Ver información de un commit:**
```bash
git log                    # Ver historial de commits
git show      # Ver detalles de un commit específico
git log --oneline          # Ver historial resumido
```

**Ejemplo de salida de `git log`:**
```
commit a3f2b4c8e9d1f6a7b2c4d5e6f7g8h9i0j1k2l3m4
Author: Juan Pérez <juan@email.com>
Date:   Mon Feb 10 14:30:00 2026 -0500

    Agrega función de validación de formularios
    
    - Implementa validación de email
    - Agrega mensajes de error personalizados
```

Esta estructura hace que Git pueda rastrear completamente la evolución del proyecto y permite volver a cualquier punto en el tiempo.

***
5. ¿Cuál es la diferencia entre git pull y git fetch?

##### R:
## Git Fetch

`git fetch` descarga los cambios del repositorio remoto a tu repositorio local, pero **NO** los fusiona automáticamente con tu rama actual. Solo actualiza las referencias remotas.

```bash
git fetch origin
```

**¿Qué hace?**
- Descarga commits, archivos y referencias del repositorio remoto
- Actualiza las ramas remotas (origin/main, origin/develop, etc.)
- Tu rama de trabajo local permanece sin cambios
- Te permite revisar los cambios antes de integrarlos

**Cuándo usarlo:**
- Quieres ver qué cambios hay en el remoto sin modificar tu código
- Necesitas revisar los cambios antes de fusionarlos
- Trabajas en una funcionalidad y no quieres interrupciones

**Ejemplo:**
```bash
git fetch origin          # Descarga cambios
git log origin/main       # Revisa los nuevos commits
git diff origin/main      # Compara con tu rama actual
git merge origin/main     # Fusiona cuando estés listo
```

## Git Pull

`git pull` descarga los cambios del repositorio remoto **Y** los fusiona automáticamente con tu rama actual. Es equivalente a hacer `git fetch` + `git merge`.

```bash
git pull origin main
```

**¿Qué hace?**
- Descarga los cambios del repositorio remoto (fetch)
- Fusiona automáticamente esos cambios con tu rama actual (merge)
- Actualiza tu directorio de trabajo inmediatamente
- Puede generar conflictos que debes resolver

**Cuándo usarlo:**
- Confías en que los cambios remotos no generarán conflictos
- Quieres actualizar rápidamente tu rama local
- Trabajas en sincronía constante con el equipo

**Ejemplo:**
```bash
git pull origin main      # Descarga y fusiona en un solo paso
```

## Comparación directa

| Característica | `git fetch` | `git pull` |
|----------------|-------------|------------|
| **Descarga cambios** | ✅ Sí | ✅ Sí |
| **Fusiona automáticamente** | ❌ No | ✅ Sí |
| **Modifica tu código** | ❌ No | ✅ Sí |
| **Seguridad** | 🟢 Más seguro | 🟡 Menos seguro |
| **Control** | 🟢 Total control | 🟡 Control limitado |
| **Equivalente a** | Solo descarga | `fetch` + `merge` |

## Flujo de trabajo recomendado

### Opción segura (fetch + merge):
```bash
# 1. Descargar cambios sin fusionar
git fetch origin

# 2. Revisar qué cambios hay
git log origin/main

# 3. Ver diferencias
git diff main origin/main

# 4. Fusionar cuando estés listo
git merge origin/main
```

### Opción rápida (pull):
```bash
# Todo en un paso
git pull origin main
```

## Ejemplo práctico

**Escenario:** Tu compañero subió cambios al repositorio remoto

**Con fetch:**
```bash
git fetch origin
# Output: From https://github.com/usuario/proyecto
#          a3f2b4c..e5d6f7g  main -> origin/main

git status
# Output: Your branch is behind 'origin/main' by 3 commits

# Revisas los cambios
git log origin/main

# Decides fusionar
git merge origin/main
```

**Con pull:**
```bash
git pull origin main
# Output: Updating a3f2b4c..e5d6f7g
#         Fast-forward
#          archivo.js | 10 +++++-----
#          1 file changed, 5 insertions(+), 5 deletions(-)
```

## Recomendación

- **Usa `git fetch`** cuando quieras ser cuidadoso y revisar cambios antes de integrarlos
- **Usa `git pull`** cuando estés seguro de que no habrá conflictos o trabajes solo en el proyecto

**Regla de oro:** Si tienes dudas, usa `fetch` primero. Es más seguro y te da control total sobre cuándo y cómo integrar los cambios.

***
6. ¿Qué es un branch (rama) en Git y cómo Git gestiona los punteros a commits?

#### R: 
### ¿Qué es un branch (rama)?

Un **branch** o rama en Git es simplemente un **puntero móvil** que apunta a un commit específico. Permite crear líneas de desarrollo independientes sin afectar el código principal del proyecto.

```bash
# Ver ramas existentes
git branch

# Crear una nueva rama
git branch nueva-funcionalidad

# Cambiar a una rama
git checkout nueva-funcionalidad

# Crear y cambiar a una rama en un solo comando
git checkout -b nueva-funcionalidad
```

**Conceptos clave:**
- Una rama NO es una copia del código, es solo un puntero ligero
- Puedes tener múltiples ramas trabajando en paralelo
- La rama por defecto se llama `main` o `master`
- Crear una rama es instantáneo y consume muy poco espacio

## ¿Cómo Git gestiona los punteros a commits?

Git utiliza un sistema de **punteros** para gestionar ramas y el historial de commits de forma eficiente.

### Punteros principales en Git:

#### 1. **Punteros de rama (branch pointers)**
Cada rama es un puntero que apunta al último commit de esa línea de desarrollo.

```
main    -> a3f2b4c (commit más reciente de main)
develop -> e5d6f7g (commit más reciente de develop)
feature -> b8c9d0e (commit más reciente de feature)
```

#### 2. **HEAD: El puntero especial**
`HEAD` es un puntero que indica **en qué rama estás trabajando actualmente** y apunta al commit donde te encuentras.

```bash
# Ver dónde apunta HEAD
git log --oneline --decorate

# Normalmente HEAD apunta a una rama
HEAD -> main -> a3f2b4c
```

**Estados de HEAD:**
- **HEAD normal**: Apunta a una rama
  ```
  HEAD -> main -> commit-abc123
  ```
- **Detached HEAD**: Apunta directamente a un commit (sin rama)
  ```
  HEAD -> commit-abc123
  ```

### Ejemplo visual de punteros

**Estado inicial:**
```
       A---B---C  (main, HEAD)
```

**Crear una rama:**
```bash
git branch feature
```

```
       A---B---C  (main, HEAD, feature)
```
Ahora `main` y `feature` apuntan al mismo commit C.

**Cambiar a la nueva rama:**
```bash
git checkout feature
```

```
       A---B---C  (main, feature, HEAD)
```
HEAD ahora apunta a `feature`.

**Hacer un commit en feature:**
```bash
git commit -m "Nuevo feature"
```

```
       A---B---C  (main)
                \
                 D  (feature, HEAD)
```
`feature` y HEAD avanzan al commit D, mientras `main` permanece en C.

**Volver a main y hacer otro commit:**
```bash
git checkout main
git commit -m "Hotfix"
```

```
       A---B---C---E  (main, HEAD)
                \
                 D  (feature)
```

### Cómo avanzan los punteros

Cuando haces un commit, Git:

1. **Crea el nuevo objeto commit** con toda su información
2. **Mueve el puntero de la rama actual** al nuevo commit
3. **Mueve HEAD junto con la rama**

```bash
# Estado antes del commit
HEAD -> main -> commit-C

# Hacer commit
git commit -m "Nuevo cambio"

# Estado después del commit
HEAD -> main -> commit-D (nuevo)
                 ↑
           commit-C (padre)
```

## Comandos útiles para trabajar con ramas

### Crear y gestionar ramas:
```bash
# Listar todas las ramas
git branch

# Listar ramas con su último commit
git branch -v

# Crear nueva rama
git branch nombre-rama

# Cambiar de rama
git checkout nombre-rama

# Crear y cambiar de rama
git checkout -b nombre-rama

# Cambiar de rama (sintaxis moderna)
git switch nombre-rama

# Crear y cambiar de rama (sintaxis moderna)
git switch -c nombre-rama

# Eliminar una rama
git branch -d nombre-rama

# Eliminar una rama forzadamente
git branch -D nombre-rama
```

### Ver el estado de los punteros:
```bash
# Ver historial con decoración de ramas
git log --oneline --decorate --graph --all

# Ver dónde apunta cada rama
git show-ref

# Ver dónde apunta HEAD
cat .git/HEAD
```

## Ejemplo práctico completo

```bash
# 1. Crear un nuevo repositorio
git init mi-proyecto
cd mi-proyecto

# 2. Hacer primer commit
echo "# Mi Proyecto" > README.md
git add README.md
git commit -m "Commit inicial"
# Estado: HEAD -> main -> commit-A

# 3. Crear rama para nueva funcionalidad
git checkout -b feature/login
# Estado: HEAD -> feature/login -> commit-A

# 4. Hacer cambios en la rama feature
echo "Login page" > login.html
git add login.html
git commit -m "Agrega página de login"
# Estado: HEAD -> feature/login -> commit-B
#         main -> commit-A

# 5. Volver a main
git checkout main
# Estado: HEAD -> main -> commit-A

# 6. Hacer cambios en main
echo "Home page" > index.html
git add index.html
git commit -m "Agrega página principal"
# Estado: HEAD -> main -> commit-C
#         feature/login -> commit-B

# 7. Ver el estado del repositorio
git log --oneline --graph --all
```

**Salida del comando anterior:**
```
* c3a5b7d (HEAD -> main) Agrega página principal
| * b2d4f6e (feature/login) Agrega página de login
|/
* a1c3e5g Commit inicial
```

## Ventajas del sistema de punteros

1. **Eficiencia**: Crear ramas es instantáneo (solo crea un puntero de 41 bytes)
2. **Flexibilidad**: Puedes tener cientos de ramas sin problemas de rendimiento
3. **Experimentación segura**: Crea ramas para probar ideas sin riesgo
4. **Organización**: Cada funcionalidad o corrección puede tener su propia rama
5. **Colaboración**: Múltiples desarrolladores pueden trabajar en paralelo

## Resumen

- **Rama**: Puntero ligero que apunta a un commit
- **HEAD**: Puntero especial que indica dónde estás trabajando
- **Commits**: Nodos conectados que forman el historial
- **Sistema de punteros**: Permite gestionar múltiples líneas de desarrollo de forma eficiente

Los punteros en Git hacen que trabajar con ramas sea extremadamente rápido y eficiente, permitiendo flujos de trabajo complejos sin consumir recursos significativos.
***
7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?

## R: 
### ¿Qué es un merge?

Un **merge** (fusión) es el proceso de integrar los cambios de una rama en otra. Combina el historial de dos ramas diferentes en una sola.

```bash
# Fusionar una rama en la rama actual
git merge nombre-rama
```

## Cómo realizar un merge

### Pasos básicos:

```bash
# 1. Cambiar a la rama que recibirá los cambios (destino)
git checkout main

# 2. Fusionar la rama que contiene los cambios (origen)
git merge feature/nueva-funcionalidad

# 3. Si no hay conflictos, el merge se completa automáticamente
```

### Ejemplo completo:

```bash
# Situación inicial: tienes dos ramas
# main: A---B---C
# feature:      \---D---E

# Paso 1: Asegurarte de estar en main
git checkout main

# Paso 2: Verificar el estado
git status

# Paso 3: Fusionar feature en main
git merge feature

# Resultado: main ahora incluye los commits D y E
# main: A---B---C---F (merge commit)
#            \     /
#             D---E (feature)
```

## Tipos de merge

### 1. **Fast-Forward Merge** (Fusión rápida)

Ocurre cuando la rama destino no ha tenido cambios desde que se creó la rama origen.

```bash
# Antes del merge
main:    A---B
feature:      \---C---D

# Después del merge (fast-forward)
main:    A---B---C---D
feature:             

# Comando
git merge feature
```

**Características:**
- No crea un commit de merge
- Solo mueve el puntero de la rama
- Historial lineal y limpio

### 2. **Three-Way Merge** (Fusión de tres vías)

Ocurre cuando ambas ramas tienen commits diferentes desde su punto de divergencia.

```bash
# Antes del merge
main:    A---B---C
feature:      \---D---E

# Después del merge
main:    A---B---C---F (nuevo commit de merge)
              \     /
feature:       D---E

# Comando
git merge feature
```

**Características:**
- Crea un commit de merge automáticamente
- Tiene dos commits padres
- Preserva el historial completo

### Comandos de merge:

```bash
# Merge normal
git merge rama-origen

# Merge sin fast-forward (siempre crea commit de merge)
git merge --no-ff rama-origen

# Merge con mensaje personalizado
git merge rama-origen -m "Fusión de nueva funcionalidad"

# Ver ramas fusionadas
git branch --merged

# Ver ramas no fusionadas
git branch --no-merged
```

## Conflictos en merge

### ¿Cuándo surgen conflictos?

Los conflictos ocurren cuando Git no puede fusionar automáticamente los cambios porque:

1. **Modificaciones en la misma línea**: Dos ramas editaron la misma línea de un archivo de forma diferente
2. **Archivo editado vs eliminado**: Una rama editó un archivo que otra rama eliminó
3. **Cambios incompatibles**: Modificaciones que se contradicen entre sí

### Ejemplo de conflicto:

**En la rama `main`:**
```javascript
function saludar() {
    console.log("Hola desde main");
}
```

**En la rama `feature`:**
```javascript
function saludar() {
    console.log("Hola desde feature");
}
```

**Al hacer merge:**
```bash
git merge feature
# Output: CONFLICT (content): Merge conflict in app.js
#         Automatic merge failed; fix conflicts and then commit the result.
```

## Cómo identificar conflictos

### Ver archivos con conflictos:

```bash
# Ver estado del repositorio
git status
```

**Salida:**
```
On branch main
You have unmerged paths.
  (fix conflicts and run "git commit")

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   app.js

no changes added to commit
```

### Estructura de un conflicto:

Cuando hay un conflicto, Git marca el archivo así:

```javascript
function saludar() {
<<<<<<< HEAD
    console.log("Hola desde main");
=======
    console.log("Hola desde feature");
>>>>>>> feature
}
```

**Explicación de las marcas:**
- `<<<<<<< HEAD`: Inicio de los cambios en tu rama actual (main)
- `=======`: Separador entre los dos conjuntos de cambios
- `>>>>>>> feature`: Fin de los cambios de la rama que estás fusionando

## Cómo resolver conflictos

### Método 1: Resolución manual

```bash
# Paso 1: Identificar archivos con conflictos
git status

# Paso 2: Abrir el archivo conflictivo en tu editor
nano app.js  # o usar VS Code, vim, etc.

# Paso 3: Editar el archivo para resolver el conflicto
# Decide qué versión mantener o combina ambas
```

**Ejemplo de resolución:**

**Antes (con conflicto):**
```javascript
function saludar() {
<<<<<<< HEAD
    console.log("Hola desde main");
=======
    console.log("Hola desde feature");
>>>>>>> feature
}
```

**Opción A - Mantener solo main:**
```javascript
function saludar() {
    console.log("Hola desde main");
}
```

**Opción B - Mantener solo feature:**
```javascript
function saludar() {
    console.log("Hola desde feature");
}
```

**Opción C - Combinar ambas:**
```javascript
function saludar() {
    console.log("Hola desde main y feature");
}
```

```bash
# Paso 4: Marcar el conflicto como resuelto
git add app.js

# Paso 5: Completar el merge
git commit -m "Resuelve conflicto en función saludar"

# Si quieres usar el mensaje predeterminado
git commit
```

### Método 2: Herramientas de merge

```bash
# Usar herramienta de merge visual
git mergetool

# Configurar VS Code como herramienta de merge
git config --global merge.tool vscode
git config --global mergetool.vscode.cmd 'code --wait $MERGED'
```

### Método 3: Aceptar todos los cambios de una rama

```bash
# Aceptar todos los cambios de la rama actual (main)
git checkout --ours archivo.js
git add archivo.js

# Aceptar todos los cambios de la rama entrante (feature)
git checkout --theirs archivo.js
git add archivo.js
```

## Comandos útiles durante conflictos

```bash
# Ver archivos en conflicto
git diff --name-only --diff-filter=U

# Ver detalles del conflicto
git diff

# Cancelar el merge y volver al estado anterior
git merge --abort

# Ver el historial de merges
git log --merges

# Ver el estado del merge
git status
```

## Ejemplo completo de resolución de conflictos

```bash
# 1. Intentar fusionar
git checkout main
git merge feature

# Output: CONFLICT (content): Merge conflict in index.html
#         Automatic merge failed; fix conflicts and then commit the result.

# 2. Ver archivos en conflicto
git status
# Output: both modified:   index.html

# 3. Abrir el archivo y ver el conflicto
cat index.html
```

**Contenido de index.html:**
```html



<<<<<<< HEAD
    Mi Proyecto - Main
=======
    Mi Proyecto - Feature
>>>>>>> feature


    Bienvenido


```

```bash
# 4. Editar el archivo para resolver el conflicto
nano index.html
```

**Después de editar:**
```html



    Mi Proyecto - Versión Completa


    Bienvenido


```

```bash
# 5. Marcar como resuelto
git add index.html

# 6. Verificar estado
git status
# Output: All conflicts fixed but you are still merging.

# 7. Completar el merge
git commit -m "Merge feature: resuelve conflicto en título"

# 8. Verificar el resultado
git log --oneline --graph
```

## Prevención de conflictos

### Buenas prácticas:

1. **Hacer commits pequeños y frecuentes**
   ```bash
   # Mejor hacer varios commits pequeños
   git commit -m "Agrega validación de email"
   git commit -m "Agrega validación de password"
   ```

2. **Mantener las ramas actualizadas**
   ```bash
   # Actualizar tu rama con los cambios de main regularmente
   git checkout feature
   git merge main  # o git rebase main
   ```

3. **Comunicación con el equipo**
   - Avisar cuando trabajas en archivos específicos
   - Coordinar cambios grandes

4. **Pull frecuente**
   ```bash
   # Traer cambios regularmente
   git pull origin main
   ```

5. **Dividir archivos grandes**
   - Archivos pequeños = menos probabilidad de conflictos

## Resumen de comandos clave

```bash
# Realizar merge
git merge rama-origen

# Ver conflictos
git status
git diff

# Resolver conflictos
# (editar archivos manualmente)
git add archivo-resuelto.js
git commit

# Cancelar merge
git merge --abort

# Aceptar cambios específicos
git checkout --ours archivo.js   # Mantener versión actual
git checkout --theirs archivo.js # Mantener versión entrante

# Herramienta visual
git mergetool
```

## Tipos de conflictos comunes

| Tipo de Conflicto | Descripción | Solución |
|-------------------|-------------|----------|
| **Contenido** | Mismas líneas editadas | Editar manualmente |
| **Renombrado** | Archivo renombrado en ambas ramas | Elegir un nombre |
| **Eliminación** | Archivo editado en una rama y eliminado en otra | Decidir mantener o eliminar |
| **Binario** | Archivos binarios modificados | Elegir una versión |

Los conflictos son normales en el trabajo colaborativo. Con práctica, resolverlos se vuelve rutinario y rápido.
***
8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso?

### R: 
## ¿Qué es el área de staging?

El **área de staging** (también llamada "índice" o "staging area") es una zona intermedia entre tu directorio de trabajo y el repositorio Git. Funciona como un "área de preparación" donde seleccionas exactamente qué cambios quieres incluir en tu próximo commit.

## Los tres estados de Git

Git maneja los archivos en tres estados principales:

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│   Working       │     │    Staging      │     │   Repository    │
│   Directory     │ --> │     Area        │ --> │   (.git dir)    │
│  (modificado)   │     │  (preparado)    │     │  (confirmado)   │
└─────────────────┘     └─────────────────┘     └─────────────────┘
    git add                  git commit
```

### 1. **Working Directory** (Directorio de trabajo)
- Archivos modificados pero no preparados
- Estado: **Modified** (modificado)

### 2. **Staging Area** (Área de preparación)
- Archivos preparados para el próximo commit
- Estado: **Staged** (preparado/staged)

### 3. **Repository** (Repositorio)
- Archivos confirmados en el historial
- Estado: **Committed** (confirmado)

## Cómo funciona git add

El comando `git add` mueve cambios del Working Directory al Staging Area.

```bash
# Agregar un archivo específico
git add archivo.txt

# Agregar múltiples archivos
git add archivo1.txt archivo2.js archivo3.css

# Agregar todos los archivos modificados
git add .

# Agregar todos los archivos de un tipo
git add *.java

# Agregar archivos de forma interactiva
git add -i

# Agregar solo parte de un archivo (parcheado)
git add -p archivo.txt
```

### Ejemplo práctico:

```bash
# 1. Modificar un archivo
echo "Nuevo contenido" >> index.html

# 2. Ver el estado
git status
```

**Salida:**
```
On branch main
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   index.html

no changes added to commit (use "git add" and/or "git commit -a")
```

```bash
# 3. Agregar al staging area
git add index.html

# 4. Ver el estado nuevamente
git status
```

**Salida:**
```
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   index.html
```

```bash
# 5. Hacer commit
git commit -m "Actualiza contenido de index.html"
```

## Ventajas del área de staging

### 1. **Control granular sobre los commits**

Puedes seleccionar exactamente qué cambios incluir:

```bash
# Modificas tres archivos
echo "cambio" >> archivo1.txt
echo "cambio" >> archivo2.txt
echo "cambio" >> archivo3.txt

# Solo agregas dos al staging
git add archivo1.txt archivo2.txt

# Haces commit solo de esos dos
git commit -m "Actualiza archivos 1 y 2"

# archivo3.txt sigue modificado pero no commiteado
```

### 2. **Commits lógicos y organizados**

```bash
# Trabajaste en dos funcionalidades diferentes
# Archivo1: funcionalidad A
# Archivo2: funcionalidad B

# Commit separado para cada funcionalidad
git add archivo1.txt
git commit -m "Implementa funcionalidad A"

git add archivo2.txt
git commit -m "Implementa funcionalidad B"
```

### 3. **Revisar antes de confirmar**

```bash
# Agregar archivos
git add .

# Revisar qué vas a commitear
git diff --staged

# Si algo no está bien, quitar del staging
git restore --staged archivo.txt
```

### 4. **Commits parciales de un archivo**

Puedes agregar solo algunas líneas de un archivo:

```bash
# Agregar interactivamente
git add -p archivo.js
```

Git te mostrará cada bloque de cambios y preguntará:
```
Stage this hunk [y,n,q,a,d,e,?]?
```
- `y` = sí, agregar este bloque
- `n` = no, no agregar este bloque
- `q` = salir
- `a` = agregar este y todos los siguientes
- `d` = no agregar este ni los siguientes
- `e` = editar manualmente

## ¿Qué pasa si omites el staging?

### Opción 1: Usar `git commit -a`

```bash
# Commitear directamente archivos modificados (sin git add)
git commit -a -m "Mensaje del commit"
# o
git commit -am "Mensaje del commit"
```

**¿Qué hace?**
- Agrega automáticamente al staging **solo archivos ya rastreados** que fueron modificados
- NO incluye archivos nuevos (untracked)
- Hace el commit inmediatamente

**Ejemplo:**

```bash
# Modificar archivo existente
echo "cambio" >> existente.txt

# Crear archivo nuevo
echo "nuevo" > nuevo.txt

# Commit con -a
git commit -am "Actualización rápida"
```

**Resultado:**
- ✅ `existente.txt` se commitea (era rastreado y modificado)
- ❌ `nuevo.txt` NO se commitea (es nuevo, necesita git add)

### Opción 2: Intentar commit sin staging

```bash
# Modificar archivo
echo "cambio" >> archivo.txt

# Intentar commitear sin git add
git commit -m "Intento de commit"
```

**Resultado:**
```
On branch main
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
        modified:   archivo.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

❌ El commit falla porque no hay nada en el staging area.

## Comparación: Con staging vs Sin staging

### Con staging (recomendado):

```bash
# Modificar varios archivos
echo "A" >> file1.txt
echo "B" >> file2.txt
echo "C" >> file3.txt

# Control total: seleccionar qué commitear
git add file1.txt file2.txt
git commit -m "Implementa features A y B"

git add file3.txt
git commit -m "Implementa feature C"
```

**Ventajas:**
- ✅ Commits organizados y lógicos
- ✅ Control total sobre qué se incluye
- ✅ Facilita la revisión antes de commitear
- ✅ Permite commits parciales

### Sin staging (git commit -a):

```bash
# Modificar varios archivos
echo "A" >> file1.txt
echo "B" >> file2.txt
echo "C" >> file3.txt

# Commitear todo de una vez
git commit -am "Implementa múltiples features"
```

**Desventajas:**
- ❌ Todos los cambios van al mismo commit
- ❌ No funciona con archivos nuevos
- ❌ Menos control sobre lo que se incluye
- ❌ Commits menos organizados

## Comandos útiles para gestionar el staging

```bash
# Ver estado del staging
git status

# Ver diferencias entre working directory y staging
git diff

# Ver diferencias entre staging y último commit
git diff --staged
# o
git diff --cached

# Quitar archivo del staging (mantiene cambios en working directory)
git restore --staged archivo.txt
# o (forma antigua)
git reset HEAD archivo.txt

# Quitar todos los archivos del staging
git restore --staged .

# Agregar interactivamente
git add -i

# Agregar por parches (parcialmente)
git add -p

# Ver qué hay en el staging
git ls-files --stage
```

## Flujo de trabajo típico

### Flujo completo (con staging):

```bash
# 1. Ver estado inicial
git status

# 2. Hacer cambios en archivos
nano app.js
nano styles.css

# 3. Ver qué cambió
git diff

# 4. Agregar al staging selectivamente
git add app.js

# 5. Revisar qué vas a commitear
git diff --staged

# 6. Hacer commit
git commit -m "Actualiza lógica de la aplicación"

# 7. Agregar el otro archivo
git add styles.css

# 8. Hacer otro commit
git commit -m "Mejora estilos CSS"
```

### Flujo rápido (sin staging para cambios simples):

```bash
# 1. Hacer cambio simple
echo "fix" >> bug.js

# 2. Commit directo
git commit -am "Corrige bug en validación"
```

## Escenarios comunes

### Escenario 1: Agregar archivo nuevo

```bash
# Crear archivo
echo "contenido" > nuevo.txt

# git commit -a NO funcionará
git commit -am "Agrega nuevo archivo"  # ❌ FALLA

# Debes usar git add
git add nuevo.txt
git commit -m "Agrega nuevo archivo"   # ✅ FUNCIONA
```

### Escenario 2: Modificar y eliminar archivos

```bash
# Modificar archivo
echo "cambio" >> existente.txt

# Eliminar archivo
git rm viejo.txt

# El archivo eliminado YA está en staging automáticamente
# Solo necesitas agregar el modificado
git add existente.txt
git commit -m "Actualiza y elimina archivos"
```

### Escenario 3: Cambiar de opinión

```bash
# Agregar archivo al staging
git add archivo.txt

# Cambias de opinión
git restore --staged archivo.txt

# El archivo sigue modificado pero ya no está en staging
```

## Casos de uso: ¿Cuándo omitir el staging?

### ✅ Puedes usar `git commit -a` cuando:
- Haces cambios simples en archivos ya rastreados
- Todos los cambios son parte de la misma funcionalidad
- Trabajas solo y no necesitas commits muy granulares
- Quieres un flujo rápido para fixes pequeños

### ❌ NO uses `git commit -a` cuando:
- Tienes archivos nuevos que agregar
- Modificaste muchos archivos con diferentes propósitos
- Quieres commits separados para diferentes funcionalidades
- Necesitas revisar cuidadosamente qué vas a commitear
- Trabajas en equipo y necesitas historial claro

## Resumen visual

```
FLUJO CON STAGING:
Modificas archivo → git add → Staging Area → git commit → Repository
     (Working)                  (Índice)                    (History)

FLUJO SIN STAGING (commit -a):
Modificas archivo → git commit -a → Repository
     (Working)                        (History)
                ↓
    Solo archivos rastreados
```

## Tabla comparativa

| Aspecto | Con Staging (`git add`) | Sin Staging (`git commit -a`) |
|---------|------------------------|-------------------------------|
| **Control** | 🟢 Total | 🟡 Limitado |
| **Archivos nuevos** | ✅ Sí | ❌ No |
| **Commits selectivos** | ✅ Sí | ❌ No |
| **Velocidad** | 🟡 Más pasos | 🟢 Rápido |
| **Organización** | 🟢 Mejor | 🟡 Menor |
| **Recomendado para** | Proyectos serios | Cambios rápidos |

## Conclusión

El área de staging es una característica poderosa de Git que te da control total sobre tus commits. Aunque puedes omitirla con `git commit -a`, usarla correctamente resulta en un historial más limpio, organizado y profesional.

**Recomendación**: Usa el staging area por defecto, y recurre a `git commit -a` solo para cambios simples y rápidos en archivos ya rastreados.
***
9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?

## R: 

## ¿Qué es el archivo .gitignore?

El archivo **.gitignore** es un archivo de texto especial que le indica a Git qué archivos o directorios **NO** debe rastrear ni incluir en el control de versiones. Funciona como una "lista negra" de archivos que Git debe ignorar completamente.

```bash
# Crear archivo .gitignore
touch .gitignore

# Editar archivo .gitignore
nano .gitignore
```

## ¿Por qué es necesario .gitignore?

En un proyecto existen archivos que **NO deberían** estar en el repositorio:

### 1. **Archivos generados automáticamente**
- Archivos compilados (`.class`, `.o`, `.pyc`)
- Builds y distribuciones (`/dist`, `/build`)
- Archivos de dependencias (`/node_modules`, `/vendor`)

### 2. **Archivos de configuración local**
- Configuraciones del IDE (`.vscode`, `.idea`)
- Configuraciones del sistema operativo (`.DS_Store`, `Thumbs.db`)

### 3. **Información sensible**
- Credenciales y claves API (`.env`, `secrets.yml`)
- Archivos con contraseñas
- Tokens de autenticación

### 4. **Archivos temporales**
- Logs (`*.log`)
- Archivos de caché (`*.cache`)
- Archivos de respaldo (`*.bak`, `*~`)

### 5. **Archivos grandes**
- Videos, imágenes de alta resolución
- Bases de datos locales
- Archivos binarios pesados

## Cómo funciona .gitignore

### Sintaxis básica:

```gitignore
# Ignorar un archivo específico
config.txt

# Ignorar todos los archivos con extensión .log
*.log

# Ignorar un directorio completo
node_modules/

# Ignorar archivos en cualquier subdirectorio
**/temp

# Ignorar archivos .txt en el directorio raíz solamente
/*.txt

# NO ignorar un archivo específico (excepción)
!importante.log

# Ignorar todos los .txt excepto uno
*.txt
!readme.txt
```

### Patrones y reglas:

| Patrón | Descripción | Ejemplo |
|--------|-------------|---------|
| `archivo.txt` | Ignora archivo específico | `config.json` |
| `*.extension` | Ignora por extensión | `*.log` |
| `directorio/` | Ignora directorio completo | `node_modules/` |
| `**/patrón` | Ignora en cualquier subdirectorio | `**/*.tmp` |
| `/archivo` | Solo en raíz del proyecto | `/secrets.txt` |
| `!archivo` | Excepción (NO ignorar) | `!important.log` |
| `#` | Comentario | `# Archivos de logs` |

## Ejemplo completo de .gitignore

### Para un proyecto Node.js:

```gitignore
# Dependencias
node_modules/
npm-debug.log*
yarn-debug.log*
yarn-error.log*

# Archivos de producción
/dist
/build

# Variables de entorno
.env
.env.local
.env.production

# Archivos del sistema operativo
.DS_Store
Thumbs.db

# IDEs y editores
.vscode/
.idea/
*.swp
*.swo
*~

# Logs
logs/
*.log

# Archivos temporales
*.tmp
*.temp
.cache/

# Coverage de tests
coverage/
.nyc_output/
```

### Para un proyecto Python:

```gitignore
# Byte-compiled / optimized
__pycache__/
*.py[cod]
*$py.class

# Virtual environments
venv/
env/
ENV/
.venv

# IDEs
.vscode/
.idea/
*.swp

# Distribución / empaquetado
dist/
build/
*.egg-info/

# Configuración local
.env
*.env

# Jupyter Notebooks
.ipynb_checkpoints

# Bases de datos
*.db
*.sqlite3

# Logs
*.log
```

### Para un proyecto Java:

```gitignore
# Archivos compilados
*.class
*.jar
*.war
*.ear

# Directorios de build
target/
build/
out/

# IDEs
.idea/
.eclipse/
*.iml

# Logs
*.log

# Sistema operativo
.DS_Store
Thumbs.db

# Maven
.mvn/
mvnw
mvnw.cmd

# Gradle
.gradle/
gradle/
```

## Cómo influye en el seguimiento de archivos

### Estados de archivos en Git:

```
┌──────────────────────────────────────────────┐
│                                              │
│  Archivos en tu proyecto                    │
│                                              │
│  ┌────────────────┐    ┌──────────────────┐ │
│  │   Tracked      │    │   Untracked      │ │
│  │  (Rastreados)  │    │ (No rastreados)  │ │
│  │                │    │                  │ │
│  │ - Modified     │    │ - Nuevos         │ │
│  │ - Staged       │    │ - Ignorados      │ │
│  │ - Committed    │    │   (.gitignore)   │ │
│  └────────────────┘    └──────────────────┘ │
│                                              │
└──────────────────────────────────────────────┘
```

### Archivos ignorados vs no rastreados:

**Archivos ignorados (.gitignore):**
- Git los ignora completamente
- No aparecen en `git status`
- No se pueden agregar con `git add .`
- No se incluyen en commits

**Archivos no rastreados (sin .gitignore):**
- Git los detecta como nuevos
- Aparecen en `git status` como "Untracked files"
- Se pueden agregar con `git add`

### Ejemplo práctico:

```bash
# Estructura del proyecto
proyecto/
├── .gitignore
├── app.js
├── config.env       # Ignorado
└── node_modules/    # Ignorado

# Contenido de .gitignore
config.env
node_modules/

# Ver estado
git status
```

**Salida:**
```
On branch main
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        app.js

nothing added to commit but untracked files present
```

> **Nota:** `config.env` y `node_modules/` NO aparecen porque están en .gitignore

## Comandos útiles con .gitignore

### Ver archivos ignorados:

```bash
# Ver archivos ignorados
git status --ignored

# Listar solo archivos ignorados
git ls-files --ignored --exclude-standard --others

# Ver qué regla está ignorando un archivo específico
git check-ignore -v archivo.txt
```

### Forzar agregar archivo ignorado:

```bash
# Agregar archivo aunque esté en .gitignore (no recomendado)
git add -f archivo-ignorado.txt
```

### Limpiar archivos ignorados:

```bash
# Ver qué archivos se eliminarían (simulación)
git clean -ndX

# Eliminar archivos ignorados
git clean -fdX

# Eliminar archivos ignorados y no rastreados
git clean -fdx
```

## Problemas comunes y soluciones

### Problema 1: Archivo ya está rastreado antes de agregarlo a .gitignore

**Situación:**
```bash
# Archivo ya está en Git
git add config.env
git commit -m "Agrega config"

# Ahora lo agregas a .gitignore
echo "config.env" >> .gitignore
```

**Problema:** El archivo sigue rastreado aunque esté en .gitignore

**Solución:**
```bash
# Quitar del índice pero mantener el archivo localmente
git rm --cached config.env

# Hacer commit del cambio
git commit -m "Deja de rastrear config.env"

# Ahora .gitignore funciona correctamente
```

### Problema 2: .gitignore no funciona

**Causas comunes:**
1. El archivo ya está siendo rastreado
2. Hay espacios o errores de sintaxis en .gitignore
3. El archivo .gitignore no está en el directorio raíz

**Solución:**
```bash
# Limpiar caché de Git
git rm -r --cached .
git add .
git commit -m "Actualiza .gitignore"
```

### Problema 3: Quiero ignorar todo excepto algunos archivos

```gitignore
# Ignorar todo
*

# Excepto estos directorios
!src/
!public/

# Excepto estos archivos
!README.md
!.gitignore
!package.json

# Ignorar todo dentro de src/ excepto .js
src/*
!src/*.js
```

## Crear .gitignore para diferentes tecnologías

### Usar plantillas de gitignore.io:

```bash
# Generar .gitignore para Node.js y VS Code
curl -L https://www.toptal.com/developers/gitignore/api/node,visualstudiocode > .gitignore

# Para Python
curl -L https://www.toptal.com/developers/gitignore/api/python > .gitignore

# Para múltiples lenguajes
curl -L https://www.toptal.com/developers/gitignore/api/java,maven,intellij > .gitignore
```

### Plantillas de GitHub:

GitHub proporciona plantillas oficiales: https://github.com/github/gitignore

## .gitignore global

Puedes crear un .gitignore global para tu sistema:

```bash
# Crear archivo global
touch ~/.gitignore_global

# Configurar Git para usarlo
git config --global core.excludesfile ~/.gitignore_global

# Agregar reglas comunes
echo ".DS_Store" >> ~/.gitignore_global
echo "Thumbs.db" >> ~/.gitignore_global
echo "*.swp" >> ~/.gitignore_global
```

## Otros archivos de ignore

### .gitignore local (no compartido)

Para ignorar archivos solo en tu máquina sin compartir con el equipo:

```bash
# Editar .git/info/exclude
nano .git/info/exclude
```

Este archivo funciona igual que .gitignore pero no se comparte con otros.

### .dockerignore

Similar a .gitignore pero para Docker:

```dockerignore
node_modules/
.git/
*.log
.env
```

## Buenas prácticas

### ✅ Qué incluir en .gitignore:

```gitignore
# Dependencias
node_modules/
vendor/

# Builds
/dist
/build
*.o
*.class

# Archivos de entorno
.env
.env.local
*.key
secrets.yml

# IDEs y editores
.vscode/
.idea/
*.swp

# Sistema operativo
.DS_Store
Thumbs.db

# Logs y temporales
*.log
*.tmp
.cache/

# Coverage y tests
coverage/
*.test.js.snap
```

### ❌ Qué NO incluir en .gitignore:

```gitignore
# ❌ NO ignorar archivos de configuración de ejemplo
# config.example.json  # Este debe estar en el repo

# ❌ NO ignorar documentación
# *.md

# ❌ NO ignorar archivos de configuración del proyecto
# package.json
# requirements.txt
# pom.xml
```

## Flujo de trabajo recomendado

```bash
# 1. Crear proyecto
mkdir mi-proyecto
cd mi-proyecto
git init

# 2. Crear .gitignore ANTES del primer commit
touch .gitignore

# 3. Agregar reglas según tu tecnología
echo "node_modules/" >> .gitignore
echo ".env" >> .gitignore
echo "*.log" >> .gitignore

# 4. Hacer primer commit (incluye .gitignore)
git add .gitignore
git commit -m "Agrega .gitignore"

# 5. Ahora puedes trabajar normalmente
git add .
git commit -m "Código inicial"
```

## Verificar qué archivos se están ignorando

```bash
# Ver estado incluyendo archivos ignorados
git status --ignored

# Verificar por qué un archivo es ignorado
git check-ignore -v archivo.txt

# Listar todos los archivos ignorados
git ls-files --others --ignored --exclude-standard

# Ver árbol completo (incluyendo ignorados)
tree -a
```

## Ejemplo de salida de git status --ignored

```bash
git status --ignored
```

**Salida:**
```
On branch main
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        src/app.js

Ignored files:
  (use "git add -f <file>..." to include in what will be committed)
        .env
        node_modules/
        *.log
        .DS_Store

nothing added to commit but untracked files present
```

## Resumen rápido

| Concepto | Explicación |
|----------|-------------|
| **.gitignore** | Archivo que lista qué ignorar |
| **Archivos ignorados** | No aparecen en `git status`, Git no los rastrea |
| **Sintaxis** | Patrones como `*.log`, `node_modules/`, `!excepción` |
| **Ubicación** | Raíz del proyecto (o subdirectorios para reglas específicas) |
| **Propósito** | Evitar rastrear archivos innecesarios o sensibles |

## Comandos esenciales

```bash
# Crear .gitignore
touch .gitignore

# Ver archivos ignorados
git status --ignored

# Verificar regla específica
git check-ignore -v archivo.txt

# Quitar archivo rastreado
git rm --cached archivo.txt

# Limpiar caché de Git
git rm -r --cached .
git add .
```

El archivo .gitignore es fundamental para mantener tu repositorio limpio, seguro y eficiente. Configurarlo correctamente desde el inicio ahorra muchos problemas futuros.

***
10. ¿Cuál es la diferencia entre un “commit amend” (--amend) y un nuevo commit?

### R: 
## ¿Qué es git commit --amend?

`git commit --amend` es un comando que te permite **modificar el último commit** realizado. En lugar de crear un nuevo commit, reescribe el commit anterior, permitiéndote agregar cambios olvidados o corregir el mensaje del commit.

```bash
# Modificar el último commit
git commit --amend

# Modificar el último commit con nuevo mensaje
git commit --amend -m "Nuevo mensaje corregido"

# Agregar cambios al último commit sin cambiar el mensaje
git commit --amend --no-edit
```

## Diferencias fundamentales

### Commit normal (nuevo commit):

```bash
# Hacer cambios
echo "código" > archivo.js

# Crear commit
git add archivo.js
git commit -m "Agrega nueva funcionalidad"

# Resultado: Se crea un NUEVO commit en el historial
```

**Historial:**
```
A---B---C---D (nuevo commit)
            ↑
         HEAD
```

### Commit amend (modificar último commit):

```bash
# Hacer cambios
echo "código" > archivo.js
git add archivo.js
git commit -m "Agrega funcionalidad"

# Te diste cuenta que olvidaste algo
echo "más código" > otro.js
git add otro.js

# Modificar el commit anterior
git commit --amend -m "Agrega funcionalidad completa"

# Resultado: El commit anterior se REESCRIBE
```

**Historial:**
```
A---B---C (commit original eliminado)

A---B---C' (nuevo commit que reemplaza a C)
        ↑
      HEAD
```

> **Importante:** C' es un commit DIFERENTE a C, aunque tenga cambios similares. Tiene un hash SHA diferente.

## Comparación lado a lado

| Aspecto | Nuevo Commit | Commit Amend |
|---------|--------------|--------------|
| **Crea nuevo commit** | ✅ Sí | ❌ No |
| **Modifica historial** | ❌ No | ✅ Sí |
| **Cambia hash SHA** | N/A (nuevo hash) | ✅ Sí |
| **Afecta commits anteriores** | ❌ No | ❌ No (solo el último) |
| **Seguro con commits públicos** | ✅ Sí | ❌ No |
| **Agrega archivos olvidados** | ✅ Sí (en nuevo commit) | ✅ Sí (al mismo commit) |
| **Corrige mensaje** | ❌ No (necesita amend) | ✅ Sí |

## Casos de uso de commit --amend

### Caso 1: Olvidaste agregar un archivo

```bash
# Hacer commit
git add archivo1.js
git commit -m "Implementa validación de formulario"

# ¡Ups! Olvidaste archivo2.js
git add archivo2.js

# Agregar al commit anterior
git commit --amend --no-edit

# Resultado: archivo2.js se incluye en el mismo commit
```

### Caso 2: Error tipográfico en el mensaje

```bash
# Commit con error en el mensaje
git commit -m "Agrega validación de emial"
                                    # ↑ typo

# Corregir el mensaje
git commit --amend -m "Agrega validación de email"

# Resultado: El mensaje se corrige sin crear nuevo commit
```

### Caso 3: Olvidaste hacer un cambio pequeño

```bash
# Hacer commit
git commit -m "Corrige bug en login"

# Te das cuenta que falta un cambio
echo "return true;" >> login.js
git add login.js

# Agregar al commit anterior
git commit --amend --no-edit
```

### Caso 4: Cambiar el autor del commit

```bash
# Cambiar autor del último commit
git commit --amend --author="Nombre "
```

## Ejemplos prácticos completos

### Ejemplo 1: Flujo con nuevo commit

```bash
# 1. Hacer primer cambio
echo "función A" > funciones.js
git add funciones.js
git commit -m "Agrega función A"

# 2. Hacer segundo cambio (olvidaste agregarlo arriba)
echo "función B" >> funciones.js
git add funciones.js
git commit -m "Agrega función B"

# 3. Ver historial
git log --oneline
```

**Resultado:**
```
b2d4f6e Agrega función B
a1c3e5g Agrega función A
```

✅ **Ventaja:** Historial claro de cambios separados  
❌ **Desventaja:** Dos commits cuando podría ser uno

### Ejemplo 2: Flujo con amend

```bash
# 1. Hacer primer cambio
echo "función A" > funciones.js
git add funciones.js
git commit -m "Agrega funciones"

# 2. Hacer segundo cambio (olvidaste agregarlo)
echo "función B" >> funciones.js
git add funciones.js
git commit --amend --no-edit

# 3. Ver historial
git log --oneline
```

**Resultado:**
```
c3e5g7i Agrega funciones
```

✅ **Ventaja:** Un solo commit limpio con todos los cambios  
❌ **Desventaja:** El hash cambió (puede causar problemas si ya se publicó)

## Cuándo usar cada uno

### Usa NUEVO COMMIT cuando:

✅ El commit anterior ya fue publicado (pusheado)
```bash
# Ya hiciste push
git push origin main

# Hacer nuevo commit (seguro)
git add cambios.js
git commit -m "Corrección adicional"
git push origin main
```

✅ Quieres mantener el historial de todos los cambios
```bash
# Commits separados para cada paso
git commit -m "Implementa estructura básica"
git commit -m "Agrega validaciones"
git commit -m "Agrega tests"
```

✅ Trabajas en equipo y otros pueden haber descargado tu commit
```bash
# Tu compañero hizo pull con tu commit
# Usar amend causaría conflictos
# Mejor hacer nuevo commit
```

### Usa AMEND cuando:

✅ El commit NO ha sido publicado (solo local)
```bash
# Commit local
git commit -m "Agrega feature"

# Corregir antes de push
git commit --amend
git push origin main
```

✅ Olvidaste agregar archivos al último commit
```bash
# Commit incompleto
git add archivo1.js
git commit -m "Implementa feature"

# Agregar archivo olvidado
git add archivo2.js
git commit --amend --no-edit
```

✅ El mensaje del commit tiene errores
```bash
# Mensaje incorrecto
git commit -m "Corije bug"

# Corregir
git commit --amend -m "Corrige bug"
```

✅ Quieres mantener un historial limpio
```bash
# Pequeños ajustes al mismo cambio
git commit -m "Agrega validación"
# ... ajustes menores ...
git commit --amend --no-edit
```

## ⚠️ ADVERTENCIAS IMPORTANTES sobre --amend

### Peligro 1: Reescribir historial público

```bash
# ❌ PELIGROSO - NO HACER ESTO
git commit -m "Feature completa"
git push origin main

# Modificar commit ya publicado
git commit --amend -m "Feature completa (corregido)"
git push origin main  # ❌ RECHAZADO

# Forzar push (MUY PELIGROSO)
git push --force origin main  # ❌❌❌ EVITAR
```

**Consecuencias:**
- Conflictos para otros desarrolladores
- Pérdida de trabajo de compañeros
- Historial inconsistente

### Peligro 2: Cambio de hash SHA

```bash
# Commit original
git log --oneline
# a1b2c3d Mensaje original

# Después de amend
git commit --amend -m "Mensaje modificado"
git log --oneline
# e4f5g6h Mensaje modificado
#   ↑ Hash completamente diferente
```

### Peligro 3: En colaboración

**Escenario problemático:**
```bash
# Desarrollador A
git commit -m "Feature X"
git push

# Desarrollador B
git pull  # Obtiene el commit de A

# Desarrollador A (hace amend después de push)
git commit --amend
git push --force

# Desarrollador B (intenta hacer pull)
git pull  # ❌ CONFLICTOS
```

## Cómo usar --amend de forma segura

### Regla de oro:

> **Solo usa `--amend` en commits que NO han sido pusheados al repositorio remoto**

### Flujo seguro:

```bash
# 1. Trabajo local (seguro usar amend)
git commit -m "WIP: trabajando en feature"
git commit --amend -m "Feature completa"
git commit --amend --no-edit  # agregar más cambios

# 2. ANTES de push final
git log --oneline  # Verificar que todo esté bien

# 3. Push al remoto (ahora no usar más amend)
git push origin main
```

### Si necesitas corregir después de push:

```bash
# ✅ CORRECTO: Hacer nuevo commit
git add corrección.js
git commit -m "Corrige error en feature X"
git push origin main
```

## Comandos relacionados con amend

### Ver diferencias antes de amend:

```bash
# Ver qué cambiarías
git diff HEAD

# Ver lo que está en staging
git diff --staged
```

### Amend interactivo:

```bash
# Abrir editor para modificar mensaje
git commit --amend

# En el editor verás:
```

```
Agrega nueva funcionalidad

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
#
# Date:      Mon Feb 10 14:30:00 2026 -0500
#
# On branch main
# Changes to be committed:
#       modified:   archivo.js
```

### Amend sin cambiar nada:

```bash
# Solo cambiar mensaje, sin agregar archivos
git commit --amend -m "Nuevo mensaje"

# Solo agregar archivos, sin cambiar mensaje
git add archivo.js
git commit --amend --no-edit

# Solo cambiar autor
git commit --amend --author="Nuevo Autor "
```

## Deshacer un amend

Si hiciste amend por error:

```bash
# Ver reflog para encontrar el commit anterior
git reflog

# Salida:
# e4f5g6h HEAD@{0}: commit (amend): Mensaje modificado
# a1b2c3d HEAD@{1}: commit: Mensaje original

# Volver al commit anterior
git reset --soft HEAD@{1}

# O usar el hash directamente
git reset --soft a1b2c3d
```

## Casos especiales

### Amend del primer commit del repositorio:

```bash
# Primer commit
git commit -m "Initial commit"

# Modificar el primer commit
git add archivo-olvidado.txt
git commit --amend -m "Initial commit (completo)"

# ✅ Funciona perfectamente
```

### Amend múltiples veces:

```bash
# Commit inicial
git commit -m "Feature X"

# Primera corrección
git add fix1.js
git commit --amend --no-edit

# Segunda corrección
git add fix2.js
git commit --amend --no-edit

# Tercera corrección
git add fix3.js
git commit --amend --no-edit

# Resultado: Un solo commit con todos los cambios
```

### Amend con merge commits:

```bash
# ⚠️ Precaución: Amend en merge commits es complicado
git merge feature
git commit --amend  # Modifica el merge commit

# Puede causar problemas, evitar si es posible
```

## Comparación visual

### Flujo nuevo commit:
```
Antes:  A---B---C
                ↑
              HEAD

Cambios: D

Después: A---B---C---D
                    ↑
                  HEAD
```

### Flujo amend:
```
Antes:  A---B---C
                ↑
              HEAD

Cambios: +

Después: A---B---C'
                ↑
              HEAD

(C desaparece, C' lo reemplaza)
```

## Resumen de comandos

```bash
# Modificar mensaje del último commit
git commit --amend -m "Nuevo mensaje"

# Agregar archivos al último commit (mantener mensaje)
git add archivo-olvidado.js
git commit --amend --no-edit

# Modificar autor
git commit --amend --author="Nombre "

# Abrir editor para modificar commit completo
git commit --amend

# Deshacer amend
git reset --soft HEAD@{1}
```

## Tabla resumen

| Situación | Comando Recomendado |
|-----------|-------------------|
| Commit no publicado, mensaje incorrecto | `git commit --amend -m "Corrección"` |
| Commit no publicado, olvidaste archivo | `git add archivo && git commit --amend --no-edit` |
| Commit YA publicado, necesitas corrección | `git commit -m "Corrección"` (nuevo commit) |
| Trabajas solo, commit local | `--amend` ✅ Seguro |
| Trabajas en equipo, commit publicado | Nuevo commit ✅ Seguro |
| Pequeños ajustes antes de push | `--amend` ✅ Ideal |
| Corrección después de push | Nuevo commit ✅ Obligatorio |

## Conclusión

**Nuevo commit:**
- Seguro para historial compartido
- Mantiene todo el historial
- No reescribe la historia

**Commit amend:**
- Solo para commits locales
- Mantiene historial limpio
- Reescribe la historia (cambio de hash)

**Regla general:** Si ya hiciste `git push`, usa nuevo commit. Si es solo local, `--amend` es perfecto para mantener un historial limpio.

***
11. ¿Cómo se utiliza git stash y en qué escenarios es útil?

##### R: 
## ¿Qué es git stash?

**Git stash** es un comando que te permite **guardar temporalmente** cambios no confirmados (modificaciones en el working directory y staging area) sin hacer commit. Es como poner tus cambios en un "cajón temporal" para recuperarlos más tarde.

```bash
# Guardar cambios temporalmente
git stash

# Recuperar cambios guardados
git stash pop
```

## ¿Cómo funciona git stash?

Git stash crea una "pila" (stack) donde guarda tus cambios temporales. Puedes guardar múltiples stashes y recuperarlos cuando los necesites.

```
┌─────────────────────────────────────┐
│         STASH STACK (Pila)          │
├─────────────────────────────────────┤
│ stash@{0}: WIP on feature: abc123   │  ← Más reciente
│ stash@{1}: WIP on main: def456      │
│ stash@{2}: WIP on hotfix: ghi789    │  ← Más antiguo
└─────────────────────────────────────┘
```

## Comandos básicos de git stash

### Guardar cambios:

```bash
# Guardar cambios (working directory y staging area)
git stash

# Guardar con mensaje descriptivo
git stash save "Descripción del stash"

# Guardar incluyendo archivos sin rastrear
git stash -u
# o
git stash --include-untracked

# Guardar TODO (incluyendo archivos ignorados)
git stash -a
# o
git stash --all

# Guardar solo archivos en staging (index)
git stash --keep-index
```

### Listar stashes:

```bash
# Ver lista de stashes guardados
git stash list

# Salida:
# stash@{0}: WIP on feature: mensaje del último commit
# stash@{1}: On main: trabajo en progreso
# stash@{2}: WIP on hotfix: corrección urgente
```

### Recuperar cambios:

```bash
# Aplicar el stash más reciente y eliminarlo de la pila
git stash pop

# Aplicar el stash más reciente sin eliminarlo
git stash apply

# Aplicar un stash específico
git stash apply stash@{1}

# Aplicar y eliminar un stash específico
git stash pop stash@{2}
```

### Ver contenido de un stash:

```bash
# Ver cambios del último stash
git stash show

# Ver cambios detallados del último stash
git stash show -p

# Ver cambios de un stash específico
git stash show stash@{1} -p
```

### Eliminar stashes:

```bash
# Eliminar el stash más reciente
git stash drop

# Eliminar un stash específico
git stash drop stash@{1}

# Eliminar TODOS los stashes
git stash clear
```

## Escenarios útiles para git stash

### Escenario 1: Cambiar de rama urgentemente

**Situación:** Estás trabajando en una funcionalidad pero necesitas cambiar a otra rama urgentemente.

```bash
# Trabajando en feature
echo "código incompleto" >> feature.js
git status
# Output: Changes not staged for commit

# ¡Te piden revisar un bug urgente en main!
# No puedes cambiar de rama con cambios sin confirmar

# Solución: Guardar cambios temporalmente
git stash save "Trabajo en progreso de feature X"

# Ahora puedes cambiar de rama limpiamente
git checkout main

# Corregir el bug
git add bug-fix.js
git commit -m "Corrige bug crítico"

# Volver a tu rama
git checkout feature

# Recuperar tu trabajo
git stash pop
```

### Escenario 2: Pull con cambios locales

**Situación:** Necesitas hacer `git pull` pero tienes cambios locales que causarían conflictos.

```bash
# Tienes cambios locales
git status
# Output: modified: app.js

# Intentas hacer pull
git pull origin main
# Error: Your local changes would be overwritten by merge

# Solución: Stash, pull, recuperar
git stash
git pull origin main
git stash pop

# Si hay conflictos, los resuelves aquí
```

### Escenario 3: Experimentar sin commit

**Situación:** Quieres probar algo rápido sin hacer commit de tu trabajo actual.

```bash
# Trabajo actual en progreso
git status
# Output: Changes not staged

# Guardar trabajo actual
git stash save "Estado estable antes de experimento"

# Hacer experimentos
echo "código experimental" >> test.js
git add test.js

# Si el experimento falla, descartar todo
git reset --hard HEAD

# Recuperar trabajo original
git stash pop
```

### Escenario 4: Limpiar working directory temporalmente

**Situación:** Necesitas un directorio de trabajo limpio para ejecutar tests o builds.

```bash
# Cambios en progreso
git status
# Output: modified: varios archivos

# Guardar todo
git stash -u

# Ejecutar tests en código limpio
npm test

# Recuperar cambios
git stash pop
```

### Escenario 5: Separar cambios en commits diferentes

**Situación:** Hiciste múltiples cambios que deberían ser commits separados.

```bash
# Varios archivos modificados
git status
# Output: modified: feature1.js, feature2.js, fix.js

# Guardar todo
git stash

# Recuperar solo lo que necesitas
git stash pop

# Hacer commit selectivo
git add feature1.js
git commit -m "Implementa feature 1"

# Guardar el resto de nuevo
git stash

# Repetir proceso
git stash pop
git add feature2.js
git commit -m "Implementa feature 2"
```

### Escenario 6: Guardar cambios accidentales en rama incorrecta

**Situación:** Hiciste cambios en la rama equivocada.

```bash
# Trabajaste en main por error
git branch
# Output: * main

echo "nueva feature" >> feature.js
git status
# Output: modified: feature.js

# Guardar cambios
git stash save "Feature para rama correcta"

# Cambiar a rama correcta
git checkout feature-branch

# Recuperar cambios
git stash pop

# Ahora hacer commit en la rama correcta
git add feature.js
git commit -m "Agrega nueva feature"
```

## Ejemplos prácticos completos

### Ejemplo 1: Workflow completo básico

```bash
# 1. Estado inicial - trabajando en feature
git checkout feature-login
echo "validación de email" >> login.js
echo "validación de password" >> login.js

# 2. Ver estado
git status
# Output: modified: login.js

# 3. Necesitas cambiar de rama urgentemente
git stash save "Login: validaciones en progreso"

# 4. Trabajar en otra rama
git checkout main
git pull origin main
echo "hotfix" >> app.js
git add app.js
git commit -m "Hotfix crítico"
git push origin main

# 5. Volver a tu trabajo
git checkout feature-login
git stash list
# Output: stash@{0}: On feature-login: Login: validaciones en progreso

# 6. Recuperar trabajo
git stash pop
# Output: Cambios aplicados exitosamente

# 7. Continuar trabajando
echo "más validaciones" >> login.js
git add login.js
git commit -m "Completa validaciones de login"
```

### Ejemplo 2: Múltiples stashes

```bash
# Primer trabajo
git checkout feature-A
echo "trabajo A" >> fileA.js
git stash save "Trabajo en feature A"

# Segundo trabajo
git checkout feature-B
echo "trabajo B" >> fileB.js
git stash save "Trabajo en feature B"

# Tercer trabajo
git checkout feature-C
echo "trabajo C" >> fileC.js
git stash save "Trabajo en feature C"

# Ver todos los stashes
git stash list
# Output:
# stash@{0}: On feature-C: Trabajo en feature C
# stash@{1}: On feature-B: Trabajo en feature B
# stash@{2}: On feature-A: Trabajo en feature A

# Recuperar un stash específico (el de feature-A)
git checkout feature-A
git stash apply stash@{2}

# Eliminar ese stash
git stash drop stash@{2}
```

### Ejemplo 3: Stash con archivos sin rastrear

```bash
# Crear nuevo archivo
echo "nuevo código" > nuevo-archivo.js

# Modificar archivo existente
echo "modificación" >> existente.js

# Ver estado
git status
# Output:
# modified:   existente.js
# Untracked files:
#   nuevo-archivo.js

# Stash normal (solo archivos rastreados)
git stash
# Output: Saved working directory
# nuevo-archivo.js NO se guarda

# Deshacer stash
git stash pop

# Stash incluyendo archivos sin rastrear
git stash -u
# Output: Saved working directory
# Ahora SÍ se guarda nuevo-archivo.js

# Recuperar
git stash pop
```

## Comandos avanzados de stash

### Crear rama desde stash:

```bash
# Guardar trabajo
git stash save "Experimento interesante"

# Crear nueva rama con el contenido del stash
git stash branch nueva-rama-experimento

# Resultado:
# - Se crea la rama
# - Se aplica el stash
# - Se elimina el stash de la lista
```

### Aplicar stash parcialmente:

```bash
# Guardar cambios
git stash

# Aplicar solo algunos archivos del stash
git checkout stash@{0} -- archivo-especifico.js

# El stash permanece en la lista
```

### Stash interactivo:

```bash
# Guardar solo algunos cambios interactivamente
git stash -p

# Git preguntará por cada bloque de cambios:
# Stash this hunk [y,n,q,a,d,e,?]?
```

## Diferencias entre comandos stash

### git stash vs git stash save:

```bash
# Ambos hacen lo mismo
git stash
git stash save "mensaje"

# save permite agregar mensaje más fácilmente
git stash save "Trabajo importante"
```

### git stash pop vs git stash apply:

| Comando | Aplica cambios | Elimina de la lista |
|---------|----------------|---------------------|
| `git stash pop` | ✅ Sí | ✅ Sí |
| `git stash apply` | ✅ Sí | ❌ No |

```bash
# pop: aplicar y eliminar
git stash pop  # Aplicar stash@{0} y eliminarlo

# apply: aplicar pero mantener
git stash apply  # Aplicar stash@{0} pero mantenerlo en la lista
```

## Conflictos al aplicar stash

### Cuando hay conflictos:

```bash
# Aplicar stash con conflictos
git stash pop
# Output:
# Auto-merging archivo.js
# CONFLICT (content): Merge conflict in archivo.js

# Resolver conflictos manualmente
nano archivo.js

# Marcar como resuelto
git add archivo.js

# El stash NO se elimina automáticamente si hubo conflictos
# Eliminarlo manualmente
git stash drop
```

## Ver información detallada de un stash

```bash
# Ver archivos modificados en el stash
git stash show stash@{0}

# Ver diferencias completas
git stash show -p stash@{0}

# Ver estadísticas
git stash show --stat stash@{0}
```

**Salida ejemplo:**
```
 archivo1.js | 10 +++++-----
 archivo2.js |  5 +++++
 2 files changed, 10 insertions(+), 5 deletions(-)
```

## Stash vs otras alternativas

### Stash vs Commit temporal:

| Aspecto | Stash | Commit temporal |
|---------|-------|-----------------|
| **En historial** | ❌ No | ✅ Sí |
| **Facilidad** | 🟢 Más rápido | 🟡 Más pasos |
| **Compartible** | ❌ No | ✅ Sí (con push) |
| **Uso típico** | Cambios temporales locales | Puntos de guardado |

```bash
# Stash (temporal, no va al historial)
git stash
git stash pop

# Commit temporal (va al historial)
git add .
git commit -m "WIP: trabajo en progreso"
# ... hacer otras cosas ...
git reset HEAD~1  # Deshacer commit temporal
```

## Buenas prácticas con stash

### ✅ DO (Hacer):

```bash
# Usar mensajes descriptivos
git stash save "Implementación de autenticación OAuth - 80% completo"

# Limpiar stashes antiguos regularmente
git stash list
git stash clear  # o eliminar individualmente

# Aplicar stash específico si tienes varios
git stash apply stash@{2}

# Crear rama si el stash es importante
git stash branch feature-importante
```

### ❌ DON'T (No hacer):

```bash
# ❌ Acumular muchos stashes sin descripción
git stash
git stash
git stash
# Después no sabrás qué contiene cada uno

# ❌ Usar stash como backup permanente
# Para eso está git commit

# ❌ Compartir stashes entre repositorios
# Los stashes son locales

# ❌ Dejar stashes olvidados por meses
# Limpiar regularmente
```

## Comandos útiles de referencia rápida

```bash
# Guardar cambios
git stash                          # Guardar cambios
git stash save "mensaje"           # Guardar con mensaje
git stash -u                       # Incluir archivos sin rastrear
git stash -a                       # Incluir todo (hasta ignorados)

# Ver stashes
git stash list                     # Listar todos
git stash show                     # Ver último stash
git stash show -p                  # Ver cambios detallados
git stash show stash@{1}           # Ver stash específico

# Recuperar cambios
git stash pop                      # Aplicar y eliminar último
git stash apply                    # Aplicar sin eliminar
git stash pop stash@{2}            # Aplicar específico y eliminar
git stash apply stash@{2}          # Aplicar específico sin eliminar

# Eliminar stashes
git stash drop                     # Eliminar último
git stash drop stash@{1}           # Eliminar específico
git stash clear                    # Eliminar todos

# Avanzado
git stash branch nombre-rama       # Crear rama desde stash
git stash -p                       # Stash interactivo
```

## Solución de problemas comunes

### Problema 1: Stash no guarda archivos nuevos

```bash
# ❌ Problema
git stash  # No guarda archivos sin rastrear

# ✅ Solución
git stash -u  # Incluir untracked files
```

### Problema 2: Perdiste un stash

```bash
# Si eliminaste un stash por error
git fsck --unreachable | grep commit

# Buscar el hash del stash perdido
git show 

# Recuperarlo
git stash apply 
```

### Problema 3: No puedes cambiar de rama

```bash
# Error: cannot switch branches with uncommitted changes

# Opción 1: Stash
git stash
git checkout otra-rama

# Opción 2: Commit temporal
git add .
git commit -m "WIP"
git checkout otra-rama
```

## Resumen visual

```
FLUJO TÍPICO DE STASH:

1. Working Directory (con cambios)
   ↓
2. git stash
   ↓
3. Working Directory (limpio) + Stash guardado
   ↓
4. Trabajar en otra cosa
   ↓
5. git stash pop
   ↓
6. Working Directory (con cambios restaurados)
```

## Cuándo usar stash

| Situación | ¿Usar stash? |
|-----------|--------------|
| Cambiar de rama con trabajo sin terminar | ✅ Sí |
| Pull con cambios locales | ✅ Sí |
| Probar algo rápidamente | ✅ Sí |
| Trabajo que quieres guardar permanentemente | ❌ No (usa commit) |
| Compartir cambios con equipo | ❌ No (usa commit + push) |
| Backup de largo plazo | ❌ No (usa commit/branch) |

Git stash es una herramienta poderosa para gestionar trabajo temporal sin ensuciar el historial de commits. Úsalo para cambios temporales y locales, pero no como reemplazo de commits reales.

***
12. ¿Qué mecanismos ofrece Git para deshacer cambios (por ejemplo, git reset, git revert, git checkout)?

##### R: 
## Introducción

Git ofrece varios comandos para deshacer cambios dependiendo del estado en que se encuentren y qué tan atrás quieras retroceder. Los principales mecanismos son:

- **git reset** - Mueve el HEAD y modifica historial
- **git revert** - Crea nuevo commit que deshace cambios
- **git checkout** - Cambia de rama o restaura archivos (antiguo)
- **git restore** - Restaura archivos (comando moderno)
- **git clean** - Elimina archivos no rastreados

## Los tres árboles de Git

Para entender cómo deshacer cambios, primero debes conocer los tres estados:

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Working       │    │    Staging      │    │   Repository    │
│   Directory     │    │     Area        │    │    (commits)    │
│  (archivos)     │    │    (index)      │    │   (historial)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

Cada comando de deshacer afecta diferentes áreas.

## 1. git reset - Mover el HEAD y resetear áreas

### ¿Qué hace git reset?

Mueve el puntero HEAD (y la rama actual) a un commit específico y opcionalmente modifica el staging area y working directory.

### Tres modos de reset:

#### A) git reset --soft

**Mueve HEAD pero mantiene staging y working directory intactos**

```bash
# Deshacer último commit manteniendo cambios staged
git reset --soft HEAD~1

# Resultado:
# ✅ Commit deshecho
# ✅ Cambios en staging area
# ✅ Cambios en working directory
```

**Diagrama:**
```
Antes:  A---B---C (HEAD)
             ↑ staging ↑ working

Después: A---B (HEAD)
             ↑ staging (con cambios de C) ↑ working (con cambios de C)
```

**Uso típico:** Rehacer el último commit

```bash
# Hiciste commit muy rápido
git commit -m "Feature incompleta"

# Deshacer commit pero mantener cambios
git reset --soft HEAD~1

# Agregar más cambios
git add otros-archivos.js

# Hacer commit completo
git commit -m "Feature completa"
```

#### B) git reset --mixed (por defecto)

**Mueve HEAD y limpia staging, pero mantiene working directory**

```bash
# Deshacer último commit y quitar del staging
git reset HEAD~1
# o
git reset --mixed HEAD~1

# Resultado:
# ✅ Commit deshecho
# ✅ Staging area limpio
# ✅ Cambios en working directory (sin staged)
```

**Diagrama:**
```
Antes:  A---B---C (HEAD)
             ↑ staging ↑ working

Después: A---B (HEAD)
             ↑ staging (vacío) ↑ working (con cambios de C)
```

**Uso típico:** Reorganizar qué va en el commit

```bash
# Commiteaste varios archivos juntos
git commit -m "Múltiples cambios"

# Deshacer para reorganizar
git reset HEAD~1

# Ahora hacer commits separados
git add feature1.js
git commit -m "Feature 1"

git add feature2.js
git commit -m "Feature 2"
```

#### C) git reset --hard

**Mueve HEAD y ELIMINA cambios en staging y working directory**

```bash
# ⚠️ PELIGROSO: Deshacer commit y ELIMINAR todos los cambios
git reset --hard HEAD~1

# Resultado:
# ✅ Commit deshecho
# ❌ Staging area limpio
# ❌ Working directory limpio (CAMBIOS PERDIDOS)
```

**Diagrama:**
```
Antes:  A---B---C (HEAD)
             ↑ staging ↑ working

Después: A---B (HEAD)
             ↑ staging (vacío) ↑ working (vacío)
```

**⚠️ ADVERTENCIA:** Los cambios se pierden permanentemente (aunque pueden recuperarse con reflog)

**Uso típico:** Descartar completamente todo

```bash
# Experimento falló, quieres volver a estado anterior
git reset --hard HEAD~1

# Descartar todos los cambios locales
git reset --hard HEAD
```

### Tabla comparativa de reset:

| Modo | Mueve HEAD | Limpia Staging | Limpia Working | Peligrosidad |
|------|-----------|----------------|----------------|--------------|
| `--soft` | ✅ Sí | ❌ No | ❌ No | 🟢 Seguro |
| `--mixed` | ✅ Sí | ✅ Sí | ❌ No | 🟢 Seguro |
| `--hard` | ✅ Sí | ✅ Sí | ✅ Sí | 🔴 Peligroso |

### Ejemplos de reset:

```bash
# Deshacer 1 commit
git reset HEAD~1

# Deshacer 3 commits
git reset HEAD~3

# Resetear a commit específico
git reset abc123

# Resetear a una rama
git reset origin/main

# Quitar archivo del staging (sin perder cambios)
git reset archivo.js
# o
git reset HEAD archivo.js
```

## 2. git revert - Crear commit que deshace cambios

### ¿Qué hace git revert?

Crea un **nuevo commit** que deshace los cambios de un commit anterior. **NO modifica el historial**.

```bash
# Revertir el último commit
git revert HEAD

# Revertir un commit específico
git revert abc123

# Revertir múltiples commits
git revert HEAD~3..HEAD
```

**Diferencia clave con reset:**
- **reset**: Borra commits del historial
- **revert**: Crea nuevos commits que deshacen cambios

**Diagrama:**
```
Antes:  A---B---C---D (HEAD)

git revert C

Después: A---B---C---D---E (HEAD)
                          ↑
                    (E deshace C)
```

### Cuándo usar revert:

✅ **Usa revert cuando:**
- El commit ya fue publicado (pusheado)
- Trabajas en equipo
- Necesitas mantener el historial completo
- Quieres documentar la corrección

❌ **NO uses revert si:**
- El commit es solo local
- Prefieres un historial limpio sin "commits de reversión"

### Ejemplos de revert:

```bash
# Revertir último commit
git revert HEAD
# Git abre editor para mensaje del commit de reversión

# Revertir sin abrir editor
git revert HEAD --no-edit

# Revertir pero no hacer commit automáticamente
git revert -n HEAD
git revert --no-commit HEAD

# Continuar después de resolver conflictos
git revert --continue

# Cancelar revert
git revert --abort
```

### Revert con conflictos:

```bash
# Intentar revertir
git revert abc123

# Si hay conflictos:
# Output: CONFLICT (content): Merge conflict in archivo.js

# Resolver conflictos manualmente
nano archivo.js
git add archivo.js

# Continuar
git revert --continue
```

## 3. git checkout - Cambiar rama o restaurar archivos (antiguo)

### ¿Qué hace git checkout?

Originalmente servía para dos propósitos:
1. Cambiar de rama
2. Restaurar archivos

**Nota:** Git 2.23+ introdujo `git switch` y `git restore` para separar estas funciones.

### Checkout para restaurar archivos:

```bash
# Descartar cambios en un archivo (restaurar desde último commit)
git checkout -- archivo.js

# Restaurar archivo desde commit específico
git checkout abc123 -- archivo.js

# Restaurar todos los archivos
git checkout -- .
```

**⚠️ ADVERTENCIA:** Los cambios locales se pierden

### Ejemplos de checkout:

```bash
# Descartar cambios en archivo modificado
echo "cambios" >> app.js
git checkout -- app.js
# app.js vuelve al estado del último commit

# Restaurar archivo desde 3 commits atrás
git checkout HEAD~3 -- config.json

# Restaurar todo a estado del último commit
git checkout -- .
```

## 4. git restore - Restaurar archivos (moderno)

### ¿Qué hace git restore?

Comando moderno (Git 2.23+) diseñado específicamente para restaurar archivos. Reemplaza el uso de `git checkout` para restauración.

### Restaurar working directory:

```bash
# Descartar cambios en archivo
git restore archivo.js

# Descartar cambios en todos los archivos
git restore .

# Restaurar desde commit específico
git restore --source=HEAD~2 archivo.js
```

### Restaurar staging area:

```bash
# Quitar archivo del staging (mantener cambios en working)
git restore --staged archivo.js

# Quitar todos los archivos del staging
git restore --staged .
```

### Restaurar ambos (staging y working):

```bash
# Descartar completamente
git restore --source=HEAD --staged --worktree archivo.js
```

### Ejemplos de restore:

```bash
# Descartar modificaciones
git restore app.js

# Quitar del staging
git add app.js
git restore --staged app.js
# app.js sigue modificado pero no staged

# Descartar todo
git restore .

# Restaurar archivo eliminado
rm archivo.js
git restore archivo.js
```

## 5. git clean - Eliminar archivos no rastreados

### ¿Qué hace git clean?

Elimina archivos que **no están siendo rastreados** por Git.

```bash
# Ver qué se eliminaría (simulación)
git clean -n

# Eliminar archivos no rastreados
git clean -f

# Eliminar archivos y directorios
git clean -fd

# Eliminar incluyendo archivos ignorados
git clean -fdx
```

**⚠️ ADVERTENCIA:** Los archivos se eliminan permanentemente

### Ejemplos de clean:

```bash
# Ver archivos que se eliminarían
git clean -n
# Output: Would remove archivo-nuevo.js

# Eliminar archivos no rastreados
git clean -f

# Eliminar archivos y carpetas
git clean -fd

# Limpiar todo (incluso ignorados)
git clean -fdx
```

## Comparación de comandos para deshacer

### Tabla comparativa completa:

| Comando | Afecta Commits | Afecta Staging | Afecta Working | Seguro | Uso típico |
|---------|---------------|----------------|----------------|--------|------------|
| `reset --soft` | ✅ Sí | ❌ No | ❌ No | 🟢 Sí | Rehacer commit |
| `reset --mixed` | ✅ Sí | ✅ Sí | ❌ No | 🟢 Sí | Reorganizar staging |
| `reset --hard` | ✅ Sí | ✅ Sí | ✅ Sí | 🔴 No | Descartar todo |
| `revert` | ✅ Crea nuevo | ❌ No | ❌ No | 🟢 Sí | Deshacer commit público |
| `checkout --` | ❌ No | ❌ No | ✅ Sí | 🔴 No | Restaurar archivo (antiguo) |
| `restore` | ❌ No | ✅ Opcional | ✅ Sí | 🔴 No | Restaurar archivo (moderno) |
| `clean` | ❌ No | ❌ No | ✅ Sí | 🔴 No | Eliminar no rastreados |

## Escenarios comunes y soluciones

### Escenario 1: Modificaste archivo y quieres descartarlo

```bash
# Cambios en archivo
echo "error" >> app.js

# Descartar cambios (método moderno)
git restore app.js

# O método antiguo
git checkout -- app.js
```

### Escenario 2: Agregaste archivo al staging por error

```bash
# Agregaste por error
git add archivo-incorrecto.js

# Quitar del staging
git restore --staged archivo-incorrecto.js

# O método antiguo
git reset HEAD archivo-incorrecto.js
```

### Escenario 3: Hiciste commit pero olvidaste algo

```bash
# Commit incompleto
git commit -m "Feature X"

# Deshacer commit (mantener cambios)
git reset --soft HEAD~1

# Agregar lo que faltaba
git add archivo-olvidado.js

# Rehacer commit
git commit -m "Feature X completa"
```

### Escenario 4: Commit equivocado en rama incorrecta

```bash
# Commiteaste en main por error
git log --oneline
# abc123 Feature nueva (este es el error)

# Guardar hash del commit
# Deshacer commit en main
git reset --hard HEAD~1

# Cambiar a rama correcta
git checkout feature-branch

# Aplicar el commit ahí
git cherry-pick abc123
```

### Escenario 5: Commit ya publicado con error

```bash
# Commit con bug ya fue pusheado
git log
# abc123 Implementa feature (con bug)

# NO usar reset (ya es público)
# Usar revert
git revert abc123

# Push del revert
git push origin main
```

### Escenario 6: Experimento falló completamente

```bash
# Hiciste muchos cambios que no sirven
git status
# Output: modified: 10 archivos

# Descartar TODO
git reset --hard HEAD

# Si hay archivos no rastreados también
git clean -fd
```

### Escenario 7: Quieres deshacer 3 commits locales

```bash
# Commits locales que quieres eliminar
git log --oneline
# ddd Feature 3
# ccc Feature 2
# bbb Feature 1
# aaa Último commit bueno

# Eliminar los 3 últimos commits
git reset --hard HEAD~3

# O resetear a commit específico
git reset --hard aaa
```

## Recuperar commits "perdidos" con reflog

Si hiciste reset --hard por error, puedes recuperar:

```bash
# Ver historial de movimientos de HEAD
git reflog

# Output:
# abc123 HEAD@{0}: reset: moving to HEAD~1
# def456 HEAD@{1}: commit: Feature importante
# ghi789 HEAD@{2}: commit: Otro commit

# Recuperar commit "perdido"
git reset --hard def456

# O usar la referencia del reflog
git reset --hard HEAD@{1}
```

## Comandos de emergencia

### Deshice algo por error:

```bash
# Ver reflog
git reflog

# Volver al estado anterior
git reset --hard HEAD@{1}
```

### Quiero volver exactamente a como está en remoto:

```bash
# Descartar TODO y sincronizar con remoto
git fetch origin
git reset --hard origin/main
git clean -fd
```

### Quiero deshacer los últimos 5 commits (local):

```bash
# Eliminar 5 commits
git reset --hard HEAD~5
```

### Quiero deshacer un merge:

```bash
# Si el merge no fue pusheado
git reset --hard HEAD~1

# Si el merge ya fue pusheado
git revert -m 1 HEAD
```

## Diferencias clave: reset vs revert

### Usar RESET cuando:
- ✅ Commits son solo locales (no publicados)
- ✅ Quieres historial limpio
- ✅ Trabajas solo
- ✅ Experimento falló

### Usar REVERT cuando:
- ✅ Commits ya fueron publicados
- ✅ Trabajas en equipo
- ✅ Necesitas mantener historial
- ✅ Quieres documentar la corrección

## Comandos de referencia rápida

```bash
# DESHACER COMMITS
git reset --soft HEAD~1      # Deshacer commit (mantener staging)
git reset HEAD~1             # Deshacer commit (quitar staging)
git reset --hard HEAD~1      # Deshacer commit (eliminar todo) ⚠️
git revert HEAD              # Crear commit que deshace otro

# RESTAURAR ARCHIVOS
git restore archivo.js       # Descartar cambios en archivo
git restore --staged archivo # Quitar del staging
git checkout -- archivo.js   # Descartar cambios (antiguo)

# LIMPIAR
git clean -n                 # Ver qué se eliminaría
git clean -fd                # Eliminar no rastreados
git reset --hard HEAD        # Descartar todos los cambios ⚠️

# RECUPERAR
git reflog                   # Ver historial de HEAD
git reset --hard HEAD@{1}    # Volver a estado anterior
```

## Niveles de "deshacer"

```
NIVEL 1 - Solo working directory:
git restore archivo.js
git checkout -- archivo.js

NIVEL 2 - Staging area:
git restore --staged archivo.js
git reset HEAD archivo.js

NIVEL 3 - Último commit (mantener cambios):
git reset --soft HEAD~1

NIVEL 4 - Último commit (sin mantener):
git reset --hard HEAD~1

NIVEL 5 - Commit público:
git revert HEAD

NIVEL 6 - Múltiples commits:
git reset --hard HEAD~5

NIVEL 7 - Todo el repositorio:
git reset --hard origin/main
git clean -fdx
```

## Resumen visual

```
ESTADOS Y COMANDOS:

Working Directory → git restore / checkout
      ↓
Staging Area → git restore --staged / reset HEAD
      ↓
Local Commits → git reset --soft/mixed/hard
      ↓
Published Commits → git revert

Archivos no rastreados → git clean
```

Git ofrece múltiples mecanismos para deshacer cambios según el nivel y el contexto. La clave es elegir el comando correcto según si los cambios son locales o públicos, y qué áreas quieres afectar.

***
13. ¿Cómo funciona la configuración de remotos (origin, upstream) y qué comandos uso para gestión de forks?

##### R: 
## ¿Qué es un remoto en Git?

Un **remoto** es una referencia a un repositorio Git alojado en otro lugar (generalmente en un servidor como GitHub, GitLab o Bitbucket). Permite sincronizar tu repositorio local con versiones remotas.

```bash
# Ver remotos configurados
git remote -v

# Salida ejemplo:
# origin    https://github.com/usuario/proyecto.git (fetch)
# origin    https://github.com/usuario/proyecto.git (push)
```

## Remotos comunes: origin y upstream

### Origin

**Origin** es el nombre **predeterminado** que Git asigna al remoto desde el cual clonaste el repositorio.

```bash
# Cuando clonas un repositorio
git clone https://github.com/usuario/proyecto.git

# Automáticamente se crea el remoto "origin"
git remote -v
# origin    https://github.com/usuario/proyecto.git (fetch)
# origin    https://github.com/usuario/proyecto.git (push)
```

**Características:**
- Nombre convencional (puedes cambiarlo)
- Tu repositorio principal
- Donde haces push por defecto

### Upstream

**Upstream** es un nombre **convencional** para el repositorio original cuando trabajas con forks. No se crea automáticamente, debes agregarlo manualmente.

```bash
# Agregar upstream manualmente
git remote add upstream https://github.com/original/proyecto.git

# Ver remotos
git remote -v
# origin     https://github.com/tu-usuario/proyecto.git (fetch)
# origin     https://github.com/tu-usuario/proyecto.git (push)
# upstream   https://github.com/original/proyecto.git (fetch)
# upstream   https://github.com/original/proyecto.git (push)
```

**Características:**
- Repositorio original (del cual hiciste fork)
- Solo lectura típicamente (no tienes permisos de push)
- Usado para mantener tu fork actualizado

## Diagrama de remotos con fork

```
┌─────────────────────────────────────────┐
│   REPOSITORIO ORIGINAL (upstream)       │
│   github.com/proyecto-original/repo     │
│                                         │
│   main: A---B---C---D---E               │
└─────────────────┬───────────────────────┘
                  │ fork
                  ↓
┌─────────────────────────────────────────┐
│   TU FORK (origin)                      │
│   github.com/tu-usuario/repo            │
│                                         │
│   main: A---B---C                       │
└─────────────────┬───────────────────────┘
                  │ clone
                  ↓
┌─────────────────────────────────────────┐
│   REPOSITORIO LOCAL                     │
│   tu-computadora/repo                   │
│                                         │
│   main: A---B---C---F (tus cambios)     │
└─────────────────────────────────────────┘
```

## Comandos básicos de remotos

### Ver remotos:

```bash
# Listar remotos (nombres)
git remote

# Listar remotos con URLs
git remote -v

# Ver información detallada de un remoto
git remote show origin
```

### Agregar remoto:

```bash
# Sintaxis
git remote add  

# Ejemplos
git remote add origin https://github.com/usuario/proyecto.git
git remote add upstream https://github.com/original/proyecto.git
git remote add colaborador https://github.com/colaborador/proyecto.git
```

### Eliminar remoto:

```bash
# Eliminar remoto
git remote remove origin
# o
git remote rm origin
```

### Renombrar remoto:

```bash
# Renombrar remoto
git remote rename origin mi-fork
git remote rename upstream original
```

### Cambiar URL de remoto:

```bash
# Cambiar URL
git remote set-url origin https://nuevo-url.git

# Cambiar de HTTPS a SSH
git remote set-url origin git@github.com:usuario/proyecto.git
```

## Gestión de Forks

### ¿Qué es un fork?

Un **fork** es una copia completa de un repositorio en tu cuenta de GitHub/GitLab. Te permite experimentar y hacer cambios sin afectar el proyecto original.

### Flujo completo de trabajo con forks:

#### Paso 1: Crear fork en GitHub

```
1. Ve al repositorio original en GitHub
2. Haz clic en "Fork" (esquina superior derecha)
3. Selecciona tu cuenta
4. Ahora tienes una copia en tu cuenta
```

#### Paso 2: Clonar tu fork

```bash
# Clonar TU fork (no el original)
git clone https://github.com/TU-USUARIO/proyecto.git
cd proyecto

# Verificar remoto
git remote -v
# origin    https://github.com/TU-USUARIO/proyecto.git (fetch)
# origin    https://github.com/TU-USUARIO/proyecto.git (push)
```

#### Paso 3: Agregar upstream (repositorio original)

```bash
# Agregar el repositorio original como upstream
git remote add upstream https://github.com/USUARIO-ORIGINAL/proyecto.git

# Verificar remotos
git remote -v
# origin     https://github.com/TU-USUARIO/proyecto.git (fetch)
# origin     https://github.com/TU-USUARIO/proyecto.git (push)
# upstream   https://github.com/USUARIO-ORIGINAL/proyecto.git (fetch)
# upstream   https://github.com/USUARIO-ORIGINAL/proyecto.git (push)
```

#### Paso 4: Mantener tu fork actualizado

```bash
# Traer cambios del repositorio original
git fetch upstream

# Ver ramas disponibles
git branch -a

# Fusionar cambios de upstream/main en tu main local
git checkout main
git merge upstream/main

# O usar rebase para historial más limpio
git rebase upstream/main

# Subir cambios actualizados a tu fork
git push origin main
```

#### Paso 5: Crear rama para nueva funcionalidad

```bash
# Crear rama desde main actualizado
git checkout main
git pull upstream main  # Asegurar que está actualizado

# Crear nueva rama
git checkout -b feature/nueva-funcionalidad

# Hacer cambios
echo "código nuevo" > archivo.js
git add archivo.js
git commit -m "Agrega nueva funcionalidad"

# Push a tu fork
git push origin feature/nueva-funcionalidad
```

#### Paso 6: Crear Pull Request

```
1. Ve a tu fork en GitHub
2. Verás botón "Compare & pull request"
3. Asegúrate que:
   - Base: USUARIO-ORIGINAL/proyecto main
   - Compare: TU-USUARIO/proyecto feature/nueva-funcionalidad
4. Clic en "Create pull request"
5. Describe tus cambios
6. Envía el PR
```

## Workflows comunes con remotos

### Workflow 1: Fork actualizado constantemente

```bash
# Cada vez que vas a trabajar:

# 1. Actualizar main local desde upstream
git checkout main
git fetch upstream
git merge upstream/main

# 2. Actualizar tu fork en GitHub
git push origin main

# 3. Crear rama para trabajar
git checkout -b feature/mi-feature

# 4. Trabajar normalmente
git add .
git commit -m "Implementa feature"

# 5. Push a tu fork
git push origin feature/mi-feature

# 6. Crear PR desde GitHub
```

### Workflow 2: Sincronizar fork antes de PR

```bash
# Tu rama está desactualizada

# 1. Traer cambios de upstream
git fetch upstream

# 2. Rebase tu rama sobre main actualizado
git checkout feature/mi-feature
git rebase upstream/main

# 3. Resolver conflictos si existen
# ... resolver conflictos ...
git add archivos-resueltos
git rebase --continue

# 4. Push forzado a tu fork (rebase cambió historial)
git push origin feature/mi-feature --force-with-lease
```

### Workflow 3: Múltiples remotos

```bash
# Agregar múltiples remotos
git remote add juan https://github.com/juan/proyecto.git
git remote add maria https://github.com/maria/proyecto.git

# Traer cambios de colaboradores
git fetch juan
git fetch maria

# Crear rama basada en trabajo de juan
git checkout -b fix-from-juan juan/fix-branch

# Fusionar trabajo de maría
git merge maria/feature-branch
```

## Comandos avanzados de remotos

### Fetch vs Pull:

```bash
# Fetch: descargar cambios SIN fusionar
git fetch origin
git fetch upstream
git fetch --all  # Todos los remotos

# Pull: descargar Y fusionar
git pull origin main
git pull upstream main

# Pull equivale a:
git fetch origin
git merge origin/main
```

### Push a remotos específicos:

```bash
# Push a origin (por defecto)
git push

# Push a remoto específico
git push origin main
git push upstream main  # (si tienes permisos)

# Push rama local a rama remota con nombre diferente
git push origin local-branch:remote-branch

# Push todas las ramas
git push --all origin

# Push tags
git push --tags origin
```

### Configurar upstream de rama:

```bash
# Configurar rama para hacer push/pull automático
git push -u origin feature-branch
# o
git push --set-upstream origin feature-branch

# Ahora solo necesitas:
git push  # Hace push a origin/feature-branch automáticamente
git pull  # Hace pull de origin/feature-branch automáticamente
```

### Eliminar ramas remotas:

```bash
# Eliminar rama en remoto
git push origin --delete feature-branch
# o
git push origin :feature-branch

# Limpiar referencias a ramas remotas eliminadas
git fetch --prune
# o
git remote prune origin
```

## Escenarios prácticos completos

### Escenario 1: Contribuir a proyecto open source

```bash
# 1. Fork en GitHub (botón Fork)

# 2. Clonar tu fork
git clone https://github.com/TU-USUARIO/proyecto-opensource.git
cd proyecto-opensource

# 3. Agregar upstream
git remote add upstream https://github.com/PROYECTO-ORIGINAL/proyecto-opensource.git

# 4. Crear rama para feature
git checkout -b fix/issue-123

# 5. Hacer cambios
nano archivo.js
git add archivo.js
git commit -m "Fix issue #123: Corrige validación de email"

# 6. Asegurar que está actualizado
git fetch upstream
git rebase upstream/main

# 7. Push a tu fork
git push origin fix/issue-123

# 8. Crear PR en GitHub
```

### Escenario 2: Tu fork está muy desactualizado

```bash
# Tu fork tiene 50 commits de retraso

# 1. Fetch upstream
git fetch upstream

# 2. Checkout a main
git checkout main

# 3. Reset hard a upstream (perderás tus cambios en main)
git reset --hard upstream/main

# 4. Force push a tu fork
git push origin main --force

# Ahora tu fork está sincronizado
```

### Escenario 3: Trabajar con múltiples forks

```bash
# Proyecto original
git remote add upstream https://github.com/original/proyecto.git

# Tu fork
git remote add origin https://github.com/tu-usuario/proyecto.git

# Fork de tu equipo
git remote add equipo https://github.com/equipo/proyecto.git

# Ver todos
git remote -v

# Traer cambios de todos
git fetch --all

# Crear rama basada en trabajo del equipo
git checkout -b feature equipo/develop

# Mantener actualizado con upstream
git fetch upstream
git rebase upstream/main
```

### Escenario 4: Sincronizar fork automáticamente

Crear script para sincronización:

```bash
#!/bin/bash
# sync-fork.sh

echo "Sincronizando fork..."

# Traer cambios de upstream
git fetch upstream

# Guardar rama actual
CURRENT_BRANCH=$(git branch --show-current)

# Actualizar main
git checkout main
git merge upstream/main
git push origin main

# Volver a rama original
git checkout $CURRENT_BRANCH

echo "Fork sincronizado!"
```

Usar el script:

```bash
chmod +x sync-fork.sh
./sync-fork.sh
```

## Configuración avanzada de remotos

### Configurar diferentes URLs para fetch y push:

```bash
# URL diferente para fetch (HTTPS)
git remote set-url origin https://github.com/usuario/proyecto.git

# URL diferente para push (SSH)
git remote set-url --push origin git@github.com:usuario/proyecto.git

# Verificar
git remote -v
# origin    https://github.com/usuario/proyecto.git (fetch)
# origin    git@github.com:usuario/proyecto.git (push)
```

### Configurar credenciales:

```bash
# Guardar credenciales temporalmente (15 min)
git config --global credential.helper cache

# Guardar credenciales permanentemente
git config --global credential.helper store

# Usar SSH en lugar de HTTPS
git remote set-url origin git@github.com:usuario/proyecto.git
```

### Configurar múltiples URLs de push:

```bash
# Push a múltiples remotos simultáneamente
git remote set-url --add --push origin https://github.com/usuario/proyecto.git
git remote set-url --add --push origin https://gitlab.com/usuario/proyecto.git

# Un solo push actualiza ambos
git push origin main
```

## Comandos de verificación y troubleshooting

### Verificar estado de remotos:

```bash
# Ver información completa
git remote show origin

# Salida ejemplo:
# * remote origin
#   Fetch URL: https://github.com/usuario/proyecto.git
#   Push  URL: https://github.com/usuario/proyecto.git
#   HEAD branch: main
#   Remote branches:
#     main    tracked
#     develop tracked
#   Local branch configured for 'git pull':
#     main merges with remote main
#   Local ref configured for 'git push':
#     main pushes to main (up to date)
```

### Ver ramas remotas:

```bash
# Ver todas las ramas (locales y remotas)
git branch -a

# Solo ramas remotas
git branch -r

# Ver ramas con último commit
git branch -av
```

### Comparar con remoto:

```bash
# Ver diferencias con rama remota
git diff origin/main

# Ver commits que no has pusheado
git log origin/main..HEAD

# Ver commits que no has traído
git log HEAD..origin/main
```

### Actualizar referencias remotas:

```bash
# Actualizar todas las referencias
git fetch --all

# Limpiar referencias obsoletas
git remote prune origin

# Fetch y limpiar
git fetch --prune
```

## Problemas comunes y soluciones

### Problema 1: Upstream no configurado

```bash
# Error al hacer push
git push
# fatal: The current branch has no upstream branch

# Solución: Configurar upstream
git push -u origin nombre-rama
```

### Problema 2: Fork muy desactualizado

```bash
# Ver cuántos commits de diferencia
git fetch upstream
git log HEAD..upstream/main --oneline

# Sincronizar
git checkout main
git reset --hard upstream/main
git push origin main --force
```

### Problema 3: Conflictos al sincronizar fork

```bash
# Fetch upstream
git fetch upstream

# Merge con conflictos
git merge upstream/main
# CONFLICT...

# Resolver conflictos
nano archivo-conflictivo.js
git add archivo-conflictivo.js
git commit

# Push a fork
git push origin main
```

### Problema 4: Acceso denegado al hacer push

```bash
# Error: Permission denied

# Verificar remoto
git remote -v

# Asegúrate de hacer push a TU fork, no al original
git remote set-url origin https://github.com/TU-USUARIO/proyecto.git
```

## Comandos de referencia rápida

```bash
# VER REMOTOS
git remote -v                    # Listar remotos con URLs
git remote show origin           # Info detallada del remoto

# AGREGAR/MODIFICAR REMOTOS
git remote add origin       # Agregar remoto
git remote add upstream     # Agregar upstream
git remote set-url origin   # Cambiar URL
git remote rename origin nuevo   # Renombrar
git remote remove origin         # Eliminar

# SINCRONIZAR
git fetch origin                 # Traer cambios
git fetch upstream               # Traer de upstream
git fetch --all                  # Traer de todos
git pull origin main             # Traer y fusionar
git push origin main             # Enviar cambios

# GESTIÓN DE FORK
git fetch upstream               # Traer cambios del original
git merge upstream/main          # Fusionar en tu rama
git rebase upstream/main         # Rebase sobre upstream
git push origin main             # Actualizar tu fork

# RAMAS REMOTAS
git branch -r                    # Ver ramas remotas
git push origin --delete rama    # Eliminar rama remota
git fetch --prune                # Limpiar referencias
```

## Tabla comparativa: origin vs upstream

| Aspecto | Origin | Upstream |
|---------|--------|----------|
| **Creación** | Automática al clonar | Manual |
| **Propósito** | Tu repositorio (fork) | Repositorio original |
| **Permisos** | Read/Write | Solo Read (típicamente) |
| **Push** | ✅ Sí | ❌ No (sin permisos) |
| **Pull** | ✅ Sí | ✅ Sí |
| **Uso principal** | Guardar tu trabajo | Mantener fork actualizado |

## Mejores prácticas

### ✅ DO (Hacer):

- Nombrar remoto principal como `origin`
- Nombrar repositorio original como `upstream`
- Sincronizar fork regularmente con upstream
- Crear ramas desde main actualizado
- Usar `--force-with-lease` en lugar de `--force`

### ❌ DON'T (No hacer):

- Hacer push directo a upstream (sin permisos)
- Dejar fork desactualizado por mucho tiempo
- Trabajar directamente en main
- Usar `--force` sin precaución
- Ignorar conflictos al sincronizar

Los remotos son esenciales para la colaboración en Git. Entender origin, upstream y cómo gestionar forks te permite contribuir efectivamente a proyectos open source y colaborar en equipo.

***
14. ¿Cómo puedo inspeccionar el historial de commits (por ejemplo, git log, git diff, git show)?

##### R: 
## Introducción

Git ofrece poderosas herramientas para explorar el historial de cambios en tu proyecto. Los comandos principales son:

- **git log** - Ver historial de commits
- **git diff** - Ver diferencias entre versiones
- **git show** - Mostrar detalles de un commit específico
- **git blame** - Ver quién modificó cada línea
- **git reflog** - Ver historial de movimientos de HEAD

## 1. git log - Historial de commits

### Uso básico:

```bash
# Ver historial completo
git log

# Salida:
# commit abc123def456... (HEAD -> main, origin/main)
# Author: Juan Pérez 
# Date:   Mon Feb 10 14:30:00 2026 -0500
#
#     Implementa validación de formularios
#
#     - Agrega validación de email
#     - Agrega validación de password
#     - Mejora mensajes de error
```

### Formato compacto (oneline):

```bash
# Una línea por commit
git log --oneline

# Salida:
# abc123d Implementa validación de formularios
# def456a Corrige bug en login
# ghi789b Agrega página de perfil
# jkl012c Initial commit
```

### Limitar número de commits:

```bash
# Ver últimos 5 commits
git log -5

# Ver últimos 10 commits en formato corto
git log --oneline -10

# Ver commits desde hace 2 semanas
git log --since="2 weeks ago"

# Ver commits hasta una fecha
git log --until="2026-01-01"
```

### Filtrar por autor:

```bash
# Commits de un autor específico
git log --author="Juan"

# Commits de múltiples autores
git log --author="Juan\|María"

# Commits propios
git log --author="$(git config user.name)"
```

### Filtrar por mensaje:

```bash
# Commits que contienen una palabra en el mensaje
git log --grep="bug"

# Commits que mencionan "login"
git log --grep="login"

# Búsqueda case-insensitive
git log --grep="BUG" -i

# Múltiples términos (OR)
git log --grep="bug\|fix"

# Múltiples términos (AND)
git log --grep="bug" --grep="login" --all-match
```

### Filtrar por archivo:

```bash
# Ver historial de un archivo específico
git log -- archivo.js

# Ver historial de múltiples archivos
git log -- archivo1.js archivo2.js

# Ver historial de un directorio
git log -- src/

# Incluir archivos renombrados
git log --follow -- archivo.js
```

### Formato visual (graph):

```bash
# Ver árbol de ramas
git log --graph

# Árbol con formato compacto
git log --graph --oneline

# Árbol con todas las ramas
git log --graph --oneline --all

# Árbol decorado (muestra ramas y tags)
git log --graph --oneline --decorate --all
```

**Salida ejemplo:**
```
* abc123d (HEAD -> main) Implementa validación
* def456a Corrige bug en login
*   ghi789b Merge branch 'feature'
|\  
| * jkl012c Agrega funcionalidad X
|/  
* mno345p Actualiza dependencias
```

### Formato personalizado:

```bash
# Formato custom
git log --pretty=format:"%h - %an, %ar : %s"

# Salida:
# abc123d - Juan Pérez, 2 hours ago : Implementa validación
# def456a - María García, 1 day ago : Corrige bug en login

# Opciones de formato:
# %H  - Hash completo del commit
# %h  - Hash abreviado
# %an - Nombre del autor
# %ae - Email del autor
# %ad - Fecha del autor
# %ar - Fecha relativa (hace 2 días)
# %s  - Mensaje del commit (subject)
# %b  - Cuerpo del mensaje
```

### Ejemplos de formatos útiles:

```bash
# Formato elegante
git log --pretty=format:"%C(yellow)%h%C(reset) - %C(green)%ad%C(reset) - %s %C(bold blue)<%an>%C(reset)" --date=short

# Ver estadísticas de cambios
git log --stat

# Ver cambios reales (patch)
git log -p

# Ver resumen de cambios
git log --shortstat

# Ver solo nombres de archivos
git log --name-only

# Ver nombres y estado de archivos
git log --name-status
```

### Filtros avanzados:

```bash
# Commits que modificaron una función específica
git log -S"nombreFuncion"

# Commits que agregaron o eliminaron líneas con "TODO"
git log -G"TODO"

# Commits de merge
git log --merges

# Commits que NO son merge
git log --no-merges

# Commits en rama A pero no en B
git log branchA ^branchB
git log branchA..branchB

# Commits en cualquiera de las ramas pero no en ambas
git log branchA...branchB
```

## 2. git diff - Ver diferencias

### Diferencias en working directory:

```bash
# Ver cambios no staged
git diff

# Salida:
# diff --git a/app.js b/app.js
# index abc123d..def456a 100644
# --- a/app.js
# +++ b/app.js
# @@ -10,7 +10,7 @@ function login() {
#    if (!email) {
# -    return "Email requerido";
# +    return "Por favor ingrese su email";
#    }
```

### Diferencias en staging area:

```bash
# Ver cambios staged (listos para commit)
git diff --staged
# o
git diff --cached
```

### Comparar commits:

```bash
# Diferencias entre dos commits
git diff abc123d def456a

# Diferencias entre commit y HEAD
git diff abc123d

# Diferencias entre HEAD y 3 commits atrás
git diff HEAD~3

# Diferencias entre HEAD y su padre
git diff HEAD~1
```

### Comparar ramas:

```bash
# Diferencias entre ramas
git diff main feature

# Diferencias entre rama local y remota
git diff main origin/main

# Ver qué se fusionaría
git diff main...feature
```

### Diferencias de archivos específicos:

```bash
# Ver cambios en un archivo
git diff app.js

# Ver cambios en múltiples archivos
git diff app.js style.css

# Ver cambios en directorio
git diff src/
```

### Formato de diff:

```bash
# Solo estadísticas
git diff --stat

# Solo nombres de archivos
git diff --name-only

# Nombres y estado
git diff --name-status

# Diff lado a lado
git diff --color-words

# Ignorar espacios en blanco
git diff -w
# o
git diff --ignore-all-space
```

### Ejemplos útiles de diff:

```bash
# Ver qué cambió en los últimos 2 commits
git diff HEAD~2

# Comparar con versión del mes pasado
git diff @{1.month.ago}

# Ver cambios que no has pusheado
git diff origin/main

# Ver cambios de otro en su rama
git diff main origin/feature-branch
```

## 3. git show - Mostrar detalles de commits

### Mostrar commit específico:

```bash
# Mostrar último commit completo
git show

# Mostrar commit específico
git show abc123d

# Salida:
# commit abc123def456...
# Author: Juan Pérez 
# Date:   Mon Feb 10 14:30:00 2026 -0500
#
#     Implementa validación de formularios
#
# diff --git a/app.js b/app.js
# ...
```

### Mostrar solo información del commit:

```bash
# Solo metadata (sin diff)
git show abc123d --no-patch
# o
git show abc123d -s

# Solo el mensaje
git show abc123d --format=%s --no-patch
```

### Mostrar archivo de un commit:

```bash
# Ver versión de archivo en commit específico
git show abc123d:app.js

# Ver archivo en HEAD
git show HEAD:app.js

# Ver archivo 3 commits atrás
git show HEAD~3:app.js
```

### Mostrar múltiples commits:

```bash
# Mostrar varios commits
git show abc123d def456a ghi789b

# Mostrar últimos 3 commits
git show HEAD~2 HEAD~1 HEAD
```

### Mostrar tag o rama:

```bash
# Mostrar detalles de un tag
git show v1.0.0

# Mostrar último commit de una rama
git show feature-branch
```

## 4. git blame - Ver quién modificó cada línea

### Uso básico:

```bash
# Ver quién modificó cada línea
git blame archivo.js

# Salida:
# abc123d (Juan Pérez  2026-02-10 14:30:00 +0000  1) function login() {
# abc123d (Juan Pérez  2026-02-10 14:30:00 +0000  2)   if (!email) {
# def456a (María García 2026-02-09 10:15:00 +0000  3)     return "Error";
# def456a (María García 2026-02-09 10:15:00 +0000  4)   }
# abc123d (Juan Pérez  2026-02-10 14:30:00 +0000  5) }
```

### Opciones de blame:

```bash
# Formato más limpio (solo hash y autor)
git blame -L 1,10 archivo.js

# Ver líneas específicas
git blame -L 10,20 archivo.js

# Ver desde línea hasta final
git blame -L 50,+10 archivo.js

# Mostrar email en lugar de nombre
git blame -e archivo.js

# Formato más compacto
git blame -s archivo.js

# Ignorar espacios en blanco
git blame -w archivo.js
```

### Blame avanzado:

```bash
# Ver blame antes de un commit
git blame abc123d^ -- archivo.js

# Detectar líneas movidas
git blame -M archivo.js

# Detectar líneas copiadas
git blame -C archivo.js

# Detectar líneas copiadas de cualquier commit
git blame -CCC archivo.js
```

## 5. git reflog - Historial de movimientos de HEAD

### Ver reflog:

```bash
# Ver historial completo de HEAD
git reflog

# Salida:
# abc123d HEAD@{0}: commit: Implementa validación
# def456a HEAD@{1}: commit: Corrige bug
# ghi789b HEAD@{2}: checkout: moving from feature to main
# jkl012c HEAD@{3}: commit: Agrega feature
```

### Usar reflog para recuperar:

```bash
# Ver estado de hace 2 movimientos
git show HEAD@{2}

# Volver a un estado anterior
git reset --hard HEAD@{3}

# Ver reflog de rama específica
git reflog show feature-branch
```

## 6. Comandos adicionales de inspección

### git shortlog - Resumen por autor:

```bash
# Resumen de commits por autor
git shortlog

# Solo contar commits
git shortlog -s

# Ordenar por número de commits
git shortlog -sn

# Ver últimas 2 semanas
git shortlog --since="2 weeks ago"
```

### git describe - Describir commit:

```bash
# Describir HEAD con tags cercanos
git describe

# Salida: v1.0.0-5-gabc123d
# (tag más cercano - commits después - hash)

# Describir commit específico
git describe abc123d
```

### git cherry - Ver commits no mergeados:

```bash
# Ver commits en main que no están en feature
git cherry -v main feature
```

## Combinaciones útiles de comandos

### Ver últimos cambios resumidos:

```bash
# Últimos 10 commits con estadísticas
git log -10 --stat --oneline
```

### Buscar cuándo se introdujo un bug:

```bash
# Buscar commits que modificaron función específica
git log -S"funcionBug" -p

# Ver historial de archivo con cambios
git log -p -- archivo-con-bug.js
```

### Ver trabajo de un desarrollador:

```bash
# Todo lo que hizo Juan la semana pasada
git log --author="Juan" --since="1 week ago" --stat
```

### Comparar dos versiones de release:

```bash
# Ver diferencias entre tags
git diff v1.0.0 v2.0.0

# Ver commits entre tags
git log v1.0.0..v2.0.0
```

### Generar changelog:

```bash
# Commits desde último tag
git log $(git describe --tags --abbrev=0)..HEAD --oneline

# Formato para changelog
git log --pretty=format:"- %s (%h)" v1.0.0..HEAD
```

## Alias útiles para inspección

Agregar a `.gitconfig`:

```bash
# Configurar aliases
git config --global alias.lg "log --graph --oneline --decorate --all"
git config --global alias.last "log -1 HEAD --stat"
git config --global alias.unstage "reset HEAD --"
git config --global alias.visual "log --graph --oneline --all"

# Usar aliases
git lg
git last
git visual
```

### Alias avanzados:

```bash
# Log bonito
git config --global alias.logline "log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"

# Ver archivos modificados
git config --global alias.changed "log --name-status"

# Buscar en commits
git config --global alias.find "log --all --grep"
```

## Ejemplos de casos de uso reales

### Caso 1: Encontrar cuándo se introdujo un bug

```bash
# 1. Buscar commits que tocan el archivo
git log --oneline -- archivo-con-bug.js

# 2. Ver cambios específicos
git show abc123d -- archivo-con-bug.js

# 3. Ver quién modificó la línea problemática
git blame -L 50,60 archivo-con-bug.js

# 4. Ver el commit completo
git show abc123d
```

### Caso 2: Revisar trabajo antes de merge

```bash
# Ver qué commits se fusionarían
git log main..feature-branch

# Ver archivos que cambiarían
git diff --name-only main feature-branch

# Ver estadísticas
git diff --stat main feature-branch

# Ver cambios completos
git diff main feature-branch
```

### Caso 3: Generar reporte de actividad

```bash
# Actividad del último mes
git log --author="$(git config user.name)" --since="1 month ago" --oneline

# Estadísticas detalladas
git log --author="$(git config user.name)" --since="1 month ago" --shortstat

# Archivos más modificados
git log --since="1 month ago" --name-only --pretty=format: | sort | uniq -c | sort -rn | head -10
```

### Caso 4: Investigar un archivo específico

```bash
# Historia completa del archivo
git log --follow -p -- archivo.js

# Ver todas las versiones del archivo
git log --all --full-history -- archivo.js

# Ver cuándo se eliminó un archivo
git log --all --full-history -- archivo-eliminado.js
```

## Herramientas visuales

### Git GUI integrado:

```bash
# Abrir gitk (visualizador de historial)
gitk

# Gitk solo para rama actual
gitk --all

# Git GUI
git gui
```

### Herramientas externas populares:

- **GitKraken** - GUI multiplataforma
- **SourceTree** - GUI gratuita de Atlassian
- **GitHub Desktop** - Simple y limpia
- **GitLens** - Extensión para VS Code
- **Git Graph** - Extensión para VS Code

## Comandos de referencia rápida

```bash
# GIT LOG
git log                          # Historial completo
git log --oneline                # Una línea por commit
git log -5                       # Últimos 5 commits
git log --graph --all            # Árbol de ramas
git log --author="nombre"        # Por autor
git log --grep="palabra"         # Buscar en mensajes
git log --since="2 weeks ago"    # Por fecha
git log -- archivo.js            # Historial de archivo
git log -p                       # Con diferencias

# GIT DIFF
git diff                         # Cambios no staged
git diff --staged                # Cambios staged
git diff abc123d                 # Con commit específico
git diff main feature            # Entre ramas
git diff --stat                  # Solo estadísticas
git diff HEAD~3                  # Con 3 commits atrás

# GIT SHOW
git show                         # Último commit
git show abc123d                 # Commit específico
git show abc123d:archivo.js      # Archivo en commit
git show --stat                  # Con estadísticas

# GIT BLAME
git blame archivo.js             # Quién modificó cada línea
git blame -L 10,20 archivo.js    # Líneas específicas

# GIT REFLOG
git reflog                       # Historial de HEAD
git reflog show main             # Reflog de rama

# OTROS
git shortlog -sn                 # Resumen por autor
git log --merges                 # Solo merges
git log --no-merges              # Sin merges
```

## Formato de salida personalizado

### Log estilo GitHub:

```bash
git log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit --date=relative
```

### Log con estadísticas:

```bash
git log --graph --stat --pretty=format:'%Cred%h%Creset - %s %Cgreen(%cr) %C(bold blue)<%an>%Creset'
```

### Log minimalista:

```bash
git log --pretty=format:'%h %s' --graph
```

## Búsquedas avanzadas

### Buscar por contenido:

```bash
# Buscar commits que agregaron/eliminaron "function login"
git log -S"function login"

# Buscar con regex
git log -G"function.*login"

# Ver commits que tocaron líneas específicas
git log -L 10,20:archivo.js
```

### Buscar por múltiples criterios:

```bash
# Commits de Juan sobre bugs en la última semana
git log --author="Juan" --grep="bug" --since="1 week ago"

# Commits de feature que no son merge
git log --author="Juan" --no-merges --grep="feature"
```

## Resumen visual de comandos

```
INSPECCIONAR HISTORIAL:
├── git log          → Ver commits
├── git diff         → Ver diferencias
├── git show         → Ver detalles
├── git blame        → Ver autoría
└── git reflog       → Ver movimientos

FILTROS DE LOG:
├── --oneline        → Formato compacto
├── --graph          → Árbol visual
├── --author         → Por autor
├── --grep           → Por mensaje
├── --since/--until  → Por fecha
└── -- archivo       → Por archivo

COMPARACIONES:
├── git diff         → Working vs staging
├── git diff --staged → Staging vs HEAD
├── git diff A B     → Entre commits/ramas
└── git diff HEAD~3  → Con commits atrás
```

Dominar estos comandos de inspección te permite entender completamente la historia de tu proyecto, encontrar bugs, y colaborar efectivamente con tu equipo.
***
