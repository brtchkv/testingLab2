package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;


public class LnCalculatorTest {

  private static void runSinTestWithPrecision(double arg, double precision) {
    assertEquals(Math.log(arg), LnCalculator.getInstance().calculate(arg), precision);
  }

  @Tag("low")
  @DisplayName("ln(x) test with low precision")
  @ParameterizedTest
  @MethodSource("getDataSet")
  public void testSinLowPrecision(double arg) {
    runSinTestWithPrecision(arg, 0.1);
  }

  @Tag("medium")
  @DisplayName("ln(x) test with medium precision")
  @ParameterizedTest
  @MethodSource("getDataSet")
  public void testSinMediumPrecision(double arg) {
    runSinTestWithPrecision(arg, 0.001);
  }

  @Tag("high")
  @DisplayName("ln(x) test with high precision")
  @ParameterizedTest
  @MethodSource("getDataSet")
  public void testSinHighPrecision(double arg) {
    runSinTestWithPrecision(arg, 0.0001);
  }

  public static Stream<Double> getDataSet() {
    return Stream.of(
        Math.pow(Math.E, -5),
        Math.pow(Math.E, -1),
        Math.sqrt(Math.E),
        Math.E,
        Math.pow(Math.E, 2.5),
        Math.pow(Math.E, 4));
  }

  @Test
  @DisplayName(value = "Invalid argument test")
  public void testIncorrectArgument() {
    LnCalculator calc = LnCalculator.getInstance();
    assertThrows(IllegalArgumentException.class, () -> calc.calculate(0));
    assertThrows(IllegalArgumentException.class, () -> calc.calculate(-0.1));
    assertThrows(IllegalArgumentException.class, () -> calc.calculate(-10));
  }
}
