package v3.vehicles;

import java.util.Random;

public class Vehicle implements IVehicule, Cloneable {
  public void setBasePrice(int basePrice) {
    this.basePrice = basePrice;
  }

  public void setPricePerPassenger(int pricePerPassenger) {
    this.pricePerPassenger = pricePerPassenger;
  }

  private int basePrice;
  private final int pricePerLengthUnit;
  private final int length;
  private final int passengerCount;
  private final String registration;
  private int pricePerPassenger;

  public Vehicle(int basePrice, int pricePerLengthUnit, int length, int passengerCount, String registration) {
    this.basePrice = basePrice;
    this.pricePerLengthUnit = pricePerLengthUnit;
    this.length = length;
    this.passengerCount = passengerCount;
    this.registration = registration;
    this.pricePerPassenger = 15;
  }

  public int getLongueur() {
    return this.length;
  }

  public int getPassagers() {
    return this.passengerCount;
  }

  public String getImmatriculation() {
    return this.registration;
  }

  public float calculerTarif() {
    return this.basePrice + this.getLongueur() * this.pricePerLengthUnit + this.passengerCount * this.pricePerPassenger;
  }

  @Override
  public Vehicle clone() {
    try {
      return (Vehicle) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  /**
   * Génère un numéro d'imatriculation
   *
   * @param random une classe Random
   * @return un numéro d'imatriculation
   */
  protected static String generateRegistration(Random random) {
    return "%s%s-%d-%s%s".formatted(generateLetter(random), generateLetter(random), random.nextInt(999 - 100) + 100, generateLetter(random), generateLetter(random));
  }

  /**
   * Génère une lettre entre A et Z
   *
   * @param random une classe random
   * @return une lettre entre A et Z
   * @source https://stackoverflow.com/questions/2626835/is-there-functionality-to-generate-a-random-character-in-java
   */
  private static char generateLetter(Random random) {
    return (char) (random.nextInt('Z' - 'A') + 'A' + 1);
  }

  /**
   * Génère un véhicule aléatoire
   *
   * @param random une classe random
   * @return un véhicule aléatoire
   */
  public static Vehicle random(Random random) {
    return switch (random.nextInt(4)) {
      case 0 -> Auto.random(random);
      case 1 -> Bus.random(random);
      case 2 -> Ambulance.random(random);
      default -> Cycle.random(random);
    };
  }
}
