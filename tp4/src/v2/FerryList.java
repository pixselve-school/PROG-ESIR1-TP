package v2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;
import java.util.stream.Stream;

public class FerryList<T> implements Iterable<T> {
  //  Ici, on utilise un Stack mais il est tout à fait possible d'utiliser une autre structure
  public final Stack<T> content;

  public synchronized Iterator<T> iterator() {
    return this.content.iterator();
  }

  /**
   * Création d'une liste
   */
  public FerryList() {
    this.content = new Stack<>();
  }

  public void sort(Comparator<T> c) {
    this.content.sort(c);
  }

  /**
   * Ajoute un élément au début de la liste
   *
   * @param item l'élément à ajouter
   */
  public void push(T item) {
    content.push(item);
  }

  public Stream<T> stream() {
    return this.content.stream();
  }
}
