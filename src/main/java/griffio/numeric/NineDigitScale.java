package griffio.numeric;

import java.util.EnumSet;
import java.util.Set;

public enum NineDigitScale {

  // Move quotient and modulus to NineDigitEnGB
  // Create formatter to print NineDigitEnGB from scale
  
  one {
    @Override public int quotient(int value) {
      return value;
    }

    @Override public int modulus(int value) {
      return 0;
    }

    @Override public String join(int value) {
      return "";
    }

    @Override public String format(int digits) {
      return String.format("%s", SmallDigit.of(digits));
    }
  },
  ten {
    @Override public int quotient(int value) {
      return value / 10;
    }

    @Override public int modulus(int value) {
      return value % 10;
    }

    @Override public String join(int value) {
      return "";
    }

    @Override public String format(int digits) {

      NineDigitScale size = NineDigitScale.of(digits);
      int modulus = size.modulus(digits);
      int quotient = size.quotient(digits);

      TenDigit tens = TenDigit.of(quotient * 10);

      if (modulus == 0) {
        return String.format("%s", tens);
      }

      if (quotient == 1) {
        return String.format("%s", SmallDigit.of(digits));
      }

      return String.format("%s %s", tens, SmallDigit.of(modulus));
    }
  },
  hundred {
    @Override public int quotient(int value) {
      return value / 100;
    }

    @Override public int modulus(int value) {
      return value % 100;
    }
  },
  thousand {
    @Override public int quotient(int value) {
      return value / 1000;
    }

    @Override public int modulus(int value) {
      return value % 1000;
    }
  },
  million {
    @Override public int quotient(int value) {
      return value / 1000000;
    }

    @Override public int modulus(int value) {
      return value % 1000000;
    }
  };

  public abstract int quotient(int value);

  public abstract int modulus(int value);

  public String join(int value) {
    return joinSizes.contains(NineDigitScale.of(value)) ? " and " : " ";
  }

  public String format(int digits) {

    NineDigitScale size = NineDigitScale.of(digits);
    int modulus = size.modulus(digits);
    int quotient = size.quotient(digits);

    NineDigitScale modulusSize = NineDigitScale.of(modulus);
    NineDigitScale quotientSize = NineDigitScale.of(quotient);

    if (modulus == 0) {
      return String.format("%s %s", quotientSize.format(quotient), this);
    }

    return String.format("%s %s%s%s", quotientSize.format(quotient), this, this.join(modulus),
      modulusSize.format(modulus));
  }

  final static Set joinSizes = EnumSet.of(NineDigitScale.ten, NineDigitScale.one);

  final static int[] ints = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999};

  final static NineDigitScale[] sizes =
    {one, ten, hundred, thousand, thousand, thousand, million, million, million};

  public static NineDigitScale of(int digits) {
    if (digits < 0 || digits > 999999999) {
      throw new IllegalArgumentException(
        String.format("digits %d must be in the inclusive range %s to %s ", digits, 0, 999999999));
    }
    
    for (int i = 0; ; i++) {
      if (digits <= ints[i]) {
        return sizes[i];
      }
    }
  }
}