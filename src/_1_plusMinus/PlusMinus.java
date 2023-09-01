package _1_plusMinus;

import java.io.*;
import java.math.*;
import java.util.*;

class Result {
  public static void plusMinus(List<Integer> arr) {
    BigDecimal listSize = BigDecimal.valueOf(arr.size()).setScale(6);
    BigDecimal greaterThanZero = BigDecimal.valueOf(0).setScale(6);
    BigDecimal lessThanZero = BigDecimal.valueOf(0).setScale(6);
    BigDecimal zeros = BigDecimal.valueOf(0).setScale(6);

    for(Integer number:arr) {
      if(number > 0) {
        greaterThanZero = greaterThanZero.add(BigDecimal.valueOf(1).setScale(6));
        continue;
      }

      if(number < 0) {
        lessThanZero = lessThanZero.add(BigDecimal.valueOf(1).setScale(6));
        continue;
      }
      zeros = zeros.add(BigDecimal.valueOf(1).setScale(6));
    }

    System.out.println(greaterThanZero.divide(listSize, 6, RoundingMode.HALF_UP));
    System.out.println(lessThanZero.divide(listSize, 6, RoundingMode.HALF_UP));
    System.out.println(zeros.divide(listSize, 6, RoundingMode.HALF_UP));

  }

}

public class PlusMinus {
  public static void main(String[] args) throws IOException {
    Result.plusMinus(Arrays.asList(0, 0, -1, 1, 1));
    /*
    * RESULT SHOULD BE:
    * 0.400000
    * 0.200000
    * 0.400000
    *
    */

  }
}
