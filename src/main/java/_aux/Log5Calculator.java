package _aux;

import base.LnCalculator;
import base.TestFunction;

public class Log5Calculator implements TestFunction {

  private static final Log5Calculator INSTANCE = new Log5Calculator();
  private TestFunction lnCalc;

  public Log5Calculator(TestFunction lnCalc) {
    this.lnCalc = lnCalc;
  }

  public Log5Calculator() {}

  @Override
  public double calculate(double arg) {
    if (arg <= 0) throw new IllegalArgumentException("log5(x) arg cannot be negative or 0");
    if (lnCalc == null) lnCalc = LnCalculator.getInstance();
    return lnCalc.calculate(arg) / lnCalc.calculate(5);
  }

  public static Log5Calculator getInstance() {
    return INSTANCE;
  }
}
