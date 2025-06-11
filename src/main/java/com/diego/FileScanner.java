package com.diego;

import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FileScanner: Escanea archivos .java y cuenta líneas usando LineCounter.
 * Cuenta líneas físicas o lógicas según el método especificado.
 * * Autor: Diego Chicuazuque
 * * Versión: 1.0
 */
public class FileScanner {

  /**
   * Cuenta las líneas en un archivo o en todos los archivos .java dentro de un directorio.
   *
   * @param pathStr ruta del archivo o directorio
   * @param method  "phy" para líneas físicas, "loc" para líneas de código
   * @return número total de líneas contadas
   */
  public int countLines(String pathStr, String method) {
    Path path = Paths.get(pathStr);
    LineCounter lineCounter = new LineCounter();
    int lineCounted = 0;

    if (!Files.exists(path)) {
      throw new IllegalArgumentException("La ruta no existe: " + pathStr);
    }

    try {
      List<Path> files = getJavaFiles(path);
      for (Path file : files) {
        lineCounted += lineCounter.countLines(file, method);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return lineCounted;
  }

  private List<Path> getJavaFiles(Path path) throws IOException {
    if (Files.isRegularFile(path) && path.toString().endsWith(".java")) {
      return Collections.singletonList(path);
    }

    if (Files.isDirectory(path)) {
      return Files
        .walk(path)
        .filter(p -> Files.isRegularFile(p))
        .filter(p -> p.toString().endsWith(".java"))
        .collect(Collectors.toList());
    }

    return Collections.emptyList();
  }
}
