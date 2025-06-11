package com.diego;

/**
 * CountLinesApp es la clase principal de la aplicación que cuenta las líneas
 * en un archivo o directorio, según el método especificado.
 *
 * Recibe como argumentos de línea de comandos un método y una ruta a archivo o directorio,
 * y cuenta las líneas utilizando la clase LineCounter junto con FileScanner.
 *
 * Uso:
 * java CountLinesApp <método> <ruta>
 *
 * Donde:
 * <método> puede ser:
 *   - "phy": para contar líneas físicas (todas las líneas del archivo)
 *   - "loc": para contar líneas de código (excluye comentarios y líneas en blanco)
 *
 * <ruta> es la ubicación del archivo o directorio a escanear.
 *
 * Autor: Diego Chicuazuque
 * Versión: 1.0
 */
public class CountLinesApp {

  /**
   * Método principal que ejecuta la aplicación CountLines.
   *
   * @param args Argumentos de línea de comandos. args[0] debe ser el método ("phy" o "loc"),
   *             y args[1] debe ser la ruta del archivo o directorio a analizar.
   */
  public static void main(String[] args) {
    // Verificar que se proporcionen exactamente dos argumentos
    if (args.length != 2) {
      System.out.println("Uso: java CountLines <método> <ruta>");
      return;
    }

    String method = args[0];
    String path = args[1];
    int lineCounted = 0;

    FileScanner fileScanner = new FileScanner();
    lineCounted = fileScanner.countLines(path, method);

    System.out.println("Líneas totales contadas: " + lineCounted);
  }
}
