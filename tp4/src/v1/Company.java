package v1;

import java.util.Random;

public class Company {
  public static void main(String[] args) {
    Ferry ferry = new Ferry(500, 500);
    Random random = new Random();
    while (addRandomVehicleToFerry(ferry, random)) {
      System.out.println(ferry);
    }
  }

  /**
   * Ajoute un véhicule aléatoire aux propriétés aléatoires dans un ferry
   * @param ferry un ferry
   * @param random une classe Random
   * @return true ssi le véhicule a bien été ajouté
   */
  private static boolean addRandomVehicleToFerry(Ferry ferry, Random random) {
    Vehicle vehicle = random.nextBoolean() ? new Auto(random.nextInt(4), generateRegistration(random), random.nextBoolean()) : new Bus(random.nextInt(100), random.nextInt(100), generateRegistration(random));
    return ferry.ajouter(vehicle.clone());
  }

  /**
   * Génère un numéro d'imatriculation
   * @param random une classe Random
   * @return un numéro d'imatriculation
   */
  private static String generateRegistration(Random random) {
    return String.valueOf(random.nextInt(999999) * 100000);
  }
}
