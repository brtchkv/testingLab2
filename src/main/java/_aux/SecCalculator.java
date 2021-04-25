package _aux;

import base.CosCalculator;
import base.TestFunction;

public class SecCalculator implements TestFunction {
  private static final SecCalculator INSTANCE = new SecCalculator();
  private TestFunction cosCalc;

  public SecCalculator() {}

  public SecCalculator(TestFunction cosCalc) {
    this.cosCalc = cosCalc;
  }

  public double calculate(double arg) {
    if (cosCalc == null) cosCalc = CosCalculator.getInstance();
    return 1 / cosCalc.calculate(arg);
  }

  public static SecCalculator getInstance() {
    return INSTANCE;
  }
}
