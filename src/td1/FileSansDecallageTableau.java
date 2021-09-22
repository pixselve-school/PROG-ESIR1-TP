package td1;

public class FileSansDecallageTableau implements File {
  private int head;
  private int length;
  private final float[] array;

  public FileSansDecallageTableau(int capacity) {
    head = 0;
    length = 0;
    array = new float[capacity];

  }

  /**
   * @return vrai si la file est vide
   */
  public boolean estVide() {
    return this.length == 0;
  }

  /**
   * @return vrai si la file est pleine
   */
  public boolean estPleine() {
    return this.length == this.array.length;
  }

  /**
   * @return le nombre d’elements presents dans la file
   */
  public int getTaille() {
    return this.length;
  }

  /**
   * @param x : valeur a ajouter en fin de file
   */
  public void ajouter(float x) {
    assert !this.estPleine();
    this.array[(this.head + this.length) % this.array.length] = x;
    this.length++;
  }

  /**
   * supprimer l’element de tete de file .
   */
  public void supprimer() {
    assert !this.estVide();
    this.head = (this.head + 1) % this.array.length;
    this.length--;
  }

  /**
   * @return valeur de l’element en tete de file
   */
  public float getTete() {
    assert !this.estVide();
    return this.array[this.head];
  }
}
