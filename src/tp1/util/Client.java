package tp1.util;

import tp1.rationnel.RationnelSimple;
import tp1.types.Rationnel;

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
        do {
            currentR = lireRationnel(new Scanner(System.in));
            if (currentR.getNumerateur() == 0) break;
            System.out.println(currentR);
            System.out.println(currentR + " + " + previousR + " = 0 " + currentR.somme(previousR).toString());
            if (currentR.getNumerateur() != 0) {
                System.out.println("🔄 L'inverse de " + currentR + " est: " + currentR.inverse());
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
        for (int i = 0; i < lesRationnels.length; i++) {
            
        }



        Rationnel[] result = new Rationnel[nb + 1];
        int currentI;
        for (currentI = 0; currentI < lesRationnels.length && nouveau.compareTo(lesRationnels[currentI]) < 0; currentI++) {
            result[currentI] = lesRationnels[currentI];
        }
        result[currentI] = nouveau;
        currentI++;
        for (; currentI < lesRationnels.length; currentI++) {
            result[currentI] = lesRationnels[currentI - 1];
        }
        return result;
    }

    static Rationnel sommeRationnels(Rationnel[] lesRationnels, int nb) {

    }
}
