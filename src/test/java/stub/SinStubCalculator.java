package stub;

import base.SinCalculator;

public class SinStubCalculator extends SinCalculator {

  private static final SinStubCalculator INSTANCE = new SinStubCalculator();

  @Override
  public double calculate(double arg) {
    if (arg == -Math.PI) return 0;
    return StubTables.sinTable.get(arg);
  }

  public static SinStubCalculator getInstance() {
    return INSTANCE;
  }
}
