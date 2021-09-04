package tp1.rationnel;

import tp1.types.Rationnel;
import tp1.util.Outils;

import java.util.Objects;

public class RationnelSimple implements Rationnel {
    private int numerateur;
    private final int denominateur;

    public RationnelSimple(int numerateur, int denominateur) {
        if (numerateur == 0) {
            this.numerateur = 0;
            this.denominateur = 1;
        } else {
            int pgcd = Outils.pgcd(Math.abs(numerateur), Math.abs(denominateur));
            if (pgcd <= 1) {
                this.numerateur = Math.abs(numerateur);
                this.denominateur = Math.abs(denominateur);
            } else {
                this.numerateur = Math.abs(numerateur) / pgcd;
                this.denominateur = Math.abs(denominateur) / pgcd;
            }

            if (numerateur < 0 ^ denominateur < 0) {
                this.numerateur = - this.numerateur;
            }
        }
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
        return r.getNumerateur() == this.getNumerateur() && r.getDenominateur() == this.getDenominateur();
    }


    /**
     * additionner deux rationnels
     *
     * @param r : rationnel Ã  additionner avec le rationnel this
     * @return nouveau rationnel somme du rationnel this et du rationnel paramÃ¨tre
     */
    public Rationnel somme(Rationnel r) {
        return new RationnelSimple(this.getNumerateur() * r.getDenominateur() + r.getNumerateur() * this.getDenominateur(), this.getDenominateur() * r.getDenominateur());
    }

    /**
     * inverser le rationnel this
     *
     * @return nouveau rationnel inverse du rationnel this
     * @pre numÃ©rateur != 0
     */
    public Rationnel inverse() {
        return new RationnelSimple(this.getDenominateur(), this.getNumerateur());
    }

    /**
     * calculer la valeur rÃ©elle du rationnel this
     *
     * @return valeur rÃ©elle du rationnel this
     */
    public double valeur() {
        return (double) this.getNumerateur() / this.getDenominateur();
    }

    /**
     * @return reprÃ©sentation affichable d'un rationnel
     */
    public String toString() {
        return this.getNumerateur() + "/" + this.getDenominateur();
    }

    public int getNumerateur() {
        return this.numerateur;
    }

    public int getDenominateur() {
        return this.denominateur;
    }

    public int compareTo(Rationnel autre) {
        return this.getNumerateur() * autre.getDenominateur() - autre.getNumerateur() * this.getDenominateur();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationnelSimple that = (RationnelSimple) o;
        return numerateur == that.numerateur && denominateur == that.denominateur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerateur, denominateur);
    }
}
