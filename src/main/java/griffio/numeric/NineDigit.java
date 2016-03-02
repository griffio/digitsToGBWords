package griffio.numeric;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * encapsulate NineDigit Number
 */
public final class NineDigit extends Number implements Serializable, Comparable<NineDigit> {

  private static final long serialVersionUID = 1L;

  public static NineDigit create(int value) {
    return new NineDigit(value);
  }

  private final int value;
  private final NineDigitScale scale;

  public NineDigit(int value) {
    if (value < 0 || 999999999 < value) {
      throw new IllegalArgumentException(
        String.format("digits [%s] must be in the inclusive range [0-99999999]", value));
    }

    this.value = value;
    this.scale = NineDigitScale.of(value);
  }

  public NineDigit modulus() {
    return NineDigit.create(this.scale.modulus(value));
  }

  public NineDigit quotient() {
    return NineDigit.create(this.scale.quotient(value));
  }

  public NineDigitScale scale() {
    return scale;
  }

  @Override public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof NineDigit)) return false;
    NineDigit nineDigit = (NineDigit) other;
    return value == nineDigit.value;
  }

  @Override public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public int compareTo(@Nonnull NineDigit other) {
    return Integer.compare(value, other.value);
  }

  @Override public String toString() {
    return String.valueOf(value);
  }

  @Override public int intValue() {
    return value;
  }

  @Override public long longValue() {
    return value;
  }

  @Override public float floatValue() {
    return value;
  }

  @Override public double doubleValue() {
    return value;
  }
}
