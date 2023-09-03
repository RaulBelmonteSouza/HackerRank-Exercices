package _5_camelCase4;

import java.util.ArrayList;
import java.util.List;

public class CamelCase4 {

  public static void main(String[] args) {
    List<String> inputs1 =
        List.of("S;V;iPad", "C;M;mouse pad", "C;C;code swarm", "S;C;OrangeHighlighter");
    List<String> inputs2 = List.of("C;V;can of coke", "S;M;sweatTea()", "S;V;epsonPrinter",
        "C;M;santa claus", "C;C;mirror");

    List<String> results1 = List.of("i pad", "mousePad()", "CodeSwarm", "orange highlighter");
    List<String> results2 =
        List.of("canOfCoke", "sweat tea", "epson printer", "santaClaus()", "Mirror");

    List<String> solution1 = solution(inputs1);
    List<String> solution2 = solution(inputs2);

    String message = solution1.equals(results1) ? "GOOD" : "WRONG";

    print(results1, solution1, message);

    System.out.println("\n\n\n");
    message = solution2.equals(results2) ? "GOOD" : "WRONG";

    print(results2, solution2, message);
  }

  private static void print(List<String> results, List<String> solution, String message) {
    System.out.println(message + "\n" + message + "\n" + message + "\n");
    for (int i = 0; i < results.size(); i++) {
      System.out.println("Expected result: " + results.get(i) + " Result: " + solution.get(i));
      System.out.println("\n");
    }
    System.out.println(message + "\n" + message + "\n" + message + "\n");
  }

  static List<String> solution(List<String> inputs) {
    List<String> result = new ArrayList<>();

    inputs.stream().forEach(input -> {
      String[] inputValues = input.split(";");
      String operation = inputValues[0];
      String operationType = inputValues[1];
      String words = inputValues[2];

      String name = "";
      if(operation.equals("C")) {
        String[] wordsSplitted = words.split(" ");
        name = wordsSplitted[0];

        for(int i = 1; i < wordsSplitted.length; i++) {
          String word = wordsSplitted[i];
          if(word != null) {
            name = name + Character.toUpperCase(word.charAt(0)) + word.substring(1, word.length());
          }
        }

        if(operationType.equals("C")) {
          name = Character.toUpperCase(name.charAt(0)) + name.substring(1, name.length());
        } else if(operationType.equals("M")) {
          name = name.endsWith("()") ? name : name + "()";
        }
      } else {
        for(int i = 0; i < words.length(); i++) {
          if(Character.isUpperCase(words.charAt(i))) {
            name = name + " " + words.charAt(i);
          } else {
            name = name + words.charAt(i);
          }
        }

        name = name.trim().replace("()", "").toLowerCase();
      }
      result.add(name);
    });

    return result;
  }

}
