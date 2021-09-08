package td1;

import java.util.Arrays;
import java.util.Scanner;

public class FileTableau implements File {
  protected final float[] content;
  protected int amount;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    File file = new FileTableau(5);
    while (!file.estPleine()) {
      System.out.print("Veuillez saisir un nombre (-1 pour arreter): ");
      float userValue = scanner.nextFloat();
      if (userValue < 0) break;
      file.ajouter(userValue);
    }
    scanner.close();
    System.out.println(file);
  }

  public FileTableau(int capacity) {
    content = new float[capacity];
    amount = 0;
  }

  /**
   * @return vrai si la file est vide
   * @implNote O(1)
   */
  public boolean estVide() {
    return amount == 0;
  }

  /**
   * @return vrai si la file est pleine
   * @implNote O(1)
   */
  public boolean estPleine() {
    return amount == content.length - 1;
  }

  /**
   * @return le nombre d’elements presents dans la file
   * @implNote O(1)
   */
  public int getTaille() {
    return amount;
  }

  /**
   * @param x : valeur a ajouter en fin de file
   * @implNote O(1)
   */
  public void ajouter(float x) {
    if (this.estPleine()) return;
    content[++amount - 1] = x;
  }

  /**
   * supprimer l’element de tete de file .
   * @implNote O(N)
   */
  public void supprimer() {
    System.arraycopy(content, 1, content, 0, content.length -1);
    amount = amount == 0 ? 0 : amount - 1;
  }

  /**
   * @return valeur de l’element en tete de file
   * @implNote O(1)
   */
  public float getTete() {
    return content[0];
  }

  /**
   * @implNote O(N)
   */
  public String toString() {
    return Arrays.toString(Arrays.copyOfRange(content, 0, amount));
  }
}
