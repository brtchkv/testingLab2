package _aux;

import base.CosCalculator;
import base.SinCalculator;
import base.TestFunction;

public class CotCalculator implements TestFunction {
  private static final CotCalculator INSTANCE = new CotCalculator();
  private TestFunction sinCalc;
  private TestFunction cosCalc;

  public CotCalculator() {}

  public CotCalculator(TestFunction sinCalc, TestFunction cosCalc) {
    this.sinCalc = sinCalc;
    this.cosCalc = cosCalc;
  }

  public double calculate(double arg) {
    if (sinCalc == null) {
      sinCalc = SinCalculator.getInstance();
      cosCalc = CosCalculator.getInstance();
    }

    return cosCalc.calculate(arg) / sinCalc.calculate(arg);
  }

  public static CotCalculator getInstance() {
    return INSTANCE;
  }
}
