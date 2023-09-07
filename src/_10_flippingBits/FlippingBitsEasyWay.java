package _10_flippingBits;

public class FlippingBitsEasyWay extends FlippingBits {

  /** This is the "easy" way, using Java built-in function  */
  @Override
  public long flippingBits(long n) {
    String value = Long.toBinaryString(n);
    while(value.length() < 32) {
      value = "0" + value;
    }

    String newValue = "";
    for(char ch : value.toCharArray()) {
      newValue = ch == '0' ? newValue + "1" : newValue + "0";
    }

    return Long.parseLong(newValue, 2);
  }

}
