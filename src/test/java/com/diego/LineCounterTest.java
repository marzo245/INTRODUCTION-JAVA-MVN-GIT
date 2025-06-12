package com.diego;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LineCounterTest {

  private LineCounter lineCounter;

  @BeforeEach
  public void setUp() {
    lineCounter = new LineCounter();
  }

  @Test
  public void testCountPhysicalLinesOnNonEmptyFile() throws IOException {
    Path tempFile = Files.createTempFile("testPhysical", ".java");
    List<String> lines = Arrays.asList(
      "public class Test {",
      "// Comentario",
      "",
      "System.out.println(\"Hola\");"
    );
    Files.write(tempFile, lines);

    int count = lineCounter.countLines(tempFile, "phy");

    assertEquals(4, count);

    Files.deleteIfExists(tempFile);
  }

  @Test
  public void testCountLogicalLinesIgnoresCommentsAndBlankLines()
    throws IOException {
    Path tempFile = Files.createTempFile("testLogical", ".java");
    List<String> lines = Arrays.asList(
      "public class Test {",
      "",
      "// Esto es un comentario",
      "int a = 0;",
      "/* Comentario de bloque",
      "continua aquí */",
      "return a;",
      ""
    );
    Files.write(tempFile, lines);

    int count = lineCounter.countLines(tempFile, "loc");

    assertEquals(3, count);

    Files.deleteIfExists(tempFile);
  }

  @Test
  public void testUnsupportedMethodThrowsException() throws IOException {
    Path tempFile = Files.createTempFile("testUnsupported", ".java");
    List<String> lines = Arrays.asList("public class Test {}");
    Files.write(tempFile, lines);

    assertThrows(
      IllegalArgumentException.class,
      () -> {
        lineCounter.countLines(tempFile, "invalid");
      }
    );

    Files.deleteIfExists(tempFile);
  }

  @Test
  public void testEmptyFileReturnsZeroLines() throws IOException {
    Path tempFile = Files.createTempFile("testEmpty", ".java");
    Files.write(tempFile, Arrays.asList(""));

    int physical = lineCounter.countLines(tempFile, "phy");
    int logical = lineCounter.countLines(tempFile, "loc");

    assertEquals(1, physical); // un archivo con 1 línea vacía cuenta como 1 línea física
    assertEquals(0, logical); // pero 0 líneas de código

    Files.deleteIfExists(tempFile);
  }
}
