import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileSansDecallageTableauTest {

  @Test
  void estVide() {
    FileSansDecallageTableau fileSansDecallageTableau = new FileSansDecallageTableau(10);
    Assertions.assertTrue(fileSansDecallageTableau.estVide());
    for (int i = 0; i < 10; i++) {
      fileSansDecallageTableau.ajouter(i);
    }
    for (int i = 0; i < 10; i++) {
      fileSansDecallageTableau.supprimer();
    }
    Assertions.assertTrue(fileSansDecallageTableau.estVide());
  }

  @Test
  void estPleine() {
    FileSansDecallageTableau fileSansDecallageTableau = new FileSansDecallageTableau(10);
    for (int i = 0; i < 10; i++) {
      fileSansDecallageTableau.ajouter(i);
    }
    Assertions.assertTrue(fileSansDecallageTableau.estPleine());
    Assertions.assertThrows(AssertionError.class, () -> fileSansDecallageTableau.ajouter(1));

  }

  @Test
  void getTaille() {
    FileSansDecallageTableau fileSansDecallageTableau = new FileSansDecallageTableau(10);
    for (int i = 1; i <= 10; i++) {
      fileSansDecallageTableau.ajouter(i);
      Assertions.assertEquals(i, fileSansDecallageTableau.getTaille());
    }
  }

  @Test
  void ajouter() {

  }

  @Test
  void supprimer() {
  }

  @Test
  void getTete() {
  }
}