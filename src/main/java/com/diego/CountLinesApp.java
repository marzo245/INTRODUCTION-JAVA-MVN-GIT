package com.diego;

/**
 * CountLinesApp es la clase principal de la aplicación que cuenta las líneas
 * en un archivo o directorio, según el método especificado.
 *
 * Recibe como argumentos de línea de comandos un método y una ruta a archivo o directorio,
 * y cuenta las líneas utilizando la clase LineCounter junto con FileScanner.
 *
 * <p><b>Uso:</b></p>
 * <pre>
 * java CountLinesApp tipo ruta
 * </pre>
 *
 * <p><b>Donde:</b></p>
 * <ul>
 *   <li><code>tipo</code>: puede ser "phy" para contar líneas físicas (todas las líneas del archivo),
 *       o "loc" para contar líneas de código (excluye comentarios y líneas en blanco).</li>
 *   <li><code>ruta</code>: es la ubicación del archivo o directorio a escanear.</li>
 * </ul>
 *
 * @author Diego Chicuazuque
 * @version 1.0
 */
public class CountLinesApp {

  /**
   * Método principal que ejecuta la aplicación CountLines.
   *
   * @param args Argumentos de línea de comandos.
   *             args[0] debe ser el tipo de conteo ("phy" o "loc"),
   *             y args[1] debe ser la ruta del archivo o directorio a analizar.
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Uso: java CountLinesApp tipo ruta");
      return;
    }

    String method = args[0];
    String path = args[1];

    FileScanner fileScanner = new FileScanner();
    int lineCounted = fileScanner.countLines(path, method);

    System.out.println("Líneas totales contadas: " + lineCounted);
  }
}
