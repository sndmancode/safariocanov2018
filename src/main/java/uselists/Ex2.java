package uselists;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
//import java.util.*;

public class Ex2 {
  public static List<String> getNamesByCriterion
      (List<String> ls, Predicate<String> criterion) {
    List<String> results = new ArrayList<>();
    for (String item : ls) {
      if (criterion.test(item)) {
        results.add(item);
      }
    }
    return results;
  }

  public static void main(String[] args) {
    List<String> names = new ArrayList<>(
        Arrays.asList(/*LocalDate.now(), */
            "Fred", "Jim", "Sheila", "Alison", "William", "Billy"));

    Predicate<String> pred = item -> {
          System.out.println("Testing " + item);
          return item.charAt(0) > 'M';
        };
    System.out.println("Last Half:--------------------");
    System.out.println(getNamesByCriterion(names, pred));
  }
}
