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

  final static int[] scale = {19, 29, 39, 49, 59, 69, 79, 89, 99};

  final static TenDigit[] tens =
    {ten, twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety};

  public static TenDigit of(int digit) {
    if (digit < 10 || 99 < digit) {
      throw new IllegalArgumentException(String.format("%s must be between 10 and 99", digit));
    }

    for (int i = 0; ; i++) {
      if (digit <= scale[i]) {
        return tens[i];
      }
    }
  }
}
