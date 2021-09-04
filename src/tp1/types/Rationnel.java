package tp1.types;

/**
 * Rationnel.java : spÃ©cification du TA Rationnel
 */

public interface Rationnel extends Comparable<Rationnel>
{

    /**
     * initialiser un rationnel Ã  partir d'un entier : nb/1
     * @param num : valeur du numÃ©rateur
     */
    // public Rationnel(int num);

    /**
     * initialiser un rationnel avec numerateur et dÃ©nominateur
     * @param num : valeur du numÃ©rateur
     * @param den : valeur du dÃ©nominateur
     * @pre den != 0
     * @post fraction irrÃ©ductible et dÃ©nominateur > 0
     */
    // public Rationnel(int num, int den):

    /**
     * initialiser un rationnel Ã  partir d'un autre
     * @param r : rationnel Ã  dupliquer
     */
    // public Rationnel(Rationnel r);

    /**
     * comparer (Ã©galitÃ©) deux rationnels
     * @param r : rationnel Ã  comparer au rationnel this
     * @return vrai si le rationnel this est Ã©gal au rationnel paramÃ¨tre
     */
    public boolean equals(Rationnel r);

    /**
     * additionner deux rationnels
     * @param r : rationnel Ã  additionner avec le rationnel this
     * @return nouveau rationnel somme du rationnel this et du rationnel paramÃ¨tre
     */
    public Rationnel somme(Rationnel r);

    /**
     * inverser le rationnel this
     * @return nouveau rationnel inverse du rationnel this
     * @pre numÃ©rateur != 0
     */
    public Rationnel inverse();

    /**
     * calculer la valeur rÃ©elle du rationnel this
     * @return valeur rÃ©elle du rationnel this
     */
    public double valeur();

    /**
     *  @return reprÃ©sentation affichable d'un rationnel
     */
    public String toString();

    // accesseurs
    public int getNumerateur();   // consulter le numÃ©rateur
    public int getDenominateur(); // consulter le dÃ©nominateur

    // mÃ©thode de l'interface Comparable<Rationnel>
    // comparaison ordonnÃ©e du rationnel this et du rationnel autre
    public int compareTo(Rationnel autre);
}// Rationnel