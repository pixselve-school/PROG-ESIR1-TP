package tableau;

import types.Tableau;

public class Tableau2x<T> implements Tableau<T> {
  private Block<T> elements;
  private int capacity;

  public Tableau2x(int capacity) {
    assert capacity > 0 : "capacity " + capacity;
    this.elements = new Block<>(capacity);
    this.capacity = capacity;
  }

  /**
   * Déterminer la taille du tableau
   *
   * @return nombre d'éléments présents dans le tableau
   */
  public int size() {
    return this.elements.size();
  }

  /**
   * Déterminer si le tableau est vide
   *
   * @return vrai si le tableau est vide
   */
  public boolean empty() {
    return this.elements.empty();
  }

  /**
   * Déterminer si le tableau est plein
   *
   * @return vrai s'il n'est plus possible d'ajouter d'élément dans le tableau
   */
  public boolean full() {
    return false;
  }

  /**
   * Renvoyer l'élément d'indice i
   *
   * @param i : indice de l'élément à consulter
   * @return valeur de l'élément d'indice i
   * @pre 0 <= i < this.size()
   */
  public T get(int i) {
    assert i >= 0 && i < this.size();
    return this.elements.get(i);
  }

  /**
   * Modifier l'élément d'indice i
   *
   * @param i : indice de l'élément à modifier
   * @param v : nouvelle valeur de l'élément d'indice i
   * @pre 0 <= i < this.size()
   */
  public void set(int i, T v) {
    assert i >= 0 && i < this.size();
    this.elements.set(i, v);
  }

  /**
   * Ajouter un élément en fin de tableau
   *
   * @param x : élément à ajouter en fin de tableau
   * @pre : ! this.full()
   */
  public void push_back(T x) {
    if (this.elements.full()) {
//            The array is full
      Block<T> newElements = new Block<>(this.capacity *= 2);

      for (int i = 0; i < this.elements.size(); i++) {
        newElements.push_back(this.elements.get(i));
      }
      elements = newElements;
    }
    this.elements.push_back(x);
  }

  /**
   * Supprimer le dernier élément du tableau
   *
   * @pre : ! this.empty()
   */
  public void pop_back() {
    this.elements.pop_back();
  }
}
