package _13_countingValleys;

public class CountingValleys {

  public static void main(String[] args) {
    String input1 = "UDDDUDUU";
    String input2 = "DDUUDDUDUUUD";
    String input3 = "UDUUUDUDDD";
    String input4 = "DUDDDUUDUU";

    int expectedResult1 = 1;
    int expectedResult2 = 2;
    int expectedResult3 = 0;
    int expectedResult4 = 2;

    int result1 = countingValleys(input1.length(), input1);
    int result2 = countingValleys(input2.length(), input2);
    int result3 = countingValleys(input3.length(), input3);
    int result4 = countingValleys(input4.length(), input4);

    test(input1, expectedResult1, result1);
    test(input2, expectedResult2, result2);
    test(input3, expectedResult3, result3);
    test(input4, expectedResult4, result4);

  }

  public static void test(String input, int expectedResult, int result) {
    String message = expectedResult == result ? "\nGOOD!\n" : "\nWRONG!\n";
    System.out.println(message);
    System.out.println("Input: " + input);
    System.out.println("Expected result: " + expectedResult + " - Result: " + result);
    System.out.println(message);
  }

  public static int countingValleys(int steps, String path) {

    int level = 0;
    int valleys = 0;
    boolean isInValley = false;
    for(char step: path.toCharArray()) {
      level = step == 'U' ? ++level : --level;
      if(level < 0 && isInValley == false) {
        valleys++;
        isInValley = true;
      }
      if(level >= 0 && isInValley == true) isInValley = false;
    }

    return valleys;

  }

}
