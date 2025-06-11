package com.diego;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * LineCounter es una clase utilitaria que proporciona métodos para contar
 * líneas en un archivo según el método especificado (físicas o lógicas).
 *
 * Lanza una IllegalArgumentException si el método de conteo no está implementado.
 *
 * Autor: Diego Chicuazuque
 * Versión: 1.0
 */
public class LineCounter {

  /**
   * Cuenta las líneas de un archivo según el método especificado.
   *
   * @param filePath Ruta del archivo a analizar.
   * @param method Método de conteo:
   *               - "phy": cuenta todas las líneas físicas del archivo.
   *               - "loc": cuenta solo las líneas de código (excluye comentarios y líneas vacías).
   * @return Número de líneas contadas.
   */
  public int countLines(Path filePath, String method) {
    if (method.equals("phy")) {
      try {
        return countPhysicalLines(filePath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (method.equals("loc")) {
      try {
        return countLogicalLines(filePath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException("Método no soportado: " + method);
    }
    return 0;
  }

  private static int countLogicalLines(Path path) throws IOException {
    List<String> lines = Files.readAllLines(path);
    int count = 0;
    boolean inBlockComment = false;

    for (String line : lines) {
      String trimmed = line.trim();

      if (trimmed.isEmpty()) continue; // línea vacía

      if (inBlockComment) {
        if (trimmed.contains("*/")) {
          inBlockComment = false;
        }
        continue; // seguir ignorando líneas en bloque
      }

      if (trimmed.startsWith("/*")) {
        inBlockComment = true;
        continue;
      }

      if (trimmed.startsWith("//")) continue; // comentario de línea única

      count++;
    }

    return count;
  }

  private static int countPhysicalLines(Path path) throws IOException {
    List<String> lines = Files.readAllLines(path);
    return lines.size();
  }
}
