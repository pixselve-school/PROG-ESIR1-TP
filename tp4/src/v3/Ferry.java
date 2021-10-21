package v3;

import v3.comparators.VehiclePrice;
import v3.vehicles.Vehicle;

import java.util.Comparator;

/**
 * Un ferry transporte des véhicules
 */
public class Ferry {
  private final int lengthCapacity;
  private final int passengerCapacity;
  private final FerryList<Vehicle> vehicles;
  private int length;
  private int passengers;

  public Ferry(int lengthCapacity, int passengerCapacity) {
    this.lengthCapacity = lengthCapacity;
    this.passengerCapacity = passengerCapacity;
    vehicles = new FerryList<>();
  }

  // accesseurs
  public int getCapaLongueur() {
    return this.lengthCapacity;
  }

  public int getCapaPassagers() {
    return this.passengerCapacity;
  }

  public int getLongueur() {
    return this.length;
  }

  public int getPassagers() {
    return this.passengers;
  }

  /**
   * Récupère la longueur disponible
   *
   * @return la longueur disponible
   */
  public int getAvailableLength() {
    return this.getCapaLongueur() - this.getLongueur();
  }

  /**
   * Récupère le nombre de passagers disponible
   *
   * @return le nombre de passagers disponible
   */
  public int getAvailablePassengers() {
    return this.getCapaPassagers() - this.getPassagers();
  }

  /**
   * ajouter un véhicule dans le ferry.
   * sans effet s'il n'y a plus de place
   *
   * @param v : véhicule à ajouter
   * @return vrai si l'ajout a eu lieu, faux sinon
   */
  public boolean ajouter(Vehicle v) {
    if (this.getPassagers() + v.getPassagers() <= this.getCapaPassagers() && this.getLongueur() + v.getLongueur() <= this.getCapaLongueur()) {
      this.vehicles.push(v.clone());
      this.passengers += v.getPassagers();
      this.length += v.getLongueur();
      return true;
    } else {
      return false;
    }
  }

  /**
   * Trie par ordre croissant le ferry selon la longueur des véhicules
   */
  public void trier() {
    this.trier(Comparator.comparingInt(Vehicle::getLongueur));
  }

  /**
   * Trie le ferry selon un comparateur
   *
   * @param comparator un comparateur pour trier les véhicules du ferry
   */
  public void trier(Comparator<Vehicle> comparator) {
    this.vehicles.sort(comparator);
  }

  /**
   * calculer le tarif de l'ensemble des véhicules présents dans le ferry
   *
   * @return le tarif de l'ensemble des véhicules présents dans le ferry
   */
  public float calculerTarif(VehiclePrice getVehiclePrice) {
    return this.vehicles.stream().map(getVehiclePrice::getVehiclePrice).reduce(0.0F, Float::sum);
  }

  /**
   * Représentation affichable du ferry
   *
   * @return la représentation affichable du ferry
   */
  public String toString(VehiclePrice getVehiclePrice) {
    StringBuilder result = new StringBuilder("⎯ ⛴ Ferry ⎯\n☑️ Longueur disponible: %s\n☑️ Nombre de place disponible: %s\n️☑️ Tarif total des véhicules: %s€\n☑️ Véhicules:\n".formatted(this.getAvailableLength(), this.getAvailablePassengers(), this.calculerTarif(getVehiclePrice)));
    for (Vehicle vehicle : this.vehicles) {
      result.append(" ").append(vehicle.toString()).append("\n");
    }
    return result.toString();
  }
}
