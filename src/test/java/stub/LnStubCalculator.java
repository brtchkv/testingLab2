package stub;

import base.LnCalculator;

public class LnStubCalculator extends LnCalculator {

  private static final LnStubCalculator INSTANCE = new LnStubCalculator();

  public double calculate(double arg) {
    return StubTables.lnTable.get(arg);
  }

  public static LnStubCalculator getInstance() {
    return INSTANCE;
  }
}
