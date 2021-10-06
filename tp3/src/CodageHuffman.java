import types.ABinHuffman;
import types.Couple;
import types.ListeABH;
import outilsHuffman.OutilsHuffman;

import java.util.Comparator;
import java.util.ListIterator;

/**
 * Réalisation du codage d'un texte par la méthode de Huffman
 */

public class CodageHuffman {
  public static void main(String[] args) {
    long time = OutilsHuffman.getInstantPresent();
    //------------------------------------------------------------------------
    // 0. Saisir le nom du fichier à coder (À FAIRE)
    //------------------------------------------------------------------------
    String nomFichier = "tp3/resources/exemple.txt";

    //------------------------------------------------------------------------
    // 1. Lire le texte (DONNÉ)
    //------------------------------------------------------------------------
    char[] texte = OutilsHuffman.lireFichier(nomFichier);

    //------------------------------------------------------------------------
    // 2. Calculer la table des fréquences des caractères (À FAIRE)
    //------------------------------------------------------------------------
    int[] tableFrequences = calculerFrequences(texte);

    //------------------------------------------------------------------------
    // 3. Enregistrer la table de fréquences dans le fichier de sortie (DONNÉ)
    //------------------------------------------------------------------------
    OutilsHuffman.enregistrerTableFrequences(tableFrequences, nomFichier + ".code");

    //------------------------------------------------------------------------
    // 4. Construire l'arbre de codage de Huffman (DONNÉ - À FAIRE)
    //------------------------------------------------------------------------
    ABinHuffman arbreCodageHuffman = construireArbreHuffman(tableFrequences);

    //------------------------------------------------------------------------
    // Afficher l'arbre de codage de Huffman (DÉJÀ FAIT)
    //------------------------------------------------------------------------
    System.out.println("Arbre de Huffman associé au texte " + nomFichier);
    DecodageHuffman.afficherHuffman(arbreCodageHuffman);

    //------------------------------------------------------------------------
    // 5. Construire la table de codage associée (À FAIRE)
    //------------------------------------------------------------------------
    String[] tablecodage = construireTableCodage(arbreCodageHuffman);

    //------------------------------------------------------------------------
    // 5.1. afficher la table de codage (À FAIRE)
    //------------------------------------------------------------------------
    System.out.println("Table de codage associée au texte " + nomFichier);
    afficherTableCodage(tablecodage);

    //------------------------------------------------------------------------
    // 6. coder le texte avec l'arbre de Huffman (À FAIRE)
    //------------------------------------------------------------------------
    long startTimeCode = OutilsHuffman.getInstantPresent();
    StringBuilder texteCode = coderTexte(texte, tablecodage);
    long timeCode = OutilsHuffman.getInstantPresent() - startTimeCode;

    //------------------------------------------------------------------------
    // 7. enregistrer le texte codé (DONNÉ)
    //------------------------------------------------------------------------
    OutilsHuffman.enregistrerTexteCode(texteCode, nomFichier + ".code");

    //------------------------------------------------------------------------
    // xx. calculer et afficher les stats (À FAIRE)
    //------------------------------------------------------------------------
    // calculer la taille du fichier non codé
    // calculer la taille du fichier codé
    double codedTextLength = Math.ceil(texteCode.length() / 8.0);

    System.out.printf("Taille texte compressé: %s%n", codedTextLength);
    System.out.printf("Taux compression texte: %s%%%n", codedTextLength * 100 / texte.length);
    System.out.printf("Taille texte fichier compressé: %s%n", OutilsHuffman.tailleFichier(nomFichier + ".code"));
    System.out.printf("Taux compression fichier: %s%%%n", OutilsHuffman.tailleFichier(nomFichier + ".code") * 100 / OutilsHuffman.tailleFichier(nomFichier));

    System.out.printf("Durée codage: %s ms%n", timeCode);
    System.out.printf("Durée totale: %s ms%n", OutilsHuffman.getInstantPresent() - time);


  }

  /**
   * 2. calculer la fréquence d'apparition de chaque caractère
   *
   * @param tcar tableau des caractères du texte
   * @return tableau de fréquence des caractères, indicé par les caractères
   */
  public static int[] calculerFrequences(char[] tcar) {
    int[] result = new int[256];
    for (char c : tcar) {
      result[c] += 1;
    }
    return result;
  }

