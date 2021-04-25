package stub;

import base.CosCalculator;

public class CosStubCalculator extends CosCalculator {

  private static final CosStubCalculator INSTANCE = new CosStubCalculator();

  public double calculate(double arg) {
    return StubTables.cosTable.get(arg);
  }

  public static CosStubCalculator getInstance() {
    return INSTANCE;
  }
}
