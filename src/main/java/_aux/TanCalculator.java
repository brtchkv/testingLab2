package _aux;

import base.CosCalculator;
import base.SinCalculator;
import base.TestFunction;

public class TanCalculator implements TestFunction {
    private static final TanCalculator INSTANCE = new TanCalculator();
    private SinCalculator sinCalc;
    private CosCalculator cosCalc;

    public TanCalculator(SinCalculator sinCalc, CosCalculator cosCalculator) {
        this.sinCalc = sinCalc;
        this.cosCalc = cosCalculator;
    }

    public TanCalculator() { }

    public double calculate(double arg) {
        if (sinCalc == null) {
            sinCalc = SinCalculator.getInstance();
            cosCalc = CosCalculator.getInstance();
        }
        return sinCalc.calculate(arg) / cosCalc.calculate(arg);
    }

    public static TanCalculator getInstance() {
        return INSTANCE;
    }
}
