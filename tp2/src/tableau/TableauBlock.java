package tableau;

import types.Array;
import types.Tableau;

public class TableauBlock<T> implements Tableau<T> {
  private final int blockCapacity;
  private Array<Block<T>> elements;
  private int blockCount;

  /**
   * Création d'un tableau de blocs
   *
   * @param arrayCapacity la capacité initiale du tableau
   * @param blockCapacity la capacité des blocs utilisés pour le stockage des données
   */
  public TableauBlock(int arrayCapacity, int blockCapacity) {
    assert arrayCapacity > 0 && blockCapacity > 0;
    this.elements = new Array<>(arrayCapacity);
    this.blockCapacity = blockCapacity;
    this.elements.set(0, new Block<>(this.blockCapacity));
    this.blockCount = 1;
  }

  /**
   * Création d'un tableau de blocs
   *
   * @param arrayCapacity la capacité initiale du tableau
   * @implNote la capacité des blocs utilisés pour le stockage des données est fixée à 128
   */
  public TableauBlock(int arrayCapacity) {
    assert arrayCapacity > 0;
    this.elements = new Array<>(arrayCapacity);
    this.blockCapacity = 128;
    this.elements.set(0, new Block<>(this.blockCapacity));
    this.blockCount = 1;
  }

  private int elementsInLastBlock() {
    return getLastBlock().size();
  }

  private Block<T> getLastBlock() {
    return this.elements.get(blockCount - 1);
  }

  private boolean lastBlockFull() {
    return getLastBlock().full();
  }

  /**
   * Déterminer la taille du tableau
   *
   * @return nombre d'éléments présents dans le tableau
   */
  public int size() {
    return (this.blockCount - 1) * this.blockCapacity + this.elementsInLastBlock();
  }

  /**
   * Déterminer si le tableau est vide
   *
   * @return vrai si le tableau est vide
   */
  public boolean empty() {
    return this.elementsInLastBlock() == 0;
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
      if (this.blockCount == this.elements.length()) {
//                The array is full
        Array<Block<T>> newElements = new Array<>(this.elements.length() * 2);
        for (int i = 0; i < this.elements.length(); i++) {
          newElements.set(i, this.elements.get(i));
        }
        this.elements = newElements;
      }
      this.elements.set(this.blockCount, new Block<>(this.blockCapacity));
      this.blockCount++;
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
      this.elements.set(this.blockCount - 1, null);
      this.blockCount--;
    }
    getLastBlock().pop_back();
  }
}
