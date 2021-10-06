package v1;

public class Vehicule implements IVehicule {
  private final int basePrice;
  private final int pricePerLengthUnit;
  private final int length;
  private final int passengerCount;
  private final String registration;

  public Vehicule(int basePrice, int pricePerLengthUnit, int length, int passengerCount, String registration) {
    this.basePrice = basePrice;
    this.pricePerLengthUnit = pricePerLengthUnit;
    this.length = length;
    this.passengerCount = passengerCount;
    this.registration = registration;
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
    return this.basePrice + this.getLongueur() * this.pricePerLengthUnit + 15 * this.pricePerPassenger;
  }
}
