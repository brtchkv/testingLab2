import _aux.*;
import base.CosCalculator;
import impl.WholeExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stub.*;

import java.util.stream.Stream;

public class IntegrationTest {

    @ParameterizedTest()
    @MethodSource("getTestValues")
    // everything mocked
    public void testUpperModule(double arg, double expected, double delta) {
        final WholeExpression wholeExpression = new WholeExpression(
                new Log5StubCalculator(), new LgStubCalculator(),
                new TanStubCalculator(), new SecStubCalculator(),
                new CscStubCalculator(), new CosStubCalculator(),
                new SinStubCalculator(), new LnStubCalculator(),
                new CotStubCalculator());
        Assertions.assertEquals(expected, wholeExpression.compute(arg), delta);
    }

    @ParameterizedTest()
    @MethodSource("getTestValues")
    // only sin, cos and ln
    public void testUpperAndFuncModules(double arg, double expected, double delta) {
        final WholeExpression wholeExpression = new WholeExpression(new Log5Calculator(new LnStubCalculator()),
                new LgCalculator(new LnStubCalculator()),
                new TanCalculator(new SinStubCalculator(), new CosStubCalculator()),
                new SecCalculator(new CosStubCalculator()),
                new CscCalculator(new SinStubCalculator()),
                new CosStubCalculator(),
                new SinStubCalculator(),
                new LnStubCalculator(),
                new CotStubCalculator());
        Assertions.assertEquals(expected, wholeExpression.compute(arg), delta);
    }

    @ParameterizedTest()
    @MethodSource("getTestValues")
    public void testAllModules(double arg, double expected, double delta) {
        final WholeExpression wholeExpression = new WholeExpression();
        Assertions.assertEquals(expected, wholeExpression.compute(arg), delta);
    }

    public static Stream<Arguments> getTestValues() {
        return Stream.of(
                Arguments.of(-Math.PI, Double.NaN, 0.0),
                Arguments.of(-Math.PI/6, -7.212 * Math.pow(10, -4), 0.01),
                Arguments.of(-1/3 * Math.PI, Double.NaN, 0.001),
                Arguments.of(-Math.PI / 5, -276.426, 0.01),
                Arguments.of(0, Double.NaN, 0.0),
                Arguments.of(0.20655, -2.185, 0.01),
                Arguments.of(0.8, -0.049, 0.01),
                Arguments.of(1, 0.0, 0.0),
                Arguments.of(3.25, -1.696, 1.0),
                Arguments.of(4.8414, -2.185, 0.01),
                Arguments.of(100, 166.207, 0.001)
        );
    }

}
