package griffio.numeric;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * Encodes en_GB words for a NineDigit integer
 */
public final class NineDigitGBWords implements Serializable, Comparable<NineDigitGBWords> {

  private static final long serialVersionUID = 1L;

  public static NineDigitGBWords create(NineDigit digits) {
    return new NineDigitGBWords(digits);
  }

  private final NineDigit digits;
  private final String enGBWords;

  public NineDigitGBWords(NineDigit digits) {
    this.enGBWords = NineDigitScale.of(digits.asInt()).format(digits.asInt());
    this.digits = digits;
  }

  public NineDigit asDigits() {
    return digits;
  }

  @Override public boolean equals(Object object) {
    if (object instanceof NineDigitGBWords) {
      NineDigitGBWords other = (NineDigitGBWords) object;
      return this.digits == other.digits;
    }
    return false;
  }

  @Override public int hashCode() {
    return Objects.hash(digits);
  }

  @Override public String toString() {
    return enGBWords;
  }

  @Override public int compareTo(@Nonnull NineDigitGBWords other) {
    return this.digits.compareTo(other.digits);
  }
}