package griffio.numeric;

public enum TenDigit {

  ten,
  twenty,
  thirty,
  forty,
  fifty,
  sixty,
  seventy,
  eighty,
  ninety;

  final static int[] tens = {90, 80, 70, 60, 50, 40, 30, 20, 10};
  final static TenDigit[] VALUES = values();

  public static TenDigit of(int value) {
    if (value < 10 || value > 99) {
      throw new IllegalArgumentException(
        String.format("value [%s] is not in range [10 to 99]", value));
    }

    for (int i = 0, j = tens.length - 1; ; i++, j--) {
      if (value >= tens[i]) {
        return VALUES[j];
      }
    }
  }
}
