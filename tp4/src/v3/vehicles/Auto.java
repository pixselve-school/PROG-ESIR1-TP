package v3.vehicles;

import java.util.Random;

public class Auto extends Vehicle {
  public boolean isAllTerrain() {
    return allTerrain;
  }

  private final boolean allTerrain;

  public Auto(int passengerCount, String registration, boolean allTerrain) {
    super(2, passengerCount, registration);
    this.allTerrain = allTerrain;
  }

  @Override
  public String toString() {
    return "%s %s ( %d passagers ) [%s]".formatted(this.allTerrain ? "\uD83D\uDE98" : "\uD83D\uDE99", this.allTerrain ? "Auto Tout Terrain" : "Auto", this.getPassagers(), this.getImmatriculation());
  }

  /**
   * Génère un véhicule aléatoire
   *
   * @param random une classe random
   * @return un véhicule aléatoire
   */
  public static Auto random(Random random, String registration) {
    return new Auto(random.nextInt(4), registration, random.nextBoolean());
  }
}
