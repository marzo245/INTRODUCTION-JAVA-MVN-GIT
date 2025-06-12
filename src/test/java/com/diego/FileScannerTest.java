package com.diego;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileScannerTest {

  private FileScanner fileScanner;
  private static final String TEST_FILE_NAME = "TempTestFile.java";

  @BeforeEach
  void setUp() {
    fileScanner = new FileScanner();
  }

  @Test
  void testCountLinesWithNonExistentPath() {
    String invalidPath = "src/test/resources/noexiste.java";
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        fileScanner.countLines(invalidPath, "phy");
      }
    );
  }

  @Test
  void testCountLinesWithEmptyJavaFile() throws IOException {
    Path tempFile = createTempFile("");
    int result = fileScanner.countLines(tempFile.toString(), "phy");
    assertEquals(0, result);
    Files.delete(tempFile);
  }

  @Test
  void testCountLinesWithJavaContent() throws IOException {
    String javaCode = "public class Hello {}\n// Comentario\n\n";
    Path tempFile = createTempFile(javaCode);
    int phy = fileScanner.countLines(tempFile.toString(), "phy");
    int loc = fileScanner.countLines(tempFile.toString(), "loc");

    assertEquals(3, phy); // Incluye líneas en blanco y comentarios
    assertEquals(1, loc); // Solo línea de código

    Files.delete(tempFile);
  }

  @Test
  void testCountLinesInDirectory() throws IOException {
    Path dir = Files.createTempDirectory("testDir");
    Path javaFile = dir.resolve("Test1.java");
    Files.write(javaFile, Collections.singletonList("public class A {}"));

    int result = fileScanner.countLines(dir.toString(), "loc");
    assertEquals(1, result);

    Files.delete(javaFile);
    Files.delete(dir);
  }

  // Helper
  private Path createTempFile(String content) throws IOException {
    Path file = Files.createTempFile(TEST_FILE_NAME, ".java");
    Files.write(file, content.getBytes());
    return file;
  }
}
