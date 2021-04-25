package impl;

import _aux.*;
import base.CosCalculator;
import base.LnCalculator;
import base.SinCalculator;

public class WholeExpression {

    private final Log5Calculator log5Calculator;
    private final LgCalculator lgCalculator;
    private final TanCalculator tanCalculator;
    private final SecCalculator secCalculator;
    private final CscCalculator cscCalculator;
    private final CosCalculator cosCalculator;
    private final SinCalculator sinCalculator;
    private final CotCalculator cotCalculator;
    private final LnCalculator lnCalculator;

    public WholeExpression(
            Log5Calculator log5Calculator,
            LgCalculator lgCalculator,
            TanCalculator tanCalculator,
            SecCalculator secCalculator,
            CscCalculator cscCalculator,
            CosCalculator cosCalculator,
            SinCalculator sinCalculator,
            LnCalculator lnCalculator,
            CotCalculator cotCalculator) {
        this.log5Calculator = log5Calculator;
        this.lgCalculator = lgCalculator;
        this.tanCalculator = tanCalculator;
        this.secCalculator = secCalculator;
        this.cscCalculator = cscCalculator;
        this.cosCalculator = cosCalculator;
        this.sinCalculator = sinCalculator;
        this.lnCalculator = lnCalculator;
        this.cotCalculator = cotCalculator;
    }

    public WholeExpression() {
        log5Calculator = Log5Calculator.getInstance();
        lgCalculator = LgCalculator.getInstance();
        tanCalculator = TanCalculator.getInstance();
        secCalculator = SecCalculator.getInstance();
        cscCalculator = CscCalculator.getInstance();
        cosCalculator = CosCalculator.getInstance();
        sinCalculator = SinCalculator.getInstance();
        cotCalculator = CotCalculator.getInstance();
        lnCalculator = LnCalculator.getInstance();
    }

    public double compute(double arg) {
        if (arg <= 0) return new TrigonometricExpression().compute(arg);

        return new LogarithmicExpression().compute(arg);
    }

    private class LogarithmicExpression {
        public double compute(double arg) {
            final double log5 = log5Calculator.calculate(arg);
            final double lg = lgCalculator.calculate(arg);
            final double ln = lnCalculator.calculate(arg);

            return (Math.pow((((lg - lg) + log5) * lg), 3) - Math.pow(ln, 2));
        }
    }

    private final class TrigonometricExpression {
        public double compute(double x) {
            final double tan = tanCalculator.calculate(x);
            final double sin = sinCalculator.calculate(x);
            final double sec = secCalculator.calculate(x);
            final double csc = cscCalculator.calculate(x);
            final double cos = cosCalculator.calculate(x);
            final double cot = cotCalculator.calculate(x);
            final double expr1 =
                    (((((((((((Math.pow((Math.pow(Math.pow(((cot + sec) / cos) + csc, 2), 3) * sin), 2) - tan) + cos) * cos) * ((Math.pow((cos - (Math.pow(csc, 2)) / (Math.pow(tan, 2))), 3) + sec)) * (sin / tan)) + cos) + cot) - cot) / csc) * ((cot - (((Math.pow((((sec + csc) + sin) - tan), 3) + sec) * ((cot + cot) * Math.pow(cot, 2))) / (sec * cos))) / cot)) - (Math.pow((Math.pow(((sin + (cos - (cot * csc))) + sec), 2) * (((((((sin - (sin + cos)) / (tan / (sec * tan))) + Math.pow((cot * csc), 2)) + sin) + csc) * (((((csc * (tan + (tan + cos))) * tan) - Math.pow((cot - cos), 2)) - tan) + (sin / sec))) - sin)), 3) + Math.pow((cot - cot), 3))) * (Math.pow((Math.pow((((sec / (csc + (Math.pow(cos, 3) + (cot - sec)))) - Math.pow((Math.pow(sin, 2) - ((csc - cot) + sec)), 3)) * (cos - ((sin * ((Math.pow(sin, 2) - cot) + cot)) + ((tan * cot) + csc)))), 3) / (sin + ((((csc * sec) - tan) * (((csc + ((sec + sec) + sin)) * Math.pow(cot, 2)) * (cos + csc))) / ((cot * ((cot - (Math.pow(sin, 2) * sin)) + tan)) * Math.pow(tan, 2))))), 2) * (cos * Math.pow((Math.pow((sin + tan), 2) - (cos / sec)), 3))));

            return expr1;
        }
    }
}
