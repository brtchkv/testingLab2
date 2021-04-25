package stub;

import _aux.Log5Calculator;

public class Log5StubCalculator extends Log5Calculator {

  private static final Log5StubCalculator INSTANCE = new Log5StubCalculator();

  public double calculate(double arg) {
    return StubTables.log5Table.get(arg);
  }

  public static Log5StubCalculator getInstance() {
    return INSTANCE;
  }
}
