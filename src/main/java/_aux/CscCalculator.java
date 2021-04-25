package _aux;

import base.SinCalculator;
import base.TestFunction;

public class CscCalculator implements TestFunction {
  private static final CscCalculator INSTANCE = new CscCalculator();
  private TestFunction sinCalc;

  public CscCalculator() {}

  public CscCalculator(TestFunction sinCalc) {
    this.sinCalc = sinCalc;
  }

  public double calculate(double arg) {
    if (sinCalc == null) sinCalc = SinCalculator.getInstance();
    return 1 / sinCalc.calculate(arg);
  }

  public static CscCalculator getInstance() {
    return INSTANCE;
  }
}
