Perfecto, aquí tienes el contenido completo para tu archivo `design-metaphor.md`, que incluye el **título**, **autor**, **fecha**, **diagrama de clases (textual)** y una **descripción detallada del diseño**:

---

# Design Metaphor - CountLinesApp

**Autor:** Diego Chicuazuque
**Fecha:** 11 de junio de 2025

## 🎯 Metáfora de diseño

La aplicación funciona como un **contador de palabras profesional**, donde:

* El usuario entrega un conjunto de documentos (archivos `.java`) y especifica qué quiere contar (todas las líneas o solo las útiles).
* El **asistente** (la clase principal) recibe la orden, organiza los documentos y le pasa el trabajo a los **analistas** (los contadores de líneas).
* Cada analista revisa los documentos uno por uno y entrega el conteo exacto, filtrando según el criterio del usuario.

---

## 📘 Diagrama de clases 

![image](https://github.com/user-attachments/assets/ad34ffed-bcf4-4846-859a-c463755fd584)




---

## 🧩 Descripción del diseño

### 1. **CountLinesApp**

* Punto de entrada (`main()`).
* Valida argumentos de consola.
* Llama a `FileScanner` para comenzar el conteo.
* Imprime el resultado al usuario.

### 2. **FileScanner**

* Recibe un archivo o carpeta.
* Si es carpeta, recorre recursivamente todos los archivos `.java`.
* Por cada archivo válido, invoca a `LineCounter`.

### 3. **LineCounter**

* Contiene la lógica para interpretar y contar líneas:

  * **Físicas**: todas las líneas del archivo.
  * **Lógicas**: ignora líneas vacías y comentarios (`//`, `/* */`, `/** */`).
* Devuelve el conteo por archivo, luego se suman globalmente.

---

## 🛠️ Justificación del diseño

* **Separación de responsabilidades:** cada clase cumple una función clara.
* **Escalabilidad:** se puede extender fácilmente para contar otros lenguajes o tipos de líneas.
* **Pruebas unitarias:** cada clase puede ser probada de forma aislada.
* **Reutilización:** `LineCounter` es independiente del origen del archivo (podría usarse en otros proyectos).
* **Mantenibilidad:** el código es legible, modular y sigue el estilo de Google para Java.

---

¿Deseas también una versión visual del diagrama UML en imagen? Puedo generarla en segundos.
