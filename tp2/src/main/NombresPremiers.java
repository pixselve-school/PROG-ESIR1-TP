package main;

import tableau.Block;
import types.Tableau;

import java.util.Random;
import java.util.Scanner;

public class NombresPremiers {
  public static void main(String[] args) {
    Tableau<Integer> primeNumbers = new Block<>(100);
    System.out.print("Veuillez saisir un entier : ");
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();
    int lastPrimeNumber = calculerNombresPremiers(n, primeNumbers);
    displayArray(primeNumbers);
    System.out.println("Le dernier entier testé : " + lastPrimeNumber);

    Tableau<Integer> randomArray = remplirHasard(lastPrimeNumber);
    displayArray(randomArray);

    System.out.println("Nombre d’entiers premiers éliminés : " + eliminerPresents(randomArray, primeNumbers));
    displayArray(randomArray);
  }

  /**
   * Affiche un tableau
   *
   * @param array le tableau à afficher
   */
  private static void displayArray(Tableau<Integer> array) {
    for (int i = 0; i < array.size(); i++) {
      System.out.println(array.get(i));
    }
  }

  /**
   * Cette fonction éliminera du tableau t1 tous les éléments présents dans le tableau t2
   *
   * @param t1 tableau de nombres entiers, quelconque
   * @param t2 tableau de nombres entiers, trié en ordre croissant
   * @return le nombre d’éléments éliminés
   */
  public static int eliminerPresents(Tableau<Integer> t1, Tableau<Integer> t2) {
//        Create a Set with the elements of t2

    int deletedCount = 0;

    int i = 0;
    while (i < t1.size()) {
      if (estPresent(t1.get(i), t2, t2.size())) {
        t1.set(i, t1.get(t1.size() - 1));
        t1.pop_back();
        deletedCount++;
      } else {
        i++;
      }

    }

    return deletedCount;
  }

  public static boolean estPresent(int element, Tableau<Integer> array, int arrayElements) {
    int a = 0;
    int b = arrayElements - 1;
    while (a < b) {
      int c = (b + a) / 2;
      if (array.get(c) == element) {
        return true;
      } else if (array.get(c) > element) {
        b = c - 1;
      } else {
        a = c + 1;
      }
    }
    return element == array.get(a);
  }

  /**
   * crée un tableau de type Block de capacité nb et le remplit avec des entiers tirés au hasard dans l’intervalle [0;length[
   *
   * @param length longueur du tableau à créer
   * @return un tableau de type Block de capacité nb remplit d'entiers tirés au hasard dans l’intervalle [0;length[
   */
  public static Tableau<Integer> remplirHasard(int length) {
    Block<Integer> result = new Block<>(length);
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      result.push_back(random.nextInt(length));
    }
    return result;
  }

  /**
   * détermine si un entier n ≥ 2 est premier
   *
   * @param n     un entier n
   * @param array un tableau contenant tous les entiers premiers compris dans l’intervalle [2; n − 1]
   * @return vrai si l’entier testé est premier, faux dans le cas contraire.
   * @pre n ≥ 2
   */
  public static boolean estPremier(int n, Tableau<Integer> array) {
    assert n >= 2;
    for (int i = 0; i < array.size(); i++) {
      if (n % array.get(i) == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Calcul de l’ensemble des entiers premiers dans l’intervalle [2;N] à l’aide de la fonction estPremier
   *
   * @param n     un entier
   * @param array un tableau, initialement vide, qui servira à stocker l’ensemble des entiers premiers trouvés dans cet intervalle
   * @return le dernier entier testé si le tableau est plein avant la fin du calcul ou l’entier N dans le cas contraire
   */
  public static int calculerNombresPremiers(int n, Tableau<Integer> array) {
    for (int i = 2; i <= n; i++) {
      if (estPremier(i, array)) {
        if (array.full()) {
          return i;
        } else {
          array.push_back(i);
        }
      }
    }
    return n;
  }
}
