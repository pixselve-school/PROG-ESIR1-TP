package tp1.rationnel;

import tp1.types.Rationnel;
import tp1.util.Outils;

public class RationnelSimple implements Rationnel {
    private final int numerateur;
    private final int denominateur;

    public RationnelSimple(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    public RationnelSimple(int a) {
        this.numerateur = a;
        this.denominateur = 1;
    }

    public RationnelSimple(Rationnel r) {
        this.numerateur = r.getNumerateur();
        this.denominateur = r.getDenominateur();
    }


    /**
     * comparer (Ã©galitÃ©) deux rationnels
     *
     * @param r : rationnel Ã  comparer au rationnel this
     * @return vrai si le rationnel this est Ã©gal au rationnel paramÃ¨tre
     */
    public boolean equals(Rationnel r) {
        Rationnel simplifiedR = simplify(r);
        Rationnel simplifiedThis = simplify(this);
        return simplifiedR.getNumerateur() == simplifiedThis.getNumerateur() && simplifiedR.getDenominateur() == simplifiedThis.getDenominateur();
    }

    private static Rationnel simplify(Rationnel r) {
        int pgcd = Outils.pgcd(r.getNumerateur(), r.getDenominateur());

        if (pgcd <= 1) {
            return r;
        } else {
            return new RationnelSimple(r.getNumerateur() / pgcd, r.getDenominateur() / pgcd);
        }
    }

    /**
     * additionner deux rationnels
     *
     * @param r : rationnel Ã  additionner avec le rationnel this
     * @return nouveau rationnel somme du rationnel this et du rationnel paramÃ¨tre
     */
    public Rationnel somme(Rationnel r) {
        return new RationnelSimple(this.numerateur * r.getDenominateur() + r.getNumerateur() * this.getDenominateur(), this.denominateur * r.getDenominateur());
    }

    /**
     * inverser le rationnel this
     *
     * @return nouveau rationnel inverse du rationnel this
     * @pre numÃ©rateur != 0
     */
    public Rationnel inverse() {
        return new RationnelSimple(this.denominateur, this.numerateur);
    }

    /**
     * calculer la valeur rÃ©elle du rationnel this
     *
     * @return valeur rÃ©elle du rationnel this
     */
    public double valeur() {
        return (double) this.numerateur / this.denominateur;
    }

    /**
     * @return reprÃ©sentation affichable d'un rationnel
     */
    public String toString() {
        return this.numerateur + "/" + this.denominateur;
    }

    public int getNumerateur() {
        return this.numerateur;
    }

    public int getDenominateur() {
        return this.denominateur;
    }

    public int compareTo(Rationnel autre) {
        return 0;
    }
}
