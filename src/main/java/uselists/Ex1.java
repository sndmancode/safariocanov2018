package uselists;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.*;

interface StringTester {
  boolean test(String item);
}

class LongStringTester implements StringTester {
  private int threshold;
  public LongStringTester(int threshold) {
    this.threshold = threshold;
  }
  @Override
  public boolean test(String item) {
    return item.length() > threshold;
  }
}

class ShortStringTester implements StringTester {
  @Override
  public boolean test(String item) {
    return item.length() < 6;
  }
}

class FirstHalfStringTester implements StringTester {
  @Override
  public boolean test(String item) {
    return item.charAt(0) < 'M';
  }
}

public class Ex1 {
//  public static List<String> getLongNames(List<String> ls, int threshold) {
//    List<String> results = new ArrayList<>();
//    for (int idx = 0; idx < ls.size(); idx++) {
//      String item = ls.get(idx);
//      if (item.length() > threshold) {
//        results.add(item);
//      }
//    }
//    return results;
//  }

//  public static List<String> getLongNames(List<String> ls, int threshold) {
//    List<String> results = new ArrayList<>();
//    for (String item : ls) {
//      if (item.length() > threshold) {
//        results.add(item);
//      }
//    }
//    return results;
//  }
//
//  public static List<String> getShortNames(List<String> ls, int threshold) {
//    List<String> results = new ArrayList<>();
//    for (String item : ls) {
//      if (item.length() < threshold) {
//        results.add(item);
//      }
//    }
//    return results;
//  }

  // Design pattern "Command"
  public static List<String> getNamesByCriterion
      (List<String> ls, StringTester criterion) {
    List<String> results = new ArrayList<>();
    for (String item : ls) {
      if (criterion.test(item)) {
        results.add(item);
      }
    }
    return results;
  }

  public static void main(String[] args) {
//    List<Integer> li;
    List<String> names = new ArrayList<>();
//    List<String> names = new ArrayList<String>();
//    LinkedList<String> names = new LinkedList<>();
    names.add("Fred");
    names.add("Jim");
//    names.add(1, LocalDate.now());

    System.out.println(names.get(0));
    System.out.println("There are " + names.size() + " elements");

    String n1 = /*(String)*/names.get(1);
    System.out.println(n1);
    names.add("Sheila");
    names.add("Alison");
    names.add("William");
    names.add("Billy");

    System.out.println(names);
    System.out.println("There are " + names.size() + " elements");
//    List<String> longNames = getLongNames(names, 4);
//    System.out.println("Long: -----------------");
//    System.out.println(longNames);
//    System.out.println("Longer: -----------------");
//    System.out.println(getLongNames(names, 5));
//    System.out.println("Short: -----------------");
//    System.out.println(getShortNames(names, 5));

    System.out.println("Long:--------------------");
    System.out.println(getNamesByCriterion(names, new LongStringTester(4)));
    System.out.println("Longer:--------------------");
    System.out.println(getNamesByCriterion(names, new LongStringTester(5)));
    System.out.println("Shorter:--------------------");
    System.out.println(getNamesByCriterion(names, new ShortStringTester()));
    System.out.println("First Half:--------------------");
    System.out.println(getNamesByCriterion(names, new FirstHalfStringTester()));
  }
}
