package griffio.numeric.text;

import griffio.numeric.NineDigit;
import griffio.numeric.NineDigitScale;
import griffio.numeric.SmallDigit;
import griffio.numeric.TenDigit;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;

/**
 * Encodes en_GB words for a NineDigit integer
 */
public final class NineDigitGBWords implements Serializable, Comparable<NineDigitGBWords> {

  private static final long serialVersionUID = 1L;

  private static EnumMap<NineDigitScale, Function<NineDigit, String>> formats =
    new EnumMap<>(NineDigitScale.class);

  static {
    formats.put(NineDigitScale.one, NineDigitGBWords::formatOnes);
    formats.put(NineDigitScale.ten, NineDigitGBWords::formatTens);
    formats.put(NineDigitScale.hundred, NineDigitGBWords::formatLarge);
    formats.put(NineDigitScale.thousand, NineDigitGBWords::formatLarge);
    formats.put(NineDigitScale.million, NineDigitGBWords::formatLarge);
  }

  public static NineDigitGBWords create(NineDigit digit) {
    return new NineDigitGBWords(digit);
  }

  private final NineDigit digit;
  private final String enGBWords;

  public NineDigitGBWords(NineDigit digit) {
    this.enGBWords = formats.get(digit.scale()).apply(digit);
    this.digit = digit;
  }

  public NineDigit digitValue() {
    return digit;
  }

  @Override public boolean equals(Object object) {
    if (object instanceof NineDigitGBWords) {
      NineDigitGBWords other = (NineDigitGBWords) object;
      return this.digit.equals(other.digit);
    }
    return false;
  }

  @Override public int hashCode() {
    return digit.hashCode();
  }

  @Override public String toString() {
    return enGBWords;
  }

  @Override public int compareTo(@Nonnull NineDigitGBWords other) {
    return this.digit.compareTo(other.digit);
  }

  final static Set<NineDigitScale> joinSizes = EnumSet.of(NineDigitScale.ten, NineDigitScale.one);

  static String joinWords(NineDigitScale digitScale) {
    return joinSizes.contains(digitScale) ? " and " : " ";
  }

  static String formatOnes(NineDigit digit) {
    return String.format("%s", SmallDigit.of(digit));
  }

  static String formatTens(NineDigit digit) {

    NineDigit modulus = digit.modulus();
    NineDigit quotient = digit.quotient();

    TenDigit tens = TenDigit.of(digit.intValue());

    if (modulus.intValue() == 0) {
      return String.format("%s", tens);
    }

    if (quotient.intValue() == 1) {
      return String.format("%s", SmallDigit.of(digit));
    }

    return String.format("%s %s", tens, SmallDigit.of(modulus));
  }

  static String formatLarge(NineDigit digit) {

    NineDigit modulus = digit.modulus();
    NineDigit quotient = digit.quotient();

    if (modulus.intValue() == 0) {
      return formats.get(quotient.scale()).apply(quotient) + " " + digit.scale();
    }

    return formats.get(quotient.scale()).apply(quotient) + " " + digit.scale() 
      + joinWords(modulus.scale()) + formats.get(modulus.scale()).apply(modulus);
  }
}