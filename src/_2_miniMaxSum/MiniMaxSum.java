package _2_miniMaxSum;

import java.io.*;
import java.util.*;

class Result {

  public static void miniMaxSum(List<Integer> arr) {
    List<Long> sums = new ArrayList<>();
    Long sum = arr.stream().mapToLong(Long::new).sum();

    for(Integer number:arr) {
      sums.add(sum - number);
    }

    System.out.println(Collections.min(sums) + " " + Collections.max(sums));

  }

}

public class MiniMaxSum {
  public static void main(String[] args) throws IOException {
    Result.miniMaxSum(Arrays.asList(1,3,5,7,9));
    // should print 16 24
  }
}
