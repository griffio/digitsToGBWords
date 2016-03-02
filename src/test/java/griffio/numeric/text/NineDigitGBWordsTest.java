package griffio.numeric.text;

import griffio.numeric.NineDigit;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

@Test
public class NineDigitGBWordsTest {

  public void twenty_three() {
    
    NineDigitGBWords nineDigitGBWords = new NineDigitGBWords(NineDigit.create(23));

    assertThat(nineDigitGBWords.toString()).isEqualTo("twenty three");
  }
  
  public void nine_hundred_and_three() {
    
    NineDigitGBWords nineDigitGBWords = new NineDigitGBWords(NineDigit.create(903));

    assertThat(nineDigitGBWords.toString()).isEqualTo("nine hundred and three");
  }
  
}