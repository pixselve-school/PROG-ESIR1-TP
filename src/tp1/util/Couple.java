package tp1.util;

import java.util.Objects;

public class Couple<T1, T2> {
  private T1 first;
  private T2 second;

  /**
   * Création d'un couple
   *
   * @param first  le premier élément du couple
   * @param second le second élément du couple
   */
  public Couple(T1 first, T2 second) {
    this.first = first;
    this.second = second;
  }

  public T1 getFirst() {
    return first;
  }

  public void setFirst(T1 first) {
    this.first = first;
  }

  public T2 getSecond() {
    return second;
  }

  public void setSecond(T2 second) {
    this.second = second;
  }

  /**
   * Vérifie l'égalité avec un Object
   *
   * @param o un Object
   * @return true ssi o est égal au couple
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Couple<?, ?> couple = (Couple<?, ?>) o;
    return Objects.equals(first, couple.first) && Objects.equals(second, couple.second);
  }
}
