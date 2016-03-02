package griffio.numeric;

public enum NineDigitScale {

  one(1),
  ten(10),
  hundred(100),
  thousand(1000),
  million(1000000);

  private final int scale;

  NineDigitScale(int scale) {
    this.scale = scale;
  }

  public int modulus(int digit) {
    return digit % scale;
  }

  public int quotient(int digit) {
    return digit / scale;
  }

  final static int[] ints = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999};

  final static NineDigitScale[] sizes =
    {one, ten, hundred, thousand, thousand, thousand, million, million, million};

  public static NineDigitScale of(int digit) {
    for (int i = 0; ; i++) {
      if (digit <= ints[i]) {
        return sizes[i];
      }
    }
  }
}