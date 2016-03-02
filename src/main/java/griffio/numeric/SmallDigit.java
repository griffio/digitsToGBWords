package griffio.numeric;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SmallDigit {

  zero(NineDigit.create(0)),
  one(NineDigit.create(1)),
  two(NineDigit.create(2)),
  three(NineDigit.create(3)),
  four(NineDigit.create(4)),
  five(NineDigit.create(5)),
  six(NineDigit.create(6)),
  seven(NineDigit.create(7)),
  eight(NineDigit.create(8)),
  nine(NineDigit.create(9)),
  ten(NineDigit.create(10)),
  eleven(NineDigit.create(11)),
  twelve(NineDigit.create(12)),
  thirteen(NineDigit.create(13)),
  fourteen(NineDigit.create(14)),
  fifteen(NineDigit.create(15)),
  sixteen(NineDigit.create(16)),
  seventeen(NineDigit.create(17)),
  eighteen(NineDigit.create(18)),
  nineteen(NineDigit.create(19));

  static final Map<NineDigit, SmallDigit> digits = Stream.of(values())
    .collect(Collectors.toMap(smallDigit -> smallDigit.digit, Function.identity()));

  final NineDigit digit;

  SmallDigit(NineDigit digit) {
    this.digit = digit;
  }
  
  public static SmallDigit of(NineDigit digit) {
    return digits.get(digit);
  }
}
