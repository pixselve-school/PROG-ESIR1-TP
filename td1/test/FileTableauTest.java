import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileTableauTest {

  @Test
  void deleteEmpty() {
    FileTableau file = new FileTableau(10);
    file.supprimer();
    assertEquals(file.amount, 0);
    assertEquals(file.content[0], 0.0);
  }

  @Test
  void deleteOneElementWhereTwoElements() {
    FileTableau file = new FileTableau(10);
    file.amount = 2;
    file.content[0] = 1;
    file.content[1] = 2;
    file.supprimer();
    assertEquals(file.amount, 1);
    assertEquals(file.content[0], 2);
  }

  @org.junit.jupiter.api.Test
  void deleteOneElement() {
    FileTableau file = new FileTableau(10);
    file.amount++;
    file.content[0] = 1;
    file.supprimer();
    assertEquals(file.amount, 0);
    assertEquals(file.content[0], 0.0);
  }

  @Test
  void addEmpty() {
    FileTableau file = new FileTableau(10);
    file.ajouter(1);
    assertEquals(file.amount, 1);
    assertEquals(file.content[0], 1);
  }
  @Test
  void addAlreadyOne() {
    FileTableau file = new FileTableau(10);
    file.ajouter(1);
    assertEquals(file.amount, 1);
    assertEquals(file.content[0], 1);
    file.ajouter(2);
    assertEquals(file.amount, 2);
    assertEquals(file.content[0], 1);
    assertEquals(file.content[1], 2);

  }
}