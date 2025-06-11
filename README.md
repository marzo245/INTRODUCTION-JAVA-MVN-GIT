# CountLinesApp 📊

Aplicación en Java que permite contar líneas de código en archivos `.java`, ya sea a nivel físico (todas las líneas del archivo) o lógico (ignorando líneas vacías y comentarios).

## 🚀 Comenzando

Sigue estos pasos para obtener una copia del proyecto, ejecutarlo localmente y entender su funcionamiento.

### ✅ Requisitos previos

Asegúrate de tener instalado:

```bash
Java 8 o superior
Apache Maven 3.x
```

### 💻 Instalación

Clona el repositorio y navega a la carpeta del proyecto:

```bash
git clone https://github.com/marzo245/INTRODUCTION-JAVA-MVN-GIT.git
cd INTRODUCTION-JAVA-MVN-GIT
```

Compila el proyecto:

```bash
mvn clean install
```

## ▶️ Uso de la aplicación

Ejecuta el programa con Maven pasando los argumentos necesarios:

```bash
mvn exec:java -Dexec.args="phy src/main/java/com/diego/CountLinesApp.java"
```

Este comando cuenta las **líneas físicas** del archivo. Para contar **líneas lógicas**, utiliza:

```bash
mvn exec:java -Dexec.args="loc src/main/java/com/diego/CountLinesApp.java"
```

También puedes pasar un **directorio** para analizar todos los `.java` de forma recursiva:

```bash
mvn exec:java -Dexec.args="loc src/main/java"
```

## 🧠 Estructura del Proyecto y Clases Utilizadas

* `CountLinesApp`: clase principal que gestiona los argumentos desde consola y ejecuta la lógica de conteo.
* `FileScanner`: escanea archivos individuales o directorios para identificar archivos `.java`.

  * Utiliza `Paths.get()` para obtener rutas y `Files.walk()` para recorrer directorios recursivamente.
* `LineCounter`: contiene la lógica para contar líneas.

  * **countPhysicalLines**: usa `Files.readAllLines()` para contar todas las líneas.
  * **countLogicalLines**: omite líneas vacías y comentarios (`//`, `/* */`) usando procesamiento de cadenas.

## ✅ Ejecutando pruebas

Este proyecto no incluye pruebas automatizadas aún, pero puede extenderse fácilmente con JUnit.

### 🔍 Pruebas de extremo a extremo

Verifica el conteo real sobre archivos de ejemplo:

```java
assertEquals(10, lineCounter.countLines(Paths.get("src/test/resources/TestFile.java"), "loc"));
```

### 🧹 Pruebas de estilo

Puedes integrar herramientas como Checkstyle para validar el estilo del código:

```bash
mvn checkstyle:check
```

## ☁️ Despliegue

Este proyecto se ejecuta localmente, pero puede integrarse a flujos de CI/CD mediante GitHub Actions, Jenkins u otras plataformas.

## 🛠️ Construido con

* [Java NIO](https://docs.oracle.com/javase/8/docs/api/java/nio/file/package-summary.html) - Manipulación de archivos y directorios
* [Java Streams](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html) - Procesamiento funcional de colecciones
* [Maven](https://maven.apache.org/) - Gestión del proyecto y dependencias

## 🙋‍♂️ Contribuciones

Por favor, revisa [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) para detalles del código de conducta y cómo enviar Pull Requests.

## 📌 Versionado

Aunque actualmente solo se ha realizado una versión inicial, este proyecto puede seguir el esquema de versionado [SemVer](http://semver.org/). Consulta los [tags del repositorio](https://github.com/marzo245/INTRODUCTION-JAVA-MVN-GIT/tags) para versiones futuras.

## 👤 Autor

* **Diego Chicuazuque** - *Trabajo inicial* - [marzo245](https://github.com/marzo245)

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia MIT - revisa el archivo [LICENSE.md](LICENSE.md) para más detalles.

## 🙌 Agradecimientos

* A los creadores de Java y sus poderosas bibliotecas
* A quienes apoyaron y enseñaron buenas prácticas
* A los desarrolladores del plugin de Maven `exec`
