package stub;

import _aux.TanCalculator;

public class TanStubCalculator extends TanCalculator {

  private static final TanStubCalculator INSTANCE = new TanStubCalculator();

  public double calculate(double arg) {
      if(arg == -Math.PI)
          return 0;
    return StubTables.tanTable.get(arg);
  }

  public static TanStubCalculator getInstance() {
    return INSTANCE;
  }
}
