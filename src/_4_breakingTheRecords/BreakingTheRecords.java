package _4_breakingTheRecords;

import java.util.List;

public class BreakingTheRecords {

  public static void main(String[] args) {
    List<Integer> test1 = List.of(10, 5, 20, 20, 4, 5, 2, 25, 1); // result should be 2 4
    List<Integer> test2 = List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42); // result should be 4 0
    List<Integer> expectedResult1 = List.of(2, 4);
    List<Integer> expectedResult2 = List.of(4, 0);

    List<Integer> result1 = breakingRecords(test1);
    List<Integer> result2 = breakingRecords(test2);

    System.out.println("Expected result: " + expectedResult1 + ", Result: " + result1 + "\n");
    System.out.println("Expected result: " + expectedResult2 + ", Result: " + result2 + "\n");

    if (breakingRecords(test1).equals(result1) && breakingRecords(test2).equals(result2)) {
      System.out.println("ALL GOOD");
    } else {
      System.out.println("There is an error");
    }
  }

  public static List<Integer> breakingRecords(List<Integer> scores) {
    Integer mostRecord = scores.get(0);
    Integer lastRecord = scores.get(0);
    Integer breaksLastPoint = 0;
    Integer breaksMostPoint = 0;

    for(int i = 1; i < scores.size(); i++) {
      Integer points = scores.get(i);
      if(points < lastRecord){
        breaksLastPoint++;
        lastRecord = points;
      }
      if(points > mostRecord) {
        breaksMostPoint++;
        mostRecord = points;
      }
    }

    return List.of(breaksMostPoint, breaksLastPoint);

  }

}
