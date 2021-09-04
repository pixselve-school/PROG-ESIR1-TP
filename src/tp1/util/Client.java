package tp1.util;

import tp1.rationnel.RationnelSimple;
import tp1.types.Rationnel;

import java.util.Arrays;
import java.util.Scanner;

public class Client {
    static Rationnel lireRationnel(Scanner input) {
        System.out.print("🔤 Numérateur");
        int numerateur = input.nextInt();
        int denominateur;
        do {
            System.out.print("🔤 Dénominateur (non nul)");
            denominateur = input.nextInt();
        } while (denominateur == 0);
        return makeRationnel(numerateur, denominateur);
    }

    public static void main(String[] args) {
        Rationnel currentR;
        Rationnel previousR = new RationnelSimple(0, 1);
        Rationnel[] rationnels = new Rationnel[100];
        int rationnelsCount = 0;
        do {
//            Ask the user
            currentR = lireRationnel(new Scanner(System.in));
            if (currentR.getNumerateur() == 0) break;

            insererRationnel(currentR, rationnels, rationnelsCount);
            rationnelsCount++;

//            Sum
            System.out.println(currentR);
            final Rationnel somme = currentR.somme(previousR);
            System.out.println(currentR + " + " + previousR + " = 0 " + somme.toString());

            insererRationnel(somme, rationnels, rationnelsCount);
            rationnelsCount++;

            if (currentR.getNumerateur() != 0) {
                final Rationnel inverse = currentR.inverse();
                System.out.println("🔄 L'inverse de " + currentR + " est: " + inverse);
                insererRationnel(inverse, rationnels, rationnelsCount);
                rationnelsCount++;
            } else {
                System.out.println("❌ Inverse impossible");
            }
            System.out.println("Valeur réelle: " + currentR.valeur());
            double compareValue = currentR.compareTo(previousR);
            if (compareValue == 0) {
                System.out.println(currentR + " = " + previousR);
            } else if (compareValue > 0) {
                System.out.println(currentR + " > " + previousR);
            } else {
                System.out.println(currentR + " < " + previousR);
            }
            System.out.println(currentR.equals(previousR) ? currentR + " = " + previousR : currentR + " != " + previousR);

            System.out.println(Arrays.toString(rationnels));
            System.out.println(sommeRationnels(rationnels, rationnelsCount));
            previousR = currentR;
        } while (true);
    }

    static Rationnel makeRationnel(int num, int den) {
        return new RationnelSimple(num, den);
    }

    static void afficher(Rationnel[] lesRationnels, int nb) {
        for (int i = 0; i < nb; i++) {
            System.out.println(lesRationnels[i] + " = " + lesRationnels[i].valeur());
        }
    }

    /**
     * inserer le rationnel nouveau dans le tableau les Rationnels
     *
     * @param nouveau       : le nouveau Rationnel a inserer
     * @param lesRationnels : le tableau de rationnel
     * @param nb            : le nombre de rationnel dans le tableau
     */
    static void insererRationnel(Rationnel nouveau, Rationnel[] lesRationnels, int nb) {
        assert nb < lesRationnels.length;
        int index = 0;
        for (int i = 0; i <= nb; i++) {
            if (i == nb || nouveau.compareTo(lesRationnels[i]) < 0) {
                index = i;
                break;
            }
        }
        if (nb - index >= 0) System.arraycopy(lesRationnels, index, lesRationnels, index + 1, nb - index);
        lesRationnels[index] = nouveau;
    }

    static Rationnel sommeRationnels(Rationnel[] lesRationnels, int nb) {
        assert nb <= lesRationnels.length;
        return Arrays.stream(Arrays.copyOfRange(lesRationnels, 0, nb - 1)).reduce(makeRationnel(0, 1), Rationnel::somme);
    }
}
