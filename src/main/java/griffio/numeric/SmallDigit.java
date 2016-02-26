package griffio.numeric;

public enum SmallDigit {

  zero,
  one,
  two,
  three,
  four,
  five,
  six,
  seven,
  eight,
  nine,
  ten,
  eleven,
  twelve,
  thirteen,
  fourteen,
  fifteen,
  sixteen,
  seventeen,
  eighteen,
  nineteen;
  
  private final static SmallDigit[] values = values();

  public static SmallDigit of(int value) {
    if (value < 0 || value > 19) {
      throw new IllegalArgumentException(String.format("value [%s] must be between 0 and 19", value));
    }
    return values[value];
  }
}