  /**
   * 4. construire un arbre de codage de Huffman par sélection et combinaison
   * des éléments minimaux
   *
   * @param tableFrequences table des fréquences des caractères
   * @return arbre de codage de Huffman
   */
  public static ABinHuffman construireArbreHuffman(int[] tableFrequences) {
    ListeABH list = faireListeAbinHuffman(tableFrequences);
    while (list.size() > 1) {
      ABinHuffman small = list.remove();
      ABinHuffman large = list.remove();
      ABinHuffman newTree = OutilsHuffman.consArbre(new Couple<>((char) 0, getFrequency(small) + getFrequency(large)), small, large);
      addInPlace(list, newTree);

    }
    return list.getFirst();
  }

  /**
   * Récupère la fréquence d'un caractère de la racine d'un arbre Huffman
   *
   * @param aBinHuffman un arbre Huffman
   * @return a fréquence d'un caractère de la racine de l'arbre
   */
  private static Integer getFrequency(ABinHuffman aBinHuffman) {
    return aBinHuffman.getValeur().deuxieme();
  }

  /**
   * Ajoute un ABinHuffman au bon endroit dans une ListeABH
   *
   * @param list    une ListeABH
   * @param element un ABinHuffman
   */
  protected static void addInPlace(ListeABH list, ABinHuffman element) {
    ListIterator<ABinHuffman> listIterator = list.listIterator();
    while (listIterator.hasNext()) {
      ABinHuffman aBinHuffman = listIterator.next();
      if (getFrequency(aBinHuffman) > getFrequency(element)) {
        if (listIterator.hasPrevious()) {
          listIterator.previous();
          listIterator.add(element);
        } else {
          list.addFirst(element);
        }
        return;
      }
    }
    list.add(element);
  }

  /**
   * 4.1 Faire une liste triée dont chaque élément est un arbreBinaire<br>
   * comprenant un unique sommet dont l'étiquette est un couple
   * <caractère, fréquence>, trié par fréquence croissante
   *
   * @param tableFrequences : table des fréquences des caractères
   * @return la liste triée
   */
  private static ListeABH faireListeAbinHuffman(int[] tableFrequences) {
    ListeABH result = new ListeABH();
    for (int i = 0; i < tableFrequences.length; i++) {
      if (tableFrequences[i] > 0) {
        ABinHuffman tree = new ABinHuffman();
        tree.setValeur(new Couple<>((char) i, tableFrequences[i]));
        result.add(tree);
      }
    }
    result.sort(Comparator.comparingInt(a -> a.getValeur().deuxieme()));
    return result;

  }

  /**
   * 5. construire la table de codage correspondant à l'arbre de Huffman
   *
   * @param abinHuff : arbre de Huffman
   * @return table de (dé)codage indicé par lex caractères
   */
  public static String[] construireTableCodage(ABinHuffman abinHuff) {
    String[] result = new String[256];
    construireTableCodage(abinHuff, new StringBuilder(), result);
    return result;
  }

  /**
   * 5. complète la table de codage correspondant à l'arbre de Huffman
   *
   * @param a      : arbre de Huffman
   * @param status : code actuel
   * @param table  : table de codage
   */
  private static void construireTableCodage(ABinHuffman a, StringBuilder status, String[] table) {
    if (a.estFeuille()) {
      table[a.getValeur().premier()] = status.toString();
    } else {
      construireTableCodage(a.filsGauche(), status.append(0), table);
      status.deleteCharAt(status.length() - 1);
      construireTableCodage(a.filsDroit(), status.append(1), table);
      status.deleteCharAt(status.length() - 1);
    }
  }

  /**
   * 5.1. Afficher la table de codage associée au texte
   *
   * @param tablecodage : table de codage associée au texte
   */
  public static void afficherTableCodage(String[] tablecodage) {
    for (int i = 0; i < tablecodage.length; i++) {
      if (tablecodage[i] != null) System.out.printf("<%s> : %s%n", (char) i, tablecodage[i]);
    }
  }

  /**
   * 6. Coder un texte à l'aide de la table de codage
   *
   * @param texte       à coder
   * @param tablecodage : table de codage associée au texte
   * @return texte codé
   */
  public static StringBuilder coderTexte(char[] texte, String[] tablecodage) {
    StringBuilder result = new StringBuilder();
    for (char c : texte) {
      result.append(tablecodage[c]);
    }
    return result;
  }
}// CodageHuffman
