package _9_gradingStudents;

import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {

  public static void main(String[] args) {
    List<Integer> input1 = List.of(73, 67, 38, 33);
    List<Integer> input2 = List.of(37, 38);
    List<Integer> expectedResult1 = List.of(75, 67, 40, 33);
    List<Integer> expectedResult2 = List.of(37, 40);

    List<Integer> result1 = gradingStudents(input1);
    List<Integer> result2 = gradingStudents(input2);

    test(expectedResult1, result1);
    test(expectedResult2, result2);
  }

  public static void test(List<Integer> expectedResult, List<Integer> result) {
    String message = expectedResult.equals(result) ? "\nGOOD!\n" : "\nWRONG!\n";
    System.out.println(message);
    for (int i = 0; i < expectedResult.size(); i++) {
      System.out
          .println("Expected Result: " + expectedResult.get(i) + " - Result: " + result.get(i));
    }
    System.out.println(message);
  }

  public static List<Integer> gradingStudents(List<Integer> grades) {
    return grades.stream().map(grade -> {
      if(grade >= 38) {
        if ((grade + 1) % 5 == 0) return grade + 1;
        if ((grade + 2) % 5 == 0) return grade + 2;
      }
      return grade;
    }).collect(Collectors.toList());
  }
}
