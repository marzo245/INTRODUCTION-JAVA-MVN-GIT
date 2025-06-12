Aquí tienes una versión **mejorada y corregida** del `README.md`, siguiendo el formato estándar, con la información completa que requiere tu proyecto (incluyendo LOC/h, pruebas y diseño). También he corregido el apartado de pruebas automatizadas y estilo, ya que **sí incluye JUnit** y ya lo estás usando.

---

# CountLinesApp 📊

Aplicación de línea de comandos en Java para contar líneas de código en archivos `.java`, ya sea a nivel físico (todas las líneas) o lógico (ignorando líneas vacías y comentarios). Utiliza Maven para la construcción y JUnit para pruebas.

## 🚀 Comenzando

Sigue estos pasos para obtener una copia del proyecto, ejecutarlo localmente y entender su funcionamiento.

### ✅ Requisitos previos

Asegúrate de tener instalado:

```bash
Java 8 o superior  
Apache Maven 3.x  
Git
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

Ejecuta el programa desde Maven pasando los argumentos requeridos:

```bash
mvn exec:java -Dexec.args="phy src/main/java/com/diego/CountLinesApp.java"
```

Este comando cuenta las **líneas físicas** del archivo. Para contar **líneas lógicas**, usa:

```bash
mvn exec:java -Dexec.args="loc src/main/java/com/diego/CountLinesApp.java"
```

También puedes pasar un **directorio** para analizar todos los archivos `.java` recursivamente:

```bash
mvn exec:java -Dexec.args="loc src/main/java"
```

## 🧠 Estructura del Proyecto

* `CountLinesApp`: Clase principal que recibe los parámetros por consola.
* `FileScanner`: Escanea archivos o directorios `.java` y delega el conteo.
* `LineCounter`: Contiene la lógica para contar líneas físicas o lógicas.

## 🧪 Pruebas

El proyecto cuenta con pruebas automatizadas escritas con **JUnit 5**.

Para ejecutarlas:

```bash
mvn test
```

Se prueban casos como:

* Archivos vacíos
* Archivos con comentarios
* Conteo físico vs. lógico
* Manejo de archivos no `.java`
* Excepciones por uso incorrecto

### 📋 Reporte de pruebas

Se puede consultar en el archivo [`TESTREPORT.md`](TESTREPORT.md) . Incluye:

* Archivos probados
* Métodos cubiertos
* Casos exitosos y fallos simulados
* Cobertura de entradas y excepciones

## 📐 Diseño

Consulta el archivo [`DISENO.md`](DISENO.md) para ver:

* Diagrama de clases
* Explicación del diseño
* Relación entre componentes

## 📊 Métrica LOC/h

* Tiempo estimado de desarrollo: 6 horas
* LOC producidas (código principal): 61 líneas
* Productividad: **10.17 LOC/h**

## 🛠️ Construido con

* [Java NIO](https://docs.oracle.com/javase/8/docs/api/java/nio/file/package-summary.html)
* [Java Streams](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
* [JUnit 5](https://junit.org/junit5/) para pruebas
* [Maven](https://maven.apache.org/) para gestión de dependencias y ejecución

## 🧹 Validación de estilo

Puedes usar Checkstyle para verificar el estilo siguiendo la [Guía de estilo de Google para Java](https://google.github.io/styleguide/javaguide.html):

```bash
mvn checkstyle:check
```

## 👤 Autor

**Diego Chicuazuque**
[marzo245](https://github.com/marzo245)

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia MIT. Ver archivo [LICENSE](LICENSE) para más información.

## 🙌 Agradecimientos

* A los profesores y mentores que guiaron el desarrollo.
* A los desarrolladores de herramientas libres como JUnit y Maven.
* A la comunidad Java por sus buenas prácticas y documentación.

---

¿Quieres que ahora genere el `design-metaphor.md` con el diagrama de clases y la explicación de diseño?
