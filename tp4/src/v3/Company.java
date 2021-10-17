package v3;

import v3.comparators.ComparateurMulti;
import v3.comparators.ComparateurLongueur;
import v3.comparators.ComparateurTarif;
import v3.vehicles.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class Company {
  public static void main(String[] args) {
    Ferry ferry = new Ferry(500, 500);
    Random random = new Random();
    HashMap<String, Tarif> registrationToTarif = new HashMap<>();

    AmbulancePrice.createSingleton();
    AutoPrice.createSingleton(15, 100, 0);
    AutoToutTerrainPrice.createSingleton(15, 350, 0);
    BusPrice.createSingleton(15, 200, 50);
    CyclePrice.createSingleton(15, 20, 0);


    while (addRandomVehicleToFerry(ferry, random, registrationToTarif)) {
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

    System.out.println("Augmentation du tarif passager de 10%");
    AutoPrice.createSingleton((float) (15 * (1 + 10 / 100.0)), 100, 0);
    AutoToutTerrainPrice.createSingleton((float) (15 * (1 + 10 / 100.0)), 350, 0);
    BusPrice.createSingleton((float) (15 * (1 + 10 / 100.0)), 200, 50);
    CyclePrice.createSingleton((float) (15 * (1 + 10 / 100.0)), 20, 0);
    System.out.println(ferry);
    System.out.println("Dublement du tarif tout terrain");
    AutoToutTerrainPrice.createSingleton(15, 350 * 2, 0);
    System.out.println(ferry);
  }

  /**
   * Ajoute un véhicule aléatoire aux propriétés aléatoires dans un ferry
   *
   * @param ferry  un ferry
   * @param random une classe Random
   * @return true ssi le véhicule a bien été ajouté
   */
  private static boolean addRandomVehicleToFerry(Ferry ferry, Random random, HashMap<String, Tarif> registrationToTarif) {
    Vehicle vehicle = Vehicle.random(random);

    switch (vehicle.getClass().getSimpleName()) {
      case "Ambulance" -> registrationToTarif.put(vehicle.getImmatriculation(), AmbulancePrice.getInstance());
      case "Auto" -> {
        if (((Auto) vehicle).isAllTerrain()) {
          registrationToTarif.put(vehicle.getImmatriculation(), AutoPrice.getInstance());
        } else {
          registrationToTarif.put(vehicle.getImmatriculation(), AutoToutTerrainPrice.getInstance());
        }
      }
      case "Bus" -> registrationToTarif.put(vehicle.getImmatriculation(), BusPrice.getInstance());
      case "Cycle" -> registrationToTarif.put(vehicle.getImmatriculation(), CyclePrice.getInstance());
    }

    return ferry.ajouter(vehicle.clone());
  }

  /**
   * Calcul le tarif d'un véhicule
   *
   * @param vehicle             un véhicule
   * @param registrationToTarif une table de correspondance (HashMap) dont la clé sera le numéro d’immatriculation du véhicule (unique !) et la valeur associée sera l’instance de Tarif correspondant à ce véhicule
   * @return le tarif du véhicule
   */
  private static float getPrice(Vehicle vehicle, HashMap<String, Tarif> registrationToTarif) {
    return registrationToTarif.get(vehicle.getImmatriculation()).getPrice(vehicle);
  }
}
