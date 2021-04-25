package _aux;

import base.LnCalculator;
import base.TestFunction;

public class LgCalculator implements TestFunction {

  private static final LgCalculator INSTANCE = new LgCalculator();
  private TestFunction lnCalc;

  public LgCalculator(TestFunction lnCalc) {
    this.lnCalc = lnCalc;
  }

  public LgCalculator() {}

  public double calculate(double arg) {
    if (arg <= 0) throw new IllegalArgumentException("lg(x) arg cannot be negative or 0");
    if (lnCalc == null) lnCalc = LnCalculator.getInstance();
    return lnCalc.calculate(arg) / lnCalc.calculate(10);
  }

  public static LgCalculator getInstance() {
    return INSTANCE;
  }
}
