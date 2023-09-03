package _7_sparseArrays;

import java.util.ArrayList;
import java.util.List;

public class SparseArrays {

  public static void main(String[] args) {
    List<String> strings1 = List.of("aba", "baba", "aba", "xzxb");
    List<String> queries1 = List.of("aba", "xzxb", "ab");
    List<Integer> expectedResults1 = List.of(2, 1, 0);

    List<String> strings2 = List.of("def", "de", "fgh");
    List<String> queries2 = List.of("de", "lmn", "fgh");
    List<Integer> expectedResults2 = List.of(1, 0, 1);

    List<String> strings3 = List.of("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj",
        "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf");
    List<String> queries3 = List.of("abcde", "sdaklfj", "asdjf", "na", "basdn");
    List<Integer> expectedResults3 = List.of(1, 3, 4, 3, 2);

    List<Integer> results1 = matchingStrings(strings1, queries1);
    List<Integer> results2 = matchingStrings(strings2, queries2);
    List<Integer> results3 = matchingStrings(strings3, queries3);

    test(expectedResults1, results1);
    test(expectedResults2, results2);
    test(expectedResults3, results3);


  }

  private static void test(List<Integer> expectedResults, List<Integer> results) {
    String message = expectedResults.equals(results) ?
        "GOOD!\nGOOD!\nGOOD!\n" :
        "WRONG\nWRONG\nWRONG\n";

    System.out.println(message);
    for (int i = 0; i < expectedResults.size(); i++) {
      System.out
          .println("Expected result: " + expectedResults.get(i) + " - Result: " + results.get(i));
      System.out.println("\n");
    }
    System.out.println(message);
  }

  public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    List<Integer> results = new ArrayList<>();


    for(String query:queries) {
      int count = 0;
      for(String string:strings) {
        if(query.equals(string)) count++;
      }
      results.add(count);
    }

    return results;

  }

}
