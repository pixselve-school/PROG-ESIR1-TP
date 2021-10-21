package v3.comparators;

import v3.vehicles.Vehicle;

/**
 * Single Abstract Method (SAM)
 * Permet de passer une fonction lamdba en paramètre d'une fonction
 * https://www.javacodemonk.com/single-abstract-method-sam-and-functional-interface-in-java-44f22fc3
 */
@FunctionalInterface
public interface VehiclePrice {
  /**
   * Récupère le prix d'un véhicule
   *
   * @param vehicle un véhicule
   * @return le prix du véhicule
   */
  public float getVehiclePrice(Vehicle vehicle);
}
