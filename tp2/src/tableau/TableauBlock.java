package tableau;

import types.Tableau;

public class TableauBlock<T> implements Tableau<T> {
  private final int blockCapacity;
  private Tableau2x<Block<T>> elements;

  /**
   * Création d'un tableau de blocs
   *
   * @param arrayCapacity la capacité initiale du tableau
   * @param blockCapacity la capacité des blocs utilisés pour le stockage des données
   */
  public TableauBlock(int arrayCapacity, int blockCapacity) {
    assert arrayCapacity > 0 && blockCapacity > 0  : "arrayCapacity " + arrayCapacity + " blockCapacity " + blockCapacity;
    this.elements = new Tableau2x<>(arrayCapacity / blockCapacity + 1);
    this.blockCapacity = blockCapacity;
    this.elements.push_back(new Block<>(this.blockCapacity));
  }

  /**
   * Création d'un tableau de blocs
   *
   * @param arrayCapacity la capacité initiale du tableau
   * @implNote la capacité des blocs utilisés pour le stockage des données est fixée à 128
   */
  public TableauBlock(int arrayCapacity) {
    assert arrayCapacity > 0  : "arrayCapacity " + arrayCapacity;
    this.blockCapacity = 128;
    this.elements = new Tableau2x<>(arrayCapacity / this.blockCapacity  + 1);
    this.elements.push_back(new Block<>(this.blockCapacity));
  }

  private Block<T> getLastBlock() {
    return this.elements.get(this.elements.size() - 1);
  }

  /**
   * Déterminer la taille du tableau
   *
   * @return nombre d'éléments présents dans le tableau
   */
  public int size() {
    return (this.elements.size() - 1) * this.blockCapacity + this.getLastBlock().size();
  }

  /**
   * Déterminer si le tableau est vide
   *
   * @return vrai si le tableau est vide
   */
  public boolean empty() {
    return this.size() == 0;
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

    int blockIndex = i / this.blockCapacity;
    int elementIndex = i % this.blockCapacity;

    return this.elements.get(blockIndex).get(elementIndex);
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

    int blockIndex = i / this.blockCapacity;
    int elementIndex = i % this.blockCapacity;
    this.elements.get(blockIndex).set(elementIndex, v);
  }

  /**
   * Ajouter un élément en fin de tableau
   *
   * @param x : élément à ajouter en fin de tableau
   * @pre : ! this.full()
   */
  public void push_back(T x) {
    if (this.getLastBlock().full()) {
//            Last block is full
      this.elements.push_back(new Block<>(this.blockCapacity));
    }
    getLastBlock().push_back(x);
  }

  /**
   * Supprimer le dernier élément du tableau
   *
   * @pre : ! this.empty()
   */
  public void pop_back() {
    assert !this.empty();
    if (getLastBlock().empty()) {
      this.elements.pop_back();
    }
    getLastBlock().pop_back();
  }
}
