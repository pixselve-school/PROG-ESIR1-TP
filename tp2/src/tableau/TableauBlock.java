package tableau;

import types.Tableau;

public class TableauBlock<T> implements Tableau<T> {
    /**
     * Déterminer la taille du tableau
     *
     * @return nombre d'éléments présents dans le tableau
     */
    public int size() {
        return 0;
    }

    /**
     * Déterminer si le tableau est vide
     *
     * @return vrai si le tableau est vide
     */
    public boolean empty() {
        return false;
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
        return null;
    }

    /**
     * Modifier l'élément d'indice i
     *
     * @param i : indice de l'élément à modifier
     * @param v : nouvelle valeur de l'élément d'indice i
     * @pre 0 <= i < this.size()
     */
    public void set(int i, T v) {

    }

    /**
     * Ajouter un élément en fin de tableau
     *
     * @param x : élément à ajouter en fin de tableau
     * @pre : ! this.full()
     */
    public void push_back(T x) {

    }

    /**
     * Supprimer le dernier élément du tableau
     *
     * @pre : ! this.empty()
     */
    public void pop_back() {

    }
}
