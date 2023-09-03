package _6_divisibleSumPairs;

import java.util.List;

public class DivisibleSumPairs {

  public static void main(String[] args) {
    int divisor1 = 3;
    int divisor2 = 2;
    List<Integer> numbers1 = List.of(1, 3, 2, 6, 1, 2);
    List<Integer> numbers2 = List.of(5, 9, 10, 7, 4);
    int expectedResult1 = 5;
    int expectedResult2 = 4;

    int result1 = solution(numbers1.size(), divisor1, numbers1);
    int result2 = solution(numbers2.size(), divisor2, numbers2);

    test(expectedResult1, result1);
    test(expectedResult2, result2);

  }

  private static void test(int expectedResult, int result) {
    System.out.println("Expected Result: " + expectedResult + " - Result: " + result);
    System.out.println(expectedResult == result ? "GOOD!\n\n" : "BAD!\n\n");
  }

  static int solution(int n, int k, List<Integer> ar) {
    int pairs = 0;
    for(int i = 0; i < ar.size(); i++) {
      for(int j = i + 1; j < ar.size(); j++) {
        if(((ar.get(i) + ar.get(j)) % k == 0)) pairs++;
      }
    }
    return pairs;
  }

}
