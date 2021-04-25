package stub;

import _aux.CotCalculator;

public class CotStubCalculator extends CotCalculator {

  private static final CotStubCalculator INSTANCE = new CotStubCalculator();

  public double calculate(double arg) {
    return StubTables.cotTable.get(arg);
  }

  public static CotStubCalculator getInstance() {
    return INSTANCE;
  }
}
