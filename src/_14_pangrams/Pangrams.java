package _14_pangrams;

import java.util.HashSet;

public class Pangrams {

  public static void main(String[] args) {
    String input1 = "We promptly judged antique ivory buckles for the next prize";
    String input2 = "We promptly judged antique ivory buckles for the prize";
    String input3 = "qmExzBIJmdELxyOFWv LOCmefk TwPhargKSPEqSxzveiun";

    String expectedResult1 = "pangram";
    String expectedResult2 = "not pangram";
    String expectedResult3 = "pangram";

    String result1 = pangrams(input1);
    String result2 = pangrams(input2);
    String result3 = pangrams(input3);

    test(input1, expectedResult1, result1);
    test(input2, expectedResult2, result2);
    test(input3, expectedResult3, result3);
  }

  public static void test(String input, String expectedResult, String result) {
    String message = expectedResult.equals(result) ? "\nGOOD!\n" : "\nWRONG!\n";
    System.out.println(message);
    System.out.println("Input: " + input);
    System.out.println("Expected result: " + expectedResult + " - Result: " + result);
    System.out.println(message);
  }

  public static String pangrams(String s) {
    HashSet<String> alphabet = new HashSet<>();
    s = s.toLowerCase().trim().replace(" ", "");
    for(int i = 0; i < s.length(); i++) {
      String letter = String.valueOf(s.charAt(i));
      alphabet.add(letter);
    }

    String result = alphabet.size() == 26 ? "pangram" : "not pangram";
    return result;

  }
}
