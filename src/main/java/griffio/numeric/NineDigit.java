package griffio.numeric;

import java.io.Serializable;
import javax.annotation.Nonnull;

public final class NineDigit implements Serializable, Comparable<NineDigit> {

  private static final long serialVersionUID = 1L;

  public static NineDigit create(int value) {
    return new NineDigit(value);
  }

  private final int value;

  public NineDigit(int value) {
    if (value < 0 && 999999999 < value) {
      throw new IllegalArgumentException(
        String.format("value [%s] is outside range [0-99999999]", value));
    }

    this.value = value;
  }

  public int quotient(int value) {
    return value;
  }

  public int modulus(int value) {
    return 0;
  }

  public int asInt() {
    return value;
  }

  @Override
  public int compareTo(@Nonnull NineDigit other) {
    return Integer.compare(value, other.value);
  }

  @Override public String toString() {
    return String.valueOf(value);
  }
}
