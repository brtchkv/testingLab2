package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinCalculatorTest {

  private static void runSinTestWithPrecision(double arg, double precision) {
    assertEquals(Math.sin(arg), SinCalculator.getInstance().calculate(arg), precision);
  }

  @Tag("low")
  @DisplayName("sin(x) test with low precision")
  @ParameterizedTest
  @MethodSource("getDataSet")
  public void testSinLowPrecision(double arg) {
    runSinTestWithPrecision(arg, 0.1);
  }

  @Tag("medium")
  @DisplayName("sin(x) test with medium precision")
  @ParameterizedTest
  @MethodSource("getDataSet")
  public void testSinMediumPrecision(double arg) {
    runSinTestWithPrecision(arg, 0.001);
  }

  @Tag("high")
  @DisplayName("sin(x) test with high precision")
  @ParameterizedTest
  @MethodSource("getDataSet")
  public void testSinHighPrecision(double arg) {
    runSinTestWithPrecision(arg, 0.0001);
  }

  @Tag("high")
  @DisplayName("sin(x) test with high precision")
  @ParameterizedTest
  @MethodSource("getDataSet")
  public void testSinHighPrecision11(double arg) {
    runSinTestWithPrecision(arg, 0.0001);
  }

  public static Stream<Double> getDataSet() {
    return Stream.of(
        0d,
        Math.PI / 6,
        Math.PI / 3,
        Math.PI / 2,
        2 * Math.PI / 3,
        5 * Math.PI / 6,
        Math.PI,
        7 * Math.PI / 6,
        4 * Math.PI / 3,
        3 * Math.PI / 2,
        5 * Math.PI / 3,
        11 * Math.PI / 6,
        2 * Math.PI,
        -Math.PI / 6,
        13 * Math.PI / 6);
  }
}
