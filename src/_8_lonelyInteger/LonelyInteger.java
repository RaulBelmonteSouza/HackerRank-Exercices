package _8_lonelyInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LonelyInteger {

  public static void main(String[] args) {
    List<Integer> input1 = List.of(1);
    List<Integer> input2 = List.of(1, 1, 2);
    List<Integer> input3 = List.of(0, 0, 1, 2, 1);
    List<Integer> input4 = List.of(4, 9, 95, 93, 57, 4, 57, 93, 9);
    int expectedResult1 = 1;
    int expectedResult2 = 2;
    int expectedResult3 = 2;
    int expectedResult4 = 95;

    int result1 = lonelyinteger(input1);
    int result2 = lonelyinteger(input2);
    int result3 = lonelyinteger(input3);
    int result4 = lonelyinteger(input4);

    test(expectedResult1, result1);
    test(expectedResult2, result2);
    test(expectedResult3, result3);
    test(expectedResult4, result4);

  }

  public static void test(int expectedResult, int result) {
    String message = expectedResult == result ? "\n\nGOOD!\n\n" : "\n\nWRONG!\n\n";

    System.out.println(message);
    System.out.println("Expected result: " + expectedResult + " - Result: " + result);
    System.out.println(message);
  }

  public static int lonelyinteger(List<Integer> a) {

    /** The commented lines are the best solution to this problem, using XOR.
     * I choose to use the solution that I could create with my skills right now */
//    int num=0;
//    for (int i=0;i<a.size();i++){
//      num=num^a.get(i);
//    }
//    return num;

    // using new ArrayList<>() to avoid UnsupportedOperationException
    a = new ArrayList<>(a);
    Collections.sort(a);
    if(a.size() == 1) return a.get(0);
    if(a.get(a.size() -1) != a.get(a.size() -2)) return a.get(a.size() - 1); //last is unique
    if(a.get(0) != a.get(1)) return a.get(0); //first is unique

    int result = 0;
    for(int i = 1; i < a.size(); i++) {
      int number = a.get(i);
      int next = a.get(i+1);
      int before = a.get(i-1);
      if(number != next && number != before) {
        result = number;
        break;
      }
    }
    return result;
  }
}
