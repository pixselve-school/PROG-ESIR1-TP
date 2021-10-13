package v3;

import v3.comparators.ComparateurMulti;
import v3.comparators.ComparateurLongueur;
import v3.comparators.ComparateurTarif;
import v3.vehicles.Vehicle;

import java.util.Comparator;
import java.util.Random;

public class Company {
  public static void main(String[] args) {
    Ferry ferry = new Ferry(500, 500);
    Random random = new Random();
    while (addRandomVehicleToFerry(ferry, random)) {
      System.out.println(ferry);
    }
    System.out.println("Tri du Ferry selon la longueur des véhicules");
    ferry.trier();
    System.out.println(ferry);

    System.out.println("Tri du Ferry selon le tarifs des véhicules");
    ferry.trier(new ComparateurTarif());
    System.out.println(ferry);

    System.out.println("Tri du Ferry selon le tarifs des véhicules (dans l'ordre décroissant)");
    ferry.trier(new ComparateurTarif(false));
    System.out.println(ferry);

    System.out.println("Tri du Ferry selon la longueur des véhicules (dans l'ordre décroissant)");
    ferry.trier(new ComparateurLongueur(false));
    System.out.println(ferry);

    System.out.println("Tri du Ferry selon le tarif et la longueur des véhicules");
    ferry.trier(new ComparateurMulti(new ComparateurTarif(), Comparator.comparingInt(Vehicle::getLongueur)));
    System.out.println(ferry);

    System.out.println("Tri du Ferry par longueur croissante, puis par tarif décroissant puis par numéro d’immatriculation croissant");
    ferry.trier(new ComparateurMulti(Comparator.comparingInt(Vehicle::getLongueur), new ComparateurMulti(new ComparateurTarif().reversed(), Comparator.comparing(Vehicle::getImmatriculation))));
    System.out.println(ferry);
  }

  /**
   * Ajoute un véhicule aléatoire aux propriétés aléatoires dans un ferry
   *
   * @param ferry  un ferry
   * @param random une classe Random
   * @return true ssi le véhicule a bien été ajouté
   */
  private static boolean addRandomVehicleToFerry(Ferry ferry, Random random) {
    return ferry.ajouter(Vehicle.random(random).clone());
  }

  /**
   * Génère un numéro d'imatriculation
   *
   * @param random une classe Random
   * @return un numéro d'imatriculation
   */
  private static String generateRegistration(Random random) {
    return String.valueOf(random.nextInt(999999) * 100000);
  }
}
