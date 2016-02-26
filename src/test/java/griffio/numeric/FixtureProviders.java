package griffio.numeric;

import org.testng.annotations.DataProvider;

public class FixtureProviders {

  public FixtureProviders() {
  }

  @DataProvider(name = "invalid-input")
  public static Object[][] invalid() {
    return new Object[][] {
        {0 - 1}, {999999999 + 1}, {Integer.MIN_VALUE}, {Integer.MAX_VALUE}};
  }

  @DataProvider(name = "valid-input")
  public static Object[][] valid() {
    return new Object[][] {
        {0}, {1}, {999999999}
    };
  }

  @DataProvider(name = "fixtures")
  public static Object[][] fixtures() {
    return new Object[][] {
        {1, "one"},
        {42, "forty two"},
        {109, "one hundred and nine"},
        {125, "one hundred and twenty five"},
        {1001, "one thousand and one"},
        {1025, "one thousand and twenty five"},
        {1107, "one thousand one hundred and seven"},
        {99999, "ninety nine thousand nine hundred and ninety nine"},
        {46945671, "forty six million nine hundred and forty five thousand six hundred and seventy one"},
        {999999999, "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine"}
    };
  }
}
