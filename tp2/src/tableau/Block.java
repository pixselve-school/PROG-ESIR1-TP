package tableau;

import types.Array;
import types.Tableau;

public class Block<T> implements Tableau<T> {
    private Array<T> elements;
    private int count;

    /**
     * Création d'un tableau de capacité fixe
     *
     * @param capacity la capacité du tableau
     */
    public Block(int capacity) {
        assert capacity > 0;
        this.elements = new Array<>(capacity);
        this.count = 0;
    }

    /**
     * Déterminer la taille du tableau
     *
     * @return nombre d'éléments présents dans le tableau
     */
    public int size() {
        return this.count;
    }

    /**
     * Déterminer si le tableau est vide
     *
     * @return vrai si le tableau est vide
     */
    public boolean empty() {
        return this.count == 0;
    }

    /**
     * Déterminer si le tableau est plein
     *
     * @return vrai s'il n'est plus possible d'ajouter d'élément dans le tableau
     */
    public boolean full() {
        return this.count == this.elements.length();
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
        assert !this.full();
        this.elements.set(this.count++, x);
    }

    /**
     * Supprimer le dernier élément du tableau
     *
     * @pre : ! this.empty()
     */
    public void pop_back() {
        assert !this.empty();
        this.elements.set(this.count-- - 1, null);
    }
}
