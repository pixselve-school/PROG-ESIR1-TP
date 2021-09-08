package td2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class questions {
  /**
   * @param figures une liste de figures
   * @return une table de correspondance (typeMap<TCle, TVal>) dont la clé correspondra à un genre de figure géométrique
   * et la valeur associée au nombre d’occurrences de ce genre de figure dans la liste passée en paramètre
   */
  public static Map<String, Integer> listToMap(List<Figure> figures) {
    Map<String, Integer> result = new HashMap<>();
    for (Figure figure : figures) {
      result.put(figure.genre(), result.getOrDefault(figure.genre(), 0) + 1);
    }
    return result;
  }
}
