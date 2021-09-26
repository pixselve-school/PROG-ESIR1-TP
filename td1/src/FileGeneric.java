public interface FileGeneric<T> {
  /**
   * @return vrai si la file est vide
   */
  public boolean estVide();

  /**
   * @return vrai si la file est pleine
   */
  public boolean estPleine();

  /**
   * @return le nombre d’elements presents dans la file
   */
  public int getTaille();

  /**
   * @param x: valeur a ajouter en fin de file
   */
  public void ajouter(T x);

  /**
   * supprimer l’element de tete de file .
   */
  public void supprimer();

  /**
   * @return valeur de l’element en tete de file
   */
  public T getTete();
}
