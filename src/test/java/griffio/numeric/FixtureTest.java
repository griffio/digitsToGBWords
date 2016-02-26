package griffio.numeric;

import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Arrange/Act/Assert or Given/When/Then
 */
public class FixtureTest {

  @Test(dataProvider = "fixtures", dataProviderClass = FixtureProviders.class)
  public void fixture_sample_data(int input, String output) {

    NineDigitScale size = NineDigitScale.of(input);
    
    assertThat(size.format(input)).isEqualTo(output);
  }
}