package tp1.rationnel;

import tp1.types.Rationnel;
import tp1.util.Couple;
import tp1.util.Outils;

public class RationnelCouple implements Rationnel {
    private final Couple<Integer, Integer> couple;

    public RationnelCouple(int numerateur, int denominateur) {
        if (numerateur == 0) {
            this.couple = new Couple<>(0, 1);
        } else {
            int pgcd = Outils.pgcd(Math.abs(numerateur), Math.abs(denominateur));
            if (pgcd <= 1) {
                this.couple = new Couple<>(Math.abs(numerateur), Math.abs(denominateur));
            } else {
                this.couple = new Couple<>(Math.abs(numerateur) / pgcd, Math.abs(denominateur) / pgcd);
            }
            if (numerateur < 0 ^ denominateur < 0) {
                this.couple.setFirst(-this.couple.getFirst());
            }
        }
    }

    public RationnelCouple(int a) {
        this.couple = new Couple<>(a, 1);
    }

    public RationnelCouple(Rationnel r) {
        this.couple = new Couple<>(r.getNumerateur(), r.getDenominateur());
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
        return this.couple.getFirst();
    }

    public int getDenominateur() {
        return this.couple.getSecond();
    }

    public int compareTo(Rationnel autre) {
        return this.getNumerateur() * autre.getDenominateur() - autre.getNumerateur() * this.getDenominateur();
    }
}
