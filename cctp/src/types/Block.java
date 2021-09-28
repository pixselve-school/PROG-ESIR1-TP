package types;

public class Block<T> implements Tableau<T> {
    private Array<T> elements;
    private int count;

    /**
     * Création d'un tableau de capacité fixe
     *
     * @param capacity la capacité du tableau
     */
    public Block(int capacity) {
        assert capacity > 0 : "capacity " + capacity;
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
        assert i >= 0 && i < this.size() : "Access types.Block index " + i;
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
        this.elements.set(--this.count, null);
    }

    /**
     * @param element element à tester
     * @return true si le param element est dans le Tableau, false sinon
     */
    public boolean contains(T element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.elements.get(i) == element) {
                return true;
            }
        }
        return false;
    }

    public Tableau<T> inter(Tableau<T> that) {
        int min = Math.min(that.size(), this.size());
        if (min == 0) return new Block<T>(1);


        Tableau<T> result = new Block<>(min);
        for (int i = 0; i < this.size(); i++) {
            T elementAti = this.get(i);
            if (that.contains(elementAti)) {
                result.push_back(elementAti);
            }
        }
        return result;
    }

    public Tableau<T> xor(Tableau<T> that) {
        int capacity = that.size() + this.size();
        if (capacity == 0) return new Block<T>(1);

        Tableau<T> result = new Block<T>(capacity);

        for (int i = 0; i < this.size(); i++) {
            T elementAti = this.get(i);
            if (!that.contains(elementAti)) {
                result.push_back(elementAti);
            }
        }
        for (int i = 0; i < that.size(); i++) {
            T elementAti = that.get(i);
            if (!this.contains(elementAti)) {
                result.push_back(elementAti);
            }
        }
        return result;
    }

    public void concat(Tableau<T> that) {
        int capacite = this.size() + that.size();
        Array<T> resultElements = new Array<T>(capacite);

        for (int i = 0; i < this.size(); i++) {
            resultElements.set(i, this.elements.get(i));
        }
        for (int i = 0; i < that.size(); i++) {
            resultElements.set(i + this.size(), that.get(i));
        }

        this.elements = resultElements;
        this.count = capacite;
    }
}
