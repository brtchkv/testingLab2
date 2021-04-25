package base;

public class SinCalculator implements TestFunction {

    private final static int ELEMS_NUM = 20;

    private static final SinCalculator INSTANCE = new SinCalculator();

    public double calculate(double arg) {
        double result = 0;
        int sign = 1;
        if (arg < 0) {
            sign *= -1;
            arg = Math.abs(arg);
        }
        arg %= Math.PI*2;
        if (arg > Math.PI) {
            sign *= -1;
            arg -= Math.PI;
        }
        if (arg > Math.PI/2)
            arg = Math.PI - arg;
        for (int i = 0; i < ELEMS_NUM; ++i)
            result += getSeriesElem(i, arg);
        return sign*result;
    }

    public static SinCalculator getInstance() {
        return INSTANCE;
    }

    private double getSeriesElem(int num, double arg) {
        return Math.pow(-1, num) * Math.pow(arg, 2*num+1) / factorial(2*num+1);
    }

    private long factorial(int n) {
        if (n < 2)
            return 1;
        else {
            long result = 1;
            int i = 2;
            while (i <= n)
                result *= i++;
            return result;
        }
    }
}
