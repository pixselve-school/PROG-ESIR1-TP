package v3;

import v3.vehicles.Vehicle;

public abstract class Tarif {
  private float pricePerPassenger;
  private int basePrice;
  private int addedPrice;

  protected Tarif(float pricePerPassenger, int basePrice, int addedPrice) {
    this.pricePerPassenger = pricePerPassenger;
    this.basePrice = basePrice;
    this.addedPrice = addedPrice;
  }

  /**
   * calcul du tarif
   *
   * @param vehicle le vehicule concerné
   * @return le tarif du vehicule
   */
  public abstract float getPrice(Vehicle vehicle);

  public float getPricePerPassenger() {
    return pricePerPassenger;
  }

  public int getBasePrice() {
    return basePrice;
  }

  public int getAddedPrice() {
    return addedPrice;
  }

  public void setPricePerPassenger(int pricePerPassenger) {
    this.pricePerPassenger = pricePerPassenger;
  }

  public void setBasePrice(int basePrice) {
    this.basePrice = basePrice;
  }

  public void setAddedPrice(int addedPrice) {
    this.addedPrice = addedPrice;
  }
}
