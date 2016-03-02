package griffio.numeric;

import griffio.numeric.text.NineDigitGBWords;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class FixtureTest {

  @Test(dataProvider = "fixtures", dataProviderClass = FixtureProviders.class)
  public void fixture_sample_data(int input, String output) {

    NineDigit nineDigit = NineDigit.create(input);

    NineDigitGBWords nineDigitGBWords = NineDigitGBWords.create(nineDigit);

    assertThat(nineDigitGBWords.toString()).isEqualTo(output);
  }
}