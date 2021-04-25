package stub;

import _aux.SecCalculator;

public class SecStubCalculator extends SecCalculator {

  private static final SecStubCalculator INSTANCE = new SecStubCalculator();

  public double calculate(double arg) {
    return StubTables.secTable.get(arg);
  }

  public static SecStubCalculator getInstance() {
    return INSTANCE;
  }
}
