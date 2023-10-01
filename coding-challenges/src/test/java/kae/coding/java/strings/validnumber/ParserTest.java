package kae.coding.java.strings.validnumber;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/** */
public class ParserTest {

  @Test
  public void parse_returnsFalse_whenEmptyInput() {
    assertThat(new Parser("").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenWhitespaceOnly() {
    assertThat(new Parser(" ").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenDecimalPointOnly() {
    assertThat(new Parser(".").parse()).isFalse();
  }

  @Test
  public void parse_returnsTrue_whenInteger() {
    assertThat(new Parser("0").parse()).isTrue();
  }

  @Test
  public void parse_returnsTrue_whenDecimal() {
    assertThat(new Parser("0.1").parse()).isTrue();
  }

  @Test
  public void parse_returnsTrue_whenDecimalWithoutIntegerPart() {
    assertThat(new Parser(".1").parse()).isTrue();
  }

  @Test
  public void parse_returnsTrue_whenDecimalWithoutDecimalPart() {
    assertThat(new Parser("1.").parse()).isTrue();
  }

  @Test
  public void parse_returnsTrue_whenDecimalWithHeadingAndTrailingSpaces() {
    assertThat(new Parser(" 0.1 ").parse()).isTrue();
  }

  @Test
  public void parse_returnsFalse_whenLetters() {
    assertThat(new Parser("abc").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenIntegerWithTrailingSpaceAndLetter() {
    assertThat(new Parser("1 a").parse()).isFalse();
  }

  @Test
  public void parse_returnsTrue_whenScientificNotation() {
    assertThat(new Parser("2e10").parse()).isTrue();
  }

  @Test
  public void parse_returnsTrue_whenScientificNotationWithDecimalSignificantNumber() {
    assertThat(new Parser("53.5e93").parse()).isTrue();
  }

  @Test
  public void parse_returnsTrue_whenNegativeScientificNotationWithHeadingAndTrailingSpaces() {
    assertThat(new Parser(" -90e3   ").parse()).isTrue();
  }

  @Test
  public void parse_returnsFalse_whenExponentWithoutPowerValueAndHeadingSpace() {
    assertThat(new Parser(" 1e").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenExponentWithoutSignificantNumber() {
    assertThat(new Parser("e3").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenExponentWithDecimalPointButWithoutSignificantNumber() {
    assertThat(new Parser(".e3").parse()).isFalse();
  }

  @Test
  public void parse_returnsTrue_whenExponentWithNegativeValueAndHeadingSpace() {
    assertThat(new Parser(" 6e-1").parse()).isTrue();
  }

  @Test
  public void parse_returnsFalse_whenDoubleNegative() {
    assertThat(new Parser("--6").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenMinusAndPlus() {
    assertThat(new Parser("-+3").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenLettersInsideNumber() {
    assertThat(new Parser("95a54e53").parse()).isFalse();
  }

  @Test
  public void parse_returnsFalse_whenExponentWithDecimalPower() {
    assertThat(new Parser(" 99e2.5 ").parse()).isFalse();
  }
}
