package _11_diagonalDifference;

import java.util.List;

public class DiagonalDifference {

  public static void main(String[] args) {
    List<List<Integer>> input = List.of(List.of(11, 2, 4), List.of(4, 5, 6), List.of(10, 8, -12));
    int expectedResult = 15;

    int result = diagonalDifference(input);

    String message = expectedResult == result ? "\nGOOD!\n" : "\nWRONG!\n";
    System.out.println(message);
    System.out.println("Expected Result: " + expectedResult + " - Result: " + result);
    System.out.println(message);
  }

  public static int diagonalDifference(List<List<Integer>> arr) {

    Integer leftSum = 0;
    Integer rightSum = 0;

    for(int i = 0; i < arr.size(); i++) {
      leftSum = leftSum + arr.get(i).get(i);
      rightSum = rightSum + arr.get(i).get((arr.size() - 1) - i);
    }

    Integer result = leftSum - rightSum;
    result = result < 0 ? result *= -1 : result;
    return result;

  }
}
