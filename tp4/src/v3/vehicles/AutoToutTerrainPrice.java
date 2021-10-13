package v3.vehicles;

import v3.Tarif;

public class AutoToutTerrainPrice extends Tarif {
  private static AutoToutTerrainPrice instance;

  private AutoToutTerrainPrice(int pricePerPassenger, int basePrice, int addedPrice) {
    super(pricePerPassenger, basePrice, addedPrice);
  }

  /**
   * Création de l'instance de classe
   *
   * @return l'instance de classe
   */
  public static AutoToutTerrainPrice createSingleton(int pricePerPassenger, int basePrice, int addedPrice) {
    instance = new AutoToutTerrainPrice(pricePerPassenger, basePrice, addedPrice);
    return instance;
  }

  /**
   * Récupère l'instance de classe
   *
   * @return l'instance de classe
   */
  public static AutoToutTerrainPrice getInstance() {
    return instance;
  }

  /**
   * calcul du tarif
   *
   * @param vehicle le vehicule concerné
   * @return le tarif du vehicule
   */
  public int getPrice(Vehicle vehicle) {
    return this.getBasePrice() + this.getPricePerPassenger() * vehicle.getPassagers();
  }
}
