package _3_timeConversion;

import java.util.List;
import java.util.stream.Collectors;

public class TimeConversion {

  public static void main(String[] args) {
    List<String> inputs = List.of("07:05:45PM", "12:40:22AM", "06:40:03AM", "12:05:39AM",
        "12:45:54PM", "02:34:50PM", "04:59:59AM", "04:59:59PM", "12:00:00AM", "11:59:59PM");

    List<String> expectedOutputs = List.of("19:05:45", "00:40:22", "06:40:03", "00:05:39",
        "12:45:54", "14:34:50", "04:59:59", "16:59:59", "00:00:00", "23:59:59");

    List<String> result = inputs.stream()
        .map(TimeConversion::timeConversion)
        .collect(Collectors.toList());

    String resultMessage = result.equals(expectedOutputs) ? "Good!\n" : "Wrong!\n";
    System.out.println(resultMessage);

    for (int i = 0; i < result.size(); i++) {
      System.out
          .println("Expected: " + expectedOutputs.get(i) + ", Result: " + result.get(i) + "\n");
    }
  }

  public static String timeConversion(String s) {
    if(s.endsWith("AM")) {
      if(s.substring(0,2).equals("12")) s = s.replace("12", "00");
      return s.replace("AM", "");
    }

    if(s.substring(0, 2).equals("12")) return s.replace("PM", "");

    Integer hourIn24Time = Integer.valueOf(s.substring(0, 2)) + 12;
    String timeIn24Format = hourIn24Time.toString() + s.substring(2, 8);
    return timeIn24Format;
  }
}
