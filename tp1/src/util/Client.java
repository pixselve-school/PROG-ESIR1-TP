package util;

import rationnel.RationnelCouple;
import rationnel.RationnelSimple;
import types.Rationnel;

import java.util.Arrays;
import java.util.Scanner;

public class Client {
  /**
   * Lecture d'un rationnel dans le terminal
   *
   * @param input un Scanner
   * @return le rationnel lu
   */
  private static Rationnel lireRationnel(Scanner input) {
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
      System.out.println("Les rationnels :");
      afficher(rationnels, rationnelsCount);
      System.out.println(sommeRationnels(rationnels, rationnelsCount));
      previousR = currentR;
    } while (true);
  }

  /**
   * Création d'un rationnel
   *
   * @param num le numérateur du rationnel
   * @param den le dénominateur du rationnel
   * @return le rationnel num / den
   */
  private static Rationnel makeRationnel(int num, int den) {
    if (Math.random() > 0.5) {
      System.out.println("Création d'un RationnelSimple");
      return new RationnelSimple(num, den);
    } else {
      System.out.println("Création d'un RationnelCouple");
      return new RationnelCouple(num, den);
    }

  }

  /**
   * Affiche un liste de rationnels
   *
   * @param lesRationnels une liste de rationnel
   * @param nb            le nombre de rationnels dans la liste lesRationnels
   */
  private static void afficher(Rationnel[] lesRationnels, int nb) {
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
   * @implSpec nb < lesRationnels.length
   */
  public static void insererRationnel(Rationnel nouveau, Rationnel[] lesRationnels, int nb) {
    assert nb < lesRationnels.length;
    int index = 0;
    for (int i = 0; i <= nb; i++) {
      if (i == nb || nouveau.compareTo(lesRationnels[i]) < 0) {
        index = i;
        break;
      }
    }
    System.arraycopy(lesRationnels, index, lesRationnels, index + 1, nb - index);
    lesRationnels[index] = nouveau;
  }

  /**
   * Effectue la somme des rationnels dans une liste
   *
   * @param lesRationnels une liste de rationnel
   * @param nb            le nombre de rationnel dans lesRationnels
   * @return la somme des nb premiers rationnels dans lesRationnels
   * @implSpec nb <= lesRationnels.length
   */
  private static Rationnel sommeRationnels(Rationnel[] lesRationnels, int nb) {
    assert nb <= lesRationnels.length;
    return Arrays.stream(lesRationnels, 0, nb).reduce(makeRationnel(0, 1), Rationnel::somme);
  }
}
