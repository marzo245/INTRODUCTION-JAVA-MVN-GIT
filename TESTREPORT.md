## 🧪 Test Report - LOC Counter

### 📌 Proyecto: INTRODUCTION TO JAVA, MVN, AND GIT: LOC Counting

**Autor:** Diego Chicuazuque
**Fecha:** 11 de junio de 2025

---

### ✅ Objetivo

Validar que el programa **cuenta correctamente las líneas de código (LOC)** tanto físicas como lógicas en archivos `.java`, usando pruebas automatizadas con JUnit.

---

### 🛠️ Herramientas Utilizadas

* Java 17
* Maven
* JUnit 5
* Git & GitHub

---

### 📂 Archivos Probados

Se realizaron pruebas con los siguientes archivos:

1. `Sample1.java`: contiene comentarios, líneas vacías y líneas de código.
2. `Sample2.java`: contiene un bloque de comentarios, líneas de código y líneas vacías.
3. Archivo vacío.

Los archivos fueron creados dinámicamente en pruebas con `TemporaryFolder` o `Files.createTempFile`.

---

### ⚙️ Métodos probados

| Clase         | Método                        | Descripción                                                |
| ------------- | ----------------------------- | ---------------------------------------------------------- |
| `LineCounter` | `countLines(path, method)`    | Cuenta líneas físicas o lógicas                            |
| `FileScanner` | `countLines(pathStr, method)` | Procesa archivos individuales o directorios recursivamente |

---

### 🧪 Pruebas Realizadas

| Prueba                                                | Método              | Entrada                                                   | Resultado Esperado         | Resultado Obtenido         | Estado |
| ----------------------------------------------------- | ------------------- | --------------------------------------------------------- | -------------------------- | -------------------------- | ------ |
| Cuenta líneas físicas en archivo no vacío             | `countLines(phy)`   | Archivo con 4 líneas (2 de código, 1 vacía, 1 comentario) | `4`                        | `4`                        | ✅      |
| Cuenta LOC en archivo con comentarios y líneas vacías | `countLines(loc)`   | Mismo archivo                                             | `2`                        | `2`                        | ✅      |
| Archivo vacío retorna 0 líneas físicas                | `countLines(phy)`   | Archivo vacío                                             | `0`                        | `0`                        | ✅      |
| Archivo vacío retorna 0 LOC                           | `countLines(loc)`   | Archivo vacío                                             | `0`                        | `0`                        | ✅      |
| Comentario de bloque es ignorado                      | `countLines(loc)`   | Archivo con `/* bloque */` y código                       | `1`                        | `1`                        | ✅      |
| Se lanza excepción en método inválido                 | `countLines("abc")` | Entrada inválida                                          | `IllegalArgumentException` | `IllegalArgumentException` | ✅      |

---

### 📊 Cobertura de Pruebas

* ✔️ Lógica de conteo de líneas físicas y lógicas
* ✔️ Manejo de archivos vacíos
* ✔️ Comentarios de línea (`//`) y de bloque (`/* */`)
* ✔️ Invocación incorrecta del método
* ✔️ Procesamiento de múltiples archivos con `FileScanner`

---

### 🧩 Conclusión

El sistema pasa correctamente todas las pruebas funcionales relevantes para el conteo de líneas físicas y lógicas. La lógica ignora correctamente líneas vacías y comentarios, y es robusta ante errores de entrada.

Las pruebas aseguran la **confiabilidad del programa**, y se recomienda mantenerlas si se amplía la funcionalidad.

---

### 📁 Anexo: Archivos de prueba

#### 📄 `Sample1.java`

```java
// Esto es un comentario
public class Sample1 {

  public void sayHello() {
    System.out.println("Hola mundo");
  }

}
```

#### 📄 `Sample2.java`

```java
/* Comentario de bloque */
public class Sample2 {
  public static void main(String[] args) {
    // Comentario
    System.out.println("¡Hola!");
  }
}
```
