package stub;

import _aux.LgCalculator;
import base.TestFunction;

public class LgStubCalculator extends LgCalculator {

  private static final LgStubCalculator INSTANCE = new LgStubCalculator();

  public double calculate(double arg) {
    return StubTables.lgTable.get(arg);
  }

  public static LgStubCalculator getInstance() {
    return INSTANCE;
  }
}
