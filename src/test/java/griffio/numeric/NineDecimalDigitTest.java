package griffio.numeric;

import org.testng.annotations.Test;

import com.google.common.testing.EqualsTester;

import static com.google.common.truth.Truth.assertThat;

public class NineDecimalDigitTest {

  NineDigit one_hundred = NineDigit.create(100);
  NineDigit nine_hundred = NineDigit.create(999);
  NineDigit zero = NineDigit.create(100);

  @Test(dataProvider = "invalid-input", dataProviderClass = FixtureProviders.class,
    expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "digits.*must be in the inclusive range.*")
  public void input_is_outside_input_range(int input) throws Exception {
    new NineDigitGBWords(NineDigit.create(input));
  }

  @Test(dataProvider = "valid-input", dataProviderClass = FixtureProviders.class)
  public void input_is_inside_input_range(int input) throws Exception {
    new NineDigitGBWords(NineDigit.create(input));
  }

  @Test
  public void input_groups_have_equality() {
  
    new EqualsTester()
      .addEqualityGroup(new NineDigitGBWords(one_hundred), new NineDigitGBWords(one_hundred))
      .addEqualityGroup(new NineDigitGBWords(nine_hundred), new NineDigitGBWords(nine_hundred))
      .addEqualityGroup(new NineDigitGBWords(zero), new NineDigitGBWords(zero))
      .testEquals();
  }

  @Test
  public void input_compare_to_is_equivalent() {
    
    NineDigitGBWords givenDigit = new NineDigitGBWords(one_hundred);

    assertThat(givenDigit).isEquivalentAccordingToCompareTo(givenDigit);
  }
  
  @Test
  public void digit_create() {
    
    NineDigitGBWords givenDigit = NineDigitGBWords.create(one_hundred);
    
    assertThat(givenDigit).isEqualTo(new NineDigitGBWords(one_hundred));
  }
  
  @Test
  public void tests() {
    
    int x = 999999999 / 1000;
    int y = 999999999 % 1000;

    System.out.println("x = " + x);
    System.out.println("x = " + y);
    
  }
  
}