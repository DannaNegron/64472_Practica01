# 📇 Gestor de Contactos en Java — Métodos File y Buffer

Este proyecto es una aplicación de consola en Java que permite gestionar una lista de contactos. Incluye dos versiones complementarias:

- **Versión File**: utiliza clases tradicionales como `FileReader`, `FileWriter`, y `Scanner`.
- **Versión Buffer**: utiliza clases modernas como `BufferedReader`, `BufferedWriter`, y `Files.newBufferedWriter`.

Ambas versiones permiten agregar, buscar, modificar y eliminar contactos, y están diseñadas para mostrar las diferencias entre el manejo básico y el optimizado de archivos en Java.

---

## 🧩 Funcionalidades

- Agregar nuevos contactos
- Mostrar todos los contactos registrados
- Buscar por nombre completo o parcial
- Modificar datos de un contacto existente
- Eliminar contactos específicos
- Eliminar el archivo completo de contactos

---

## 🛠️ Tecnologías utilizadas

### Versión File
- `File`
- `FileReader`
- `FileWriter`
- `Scanner`
- `ArrayList`, `List`

### Versión Buffer
- `BufferedReader`
- `BufferedWriter`
- `Files`
- `Paths`
- `StandardOpenOption`
- `ArrayList`, `List`
- `Scanner`

---

## 🚀 Cómo ejecutar
Ambas versiones utilizan el mismo archivo `Contactos.txt`.  
Ejecuta solo una versión a la vez para evitar conflictos.

### Compilar y ejecutar
Versión File
javac GestorContactoMFile.java
java GestorContactoMFile

Version Buffers
javac GestorContactosBuffer.java
java GestorContactosBuffer

### Formato del archivo contactos
Nombre,Teléfono

Ejemplo
Danna,9812411236
Michelle,9812415498
Iliana,9812417123

### Guia de uso (ambas versiones)
    Menú principal

=== GESTOR DE CONTACTOS ===
1. 	Agregar contacto
2. 	Mostrar todos los contactos
3. 	Buscar contacto por nombre compl./part.
4. 	Modificar contacto
5. 	Eliminar contacto
6. 	Eliminar archivo de contactos
7. 	Salir

-------------------------------------------------------------------------------
### 1. AGREGAR CONTACTO
-------------------------------------------------------------------------------

- Solicita nombre y teléfono del usuario  
- Guarda automáticamente en `Contactos.txt`  
- Muestra confirmación con los datos agregados  

**Ejemplo:**
--- AGREGAR CONTACTO ---
Nombre: Juan
Teléfono: 9812412589

--- CONTACTO AGREGADO CORRECTAMENTE ---
Nombre: Juan
Teléfono: 9812412589
Contacto agregado con éxito.

-------------------------------------------------------------------------------
### 2. MOSTRAR TODOS LOS CONTACTOS
-------------------------------------------------------------------------------

- Lista todos los contactos registrados  
- Formato: `Nombre: [nombre] | Teléfono: [teléfono]`  
- Mensaje informativo si no hay contactos  

**Ejemplo:**
--- LISTA DE CONTACTOS ---
Nombre: Danna | Teléfono: 9812411236
Nombre: Michelle | Teléfono: 9812415498
Nombre: Iliana | Teléfono: 9812417123
Nombre: Jonathan | Teléfono: 9182411478
Nombre: Juan | Teléfono: 9812412589

-------------------------------------------------------------------------------
### 3. BUSCAR CONTACTO POR NOMBRE
-------------------------------------------------------------------------------

- Búsqueda parcial o completa  
- Muestra todas las coincidencias encontradas  
- Formato claro y ordenado  

**Ejemplo:**
Ingrese el nombre o parte de: ju

--- RESULTADOS DE BÚSQUEDA ---
Nombre: Juan | Teléfono: 9812412589

-------------------------------------------------------------------------------
### 4. MODIFICAR CONTACTO
-------------------------------------------------------------------------------

- Búsqueda por nombre 
- Permite mantener datos actuales presionando Enter  
- Muestra los datos actualizados  

**Ejemplo:**
--- MODIFICAR CONTACTO ---
Nombre del contacto a modificar: juan
Contacto encontrado: Juan,9812412589
Nuevo nombre (Enter para mantener 'Juan'):
Nuevo teléfono (Enter para mantener '9812412589'): 

--- DATOS ACTUALIZADOS ---
Nombre: Juan
Teléfono: 9812412589
Contacto modificado con éxito.

-------------------------------------------------------------------------------
### 5. ELIMINAR CONTACTO
-------------------------------------------------------------------------------

- Elimina el contacto que coincide exactamente con el nombre ingresado  
- Muestra mensaje de éxito o advertencia si no se encuentra  

**Ejemplo:**
--- ELIMINAR CONTACTO ---
Nombre del contacto a eliminar: juan
Contacto eliminado con éxito.

-------------------------------------------------------------------------------
### 6. ELIMINAR ARCHIVO DE CONTACTOS
-------------------------------------------------------------------------------

- Elimina completamente el archivo `Contactos.txt`  
- Acción irreversible  
- Muestra confirmación visual  

**Ejemplo:**
--- ELIMINAR ARCHIVO (File) ---
Archivo eliminado correctamente.

-------------------------------------------------------------------------------
### 7. SALIR
-------------------------------------------------------------------------------

- Cierra el programa de forma segura  
- Scanner cerrado correctamente  
- Datos guardados automáticamente

**Ejemplo:**
¡Hasta pronto!

===============================================================================