import types.ABinHuffman;
import outilsHuffman.OutilsHuffman;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * Réalisation du décodage d'un texte par la méthode de Huffman
 */

public class DecodageHuffman {
  public static void main(String[] args) throws IOException {
    //------------------------------------------------------------------------
    // 0. Saisir le nom du fichier à décoder (À FAIRE)
    //------------------------------------------------------------------------
    String nomFichier = "tp3/resources/exemple.txt.code";

    //------------------------------------------------------------------------
    // 1. Lire et construire la table de fréquences (DONNÉ)
    //------------------------------------------------------------------------
    int[] tableFrequences = OutilsHuffman.lireTableFrequences(nomFichier);

    //------------------------------------------------------------------------
    // 2. Construire l'arbre de Huffman (DONNÉ)
    //------------------------------------------------------------------------
    ABinHuffman arbreHuffman =
        OutilsHuffman.construireArbreHuffman(tableFrequences);

    //------------------------------------------------------------------------
    // 2.1 afficher l'arbre de Huffman (À FAIRE)
    //------------------------------------------------------------------------
    System.out.println("Arbre de Huffman associé au texte " + nomFichier);
    afficherHuffman(arbreHuffman);

    //------------------------------------------------------------------------
    // 3. Lire le texte codé (DONNÉ)
    //------------------------------------------------------------------------
    String texteCode = OutilsHuffman.lireTexteCode(nomFichier);

    //------------------------------------------------------------------------
    // 4. Décoder le texte (À FAIRE)
    //------------------------------------------------------------------------
    StringBuilder texteDecode = decoderTexte(texteCode, arbreHuffman);

    //------------------------------------------------------------------------
    // 5. Enregistrer le texte décode (DONNÉ)
    //------------------------------------------------------------------------
    System.out.println("texte décodé:\n\n" + texteDecode);
    enregistrerTexte(texteDecode, nomFichier + ".decode");
  }

  /**
   * 4. décoder une chaîne (non vide) encodée par le codage de Huffman
   *
   * @param texteCode    : chaîne de "0/1" à décoder
   * @param arbreHuffman : arbre de (dé)codage des caractères
   */
  public static StringBuilder decoderTexte(String texteCode, ABinHuffman arbreHuffman) {
    int i = 0;
    StringBuilder result = new StringBuilder();
    ABinHuffman current = arbreHuffman;

    while (i < texteCode.length()) {
      char character = texteCode.charAt(i);
      if (current.estFeuille()) {
        result.append(current.getValeur().premier());
        current = arbreHuffman;
      } else {
        if (character == '0') {
          current = current.filsGauche();
        } else {
          current = current.filsDroit();
        }
        i++;
      }

    }

    return result;
  }

  /**
   * 2.1 afficher un arbre de Huffman
   *
   * @param a : arbre binaire de Huffman
   */
  public static void afficherHuffman(ABinHuffman a) {
    afficherHuffman(a, new StringBuilder());
  }

  /**
   * 2.1 afficher un arbre de Huffman
   *
   * @param a      : arbre binaire de Huffman
   * @param status : code actuel
   */
  private static void afficherHuffman(ABinHuffman a, StringBuilder status) {
    if (a.estFeuille()) {
      System.out.printf("<%s,%s>: %s%n", a.getValeur().premier(), a.getValeur().deuxieme(), status);
    } else {
      afficherHuffman(a.filsGauche(), status.append(0));
      status.deleteCharAt(status.length() - 1);
      afficherHuffman(a.filsDroit(), status.append(1));
      status.deleteCharAt(status.length() - 1);
    }
  }

  public static void enregistrerTexte(StringBuilder texte, String nomFichierDecode) throws IOException {
    OutputStream outputStream = new FileOutputStream(nomFichierDecode);
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.ISO_8859_1);
    outputStreamWriter.write(texte.toString());
    outputStreamWriter.close();

  }
} // DecodageHuffman
