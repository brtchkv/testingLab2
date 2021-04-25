package stub;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface StubTables {

    List<Double> trigArgs = List.of(
            -Math.PI / 5,
            -Math.PI/3,
            -Math.PI/6,
            -Math.PI/2,
            -Math.PI,
            0.0
            );

    List<Double> logArgs = List.of(
            0.8,
            1.0,
            3.25,
            4.8414,
            5.0,
            100.0,
            0.20655,
            3.0,
            2.0,
            10.0
            );

    Map<Double, Double> sinTable = trigArgs.stream().collect(Collectors.toMap(arg -> arg, Math::sin));
    Map<Double, Double> cosTable = trigArgs.stream().collect(Collectors.toMap(arg -> arg, Math::cos));
    Map<Double, Double> tanTable = trigArgs.stream().collect(Collectors.toMap(arg -> arg, Math::tan));
    Map<Double, Double> secTable = trigArgs.stream().collect(Collectors.toMap(arg -> arg, arg -> 1 / Math.cos(arg)));
    Map<Double, Double> cscTable = trigArgs.stream().collect(Collectors.toMap(arg -> arg, arg -> 1 / Math.sin(arg)));
    Map<Double, Double> cotTable = trigArgs.stream().collect(Collectors.toMap(arg -> arg, arg -> Math.cos(arg) / Math.sin(arg)));

    Map<Double, Double> lnTable = logArgs.stream().collect(Collectors.toMap(arg -> arg, Math::log));
    Map<Double, Double> log5Table = logArgs.stream().collect(Collectors.toMap(arg -> arg, arg -> Math.log(arg) / Math.log(5)));
    Map<Double, Double> lgTable = logArgs.stream().collect(Collectors.toMap(arg -> arg, arg -> Math.log(arg) / Math.log(10)));
}
