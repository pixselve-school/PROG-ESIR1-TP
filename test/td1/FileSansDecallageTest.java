package td1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSansDecallageTest {

  @Test
  void deleteEmpty() {
    FileSansDecallage file = new FileSansDecallage();
    file.supprimer();
    assertNull(file.content);
  }

  @Test
  void deleteOneElementWhereTwoElements() {
    FileSansDecallage file = new FileSansDecallage();

    file.content = new FileSansDecallage.Node<>(1.0F, new FileSansDecallage.Node<>(2.0F));
    file.supprimer();
    assertEquals(file.content.getElement(), 2.0F);
    assertNull(file.content.getNext());
  }

  @org.junit.jupiter.api.Test
  void deleteOneElement() {
    FileSansDecallage file = new FileSansDecallage();

    file.content = new FileSansDecallage.Node<>(1.0F);
    file.supprimer();
    assertNull(file.content);
  }

  @Test
  void addEmpty() {
    FileSansDecallage file = new FileSansDecallage();
    file.ajouter(1);
    assertEquals(file.content.getElement(), 1);
    assertNull(file.content.getNext());
  }
  @Test
  void addAlreadyOne() {
    FileSansDecallage file = new FileSansDecallage();

    file.content = new FileSansDecallage.Node<>(1.0F);

    file.ajouter(2);
    assertEquals(file.content.getElement(), 1);
    assertEquals(file.content.getNext().getElement(), 2);
    assertNull(file.content.getNext().getNext());

  }
}