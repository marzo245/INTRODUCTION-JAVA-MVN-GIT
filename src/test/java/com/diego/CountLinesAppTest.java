package com.diego;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class CountLinesAppTest {

  @Test
  void testUsageMessageWhenNoArguments() {
    // Capturar la salida estándar
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Ejecutar el main sin argumentos
    CountLinesApp.main(new String[] {});

    // Verificar mensaje de uso
    String output = outContent.toString().trim();
    assertTrue(output.contains("Uso: java CountLinesApp tipo ruta"));
  }

  @Test
  void testValidPhyArgumentOnExampleFile() {
    // Crear un archivo temporal
    String filePath = "src/test/resources/TestFile.java"; // Asegúrate de que exista
    String[] args = { "phy", filePath };

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    CountLinesApp.main(args);

    String output = outContent.toString();
    assertTrue(output.contains("Líneas totales contadas"));
  }
}
