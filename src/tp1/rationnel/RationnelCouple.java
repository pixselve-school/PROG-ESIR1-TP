package tp1.rationnel;

import tp1.types.Rationnel;

public class RationnelCouple implements Rationnel {
    /**
     * comparer (Ã©galitÃ©) deux rationnels
     *
     * @param r : rationnel Ã  comparer au rationnel this
     * @return vrai si le rationnel this est Ã©gal au rationnel paramÃ¨tre
     */
    public boolean equals(Rationnel r) {
        return false;
    }

    /**
     * additionner deux rationnels
     *
     * @param r : rationnel Ã  additionner avec le rationnel this
     * @return nouveau rationnel somme du rationnel this et du rationnel paramÃ¨tre
     */
    public Rationnel somme(Rationnel r) {
        return null;
    }

    /**
     * inverser le rationnel this
     *
     * @return nouveau rationnel inverse du rationnel this
     * @pre numÃ©rateur != 0
     */
    public Rationnel inverse() {
        return null;
    }

    /**
     * calculer la valeur rÃ©elle du rationnel this
     *
     * @return valeur rÃ©elle du rationnel this
     */
    public double valeur() {
        return 0;
    }

    public int getNumerateur() {
        return 0;
    }

    public int getDenominateur() {
        return 0;
    }

    public int compareTo(Rationnel autre) {
        return 0;
    }
}
