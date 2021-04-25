package stub;

import _aux.CscCalculator;
import base.TestFunction;

public class CscStubCalculator extends CscCalculator {

  private static final CscStubCalculator INSTANCE = new CscStubCalculator();

  public double calculate(double arg) {
    return StubTables.cscTable.get(arg);
  }

  public static CscStubCalculator getInstance() {
    return INSTANCE;
  }
}
