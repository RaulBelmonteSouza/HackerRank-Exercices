package _10_flippingBits;

import java.util.List;
import java.util.stream.Collectors;

public class FlippingBitsTest {

  public static void main(String[] args) {
    List<Long> input1 = List.of(2147483647L, 1L, 0L);
    List<Long> input2 = List.of(4L, 123456L);
    List<Long> input3 = List.of(0L, 802743475L, 35601423L);
    List<Long> expectedResult1 = List.of(2147483648L, 4294967294L, 4294967295L);
    List<Long> expectedResult2 = List.of(4294967291L, 4294843839L);
    List<Long> expectedResult3 = List.of(4294967295L, 3492223820L, 4259365872L);

    FlippingBitsEasyWay flippingBitsEasyWay = new FlippingBitsEasyWay();
    FlippingBitsHardWay flippingBitsHardWay = new FlippingBitsHardWay();

    List<Long> easyWayResult1 = submitAndGetResult(flippingBitsEasyWay, input1);
    List<Long> easyWayResult2 = submitAndGetResult(flippingBitsEasyWay, input2);
    List<Long> easyWayResult3 = submitAndGetResult(flippingBitsEasyWay, input3);
    List<Long> hardWayResult1 = submitAndGetResult(flippingBitsHardWay, input1);
    List<Long> hardWayResult2 = submitAndGetResult(flippingBitsHardWay, input2);
    List<Long> hardWayResult3 = submitAndGetResult(flippingBitsHardWay, input3);

    System.out.println("TEST EASY WAY -- BEGIN");
    test(expectedResult1, easyWayResult1);
    test(expectedResult2, easyWayResult2);
    test(expectedResult3, easyWayResult3);
    System.out.println("TEST EASY WAY -- END");
    System.out.println("\n\n");
    System.out.println("TEST HARD WAY -- BEGIN");
    test(expectedResult1, hardWayResult1);
    test(expectedResult2, hardWayResult2);
    test(expectedResult3, hardWayResult3);
    System.out.println("TEST HARD WAY -- END");


  }

  public static void test(List<Long> expectedResult, List<Long> result) {
    String message = expectedResult.equals(result) ? "\nGOOD!\n" : "\nWRONG!\n";
    System.out.println(message);
    for (int i = 0; i < expectedResult.size(); i++) {
      System.out
          .println("Expected Result: " + expectedResult.get(i) + " - Result: " + result.get(i));
    }
    System.out.println(message);
  }

  public static List<Long> submitAndGetResult(FlippingBits flippingBits, List<Long> input) {
    List<Long> result = input.stream()
        .map(number -> flippingBits.flippingBits(number))
        .collect(Collectors.toList());

    return result;
  }

}
