package _10_flippingBits;

public class FlippingBitsHardWay extends FlippingBits{

  /** This is the "hard" way, converting to binary manually and converting back to decimal*/
  @Override
  public long flippingBits(long n) {
    String binaryValue = "";

    if(n == 0 || n == 1) {
      binaryValue = Long.toString(n);
    } else {
      while(n != 0) {
        if(n % 2 == 0) {
          binaryValue = "0" + binaryValue;
          n = n/2;
        } else {
          binaryValue = "1" + binaryValue;
          n = (n - 1) / 2;
        }
      }
    }

    while(binaryValue.length() < 32) {
      binaryValue = "0" + binaryValue;
    }

    String newValue = "";
    for(char ch:binaryValue.toCharArray()) {
      newValue = ch == '0' ? newValue + "1" : newValue + "0";
    }

    Long newLongValue = 0L;
    int count = 0;
    for(int i = newValue.length() - 1; i >= 0; i--) {
      Double value = Double.parseDouble(String.valueOf(newValue.charAt(i)));
      if(value == 0) {
        count++;
        continue;
      }
      Double result = value * Math.pow(2, count);
      newLongValue = newLongValue + result.longValue();
      count++;
    }
    return newLongValue;
  }

}
