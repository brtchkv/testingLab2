package base;

public class CosCalculator implements TestFunction {

  private static final CosCalculator INSTANCE = new CosCalculator();
  private TestFunction sinCalc;

  public double calculate(double arg) {
    if (sinCalc == null) sinCalc = SinCalculator.getInstance();
    final double sin = sinCalc.calculate(arg);
    return Math.sqrt(1d - sin * sin);
  }

  public static CosCalculator getInstance() {
    return INSTANCE;
  }
}
